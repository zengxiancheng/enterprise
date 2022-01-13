package com.enterprise.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.enterprise.dao.BaseDao;
import com.enterprise.entity.History;
import com.enterprise.entity.page.PageModel;
import com.enterprise.service.HistoryService;


@Service("historyService")
public class HistoryServiceImpl  implements HistoryService {
	
	 @Resource
	private BaseDao dao;
	public void setDao(BaseDao dao) {
		this.dao = dao;
		
	}
	
	// 多行删除方法
	public int deletes(String[] ids) {
		History history = new History();
		for (int i = 0; i < ids.length; i++) {
			history.setId(Integer.parseInt(ids[i]));
			delete(history);
		}
		return 0;
	}

	@Override
	public int insert(History e) {
		return dao.insert("history.insert", e);
	}

	@Override
	public int delete(History e) {
		return dao.delete("history.delete", e);
	}

	@Override
	public int update(History e) {
		return dao.update("history.update", e);
	}

	@Override
	public History selectOne(History e) {
		return (History) dao.selectOne("history.selectOne", e);
	}

	@Override
	public History selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(History e) {
		return dao.selectPageList("history.selectPageList",
				"history.selectPageCount", e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<History> selectList(History e) {
		if (e == null)
			return dao.selectList("history.selectList");
		return dao.selectList("history.selectList", e);
	}
	


}
