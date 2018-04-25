package br.com.cinq.spring.data.sample.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@XmlRootElement
@Data
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "name"})
@Entity
public class Country {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotNull
  @Size(min = 3, max = 40, message = "Invalid country name length")
  private String name;

  @XmlTransient @OneToMany private List<City> cities;
}
