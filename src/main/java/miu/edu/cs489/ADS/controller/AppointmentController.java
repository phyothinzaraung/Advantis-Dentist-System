package miu.edu.cs489.ADS.controller;

import miu.edu.cs489.ADS.dto.appointment.AppointmentRequest;
import miu.edu.cs489.ADS.dto.appointment.AppointmentResponse;
import miu.edu.cs489.ADS.model.Appointment;
import miu.edu.cs489.ADS.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adsweb/api/v1/appointment")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/list")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }

    @PostMapping("/new")
    public ResponseEntity<AppointmentResponse> addNewAppointment(@RequestBody AppointmentRequest appointmentRequest){
        
        return new ResponseEntity<>(appointmentService.addNewAppointment(appointmentRequest), HttpStatus.OK);
    }
}
