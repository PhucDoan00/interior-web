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
	
	@Transactional
	@Query(value = "select * from Product", nativeQuery = true)
	List<Product> getAll();
	
	List<Product> findAll();
	
	Product getOne(long id);
	
	@Transactional
	@Query(value = "select top 1* from Product order by product_id desc", nativeQuery = true)
	Product getCreatedProduct();
	
	@Transactional
	@Query(value = "select * from Product where product_name like :param1", nativeQuery = true)
	List<Product> searchProduct(@Param("param1") String param1);
	
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_category on Product.product_id = product_category.product_id "
			+ "where category_id = :param1", nativeQuery = true)
	List<Product> getProductByCategory(@Param("param1") long param1);
	
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
	
	
	////////////////////////////////////SORT/////////////////////////////////////////////////
	//AFTER HAVING FILTERED BY ROOM
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_category on Product.product_id = product_category.product_id "
			+ "where category_id = :param1 order by price asc", nativeQuery = true)
	List<Product> sortByPriceAsc(@Param("param1") long param1);
	
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_category on Product.product_id = product_category.product_id "
			+ "where category_id = :param1 order by price desc", nativeQuery = true)
	List<Product> sortByPriceDesc(@Param("param1") long param1);
	
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_category on Product.product_id = product_category.product_id "
			+ "where category_id = :param1 order by bought_count desc", nativeQuery = true)
	List<Product> sortByBestSales(@Param("param1") long param1);
	
	
	//////////////////////////////FILTER BY COLOR//////////////////////////////////////////////
	//1. BLACK
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_color on Product.product_id = product_color.product_id inner join Color on product_color.color_id = Color.color_id "
			+ "where color_name like '%Black%' or product_color.color_id = 3 or product_color.color_id = 33", nativeQuery = true)
	List<Product> filterBlack();
	
	//2. PINK
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_color on Product.product_id = product_color.product_id inner join Color on product_color.color_id = Color.color_id "
			+ "where color_name like '%Pink%' or product_color.color_id = 4 or product_color.color_id = 6 or product_color.color_id = 13 or product_color.color_id = 23", nativeQuery = true)
	List<Product> filterPink();
	
	//3. YELLOW / ORANGE
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_color on Product.product_id = product_color.product_id inner join Color on product_color.color_id = Color.color_id "
			+ "where color_name like '%Yellow%' or color_name like '%Orange%' or product_color.color_id = 7 or product_color.color_id = 15 or product_color.color_id = 17 or product_color.color_id = 23 or product_color.color_id = 27", nativeQuery = true)
	List<Product> filterYellowOrange();
	
	//4. BLUE
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_color on Product.product_id = product_color.product_id inner join Color on product_color.color_id = Color.color_id "
			+ "where color_name like '%Blue%' or product_color.color_id = 8 or product_color.color_id = 11 or product_color.color_id = 24 or product_color.color_id = 25 or product_color.color_id = 26 or product_color.color_id = 28 or product_color.color_id = 29 or product_color.color_id = 34", nativeQuery = true)
	List<Product> filterBlue();
	
	//5. GREEN
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_color on Product.product_id = product_color.product_id inner join Color on product_color.color_id = Color.color_id "
			+ "where color_name like '%Green%' or product_color.color_id = 9 or product_color.color_id = 26", nativeQuery = true)
	List<Product> filterGreen();
	
	//6. GREY
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_color on Product.product_id = product_color.product_id inner join Color on product_color.color_id = Color.color_id "
			+ "where color_name like '%Grey%' or product_color.color_id = 10 or product_color.color_id = 29 or product_color.color_id = 33", nativeQuery = true)
	List<Product> filterGrey();
	
	//7. WHITE
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_color on Product.product_id = product_color.product_id inner join Color on product_color.color_id = Color.color_id "
			+ "where color_name like '%White%' or product_color.color_id = 5", nativeQuery = true)
	List<Product> filterWhite();
	
	//8. BROWN
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_color on Product.product_id = product_color.product_id inner join Color on product_color.color_id = Color.color_id "
			+ "where color_name like '%Brown%' or product_color.color_id = 17 or product_color.color_id = 19 or product_color.color_id = 20 or product_color.color_id = 21 or product_color.color_id = 27 or product_color.color_id = 30 or product_color.color_id = 31", nativeQuery = true)
	List<Product> filterBrown();
	
	//9. NATURAL
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_color on Product.product_id = product_color.product_id inner join Color on product_color.color_id = Color.color_id "
			+ "where color_name like '%Natural%'", nativeQuery = true)
	List<Product> filterNatural();
	
	//10. METALLIC
	@Transactional
	@Query(value = "select Product.product_id, Product.product_name, Product.price, Product.quantity, Product.[image], Product.[description], Product.bought_count, Product.material, Product.dimension "
			+ "from Product inner join product_color on Product.product_id = product_color.product_id inner join Color on product_color.color_id = Color.color_id "
			+ "where color_name like '%Metallic%' or product_color.color_id = 16 or product_color.color_id = 12 or product_color.color_id = 22", nativeQuery = true)
	List<Product> filterMetallic();
}
