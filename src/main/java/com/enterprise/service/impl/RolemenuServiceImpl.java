package com.enterprise.service.impl;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.enterprise.dao.BaseDao;
import com.enterprise.entity.Role;
import com.enterprise.entity.Rolemenu;
import com.enterprise.entity.page.PageModel;
import com.enterprise.service.RolemenuService;

@Service("rolemenuService")
public class RolemenuServiceImpl  implements RolemenuService {	
	 @Resource
		private BaseDao dao;
		public void setDao(BaseDao dao) {
			this.dao = dao;
			
		}
	
	// 多行删除方法
	public int deletes(String[] ids) {
		Rolemenu rolemenu = new Rolemenu();
		for (int i = 0; i < ids.length; i++) {
			rolemenu.setId(Integer.parseInt(ids[i]));
			delete(rolemenu);
		}
		return 0;
	}

	@Override
	public int insert(Rolemenu e) {
		return dao.insert("rolemenu.insert", e);
	}

	@Override
	public int delete(Rolemenu e) {
		return dao.delete("rolemenu.delete", e);
	}

	@Override
	public int update(Rolemenu e) {
		return dao.update("rolemenu.update", e);
	}

	@Override
	public Rolemenu selectOne(Rolemenu e) {
		return (Rolemenu) dao.selectOne("rolemenu.selectOne", e);
	}

	@Override
	public Rolemenu selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(Rolemenu e) {
		return dao.selectPageList("rolemenu.selectPageList",
				"rolemenu.selectPageCount", e);
	}

	@Override
	public List<Rolemenu> selectList(Rolemenu e) {
		if (e == null)
			return dao.selectList("rolemenu.selectList");
		return dao.selectList("rolemenu.selectList", e);
	}
	


}
