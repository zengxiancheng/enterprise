package com.enterprise.service.impl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.enterprise.dao.BaseDao;
import com.enterprise.entity.Product;
import com.enterprise.entity.page.PageModel;
import com.enterprise.service.ProductService;

@Service("productService")
public class ProductServiceImpl  implements ProductService {
	
	 @Resource
	private BaseDao dao;
	public void setDao(BaseDao dao) {
		this.dao = dao;
		
	}
	
	// 多行删除方法
	public int deletes(String[] ids) {
		Product product = new Product();
		for (int i = 0; i < ids.length; i++) {
			product.setId(Integer.parseInt(ids[i]));
			delete(product);
		}
		return 0;
	}

	@Override
	public int insert(Product e) {
		return dao.insert("product.insert", e);
	}

	@Override
	public int delete(Product e) {
		return dao.delete("product.delete", e);
	}

	@Override
	public int update(Product e) {
		return dao.update("product.update", e);
	}

	@Override
	public Product selectOne(Product e) {
		return (Product) dao.selectOne("product.selectOne", e);
	}

	@Override
	public Product selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageModel selectPageList(Product e) {
		return dao.selectPageList("product.selectPageList",
				"product.selectPageCount", e);
	}

	@Override
	public List<Product> selectList(Product e) {
		if (e == null)
			return dao.selectList("product.selectList");
		return dao.selectList("product.selectList", e);
	}
	


}
