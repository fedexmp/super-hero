package com.superhero.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tbl_users")
@Setter
@Getter
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "username", unique=true, nullable = false)
	private String username;

	@Column(name = "password", nullable = false)
	private String password;

}
