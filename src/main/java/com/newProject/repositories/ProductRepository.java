package com.newProject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.newProject.models.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	
	@SuppressWarnings("unchecked")
	Product save(Product productDetail);

	@Query(value = "SELECT * FROM PRODUCT_MASTER", nativeQuery = true)
	List<Product> getAllProducts();
	
	Optional<Product> findById(Long prdId);

	@Query(value = "SELECT * FROM PRODUCT_MASTER p where p.prd_id= :prdId", 
		    nativeQuery = true)
	Optional<Product> check(Long prdId);

	void deleteById(Long prdId);

}
