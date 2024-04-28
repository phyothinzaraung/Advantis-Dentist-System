package miu.edu.cs489.ADS.repository;

import miu.edu.cs489.ADS.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Integer> {
}
