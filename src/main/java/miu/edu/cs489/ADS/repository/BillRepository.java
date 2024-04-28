package miu.edu.cs489.ADS.repository;

import miu.edu.cs489.ADS.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
