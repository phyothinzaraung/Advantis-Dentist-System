package miu.edu.cs489.ADS.repository;

import miu.edu.cs489.ADS.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
