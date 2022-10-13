package dev.carlos.citiesAPI.geo.services.implementation;

import dev.carlos.citiesAPI.geo.domain.City;
import dev.carlos.citiesAPI.geo.domain.CityRepository;
import dev.carlos.citiesAPI.geo.models.requets.CityRequest;
import dev.carlos.citiesAPI.geo.models.responses.CityResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;

@Service
public class CityServiceImpl {
    @Autowired
    private CityRepository cityRepository;

    public Flux<CityResponse> findAllCities() {
        ModelMapper modelMapper = new ModelMapper();

        return cityRepository.findAll()
                .map(city -> {
                    return modelMapper.map(city, CityResponse.class);
                });
    }

    public Flux<CityResponse> createCity(CityRequest cityRequest) {

        ModelMapper modelMapper = new ModelMapper();

        return cityRepository.findByCityName(cityRequest.getCityName())
                .map(city -> {
                    if(city.getCityUf().equals(cityRequest.getCityUf())) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                    }
                    return modelMapper.map(city, CityResponse.class);
                })
                .doOnComplete(() -> {
                    cityRepository.save(modelMapper.map(cityRequest, City.class)).subscribe();
                });
    }

    public Flux<CityResponse> findCitiesByRegion(String cityRegion) {
        return cityRepository.findByCityRegion(cityRegion)
                .map(city -> {
                    return new ModelMapper().map(city, CityResponse.class);
                });
    }

}
