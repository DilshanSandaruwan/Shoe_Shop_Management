package lk.ijse.gdse66.ShoeShopFinal.service.impl;

import lk.ijse.gdse66.ShoeShopFinal.dto.CustomerDTO;
import lk.ijse.gdse66.ShoeShopFinal.persistence.entity.Customer;
import lk.ijse.gdse66.ShoeShopFinal.persistence.repository.CustomerRepository;
import lk.ijse.gdse66.ShoeShopFinal.service.CustomerService;
import lk.ijse.gdse66.ShoeShopFinal.service.execption.DublicateRecordException;
import lk.ijse.gdse66.ShoeShopFinal.service.execption.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;
    ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(
                customer -> modelMapper.map(customer,CustomerDTO.class)
        ).toList();
    }

    @Override
    public CustomerDTO getCustomerDetails(String id) {
        if(!customerRepository.existsByCustomerCode(id)){
            throw new NotFoundException("Customer "+id+" Not Found!");
        }
        return modelMapper.map(customerRepository.findByCustomerCode(id), CustomerDTO.class);
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        if(customerRepository.existsByCustomerCode(customerDTO.getCustomerCode())){
            throw new DublicateRecordException("This Customer "+customerDTO.getCustomerCode()+" already exicts...");
        }
        customerDTO.setCustomerCode(genarateNextCustomerCode());
        return modelMapper.map(customerRepository.save(modelMapper.map(
                customerDTO, Customer.class)), CustomerDTO.class
        );
    }

    @Override
    public void updateCustomer(String id, CustomerDTO customerDTO) {
        Customer existingCustomer = customerRepository.findByCustomerCode(id);

        if(existingCustomer.getCustomerName().isEmpty()){
            throw new NotFoundException("Customer ID"+ id + "Not Found...");
        }

        existingCustomer.setCustomerName(customerDTO.getCustomerName());
        existingCustomer.setGender(customerDTO.getGender());

        customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(String id) {
        if(!customerRepository.existsByCustomerCode(id)){
            throw  new NotFoundException("Customer ID"+ id + "Not Found...");
        }
        customerRepository.deleteByCustomerCode(id);
    }

    @Override
    public String genarateNextCustomerCode() {
        String lastCustomerCode = customerRepository.findLatestCustomerCode();
        if(lastCustomerCode==null){lastCustomerCode = "CUS000";}
        int numericPart = Integer.parseInt(lastCustomerCode.substring(3));
        numericPart++;
        String nextSupplierCode = "CUS" + String.format("%03d", numericPart);
        return nextSupplierCode;
    }
}
