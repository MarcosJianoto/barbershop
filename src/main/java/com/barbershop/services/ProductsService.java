package com.barbershop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barbershop.dto.ProductsDTO;
import com.barbershop.entities.Products;
import com.barbershop.repositories.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

	public void saveProducts(ProductsDTO productsDTO) {

		Products products = new Products();
		products.setName(productsDTO.getName());
		products.setPrice(productsDTO.getPrice());
		products.setQuantity(productsDTO.getQuantity());
		productsRepository.save(products);

	}

	public List<ProductsDTO> getProducts() {

		List<Products> products = productsRepository.findAll();
		List<ProductsDTO> productsDTOs = new ArrayList<>();

		if (!products.isEmpty()) {

			for (Products prods : products) {
				ProductsDTO prod = new ProductsDTO();
				prod.setName(prods.getName());
				prod.setPrice(prods.getPrice());
				prod.setQuantity(prods.getQuantity());
				productsDTOs.add(prod);
			}
		}

		return productsDTOs;
	}

	public ProductsDTO getProductId(Long id) {

		Optional<Products> productFindById = productsRepository.findById(id);
		ProductsDTO products = new ProductsDTO();
		if (productFindById.isPresent()) {
			products.setName(productFindById.get().getName());
			products.setPrice(productFindById.get().getPrice());
			products.setQuantity(productFindById.get().getQuantity());
		}

		return products;
	}

	public void updateProduct(Long id, ProductsDTO productsDTO) {

		Optional<Products> productFindById = productsRepository.findById(id);
		if (productFindById.isPresent()) {
			productFindById.get().setName(productsDTO.getName());
			productFindById.get().setPrice(productsDTO.getPrice());
			productFindById.get().setQuantity(productsDTO.getQuantity());
			productsRepository.save(productFindById.get());
		}

	}

	public void deleteProduct(Long id) {
		productsRepository.deleteById(id);
	}

}
