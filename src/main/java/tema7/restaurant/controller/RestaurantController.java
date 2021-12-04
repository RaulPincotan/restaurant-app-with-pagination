package tema7.restaurant.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tema7.restaurant.domain.Restaurant;
import tema7.restaurant.domain.model.PageInfo;
import tema7.restaurant.domain.model.RestaurantFilters;
import tema7.restaurant.exceptions.RestaurantException;
import tema7.restaurant.service.CollectionResponse;
import tema7.restaurant.service.RestaurantService;

@RestController
@RequestMapping("restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping
    public CollectionResponse<Restaurant> getAllRestaurants(Pageable pageable, RestaurantFilters filters) {
        Page<Restaurant> restaurantsPage = restaurantService.getAllRestaurants(pageable, filters);
        return CollectionResponse.<Restaurant>builder()
                .content(restaurantsPage.getContent())
                .pageInfo(PageInfo.builder()
                        .currentPage(restaurantsPage.getNumber())
                        .totalElements((int) restaurantsPage.getTotalElements())
                        .totalPages(restaurantsPage.getTotalPages())
                        .pageSize(restaurantsPage.getSize())
                        .build())
                .build();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaurantService.getRestaurantById(id)
                .orElseThrow(() -> new RestaurantException("Restaurant with id " + id + " does not exist"));
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    public Restaurant replaceRestaurant(@PathVariable Long id, @RequestBody Restaurant restaurant) {
        return restaurantService.replaceRestaurant(id, restaurant);
    }

    @DeleteMapping("/{id}")
    public Restaurant removeRestaurant(@PathVariable Long id) {
        return restaurantService.removeRestaurant(id).orElseThrow(() -> new RestaurantException("Restaurant with id " + id + " no puedo deleto"));
    }
}
