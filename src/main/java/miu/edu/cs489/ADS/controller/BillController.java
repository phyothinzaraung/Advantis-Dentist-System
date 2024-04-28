package miu.edu.cs489.ADS.controller;

import miu.edu.cs489.ADS.model.Bill;
import miu.edu.cs489.ADS.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillController {
    @Autowired
    private BillService billService;

    @GetMapping("api/ads/bills")
    List<Bill> getAllBills(){
        return billService.getAllBill();
    }
}
