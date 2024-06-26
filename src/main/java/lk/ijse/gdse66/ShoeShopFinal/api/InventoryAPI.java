package lk.ijse.gdse66.ShoeShopFinal.api;

import lk.ijse.gdse66.ShoeShopFinal.dto.InventoryDTO;
import lk.ijse.gdse66.ShoeShopFinal.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;

/**
 * @author: Dilshan Sandaruwan,
 * @Runtime version: 11.0.11+9-b1341.60 amd64
 **/

@RestController
@RequestMapping("api/v0/inventory")
@RequiredArgsConstructor
public class InventoryAPI {
    private final InventoryService inventoryService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    List<InventoryDTO> getAllInventory(){
        return inventoryService.getAllInventory();
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    InventoryDTO saveInventory(@RequestPart("data") InventoryDTO inventoryDTO,@RequestPart("itempic")String itempic){
        String base64ProfilePic = Base64.getEncoder().encodeToString(itempic.getBytes());
        inventoryDTO.setItemPicture(
                base64ProfilePic
        );
        return inventoryService.saveInventory(inventoryDTO);
    }

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void updateInventory(@RequestPart("data") InventoryDTO inventoryDTO,@RequestPart("itempic")String itempic){
        String base64ProfilePic = Base64.getEncoder().encodeToString(itempic.getBytes());
        inventoryDTO.setItemPicture(
                base64ProfilePic
        );
        inventoryService.updateInventory(inventoryDTO.getItemCode(),inventoryDTO);
    }

    @DeleteMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    void deleteInventory(@PathVariable("id") String itemCode){
        inventoryService.deleteInventory(itemCode);
    }

    @PatchMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    InventoryDTO getInventory(@PathVariable("id") String id){
        return inventoryService.getInventoryDetails(id);
    }
}
