package doan.backend.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import doan.backend.entity.Product;
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Transactional
	@Query(value = "select top 5* from Product order by bought_count desc", nativeQuery = true)
	List<Product> getTop5();
	
	List<Product> findAll();
	
	Product getOne(long id);
	
	@Transactional
	@Query(value = "select top 1* from Product order by product_id desc", nativeQuery = true)
	Product getCreatedProduct();
	
	@Transactional
	@Query(value = "select * from Product where product_name like :param1", nativeQuery = true)
	List<Product> searchProduct(@Param("param1") String param1);
	
	@Transactional
	@Query(value = "select count(*) from Product where product_id = :param1", nativeQuery = true)
	int countExistID (@Param("param1") long param1);
	
	@Transactional
	@Modifying
	@Query(value = "insert into Product(product_name, price, quantity, bought_count, material, dimension, [image], [description]) "
			+ "values (:param1, :param2, :param3, 0, :param4, :param5, :param6, :param7)", nativeQuery = true)
	void insertProduct(@Param("param1") String param1,
					   @Param("param2") float param2,
					   @Param("param3") int param3,
					   @Param("param4") String param4,
					   @Param("param5") String param5,
					   @Param("param6") String param6,
					   @Param("param7") String param7);
	
	@Transactional
	@Modifying
	@Query(value = "insert into product_color(product_id, color_id) values (:param1, :param2)", nativeQuery = true)
	void insertProductColor(@Param("param1") long param1,
							@Param("param2") long param2);
	
	@Transactional
	@Modifying
	@Query(value = "insert into product_category(product_id, category_id) values (:param1, :param2)", nativeQuery = true)
	void insertProductCategory(@Param("param1") long param1,
							   @Param("param2") long param2);
	
	@Transactional
	@Modifying
	@Query(value = "update Product\r\n"
			+ "set product_name = :param1, price = :param2, quantity = :param3, [image] = :param4, [description] = :param5, material = :param6, dimension = :param7\r\n"
			+ "where product_id = :param8", nativeQuery = true)
	void editProductInfo(@Param("param1") String param1,
					   @Param("param2") float param2,
					   @Param("param3") int param3,
					   @Param("param4") String param4,
					   @Param("param5") String param5,
					   @Param("param6") String param6,
					   @Param("param7") String param7,
					   @Param("param8") long param8);
	
	@Transactional
	@Modifying
	@Query(value = "update Product set quantity = :param1 where product_id = :param2", nativeQuery = true)
	void editProductQuantity(@Param("param1") int param1,
					   		 @Param("param2") long param2);
	
	@Transactional
	@Modifying
	@Query(value = "update Product set bought_count = :param1 where product_id = :param2", nativeQuery = true)
	void editProductBoughtCount(@Param("param1") int param1,
					   		 @Param("param2") long param2);
	
	@Transactional
	@Modifying
	@Query(value = "delete from product_color where product_id = :param1", nativeQuery = true)
	void deleteProductColor(@Param("param1") long param1);
	
	@Transactional
	@Modifying
	@Query(value = "delete from product_category where product_id = :param1", nativeQuery = true)
	void deleteProductCategory(@Param("param1") long param1);
}
