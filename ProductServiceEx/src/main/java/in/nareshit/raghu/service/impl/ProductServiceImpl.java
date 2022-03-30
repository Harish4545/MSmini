package in.nareshit.raghu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nareshit.raghu.entity.Product;
import in.nareshit.raghu.repo.ProductRepository;
import in.nareshit.raghu.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository repo;
	
	public Long createProduct(Product p) {
		return repo.save(p).getId();
	}

	public List<Product> fetchAllProducts() {
		return repo.findAll();
	}

}
