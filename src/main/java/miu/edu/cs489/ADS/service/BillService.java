package miu.edu.cs489.ADS.service;

import miu.edu.cs489.ADS.model.Bill;

import java.util.List;

public interface BillService {
    Bill addNewBill(Bill bill);
    List<Bill> getAllBill();
    Bill getBillById(Integer billId);
    Bill updateBill(Bill bill);
    void deleteBill(Integer billId);
}
