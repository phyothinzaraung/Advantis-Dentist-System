package miu.edu.cs489.ADS.service;

import miu.edu.cs489.ADS.model.Bill;
import miu.edu.cs489.ADS.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService{

    @Autowired
    BillRepository billRepository;

    @Override
    public Bill addNewBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> getAllBill() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBillById(Integer billId) {
        return billRepository.findById(billId).orElse(null);
    }

    @Override
    public Bill updateBill(Bill bill) {
        if(!billRepository.existsById(bill.getBillId())){
            throw new IllegalArgumentException("Bill not found with id: " + bill.getBillId());
        }
        return billRepository.save(bill);
    }

    @Override
    public void deleteBill(Integer billId) {
        billRepository.deleteById(billId);
    }
}
