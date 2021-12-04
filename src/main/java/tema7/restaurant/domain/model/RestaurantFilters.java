package tema7.restaurant.domain.model;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class RestaurantFilters {
    List<String> city;
}
