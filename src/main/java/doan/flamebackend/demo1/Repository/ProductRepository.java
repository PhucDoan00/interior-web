package doan.flamebackend.demo1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import doan.flamebackend.demo1.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
