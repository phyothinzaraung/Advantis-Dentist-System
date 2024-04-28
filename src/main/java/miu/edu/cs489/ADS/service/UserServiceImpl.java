package miu.edu.cs489.ADS.service;

import miu.edu.cs489.ADS.dto.address.AddressResponse;
import miu.edu.cs489.ADS.dto.patient.PatientRequest;
import miu.edu.cs489.ADS.dto.patient.PatientResponse;
import miu.edu.cs489.ADS.exception.UserNotFoundException;
import miu.edu.cs489.ADS.model.*;
import miu.edu.cs489.ADS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public PatientResponse addNewPatient(PatientRequest patientRequest) {
        Patient newPatient = new Patient();
        newPatient.setFirstName(patientRequest.firstName());
        newPatient.setLastName(patientRequest.lastName());
        newPatient.setEmail(patientRequest.email());
        String password = new BCryptPasswordEncoder().encode(patientRequest.password());
        newPatient.setPassword(password);
        newPatient.setPhoneNumber(patientRequest.phoneNumber());
        newPatient.setDob(patientRequest.dob());
        newPatient.setAddress(new Address(
                null,
                patientRequest.address().getStreet(),
                patientRequest.address().getCity(),
                patientRequest.address().getState(),
                patientRequest.address().getZipCode()
        ));

        Patient patient = userRepository.save(newPatient);
        return new PatientResponse(
                patient.getUserId(),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getEmail(),
                patient.getPassword(),
                patient.getPhoneNumber(),
                patient.getDob(),
                new AddressResponse(
                        patient.getAddress().getAddressId(),
                        patient.getAddress().getStreet(),
                        patient.getAddress().getCity(),
                        patient.getAddress().getState(),
                        patient.getAddress().getZipCode()
                ));
    }

    @Override
    public List<PatientResponse> getAllPatient() {
        return userRepository.getAllPatient()
                .stream()
                .map(patient -> new PatientResponse(
                        patient.getUserId(),
                        patient.getFirstName(),
                        patient.getLastName(),
                        patient.getEmail(),
                        patient.getPassword(),
                        patient.getPhoneNumber(),
                        patient.getDob(),
                        (patient.getAddress()!=null)?
                                new AddressResponse(
                                        patient.getAddress().getAddressId(),
                                        patient.getAddress().getStreet(),
                                        patient.getAddress().getCity(),
                                        patient.getAddress().getState(),
                                        patient.getAddress().getZipCode())
                        : null))
                .toList()
                ;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElse(null);
    }

//    @Override
//    public List<Dentist> getAllDentist() {
//        return userRepository.getAllDentist();
//    }
//
//    @Override
//    public List<Manager> getAllManager() {
//        return userRepository.getAllManager();
//    }
//
////    @Override
////    public List<Patient> getAllPatient() {
////        return userRepository.getAllPatient();
////    }

    @Override
    public PatientResponse getPatientById(Integer patientId) throws UserNotFoundException {
        var patientOptional = userRepository.findById(patientId);
        if(patientOptional.isPresent()){
            var patient = (Patient)patientOptional.get();
            return new PatientResponse(
                    patient.getUserId(),
                    patient.getFirstName(),
                    patient.getLastName(),
                    patient.getEmail(),
                    patient.getPassword(),
                    patient.getPhoneNumber(),
                    patient.getDob(),
                    patient.getAddress() != null ? new AddressResponse(
                            patient.getAddress().getAddressId(),
                            patient.getAddress().getStreet(),
                            patient.getAddress().getCity(),
                            patient.getAddress().getState(),
                            patient.getAddress().getZipCode())
                            : null);
        }else {
            throw new UserNotFoundException(String.format("Error: User with Id, %d, is not found.", patientId));
        }
    }

    @Override
    public PatientResponse updatePatient(Integer userId, PatientRequest editUser) {
        User user = userRepository.findById(userId).orElse(null);
        if(user != null){
            user.setFirstName(editUser.firstName());
            user.setLastName(editUser.lastName());
            user.setEmail(editUser.email());
            user.setPassword(editUser.password());
            user.setPhoneNumber(editUser.phoneNumber());
            if(user.getAddress() != null){
                Address address = user.getAddress();
                address.setStreet(editUser.address().getStreet());
                address.setCity(editUser.address().getCity());
                address.setState(editUser.address().getState());
                address.setZipCode(editUser.address().getZipCode());
                user.setAddress(address);
            }else {
                Address newAddress = new Address();
                newAddress.setStreet(editUser.address().getStreet());
                newAddress.setCity(editUser.address().getCity());
                newAddress.setState(editUser.address().getState());
                newAddress.setZipCode(editUser.address().getZipCode());
                newAddress.setUser(user);
                user.setAddress(newAddress);
            }

            Patient editedUser = (Patient) userRepository.save(user);
            return new PatientResponse(
                    editedUser.getUserId(),
                    editedUser.getFirstName(),
                    editedUser.getLastName(),
                    editedUser.getEmail(),
                    editedUser.getPassword(),
                    editedUser.getPhoneNumber(),
                    editedUser.getDob(),
                    new AddressResponse(
                            editedUser.getAddress().getAddressId(),
                            editedUser.getAddress().getStreet(),
                            editedUser.getAddress().getCity(),
                            editedUser.getAddress().getState(),
                            editedUser.getAddress().getZipCode()));
        }else {
            return null;
        }
    }

    @Override
    public String deletePatient(Integer userId) {
        userRepository.deleteById(userId);
        return String.format("Patient with Id, %d, is deleted successfully.", userId);
    }

    @Override
    public List<PatientResponse> searchPatient(String searchString) {
        List<User> users = userRepository.findAll();
        return users.stream().filter(user ->
                user.getFirstName().contains(searchString) ||
                        user.getLastName().contains(searchString) ||
                        user.getEmail().contains(searchString)||
                        user.getPhoneNumber().contains(searchString)
        ).map(user -> new PatientResponse(
                user.getUserId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhoneNumber(),
                "",
                (user.getAddress() != null) ?
                        new AddressResponse(user.getAddress().getAddressId(),
                                user.getAddress().getStreet(),
                                user.getAddress().getCity(),
                                user.getAddress().getState(),
                                user.getAddress().getZipCode()) : null)).toList();
    }
}
