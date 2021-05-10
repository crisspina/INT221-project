package casecoolors.Repositories;

import casecoolors.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value ="select MAX(productid) from Product ")
    public Integer lastedProductId();
}
