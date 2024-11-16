package com.express.entities;

import java.util.List;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Category extends Auditable{

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;  
	private String name; 
	
	@OneToMany(mappedBy="category")
	@JsonIgnore
	private List<Product> products;
}
