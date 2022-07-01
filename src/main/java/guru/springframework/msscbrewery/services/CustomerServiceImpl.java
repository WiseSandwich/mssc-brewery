package guru.springframework.msscbrewery.services;

import static java.lang.Math.random;
import static java.util.UUID.randomUUID;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

  @Override
  public CustomerDto getCustomerById(UUID id) {
    return CustomerDto.builder()
        .id(id)
        .name("Customer".concat(String.valueOf(random())))
        .build();
  }

  @Override
  public CustomerDto saveNewCustomer(CustomerDto customerDto) {
    return CustomerDto.builder()
        .id(randomUUID())
        .build();
  }

  @Override
  public void updateCustomer(UUID customerId) {
    //todo impl - would add a real impl to update customer
  }

  @Override
  public void deleteCustomer(UUID customerId) {
    log.debug("Deleting Customer...");
  }
}
