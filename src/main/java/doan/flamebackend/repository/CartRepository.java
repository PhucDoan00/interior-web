package doan.flamebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	Cart findByCartId(long cartId);
}
