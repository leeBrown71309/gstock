package nazeem.web.dao;


import nazeem.web.model.Product;
import nazeem.web.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
@Query("SELECT p FROM Product p INNER JOIN Sale s ON p.id = s.product_id")
    List getAllSaleProduct();

@Transactional
@Modifying
@Query("delete FROM Sale s WHERE s.product_id = :product_id")
    int removeProduct(@Param("product_id") Long ProductID);

}
