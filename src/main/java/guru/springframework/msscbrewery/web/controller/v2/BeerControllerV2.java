package guru.springframework.msscbrewery.web.controller.v2;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import java.util.UUID;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
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

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

  private final BeerServiceV2 beerServiceV2;

  @GetMapping({"/{beerId}"})
  public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {

    return new ResponseEntity<>(beerServiceV2.getBeerById(beerId), OK);
  }

  @PostMapping //POST - Create a new beer
  public ResponseEntity handlePost(@Valid @RequestBody BeerDtoV2 beerDto) {

    log.debug("in handle post...");

    val savedDto = beerServiceV2.saveNewBeer(beerDto);

    var headers = new HttpHeaders();
    //todo add hostname to url
    headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
    return new ResponseEntity(headers, CREATED);
  }

  @PutMapping({"/{beerId}"})
  public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDtoV2 beerDto) {

    beerServiceV2.updateBeer(beerId, beerDto);
    return new ResponseEntity(NO_CONTENT);
  }

  @DeleteMapping({"/{beerId}"})
  @ResponseStatus(NO_CONTENT)
  public void deleteBeer(@PathVariable("beerId") UUID beerId) {
    beerServiceV2.deleteBeer(beerId);
  }
}
