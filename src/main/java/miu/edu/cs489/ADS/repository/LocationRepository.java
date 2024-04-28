package miu.edu.cs489.ADS.repository;

import miu.edu.cs489.ADS.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
