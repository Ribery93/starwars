package br.com.starwars.domain.entity;

import br.com.starwars.domain.enums.GenderEnum;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Rebel {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NonNull
  private String name;
  @NonNull
  private Integer age;
  @NonNull
  private BigDecimal balance;
  @Enumerated
  private GenderEnum gender;
  @ManyToOne
  @NonNull
  private Galaxy galaxy;
  @OneToMany
  private List<Item> iventory;

}
