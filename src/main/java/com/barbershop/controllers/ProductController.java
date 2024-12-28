package com.barbershop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barbershop.dto.ProductsDTO;
import com.barbershop.services.ProductsService;

@RestController
public class ProductController {

	@Autowired
	private ProductsService productsService;

	@PostMapping("/saveproduct")
	public ResponseEntity<Void> saveProduct(@RequestBody ProductsDTO productsDTO) {
		productsService.saveProducts(productsDTO);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/getproducts")
	public ResponseEntity<List<ProductsDTO>> getProducts() {

		List<ProductsDTO> listProducts = productsService.getProducts();
		return ResponseEntity.ok().body(listProducts);
	}

	@GetMapping("/getproductid/{id}")
	public ResponseEntity<ProductsDTO> getProductId(@PathVariable Long id) {

		ProductsDTO productFindId = productsService.getProductId(id);
		return ResponseEntity.ok().body(productFindId);
	}

	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<Void> updateProductId(@PathVariable Long id, @RequestBody ProductsDTO productsDTO) {

		productsService.updateProduct(id, productsDTO);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/deleteproduct/{id}")
	public void deleteProductId(@PathVariable Long id) {

		productsService.deleteProduct(id);
	}

}
