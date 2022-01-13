package com.enterprise.controller.manage;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.enterprise.cache.FrontCache;
import com.enterprise.controller.BaseController;
import com.enterprise.entity.Device;
import com.enterprise.entity.FriendLinks;
import com.enterprise.entity.Product;
import com.enterprise.entity.Project;
import com.enterprise.entity.Role;
import com.enterprise.entity.User;
import com.enterprise.service.DeviceService;
import com.enterprise.service.ProductService;
import com.enterprise.service.ProjectService;
import com.enterprise.service.RoleService;
import com.enterprise.service.Services;


/**
 * 
 * @author zxc
 * 角色添加
 */
@Controller
@RequestMapping("/manage/device/")
public class DeviceAction extends BaseController<Device> {
	
	private static final String page_toEdit = "/manage/system/device/deviceEdit";
	private static final String page_toAdd = "/manage/system/device/deviceEdit";
	private static final String page_toList = "/manage/system/device/deviceList";

	public DeviceAction() {
		super.page_toAdd = page_toAdd;
		super.page_toEdit = page_toEdit;
		super.page_toList = page_toList;
	}
	
	@Autowired
	private DeviceService deviceService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ProductService productService;
	
	@Override
	public Services<Device> getService() {
		return deviceService;
	}
	
	@RequestMapping("unique")
	@ResponseBody
	public String unique(@ModelAttribute("e") Device e,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");//设置响应编码为utf-8
		if(StringUtils.isNotBlank(e.getSeriNo())){
			Device device = new Device();
			device.setSeriNo(e.getSeriNo());			
			device = deviceService.selectOne(device);
			if(device==null){
				return "{\"ok\":\"设备编号可以使用!\"}";
			}else{
				return "{\"error\":\"设备编号已经存在!\"}";
			}
		}
		return null;

	}
	
	
	@RequestMapping("toAdd")
	public String toAdd(@ModelAttribute("e") Device e,ModelMap model) throws Exception{
		e.clean();
		
	   List<Project> projects=projectService.selectList(new Project());
	   List<Product> products= productService.selectList(new Product());
	   model.addAttribute("projects", projects);
	   model.addAttribute("products", products);		
	   return page_toAdd;
	}
	
	@RequestMapping("toEdit")
	public String toEdit(@ModelAttribute("e") Device e, ModelMap model) throws Exception {
		e = getService().selectOne(e);
		model.addAttribute("e", e);
		List<Project> projects = projectService.selectList(new Project());
		List<Product> products = productService.selectList(new Product());
		e = getService().selectOne(e);
		model.addAttribute("e", e);
		model.addAttribute("projects", projects);
		model.addAttribute("products", products);
		return page_toEdit;
	}
	
	@Override
	public String insert(HttpServletRequest request, @ModelAttribute("e")Device e, RedirectAttributes flushAttrs) throws Exception {
		deviceService.insert(e);
		insertAfter(e);
		//插入成功后更新缓存
		addMessage(flushAttrs,"操作成功！");
		return "redirect:selectList";
	}
	


}
