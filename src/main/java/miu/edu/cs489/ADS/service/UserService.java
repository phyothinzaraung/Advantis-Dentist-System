package miu.edu.cs489.ADS.service;

import miu.edu.cs489.ADS.dto.patient.PatientRequest;
import miu.edu.cs489.ADS.dto.patient.PatientResponse;
import miu.edu.cs489.ADS.exception.UserNotFoundException;
import miu.edu.cs489.ADS.model.User;

import java.util.List;

public interface UserService {
    PatientResponse addNewPatient(PatientRequest patientRequest);
    List<PatientResponse> getAllPatient();
    User getUserByEmail(String email);
//    List<Dentist> getAllDentist();
//    List<Manager> getAllManager();
    PatientResponse getPatientById(Integer patientId) throws UserNotFoundException;
    PatientResponse updatePatient(Integer patientId, PatientRequest user);
    String deletePatient(Integer patientId);
    List<PatientResponse> searchPatient(String searchString);
}
