package guru.springframework.sfgrestbrewery.repositories;


import guru.springframework.sfgrestbrewery.domain.Beer;
import guru.springframework.sfgrestbrewery.domain.BeerStyleEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

/*
    By default, Spring Data Rest provides a path related to beer entity as ".../beers".
    But, say that we want to make it ".../beer". So, we need to change path.

    Besides, the property name of the returned list of beers is "beers: [....]".
    Say that we want to make it "beerList". Then, change collectionResourceRel.
 */
@RepositoryRestResource(path = "beer", collectionResourceRel = "beerList")
public interface BeerRepository extends JpaRepository<Beer, UUID> {
    Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);

    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageable);

    Beer findByUpc(String upc);
}
