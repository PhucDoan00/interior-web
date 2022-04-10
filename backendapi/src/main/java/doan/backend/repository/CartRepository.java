package doan.backend.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import doan.backend.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	@Transactional
	@Modifying
	@Query(value = "insert into Cart(customer_id, phone, email, [address], cart_status) values (:param1, :param2, :param3, :param4, 1)", nativeQuery = true)
	void newCart(@Param("param1") long param1,
				 @Param("param2") String param2,
				 @Param("param3") String param3,
				 @Param("param4") String param4);
	
	@Transactional
	@Query(value = "select count(*) from Cart where customer_id = :param1 and cart_status = 1", nativeQuery = true)
	int countAvailableCart (@Param("param1") long param1);
	
	@Transactional
	@Query(value = "select count(*) from cart_item where cart_id = :param1 and product_id = :param2", nativeQuery = true)
	int findAvailableItem (@Param("param1") long param1,
						   @Param("param2") long param2);
	
	@Transactional
	@Query(value = "select count(*) from cart_item where cart_id = :param1 and quantity > 0", nativeQuery = true)
	int countItemsInCart (@Param("param1") long param1);
	
	@Transactional
	@Modifying
	@Query(value = "insert into cart_item(cart_id, product_id, quantity, price, added_at) values (:param1, :param2, :param3, :param4, GETDATE())", nativeQuery = true)
	void insertCartItem(@Param("param1") long param1,
				 		@Param("param2") long param2,
				 		@Param("param3") int param3,
				 		@Param("param4") float param4);
	
	@Transactional
	@Query(value = "select * from Cart where customer_id = :param1 and cart_status = 1", nativeQuery = true)
	Cart findActiveCartByCustomerId (@Param("param1") long param1);
	
	@Transactional
	@Query(value = "select * from cart_item where cart_id = :param1 and product_id = :param2", nativeQuery = true)
	Iterable<Object[]> findItemInCart (@Param("param1") long param1,
						     		   @Param("param2") long param2);
	
	@Transactional
	@Query(value = "select * from cart_item where cart_id = :param1 and quantity > 0", nativeQuery = true)
	Iterable<Object[]> getItemsInCart (@Param("param1") long param1);
	
	@Transactional
	@Modifying
	@Query(value = "update cart_item set quantity = :param1 where cart_id = :param2 and product_id = :param3", nativeQuery = true)
	void updateItemQuantity(@Param("param1") int param1,
				 			@Param("param2") long param2,
				 			@Param("param3") long param3);
	
	@Transactional
	@Modifying
	@Query(value = "update Cart set cart_status = :param1 where cart_id = :param2", nativeQuery = true)
	void updateCartStatus(@Param("param1") long param1,
						  @Param("param2") long param2);
}
