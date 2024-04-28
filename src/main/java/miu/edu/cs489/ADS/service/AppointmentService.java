package miu.edu.cs489.ADS.service;

import miu.edu.cs489.ADS.dto.appointment.AppointmentRequest;
import miu.edu.cs489.ADS.dto.appointment.AppointmentResponse;
import miu.edu.cs489.ADS.model.Appointment;
import miu.edu.cs489.ADS.repository.AppointmentRepository;

import java.util.List;

public interface AppointmentService {
    AppointmentResponse addNewAppointment(AppointmentRequest appointment);
    List<Appointment> getAllAppointments();
    Appointment findAppointmentById(Integer appointmentId);
    Appointment updateAppointment(Appointment appointment);
    void deleteAppointment(Integer appointmentId);
}
