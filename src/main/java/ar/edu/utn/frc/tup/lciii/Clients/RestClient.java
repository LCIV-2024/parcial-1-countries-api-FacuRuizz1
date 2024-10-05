package ar.edu.utn.frc.tup.lciii.Clients;

import ar.edu.utn.frc.tup.lciii.dtos.common.CountryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RestClient {
    private final RestTemplate restTemplate;

    public List<CountryDTO> getAllCountries(){
        String url = "https://restcountries.com/v3.1/all";
        ResponseEntity<List<CountryDTO>> rest = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CountryDTO>>() {
        });
        return rest.getBody();

    }
    public List<CountryDTO> getAllCountryByCodeandName(String code, String name){
        String url = "https://restcountries.com/v3.1/all";
        ResponseEntity<List<CountryDTO>> rest = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CountryDTO>>() {
        });
        return rest.getBody();

    }
    public List<CountryDTO> GetCountriesByContents(String continent){
        String url = "https://restcountries.com/v3.1/all";
        ResponseEntity<List<CountryDTO>> rest = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CountryDTO>>() {
        });
        return rest.getBody();

    }
    public List<CountryDTO> getCountriesByLanguage(String languaje){
        String url = "https://restcountries.com/v3.1/all";
        ResponseEntity<List<CountryDTO>> rest = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<CountryDTO>>() {
        });
        return rest.getBody();

    }




}
