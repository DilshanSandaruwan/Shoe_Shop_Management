package lk.ijse.gdse66.ShoeShopFinal.service;

import lk.ijse.finalcoursework.shoeshop.dto.InventoryDTO;
import lk.ijse.gdse66.ShoeShopFinal.dto.InventoryDTO;

import java.util.List;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

public interface InventoryService {
    List<InventoryDTO> getAllInventory();
    InventoryDTO getInventoryDetails(String id);
    InventoryDTO saveInventory(InventoryDTO inventoryDTO);
    void updateInventory(String id, InventoryDTO inventoryDTO);
    void deleteInventory(String id);
}
