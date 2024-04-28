package miu.edu.cs489.ADS.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appointmentId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;
    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalTime appointmentTime;
    private String status;

    @ManyToMany
    @JoinTable(
            name = "appointment_bill",
            joinColumns = {@JoinColumn(name = "appointment_id", referencedColumnName = "appointmentId")},
            inverseJoinColumns = {@JoinColumn(name = "bill_id", referencedColumnName = "billId")}
    )
    private List<Bill> bills;

    @OneToMany(mappedBy = "appointment")
    List<Location> locations;

    @ManyToOne
    @JoinColumn(name="dentist_id")
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
