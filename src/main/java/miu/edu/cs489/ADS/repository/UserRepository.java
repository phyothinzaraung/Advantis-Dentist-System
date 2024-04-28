package miu.edu.cs489.ADS.repository;

import miu.edu.cs489.ADS.model.Dentist;
import miu.edu.cs489.ADS.model.Manager;
import miu.edu.cs489.ADS.model.Patient;
import miu.edu.cs489.ADS.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "SELECT * FROM users WHERE role= \'dentist\'", nativeQuery = true)
    List<Dentist> getAllDentist();

    @Query(value = "SELECT * FROM users WHERE role= \'manager\'", nativeQuery = true)
    List<Manager> getAllManager();

    @Query(value = "SELECT * FROM users WHERE role= \'patient\'", nativeQuery = true)
    List<Patient> getAllPatient();

    Optional<User> findUserByEmail(String email);
}
