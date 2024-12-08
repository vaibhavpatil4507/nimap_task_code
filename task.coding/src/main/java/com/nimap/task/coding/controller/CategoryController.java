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

import com.nimap.task.coding.entity.Category;
import com.nimap.task.coding.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

   //http://localhost:8080/api/categories?page=3
	@GetMapping
	public Page<Category> getAllCategories(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "3") int size) {
		Pageable pageable = PageRequest.of(page, size);
		return categoryService.getAllCategories(pageable);
	}

	// http://localhost:8080/api/categories
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}

	// http://localhost:8080/api/categories/2
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
		Optional<Category> category = categoryService.getCategoryById(id);
		return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	// http://localhost:8080/api/categories/2 (in req body Category json Obj)
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category categoryDetails) {
		Category updatedCategory = categoryService.updateCategory(id, categoryDetails);
		return ResponseEntity.ok(updatedCategory);
	}

	// http://localhost:8080/api/categories/2
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
}
