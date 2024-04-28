package miu.edu.cs489.ADS.service;

import miu.edu.cs489.ADS.dto.appointment.AppointmentRequest;
import miu.edu.cs489.ADS.dto.appointment.AppointmentResponse;
import miu.edu.cs489.ADS.model.Appointment;
import miu.edu.cs489.ADS.model.Dentist;
import miu.edu.cs489.ADS.model.Location;
import miu.edu.cs489.ADS.model.Patient;
import miu.edu.cs489.ADS.repository.AppointmentRepository;
import miu.edu.cs489.ADS.repository.DentistRepository;
import miu.edu.cs489.ADS.repository.LocationRepository;
import miu.edu.cs489.ADS.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService{

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DentistRepository dentistRepository;

    @Autowired
    LocationRepository locationRepository;


    @Override
    public AppointmentResponse addNewAppointment(AppointmentRequest appointment) {
        Appointment apt = appointmentRepository.save(new Appointment(0, LocalDate.parse(appointment.date(), DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalTime.parse(appointment.time(), DateTimeFormatter.ofPattern("HH:mm:ss")), appointment.status(), appointment.bills(), appointment.locations(), appointment.dentist(), appointment.patient()));
        return new AppointmentResponse(apt.getAppointmentId(), apt.getAppointmentDate(), apt.getAppointmentTime(), apt.getStatus(), apt.getBills(), apt.getLocations(), apt.getDentist(), apt.getPatient());
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment findAppointmentById(Integer appointmentId) {
        return appointmentRepository.findById(appointmentId).orElse(null);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment) {
        if(!appointmentRepository.existsById(appointment.getAppointmentId())){
            throw new IllegalArgumentException("Appointment not found with id: " + appointment.getAppointmentId());
        }
        return appointmentRepository.save(appointment);
    }

    @Override
    public void deleteAppointment(Integer appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }
}
