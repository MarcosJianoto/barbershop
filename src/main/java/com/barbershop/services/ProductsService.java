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

    private final ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public void saveProducts(ProductsDTO productsDTO) {

        Products products = new Products(productsDTO.getName(), productsDTO.getPrice(),
                productsDTO.getQuantity(), productsDTO.getDescription(), productsDTO.getStatus(), productsDTO.getBarcode());
        productsRepository.save(products);
    }

    public List<ProductsDTO> getProducts() {

        List<Products> products = productsRepository.findAll();
        List<ProductsDTO> productsDTOs = new ArrayList<>();

        if (!products.isEmpty()) {
            for (Products prods : products) {
                ProductsDTO prod = new ProductsDTO(prods.getId(), prods.getName(), prods.getPrice(), prods.getQuantity(),
                        prods.getDescription(), prods.getStatus(), prods.getBarcode());
                productsDTOs.add(prod);
            }
        }

        return productsDTOs;
    }

    public Products findProductById(Long id) {
        return productsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Product not found"));
    }

    public ProductsDTO getProductId(Long id) {

        Products prod = findProductById(id);
        return new ProductsDTO(prod.getId(), prod.getName(), prod.getPrice(), prod.getQuantity(),
                prod.getDescription(), prod.getStatus(), prod.getBarcode());
    }

    public void updateProduct(Long id, ProductsDTO productsDTO) {

        Products prod = findProductById(id);
        prod.setName(productsDTO.getName());
        prod.setPrice(productsDTO.getPrice());
        prod.setQuantity(productsDTO.getQuantity());
        prod.setStatus(productsDTO.getStatus());
        prod.setDescription(productsDTO.getDescription());
        prod.setBarcode(productsDTO.getBarcode());
        productsRepository.save(prod);

    }

    public void deleteProduct(Long id) {
        productsRepository.deleteById(id);
    }

}
