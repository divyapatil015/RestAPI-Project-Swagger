package com.express.responses;

import java.util.List;

import com.express.entities.Product;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ProductBoResponse {

	int totalPageNumbers;
	long totalNumberofElements;
	List<Product> products;
}
