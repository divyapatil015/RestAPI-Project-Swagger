package com.express.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.express.entities.Product;
import com.express.responses.ProductBoResponse;
import com.express.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping
	public void createProduct(@RequestBody Product product) {
		 productService.createProduct(product);
	}
	
	@GetMapping("{pId}")
	public Product fetchProduct(@PathVariable(name ="pId") long productId) {
		return productService.fetchProductInfo(productId);
	}
	
	@GetMapping("category/{name}")
	public List<Product> fetchProductBasedOnCategoryName(@PathVariable String name) {
		return productService.fetchProducts(name);
	}
	
	@GetMapping("/pagination")
	public  ProductBoResponse fetchProducts(@RequestParam(defaultValue="0") Integer pageNo,
			@RequestParam(defaultValue="5") Integer pageSize, 
			@RequestParam(defaultValue="DESC") String sortBy ) {
		 if(sortBy.equals("ASC")) {
			 return productService.fetchProducts(PageRequest.of(pageNo, pageSize,Direction.ASC,"price"));
		 }else {
			 return productService.fetchProducts(PageRequest.of(pageNo, pageSize,Direction.DESC,"price"));
		 }
		
	}
}
