package ar.edu.utn.frc.tup.lciii.repository;

import ar.edu.utn.frc.tup.lciii.entities.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, String> {
    List<CountryEntity> findByCodeAndName(String code, String name);
    List<CountryEntity> findByContinent(String continent);
    List<CountryEntity> findByLanguagesContaining(String language);
}