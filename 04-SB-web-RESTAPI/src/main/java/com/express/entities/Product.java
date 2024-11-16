package com.express.entities;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Product extends Auditable{
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long Id;
	
	private String name;
	private double price;
	private Integer quantity;
	private String description;
	private Boolean isStock;
	private String barCode;
	
	//many to one
	@ManyToOne
	@JoinColumn(name="cat_id",nullable = false)
	private Category category;
}
