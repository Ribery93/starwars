package br.com.starwars.domain.service;

import br.com.starwars.domain.dto.TransferRequestDTO;
import br.com.starwars.domain.entity.Item;
import br.com.starwars.domain.entity.Rebel;
import br.com.starwars.domain.exception.NegotiateBalanceException;
import br.com.starwars.integration.repository.ItemRepository;
import br.com.starwars.integration.repository.RebelRepository;
import java.math.BigDecimal;
import java.util.StringJoiner;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Service
public class ItemNegotiateService {

  @Autowired
  private RebelRepository rebelRepository;
  @Autowired
  private ItemRepository itemRepository;

  public void negotiateItens(TransferRequestDTO... transferRequest) {
    CollectionUtils.arrayToList(transferRequest)
        .parallelStream()
        .forEach(transfer -> validateRequest((TransferRequestDTO) transfer));
  }

  private void validateRequest(TransferRequestDTO transferRequestDTO) {
    StringJoiner result = new StringJoiner(",");

    Validate.notNull(transferRequestDTO.getItem());
    Validate.notNull(transferRequestDTO.getDestinyRebel());
    Validate.notNaN(transferRequestDTO.getQuantity());

    if (transferRequestDTO.getItem().getQuantity().compareTo(transferRequestDTO.getQuantity())
        >= 0) {
      finalizeRequest(transferRequestDTO);
    }
    throw new NegotiateBalanceException("Quantidade solicitada é maior que o saldo do negociante.");

  }

  private void finalizeRequest(TransferRequestDTO transferRequestDTO) {
    Item item = itemRepository.getOne(transferRequestDTO.getItem().getId());

    Rebel origin = rebelRepository.getByIventory(item);
    Rebel destiny = rebelRepository.getOne(transferRequestDTO.getDestinyRebel().getId());

    BigDecimal totalValue = calculateValue(transferRequestDTO, item);

    startedTransaction(transferRequestDTO, item, destiny, origin, totalValue);


  }

  private BigDecimal calculateValue(TransferRequestDTO transferRequestDTO, Item item) {
    BigDecimal totalValue = item.getPrice()
        .multiply(BigDecimal.valueOf(transferRequestDTO.getQuantity()));
    return totalValue;
  }

  private void startedTransaction(TransferRequestDTO transferRequestDTO,
      Item item,
      Rebel destiny,
      Rebel origin,
      BigDecimal totalValue) {

    item.setQuantity(item.getQuantity() - transferRequestDTO.getQuantity());
    transferRequestDTO.getItem().setId(null);
    destiny.getIventory().add(transferRequestDTO.getItem());
    transferRequestDTO.getDestinyRebel()
        .setBalance(transferRequestDTO.getDestinyRebel().getBalance().subtract(totalValue));

    origin.getBalance().add(totalValue);
    persistChanges(destiny, origin, item);
  }

  @Transactional
  protected void persistChanges(Rebel destiny, Rebel origin, Item item) {
    itemRepository.save(item);
    rebelRepository.save(destiny);
    rebelRepository.save(origin);
  }
}
