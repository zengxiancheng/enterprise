package com.enterprise.service.impl;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.enterprise.dao.BaseDao;
import com.enterprise.entity.Role;
import com.enterprise.entity.page.PageModel;
import com.enterprise.service.RoleService;

@Service("roleService")
public class RoleServiceImpl  implements RoleService {	
	 @Resource
		private BaseDao dao;
		public void setDao(BaseDao dao) {
			this.dao = dao;
			
		}
	
	// 多行删除方法
	public int deletes(String[] ids) {
		Role role = new Role();
		for (int i = 0; i < ids.length; i++) {
			role.setId(Integer.parseInt(ids[i]));
			delete(role);
		}
		return 0;
	}

	@Override
	public int insert(Role e) {
		return dao.insert("role.insert", e);
	}

	@Override
	public int delete(Role e) {
		return dao.delete("role.delete", e);
	}

	@Override
	public int update(Role e) {
		return dao.update("role.update", e);
	}

	@Override
	public Role selectOne(Role e) {
		return (Role) dao.selectOne("role.selectOne", e);
	}

	@Override
	public Role selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(Role e) {
		return dao.selectPageList("role.selectPageList",
				"role.selectPageCount", e);
	}

	@Override
	public List<Role> selectList(Role e) {
		if (e == null)
			return dao.selectList("role.selectList");
		return dao.selectList("role.selectList", e);
	}
	


}
