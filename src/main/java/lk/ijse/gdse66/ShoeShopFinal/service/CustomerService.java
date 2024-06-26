package lk.ijse.gdse66.ShoeShopFinal.service;

import lk.ijse.gdse66.ShoeShopFinal.dto.CustomerDTO;

import java.util.List;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerDetails(String id);
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String id, CustomerDTO customerDTO);
    void deleteCustomer(String id);
    String genarateNextCustomerCode();
}
