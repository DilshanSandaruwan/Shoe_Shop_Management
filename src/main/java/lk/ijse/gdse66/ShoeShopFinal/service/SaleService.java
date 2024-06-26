package lk.ijse.gdse66.ShoeShopFinal.service;


import lk.ijse.gdse66.ShoeShopFinal.dto.SalesDTO;

import java.util.List;
/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

public interface SaleService {
    List<SalesDTO> getAllSales();
    SalesDTO getSaleDetails(String id);
    SalesDTO saveSales(SalesDTO salesDTO);
    void updateSales(String id, SalesDTO salesDTO);
    void deleteSales(String id);
}
