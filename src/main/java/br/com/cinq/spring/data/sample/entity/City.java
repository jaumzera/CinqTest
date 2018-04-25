package br.com.cinq.spring.data.sample.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name"})
@Entity
public class City {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  @Size(min = 3, max = 40, message = "Invalid city name length")
  private String name;

  @NotNull(message = "Country can't be null")
  @ManyToOne
  @JoinColumn(name = "countryId")
  private Country country;
}
