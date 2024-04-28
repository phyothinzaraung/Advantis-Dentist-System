package miu.edu.cs489.ADS.dto.appointment;

import miu.edu.cs489.ADS.model.Bill;
import miu.edu.cs489.ADS.model.Dentist;
import miu.edu.cs489.ADS.model.Location;
import miu.edu.cs489.ADS.model.Patient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public record AppointmentRequest(
        String date,
        String time,
        String status,
        List<Bill> bills,
        List<Location> locations,
        Dentist dentist,
        Patient patient
) {

}
