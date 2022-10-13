package dev.carlos.citiesAPI.geo.services;

import dev.carlos.citiesAPI.geo.models.requets.CityRequest;
import dev.carlos.citiesAPI.geo.models.responses.CityResponse;
import reactor.core.publisher.Flux;

public interface CityService {
    Flux<CityResponse> findAllCities();
    Flux<CityResponse> createCity(CityRequest cityRequest);
    Flux<CityResponse> findCitiesByRegion(String region);
}
