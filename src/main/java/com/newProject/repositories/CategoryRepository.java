package com.newProject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.newProject.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@SuppressWarnings("unchecked")
	Category save(Category categoryDetail);

	@Query(value = "SELECT * FROM CATEGORY_MASTER", nativeQuery = true)
	List<Category> getAllCategories();

	@Query(value = "SELECT * FROM CATEGORY_MASTER cm WHERE cm.cat_id = :catId", nativeQuery = true)
	Optional<Category> getCatById(Long catId);
}
