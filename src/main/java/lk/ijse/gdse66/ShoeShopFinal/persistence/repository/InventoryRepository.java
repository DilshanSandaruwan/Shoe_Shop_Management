package lk.ijse.gdse66.ShoeShopFinal.persistence.repository;

import lk.ijse.gdse66.ShoeShopFinal.persistence.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

public interface InventoryRepository extends JpaRepository<Inventory,String> {
    Boolean existsByItemCode(String id);
    Inventory findByItemCode(String id);
    void deleteByItemCode(String id);
}
