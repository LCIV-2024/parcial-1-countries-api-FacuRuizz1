package ar.edu.utn.frc.tup.lciii.service;

import ar.edu.utn.frc.tup.lciii.dtos.common.CountryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICountryService {
    List<CountryDTO> getALLCountries();
    List<CountryDTO> getALLCountriesByCodeandName(String code,String name);
    List<CountryDTO> GetCountriesByContents(String cotinent);
    List<CountryDTO> getCountriesByLanguage(String language);
}
