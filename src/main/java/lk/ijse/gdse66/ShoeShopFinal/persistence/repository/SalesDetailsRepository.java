package lk.ijse.gdse66.ShoeShopFinal.persistence.repository;

import lk.ijse.gdse66.ShoeShopFinal.persistence.entity.SalesDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

public interface SalesDetailsRepository extends JpaRepository<SalesDetails,String> {
    Boolean existsBySalesOrderNo(String id);
    List<SalesDetails> findAllBySalesOrderNo(String id);
    void deleteAllBySalesOrderNo(String id);
    Boolean existsAllBySalesOrderNo(String id);
}
