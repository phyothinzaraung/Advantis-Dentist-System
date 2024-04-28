package miu.edu.cs489.ADS;

import miu.edu.cs489.ADS.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdsApplication implements CommandLineRunner {

	@Autowired
	AddressService addressService;

	@Autowired
	LocationService locationService;

	@Autowired
	UserService userService;

	@Autowired
	AppointmentService appointmentService;

	@Autowired
	BillService billService;

	public static void main(String[] args) {
		SpringApplication.run(AdsApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {

//		Address address = new Address(1, "123 Main St", "Some City", "CA", "90001");
//		addressService.addNewAddress(address);
//
//		Address address1 = addressService.getAddressById(1);
//
//
//		User user = new User(0, "John", "Doe", "555-1234-109", "john.doe@example.com", "password123", "1990-01-01", "PATIENT",address1);
//		userService.addNewUser(user);
//
//
//		Location location = new Location(1, "Surgery Location 1", "641-233-9999", address);
//		locationService.addNewLocation(location);
//
//		Bill bill1 = new Bill(1, 100.0, "Paid");
//		billService.addNewBill(bill1);
//
//		Bill bill2 = new Bill(2, 150.0, "Pending");
//		billService.addNewBill(bill2);
//
//		User user1 = userService.getUserById(2);
//		Appointment appointment = new Appointment(1, LocalDate.of(2024, 4, 15), LocalDate.of(2024, 4, 15), "Scheduled", user1);
//		appointmentService.addNewAppointment(appointment);

		//createUser();
    }

//	private void createUser(){
//		var patient = new Patient();
//		patient.setFirstName("Thao");
//		patient.setLastName("Vu");
//		patient.setDob("10/10/1990");
//		var savedPatient = (Patient)userService.addNewUser(patient);
//
//		var dentist = new Dentist();
//		dentist.setFirstName("John");
//		dentist.setLastName("Vu");
//		dentist.setSpecialization("Orthodentist");
//		var savedDentist = (Dentist) userService.addNewUser(dentist);
//
//		var appointment = new Appointment();
//		appointment.setAppointmentDate(LocalDate.of(2024, 5, 1));
//		appointment.setAppointmentTime(LocalTime.of(10, 30));
//		appointment.setDentist(savedDentist);
//		appointment.setPatient(savedPatient);
//
//		appointmentService.addNewAppointment(appointment);
//
//	}

//	private void createAddress(){
//		var address = new Address(null, "1000 N 4th ST", "Fairfield", "IA", "52556");
//		var savedAddress = addressService.addNewAddress(address);
//		System.out.println(savedAddress);
//	}

//	private void getAllAddresses(){
//		var res = addressService.getAllAddress();
//		for(Address a: res){
//			System.out.println(a);
//		}
//	}
}
