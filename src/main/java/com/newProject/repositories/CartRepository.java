package com.newProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.newProject.models.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	@SuppressWarnings("unchecked")
	Cart save(Cart cart);
	
	public static final String DELETE_FROM_CART_MASTER_O_WHERE_O_CART_ID_ID = "DELETE FROM CART_MASTER o WHERE o.cart_id =:Id";
	
	public static final String SELECT_FROM_CART_MASTER_O_WHERE_O_USER_ID_ID = "SELECT * FROM CART_MASTER o where o.user_id = :id";

	public static final String DELETE_FROM_CART_MASTER_O_WHERE_O_USER_ID_ID = "DELETE FROM CART_MASTER o WHERE o.user_id =:userId";

	
	@Modifying
    @Query(value = DELETE_FROM_CART_MASTER_O_WHERE_O_CART_ID_ID , nativeQuery = true)
    void deleteById(int Id);

	@Query(value =  SELECT_FROM_CART_MASTER_O_WHERE_O_USER_ID_ID , nativeQuery = true)
	List<Cart> getCartDetailById(Long id);

	void deleteById(Long userId);

	@Modifying
    @Query(value = DELETE_FROM_CART_MASTER_O_WHERE_O_USER_ID_ID , nativeQuery = true)
	void deleteCartByUserId(Long userId);
}
