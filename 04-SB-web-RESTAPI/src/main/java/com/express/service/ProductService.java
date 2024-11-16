package com.express.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.express.entities.Product;
import com.express.repository.ProductRepository;
import com.express.responses.ProductBoResponse;
import com.express.service.exception.ResourceNotfoundException;

@Service
public class ProductService {

	
	@Autowired
	private ProductRepository productRepository;
	
	public void createProduct(Product product) {
		product.setIsStock(true);
		product.setBarCode(UUID.randomUUID().toString());
		productRepository.save(product);
	}
	public Product fetchProductInfo(long productId) {
		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotfoundException("Product Not Found"));
	}
	public List<Product> fetchProducts(String name) {
		return productRepository.findByCategoryName(name);
	}
	public ProductBoResponse fetchProducts(PageRequest pageRequest) {
		// TODO Auto-generated method stub
		Page <Product> page = productRepository.findAll(pageRequest);
		ProductBoResponse productBoResponse = new ProductBoResponse();
		
		productBoResponse.setTotalPageNumbers(page.getTotalPages());
		productBoResponse.setTotalNumberofElements(page.getTotalElements());
		productBoResponse.setProducts(page.getContent());
		return productBoResponse;
	}
}

