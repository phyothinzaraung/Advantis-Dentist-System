package miu.edu.cs489.ADS.repository;

import miu.edu.cs489.ADS.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
}
