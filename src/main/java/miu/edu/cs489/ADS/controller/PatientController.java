package miu.edu.cs489.ADS.controller;

import jakarta.validation.Valid;
import miu.edu.cs489.ADS.dto.patient.PatientRequest;
import miu.edu.cs489.ADS.dto.patient.PatientResponse;
import miu.edu.cs489.ADS.exception.UserNotFoundException;
import miu.edu.cs489.ADS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("adsweb/api/v1/patient")
public class PatientController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<PatientResponse>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllPatient());
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponse> getUserById(@PathVariable Integer patientId) throws UserNotFoundException {
        return new ResponseEntity<>(userService.getPatientById(patientId), HttpStatus.CREATED);
    }

    @PostMapping("/register")
    public ResponseEntity<PatientResponse> addNewUser(@Valid @RequestBody PatientRequest patientRequest){
        return ResponseEntity.ok(userService.addNewPatient(patientRequest));
    }

    @PutMapping("/update/{patientId}")
    public ResponseEntity<PatientResponse> updateUser(@PathVariable Integer patientId, @RequestBody PatientRequest patient){
        return new ResponseEntity<>(userService.updatePatient(patientId, patient), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{patientId}")
    public ResponseEntity<String> deletePatientById(@PathVariable Integer patientId){
        return new ResponseEntity<>(userService.deletePatient(patientId), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PatientResponse>> searchPatient(@Param("searchString") String searchString){
        return new ResponseEntity<>(userService.searchPatient(searchString), HttpStatus.OK);
    }
}

