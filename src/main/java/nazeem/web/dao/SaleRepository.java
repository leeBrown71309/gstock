package nazeem.web.dao;


import nazeem.web.model.Product;
import nazeem.web.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
@Query("SELECT p FROM Product p INNER JOIN Sale s ON p.id = s.product_id")
    List getAllSaleProduct();

}
