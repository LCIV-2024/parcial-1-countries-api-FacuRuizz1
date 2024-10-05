package ar.edu.utn.frc.tup.lciii.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "country")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryEntity {

    @Id
    @Column
    private String code;

    @Column
    private String name;

    @Column(name = "continent")
    private String continent;

    @ElementCollection
    @CollectionTable(name = "country_languages", joinColumns = @JoinColumn(name = "country_code"))
    @Column(name = "languajes")
    private List<String> languages;
}