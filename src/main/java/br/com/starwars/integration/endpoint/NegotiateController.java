package br.com.starwars.integration.endpoint;

import br.com.starwars.domain.dto.TransferRequestDTO;
import br.com.starwars.domain.service.ItemNegotiateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NegotiateController {

  @Autowired
  public ItemNegotiateService itemNegotiateService;

  @PostMapping("/negotiate")
  public ResponseEntity newNegotiate(@RequestBody TransferRequestDTO... object) {
    try {
      CollectionUtils.arrayToList(object).parallelStream()
          .forEach(o -> itemNegotiateService.negotiateItens((TransferRequestDTO) o));
    } catch (Exception e) {
    }
    return null;
  }

}
