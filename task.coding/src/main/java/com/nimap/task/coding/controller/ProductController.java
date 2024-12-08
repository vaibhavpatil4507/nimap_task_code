package com.nimap.task.coding.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.task.coding.entity.Product;
import com.nimap.task.coding.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	
	//http://localhost:8080/api/products?page2
	@GetMapping
	public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return productService.getAllProducts(pageable);
	}

	
	//http://localhost:8080/api/products    (req body Product object )
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	//http://localhost:8080/api/products/2
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		Optional<Product> product = productService.getProductById(id);
		return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	//http://localhost:8080/api/products/2
	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
		Product updatedProduct = productService.updateProduct(id, productDetails);
		return ResponseEntity.ok(updatedProduct);
	}

	//http://localhost:8080/api/products/2
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
	}
}
