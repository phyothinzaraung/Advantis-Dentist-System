package miu.edu.cs489.ADS;

import miu.edu.cs489.ADS.dto.address.AddressResponse;
import miu.edu.cs489.ADS.model.Address;
import miu.edu.cs489.ADS.repository.AddressRepository;
import miu.edu.cs489.ADS.service.AddressServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplTest {

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImpl addressService;

    private Address address;
    private AddressResponse addressResponse;

    @BeforeEach
    void setUp(){
        address = new Address(1, "123 Main Street", "Fairfield", "Iowa", "52556");
        addressResponse = new AddressResponse(1, "123 Main Street", "Fairfield", "Iowa", "52556");
    }

    @Test
    void getAllAddress_ShouldReturnListOfAddressResponses(){
        when(addressRepository.findAll()).thenReturn(Arrays.asList(address));
        List<AddressResponse> result = addressService.getAllAddress();
        assertEquals(1, result.size());
        assertEquals(addressResponse, result.get(0));
        verify(addressRepository).findAll();
    }

    @Test
    void getAddressById_ShouldReturnOneAddress(){
        when(addressRepository.findById(1)).thenReturn(Optional.of(address));
        Address result = addressService.getAddressById(1);
        assertEquals(address, result);
        verify(addressRepository).findById(1);
    }
}
