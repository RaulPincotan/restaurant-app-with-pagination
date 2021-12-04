package tema7.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tema7.restaurant.domain.Restaurant;
import tema7.restaurant.exceptions.ValidatorException;
import tema7.restaurant.repository.RestaurantRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RestaurantValidator {
    private final RestaurantRepository repository;

    public void validateNewThrow(Restaurant restaurant) {
        validate(restaurant, true).ifPresent(exception -> {
            throw exception;
        });
    }

    public void validateReplaceWithThrow(Long id, Restaurant restaurant) {
        exist(id).or(() -> validate(restaurant, false))
                .ifPresent(exception -> {
                    throw exception;
                });
    }

    private Optional<ValidatorException> validate(Restaurant restaurant, boolean newEntity) {
        if (restaurant.getName() == null || restaurant.getCity() == null) {
            return Optional.of(new ValidatorException(" Nor name nor city can be left null"));
        } else if (newEntity && repository.existsByNameAndCity(restaurant.getName(), restaurant.getCity())) {
            return Optional.of(new ValidatorException("A restaurant with the same name in the same city cannot exist"));
        } else if (newEntity && repository.existsByNameAndCityAndIdNot(restaurant.getName(), restaurant.getCity(), restaurant.getId())) {
            return Optional.of(new ValidatorException("A restaurant with the same name in the same city cannot exist"));
        } else {
            return Optional.empty();
        }
    }

    private Optional<ValidatorException> exist(Long id) {
        return repository.existsById(id) ? Optional.empty()
                : Optional.of(new ValidatorException("Product with id " + id + " does not exist "));
    }


}
