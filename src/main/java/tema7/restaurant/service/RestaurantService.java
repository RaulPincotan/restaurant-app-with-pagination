package tema7.restaurant.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tema7.restaurant.domain.Restaurant;
import tema7.restaurant.domain.model.RestaurantFilters;
import tema7.restaurant.repository.RestaurantRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantValidator validator;

    public Page<Restaurant> getAllRestaurants(Pageable pageable, RestaurantFilters restaurantFilters) {
        if (!CollectionUtils.isEmpty(restaurantFilters.getCity())) {
            return restaurantRepository.findByCityIn(restaurantFilters.getCity(), pageable);
        }
        return restaurantRepository.findAll(pageable);
    }

    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }


    public Restaurant addRestaurant(Restaurant restaurant) {
        validator.validateNewThrow(restaurant);
        return restaurantRepository.save(restaurant);
    }

    public Restaurant replaceRestaurant(Long id, Restaurant restaurant) {
        validator.validateReplaceWithThrow(id, restaurant);
        Restaurant dbRestaurant = restaurantRepository.findById(id).get();
        copyRestaurant(dbRestaurant, restaurant);
        return restaurantRepository.save(dbRestaurant);
    }

    private void copyRestaurant(Restaurant dbRestaurant, Restaurant restaurant) {
        dbRestaurant.setCity(restaurant.getCity());
        dbRestaurant.setName(restaurant.getName());
        dbRestaurant.setSince(restaurant.getSince());
        dbRestaurant.setStars(restaurant.getStars());
    }
}
