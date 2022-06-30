package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDto;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class BeerServiceImpl implements BeerService {

  @Override
  public BeerDto getBeerById(UUID beerId) {
    return BeerDto.builder()
        .id(UUID.randomUUID())
        .beerName("Wise Sandwich")
        .beerStyle("IPA")
        .build();
  }
}
