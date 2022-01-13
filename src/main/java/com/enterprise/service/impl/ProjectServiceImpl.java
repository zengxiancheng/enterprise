package com.enterprise.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.enterprise.dao.BaseDao;
import com.enterprise.entity.Project;
import com.enterprise.entity.page.PageModel;
import com.enterprise.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl  implements ProjectService {
	
	 @Resource
	private BaseDao dao;
	public void setDao(BaseDao dao) {
		this.dao = dao;
		
	}
	
	// 多行删除方法
	public int deletes(String[] ids) {
		Project project = new Project();
		for (int i = 0; i < ids.length; i++) {
			project.setId(Integer.parseInt(ids[i]));
			delete(project);
		}
		return 0;
	}

	@Override
	public int insert(Project e) {
		return dao.insert("project.insert", e);
	}

	@Override
	public int delete(Project e) {
		return dao.delete("project.delete", e);
	}

	@Override
	public int update(Project e) {
		return dao.update("project.update", e);
	}

	@Override
	public Project selectOne(Project e) {
		return (Project) dao.selectOne("project.selectOne", e);
	}

	@Override
	public Project selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(Project e) {
		return dao.selectPageList("project.selectPageList",
				"project.selectPageCount", e);
	}

	@Override
	public List<Project> selectList(Project e) {
		if (e == null)
			return dao.selectList("project.selectList");
		return dao.selectList("project.selectList", e);
	}
	


}
