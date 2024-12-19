package com.barbershop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barbershop.entities.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {

}
