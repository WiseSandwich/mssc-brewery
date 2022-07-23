package guru.springframework.msscbrewery.web.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import java.util.UUID;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

  private final CustomerService customerService;

  CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping({"/{customerId}"})
  public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId) {

    return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity createCustomer(@RequestBody CustomerDto customerDto) {

    CustomerDto savedCustomerDto = customerService.saveNewCustomer(customerDto);

    HttpHeaders headers = new HttpHeaders();
    //todo add hostname url
    headers.add("Location", "/api/v1/customer/" + savedCustomerDto.getId().toString());
    return new ResponseEntity(headers, CREATED);
  }

  @PutMapping({"/{customerId}"})
  @ResponseStatus(NO_CONTENT)
  public void updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto) {
    customerService.updateCustomer(customerId);
  }

  @DeleteMapping({"/{customerId}"})
  @ResponseStatus(NO_CONTENT)
  public void deleteBeer(@PathVariable("customerId") UUID customerId) {
    customerService.deleteCustomer(customerId);
  }
}
