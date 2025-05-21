package com.example.cadastroprodutos;

import java.sql.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastroprodutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroprodutosApplication.class, args);
	}

	public static Connection makeConnection() {
		return null;
	}

}
