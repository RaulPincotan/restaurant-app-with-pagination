package tema7.restaurant;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tema7.restaurant.domain.Restaurant;
import tema7.restaurant.repository.RestaurantRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final RestaurantRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.saveAll(List.of(
                Restaurant.builder()
                        .name("La cuptor")
                        .since(LocalDate.of(2020, Month.JULY, 3))
                        .city("Oradea")
                        .stars(5)
                        .build(),
                Restaurant.builder()
                        .name("Graf")
                        .since(LocalDate.of(2005, Month.MAY, 17))
                        .city("Oradea")
                        .stars(5)
                        .build(),
                Restaurant.builder()
                        .name("Dristor")
                        .since(LocalDate.of(2009, Month.AUGUST, 11))
                        .city("Bucuresti")
                        .stars(3)
                        .build(),
                Restaurant.builder()
                        .name("Casa Boema")
                        .since(LocalDate.of(2018, Month.OCTOBER, 5))
                        .city("Cluj")
                        .stars(5)
                        .build(),
                Restaurant.builder()
                        .name("Micii")
                        .since(LocalDate.of(2009, Month.AUGUST, 11))
                        .city("Alesd")
                        .stars(3)
                        .build(),
                Restaurant.builder()
                        .name("Amoretti")
                        .since(LocalDate.of(2009, Month.AUGUST, 11))
                        .city("Arad")
                        .stars(3)
                        .build(),
                Restaurant.builder()
                        .name("LaPlacinte")
                        .since(LocalDate.of(2009, Month.AUGUST, 11))
                        .city("Pitesti")
                        .stars(4)
                        .build(),
                Restaurant.builder()
                        .name("Bistro22")
                        .since(LocalDate.of(2009, Month.AUGUST, 11))
                        .city("Cluj")
                        .stars(4)
                        .build(),
                Restaurant.builder()
                        .name("Bilbao")
                        .since(LocalDate.of(2009, Month.AUGUST, 11))
                        .city("Arad")
                        .stars(4)
                        .build(),
                Restaurant.builder()
                        .name("Beraria700")
                        .since(LocalDate.of(2009, Month.AUGUST, 11))
                        .city("Timisoara")
                        .stars(5)
                        .build(),
                Restaurant.builder()
                        .name("ArgentinianStake")
                        .since(LocalDate.of(2009, Month.AUGUST, 11))
                        .city("Timisoara")
                        .stars(4)
                        .build(),
                Restaurant.builder()
                        .name("Nicoresti")
                        .since(LocalDate.of(2009, Month.AUGUST, 11))
                        .city("Bucuresti")
                        .stars(4)
                        .build()
        ));

    }
}

