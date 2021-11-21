package br.com.starwars.domain.dto;

import br.com.starwars.domain.entity.Item;
import br.com.starwars.domain.entity.Rebel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TransferRequestDTO {

  private Item item;
  private Integer quantity;
  private Rebel destinyRebel;

}
