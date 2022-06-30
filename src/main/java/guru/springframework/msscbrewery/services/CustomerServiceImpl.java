package guru.springframework.msscbrewery.services;

import static java.lang.Math.*;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Override
  public CustomerDto getCustomerById(UUID id) {
    return CustomerDto.builder()
        .id(id)
        .name("Customer".concat(String.valueOf(random())))
        .build();
  }
}
