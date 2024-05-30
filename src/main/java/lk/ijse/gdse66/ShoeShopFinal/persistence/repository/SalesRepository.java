package lk.ijse.gdse66.ShoeShopFinal.persistence.repository;

import lk.ijse.gdse66.ShoeShopFinal.persistence.entity.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

public interface SalesRepository extends JpaRepository<Sales,String> {
    Boolean existsByOrderNo(String id);
    Sales findByOrderNo(String id);
    void deleteByOrderNo(String id);
}
