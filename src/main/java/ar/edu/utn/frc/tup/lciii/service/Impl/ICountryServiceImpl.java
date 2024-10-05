// ICountryServiceImpl.java
package ar.edu.utn.frc.tup.lciii.service.Impl;

import ar.edu.utn.frc.tup.lciii.Clients.RestClient;
import ar.edu.utn.frc.tup.lciii.configs.RestTemplateConfig;
import ar.edu.utn.frc.tup.lciii.dtos.common.CountryDTO;
import ar.edu.utn.frc.tup.lciii.entities.CountryEntity;
import ar.edu.utn.frc.tup.lciii.model.Country;
import ar.edu.utn.frc.tup.lciii.repository.CountryRepository;
import ar.edu.utn.frc.tup.lciii.service.ICountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ICountryServiceImpl implements ICountryService {

    private final CountryRepository countryRepository;
    private final RestTemplate restTemplate; // Inyectar RestTemplate
    private final RestClient restClient;

    public List<Country> getAllCountries() {
        String url = "https://restcountries.com/v3.1/all";
        List<Map<String, Object>> response = restTemplate.getForObject(url, List.class);
        return response.stream().map(this::mapToCountry).collect(Collectors.toList());
    }

    private Country mapToCountry(Map<String, Object> countryData) {
        Map<String, Object> nameData = (Map<String, Object>) countryData.get("name");
        return Country.builder()
                .name((String) nameData.get("common"))
                .population(((Number) countryData.get("population")).longValue())
                .area(((Number) countryData.get("area")).doubleValue())
                .region((String) countryData.get("region"))
                .languages((Map<String, String>) countryData.get("languages"))
                .build();
    }

    private CountryDTO mapToDTO(Country country) {
        return new CountryDTO(country.getCode(), country.getName());
    }

    @Override
    public List<CountryDTO> getALLCountries() {
        List<CountryDTO> countries = restClient.getAllCountries() ;
        if (countries == null) {
            throw new RuntimeException("No se encontraron los paises");
        } else {
            return countries.stream().map(country -> new CountryDTO(country.getCode(), country.getName()))
                    .collect(Collectors.toList());
        }
    }

    public List<CountryDTO> getALLCountriesByCodeandName(String code, String name) {
        List<CountryDTO> countries = restClient.getAllCountryByCodeandName(code,name);
        return countries.stream().map(country -> new CountryDTO(country.getCode(), country.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryDTO> GetCountriesByContents(String continent) {
        List<CountryDTO> countries = restClient.GetCountriesByContents(continent);
        return countries.stream().map(country -> new CountryDTO(country.getCode(), country.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryDTO> getCountriesByLanguage(String language) {
        List<CountryDTO> countryEntities = restClient.getCountriesByLanguage(language);
        return countryEntities.stream().map(country -> new CountryDTO(country.getCode(),country.getName()))
                .collect(Collectors.toList());
    }

}