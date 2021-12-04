package tema7.restaurant.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import tema7.restaurant.domain.Restaurant;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    boolean existsByNameAndCity(String name, String city);

    boolean existsByNameAndCityAndIdNot(String name, String city, Long id);

    Page<Restaurant> findByCityIn(List<String> cities, Pageable pageable);
}
