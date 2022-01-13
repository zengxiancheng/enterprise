package com.enterprise.controller.manage;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.enterprise.cache.FrontCache;
import com.enterprise.controller.BaseController;
import com.enterprise.entity.Role;
import com.enterprise.entity.Rolemenu;
import com.enterprise.service.RoleService;
import com.enterprise.service.Services;
import com.enterprise.service.impl.RolemenuServiceImpl;

/**
 * 
 * @author zxc 角色添加
 */
@Controller
@RequestMapping("/manage/role/")
public class RoleAction extends BaseController<Role> {

	private static final String page_toEdit = "/manage/system/role/roleEdit";
	private static final String page_toAdd = "/manage/system/role/roleEdit";
	private static final String page_toList = "/manage/system/role/roleList";
	private static final String page_addOrUpdate = "/manage/system/role/roleEdit";

	public RoleAction() {
		super.page_toAdd = page_toAdd;
		super.page_toEdit = page_toEdit;
		super.page_toList = page_toList;
	}

	@Autowired
	private RoleService roleService;

	@Autowired
	private RolemenuServiceImpl rolemenuService;

	@Override
	public Services<Role> getService() {
		return roleService;
	}

	/**
	 * 更新数据
	 * 
	 * @param request
	 * @param e
	 * @param flushAttrs
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(HttpServletRequest request, @ModelAttribute("e") Role e, RedirectAttributes flushAttrs)
			throws Exception {

		getService().update(e);
		insertAfter(e);
		addMessage(flushAttrs, "操作成功！");
		return "redirect:selectList";
	}

	@RequestMapping("unique")
	@ResponseBody
	public String unique(@ModelAttribute("e") Role e, HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("utf-8");// 设置响应编码为utf-8
		if (StringUtils.isNotBlank(e.getRoleName())) {
			Role role = new Role();
			role.setRoleName(e.getRoleName());
			role = roleService.selectOne(role);
			if (role == null) {
				return "{\"ok\":\"角色名称可以使用!\"}";
			} else {
				return "{\"error\":\"角色名称已经存在!\"}";
			}
		} else if (StringUtils.isNotBlank(e.getRoleCode())) {
			Role role = new Role();
			role.setRoleCode(e.getRoleCode());
			role = roleService.selectOne(role);
			if (role == null) {
				return "{\"ok\":\"该角色代码可以使用!\"}";
			} else {
				return "{\"error\":\"该角色代码已经存在!\"}";
			}
		}
		return null;

	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String insert(HttpServletRequest request, @ModelAttribute("e") Role e, RedirectAttributes flushAttrs)
			throws Exception {
		roleService.insert(e);
		insertAfter(e);
		// 插入成功后更新缓存
		addMessage(flushAttrs, "操作成功！");
		return "redirect:selectList";
	}

	protected void insertAfter(Role e) {
		String ids = e.getMenuIds();
		if (ids == null || ids.trim().equals("")) {

		} else {
			e = roleService.selectOne(e);
			Rolemenu rolemenu = new Rolemenu();
			rolemenu.setRoleId(new Integer(e.getId()).toString());
			rolemenuService.delete(rolemenu);
			String[] menus = ids.trim().split(",");
			for (String menuId : menus) {
				rolemenu.setMenuId(menuId);
				rolemenuService.insert(rolemenu);
			}
		}

	}

}
