package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.dtos.common.CountryDTO;
import ar.edu.utn.frc.tup.lciii.service.ICountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CountryController {

    @Qualifier("ICountryServiceImpl")
    private final ICountryService countryService;

    @GetMapping("/countries")
    public ResponseEntity<?> getAllCountries() {
        return ResponseEntity.ok(countryService.getALLCountries());
    }

    @GetMapping("/api/countries")
    public List<CountryDTO> getAlCountriesByCodeAndName(@RequestParam(required = false) String code,
                                                         @RequestParam(required = false) String name) {
        return countryService.getALLCountriesByCodeandName(code, name);
    }

    @GetMapping("/api/countries/{language}/language")
    public List<CountryDTO> getCountriesByLanguage(@PathVariable String language) {
        return countryService.getCountriesByLanguage(language);
    }

    @GetMapping("/api/countries/continent/{continent}")
    public List<CountryDTO> getCountriesByContinent(@PathVariable String continent) {
        return countryService.GetCountriesByContents(continent);
    }
}

//