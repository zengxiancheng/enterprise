package com.enterprise.controller.manage;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.enterprise.cache.FrontCache;
import com.enterprise.controller.BaseController;
import com.enterprise.entity.FriendLinks;
import com.enterprise.entity.Project;
import com.enterprise.entity.User;
import com.enterprise.service.ProjectService;
import com.enterprise.service.RoleService;
import com.enterprise.service.Services;
import com.enterprise.util.LoginUserHolder;


/**
 * 
 * @author zxc
 * 角色添加
 */
@Controller
@RequestMapping("/manage/project/")
public class ProjectAction extends BaseController<Project> {
	
	private static final String page_toEdit = "/manage/system/project/projectEdit";
	private static final String page_toAdd = "/manage/system/project/projectEdit";
	private static final String page_toList = "/manage/system/project/projectList";

	public ProjectAction() {
		super.page_toAdd = page_toAdd;
		super.page_toEdit = page_toEdit;
		super.page_toList = page_toList;
	}
	
	@Autowired
	private ProjectService projectService;
	@Override
	public Services<Project> getService() {
		return projectService;
	}
	
	@RequestMapping("unique")
	@ResponseBody
	public String unique(@ModelAttribute("e") Project e,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");//设置响应编码为utf-8
		if(StringUtils.isNotBlank(e.getName())){
			Project project = new Project();			
			project.setName(e.getName());
			project = projectService.selectOne(project);
			if(project==null){
				return "{\"ok\":\"该项目名称可以使用!\"}";
			}else{
				return "{\"error\":\"该项目名称已经存在!\"}";
			}
		}else if(StringUtils.isNotBlank(e.getSeriNo())){
			Project project = new Project();
			project.setSeriNo(e.getSeriNo());
			project = projectService.selectOne(project);
			if(project==null){
				return "{\"ok\":\"该项目编号可以使用!\"}";
			}else{
				return "{\"error\":\"该项目编号已经存在!\"}";
			}
		}
		return null;

	}
	
	
	
	
	
	@Override
	public String insert(HttpServletRequest request, @ModelAttribute("e")Project e, RedirectAttributes flushAttrs) throws Exception {
		projectService.insert(e);
		insertAfter(e);
		//插入成功后更新缓存
		addMessage(flushAttrs,"操作成功！");
		return "redirect:selectList";
	}
	


}
