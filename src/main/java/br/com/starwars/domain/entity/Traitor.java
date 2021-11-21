package br.com.starwars.domain.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Traitor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;
  @OneToOne
  @NonNull
  public Rebel rebel;
  @NonNull
  public LocalDate dateReport;

}