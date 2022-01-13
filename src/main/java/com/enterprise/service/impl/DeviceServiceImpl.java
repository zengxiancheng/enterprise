package com.enterprise.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.enterprise.dao.BaseDao;
import com.enterprise.entity.Device;
import com.enterprise.entity.page.PageModel;
import com.enterprise.service.DeviceService;

@Service("deviceService")
public class DeviceServiceImpl  implements DeviceService {
	
	 @Resource
	private BaseDao dao;
	public void setDao(BaseDao dao) {
		this.dao = dao;
		
	}
	
	// 多行删除方法
	public int deletes(String[] ids) {
		Device device = new Device();
		for (int i = 0; i < ids.length; i++) {
			device.setId(Integer.parseInt(ids[i]));
			delete(device);
		}
		return 0;
	}

	@Override
	public int insert(Device e) {
		return dao.insert("device.insert", e);
	}

	@Override
	public int delete(Device e) {
		return dao.delete("device.delete", e);
	}

	@Override
	public int update(Device e) {
		return dao.update("device.update", e);
	}

	@Override
	public Device selectOne(Device e) {
		return (Device) dao.selectOne("device.selectOne", e);
	}

	@Override
	public Device selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(Device e) {
		return dao.selectPageList("device.selectPageList",
				"device.selectPageCount", e);
	}

	@Override
	public List<Device> selectList(Device e) {
		if (e == null)
			return dao.selectList("device.selectList");
		return dao.selectList("device.selectList", e);
	}
	


}
