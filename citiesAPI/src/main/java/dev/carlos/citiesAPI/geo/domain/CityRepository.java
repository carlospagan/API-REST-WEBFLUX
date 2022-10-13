package dev.carlos.citiesAPI.geo.domain;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;


@Repository
public interface CityRepository extends ReactiveMongoRepository<City, String> {
    Flux<City> findByCityRegion(String cityRegion);
    Flux<City> findByCityName(String cityName);
}
