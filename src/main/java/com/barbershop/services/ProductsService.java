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
		products.setStatus(productsDTO.getStatus());
		products.setDescription(productsDTO.getDescription());
		products.setBarcode(productsDTO.getBarcode());
		productsRepository.save(products);

	}

	public List<ProductsDTO> getProducts() {

		List<Products> products = productsRepository.findAll();
		List<ProductsDTO> productsDTOs = new ArrayList<>();

		if (!products.isEmpty()) {

			for (Products prods : products) {
				ProductsDTO prod = new ProductsDTO();
				prod.setId(prods.getId());
				prod.setName(prods.getName());
				prod.setPrice(prods.getPrice());
				prod.setQuantity(prods.getQuantity());
				prod.setStatus(prods.getStatus());
				prod.setDescription(prods.getDescription());
				prod.setBarcode(prods.getBarcode());
				productsDTOs.add(prod);
			}
		}

		return productsDTOs;
	}

	public ProductsDTO getProductId(Long id) {

		Optional<Products> productFindById = productsRepository.findById(id);
		ProductsDTO products = new ProductsDTO();
		if (productFindById.isPresent()) {
			Products prod = productFindById.get();

			products.setId(prod.getId());
			products.setName(prod.getName());
			products.setPrice(prod.getPrice());
			products.setQuantity(prod.getQuantity());
			products.setStatus(prod.getStatus());
			products.setDescription(prod.getDescription());
			products.setBarcode(prod.getBarcode());
		}

		return products;
	}

	public void updateProduct(Long id, ProductsDTO productsDTO) {

		Optional<Products> productFindById = productsRepository.findById(id);
		if (productFindById.isPresent()) {
			Products prod = productFindById.get();
			prod.setName(productsDTO.getName());
			prod.setPrice(productsDTO.getPrice());
			prod.setQuantity(productsDTO.getQuantity());
			prod.setStatus(productsDTO.getStatus());
			prod.setDescription(productsDTO.getDescription());
			prod.setBarcode(productsDTO.getBarcode());
			productsRepository.save(productFindById.get());
		}

	}

	public void deleteProduct(Long id) {
		productsRepository.deleteById(id);
	}

}
