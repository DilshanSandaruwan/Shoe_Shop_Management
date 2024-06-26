package lk.ijse.gdse66.ShoeShopFinal.service.impl;


import lk.ijse.gdse66.ShoeShopFinal.dto.SalesDTO;
import lk.ijse.gdse66.ShoeShopFinal.dto.SalesInventoryDTO;
import lk.ijse.gdse66.ShoeShopFinal.persistence.entity.Sales;
import lk.ijse.gdse66.ShoeShopFinal.persistence.entity.SalesDetails;
import lk.ijse.gdse66.ShoeShopFinal.persistence.repository.SalesDetailsRepository;
import lk.ijse.gdse66.ShoeShopFinal.persistence.repository.SalesRepository;
import lk.ijse.gdse66.ShoeShopFinal.service.SaleService;
import lk.ijse.gdse66.ShoeShopFinal.service.execption.DublicateRecordException;
import lk.ijse.gdse66.ShoeShopFinal.service.execption.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

@Service
@Transactional
public class SaleServiceImpl implements SaleService {
    SalesRepository salesRepository;
    SalesDetailsRepository salesDetailsRepository;
    ModelMapper modelMapper;

    public SaleServiceImpl(SalesRepository salesRepository, SalesDetailsRepository salesDetailsRepository, ModelMapper modelMapper) {
        this.salesRepository = salesRepository;
        this.salesDetailsRepository = salesDetailsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<SalesDTO> getAllSales() {
        return salesRepository.findAll().stream().map(
                sales -> modelMapper.map(sales, SalesDTO.class)
        ).toList();
    }

    @Override
    public SalesDTO getSaleDetails(String id) {
        if(!salesRepository.existsByOrderNo(id)){
            throw new NotFoundException("Sales "+id+" Not Found!");
        }
        SalesDTO salesDTO = modelMapper.map(salesRepository.findByOrderNo(id), SalesDTO.class);
        System.out.println("ID-----------------------"+id);
        List<SalesInventoryDTO> salesInventory = salesDetailsRepository.findAllBySalesOrderNo(id).stream().map(
                salesDetails -> modelMapper.map(salesDetails, SalesInventoryDTO.class)
        ).toList();
        salesDTO.setInventory(salesInventory);

        return salesDTO;
    }

    @Override
    public SalesDTO saveSales(SalesDTO salesDTO) {
        if(salesRepository.existsByOrderNo(salesDTO.getOrderNo())){
            throw new DublicateRecordException("This Sales "+salesDTO.getOrderNo()+" already exicts...");
        }
        SalesDTO newsalesDTO = modelMapper.map(salesRepository.save(modelMapper.map(
                salesDTO, Sales.class)), SalesDTO.class
        );

        List<SalesInventoryDTO> salesInventoryDTO = new ArrayList<>();
        for (SalesInventoryDTO inventoryDTO : salesDTO.getInventory()) {
            /*System.out.println("------------------------");
            System.out.println(inventoryDTO.getInventory());*/
            SalesDetails savedSaleDetails = salesDetailsRepository.save(modelMapper.map(inventoryDTO, SalesDetails.class));
            salesInventoryDTO.add(modelMapper.map(savedSaleDetails, SalesInventoryDTO.class));
        }
        newsalesDTO.setInventory(salesInventoryDTO);
        return newsalesDTO;
    }

    @Override
    public void updateSales(String id, SalesDTO salesDTO) {
        for (SalesInventoryDTO inventoryDTO : salesDTO.getInventory()) {
            if(!salesDetailsRepository.existsById(inventoryDTO.getId())){
                throw new NotFoundException("Update Failed; Sales id: " +
                        salesDTO.getOrderNo() + " does not exist");
            }
            salesDetailsRepository.save(modelMapper.map(inventoryDTO, SalesDetails.class));
        }
    }

    @Override
    public void deleteSales(String id) {
        if(!salesDetailsRepository.existsBySalesOrderNo(id)){
            throw  new NotFoundException("Sales "+ id + "Not Found...");
        }
        salesDetailsRepository.deleteAllBySalesOrderNo(id);
        salesRepository.deleteByOrderNo(id);
    }
}
