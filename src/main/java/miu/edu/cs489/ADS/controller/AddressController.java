package miu.edu.cs489.ADS.controller;

import miu.edu.cs489.ADS.dto.address.AddressResponse;
import miu.edu.cs489.ADS.model.Address;
import miu.edu.cs489.ADS.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("adsweb/api/v1/address")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping("/list")
    public ResponseEntity<List<AddressResponse>> getAllAddress(){
        return ResponseEntity.ok(addressService.getAllAddress());
    }
}
