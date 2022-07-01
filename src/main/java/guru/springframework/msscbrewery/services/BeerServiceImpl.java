package guru.springframework.msscbrewery.services;

import static java.util.UUID.randomUUID;

import guru.springframework.msscbrewery.web.model.BeerDto;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

  @Override
  public BeerDto getBeerById(UUID beerId) {
    return BeerDto.builder()
        .id(randomUUID())
        .beerName("Wise Sandwich")
        .beerStyle("IPA")
        .build();
  }

  @Override
  public BeerDto saveNewBeer(BeerDto beerDto) {
    return BeerDto.builder()
        .id(randomUUID())
        .build();
  }

  @Override
  public void updateBeer(UUID beerId, BeerDto beerDto) {
    //todo impl - would add a real impl to update beer
  }

  @Override
  public void deleteBeer(UUID beerId) {
    log.debug("Deleting beer ....");
  }
}
