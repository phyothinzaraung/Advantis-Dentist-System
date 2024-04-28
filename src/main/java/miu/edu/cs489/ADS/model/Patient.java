package miu.edu.cs489.ADS.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
@DiscriminatorValue("patient")
public class Patient extends User{
    private String dob;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.PERSIST)
    private List<Appointment> appointmentList;
}
