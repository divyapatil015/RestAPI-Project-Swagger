package com.express.entities;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class User extends Auditable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String username;
	private String password;
	private String email;


}
