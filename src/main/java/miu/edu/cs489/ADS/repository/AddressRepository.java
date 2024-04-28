package miu.edu.cs489.ADS.repository;

import miu.edu.cs489.ADS.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
