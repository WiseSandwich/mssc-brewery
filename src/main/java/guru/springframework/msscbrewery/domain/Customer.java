package guru.springframework.msscbrewery.domain;

import java.util.UUID;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

  private UUID id;

  @Size(min = 3, max = 100)
  @NotBlank
  private String name;

}
