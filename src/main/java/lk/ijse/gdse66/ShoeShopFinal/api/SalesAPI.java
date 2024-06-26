package lk.ijse.gdse66.ShoeShopFinal.api;

import jakarta.validation.Valid;;
import lk.ijse.gdse66.ShoeShopFinal.dto.SalesDTO;
import lk.ijse.gdse66.ShoeShopFinal.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

@RestController
@RequestMapping("api/v0/sales")
public class SalesAPI {
    private final SaleService saleService;

    public SalesAPI(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<SalesDTO> getAllSales(){
        return saleService.getAllSales();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    SalesDTO saveSales(@Valid @RequestBody SalesDTO salesDTO){
        return saleService.saveSales(salesDTO);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateSales(@Valid @RequestBody SalesDTO salesDTO){
        saleService.updateSales(salesDTO.getOrderNo(),salesDTO);
    }

    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteSales(@PathVariable("id") String id){
        saleService.deleteSales(id);
    }

    @PatchMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    SalesDTO getSales(@PathVariable("id") String id){
        return saleService.getSaleDetails(id);
    }
}
