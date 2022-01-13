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
import com.enterprise.entity.Product;
import com.enterprise.entity.User;
import com.enterprise.service.ProductService;
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
@RequestMapping("/manage/product/")
public class ProductAction extends BaseController<Product> {
	
	private static final String page_toEdit = "/manage/system/product/productEdit";
	private static final String page_toAdd = "/manage/system/product/productEdit";
	private static final String page_toList = "/manage/system/product/productList";

	public ProductAction() {
		super.page_toAdd = page_toAdd;
		super.page_toEdit = page_toEdit;
		super.page_toList = page_toList;
	}
	
	@Autowired
	private ProductService productService;
	@Override
	public Services<Product> getService() {
		return productService;
	}
	
	@RequestMapping("unique")
	@ResponseBody
	public String unique(@ModelAttribute("e") Product e,HttpServletResponse response) throws IOException{
		response.setCharacterEncoding("utf-8");//设置响应编码为utf-8
		if(StringUtils.isNotBlank(e.getName())){
			Product product = new Product();			
			product.setName(e.getName());
			product = productService.selectOne(product);
			if(product==null){
				return "{\"ok\":\"该产品名称可以使用!\"}";
			}else{
				return "{\"error\":\"该产品名称已经存在!\"}";
			}
		}else if(StringUtils.isNotBlank(e.getModel())){
			Product product = new Product();
			product.setModel(e.getModel());
			product = productService.selectOne(product);
			if(product==null){
				return "{\"ok\":\"该产品编号可以使用!\"}";
			}else{
				return "{\"error\":\"该产品编号已经存在!\"}";
			}
		}
		return null;

	}
	
	
	
	
	
	@Override
	public String insert(HttpServletRequest request, @ModelAttribute("e")Product e, RedirectAttributes flushAttrs) throws Exception {
		productService.insert(e);
		insertAfter(e);
		//插入成功后更新缓存
		addMessage(flushAttrs,"操作成功！");
		return "redirect:selectList";
	}
	


}
