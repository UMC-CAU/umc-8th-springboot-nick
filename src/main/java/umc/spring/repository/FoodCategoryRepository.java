package umc.spring.repository;

import org.springframework.data.repository.CrudRepository;
import umc.spring.domain.FoodCategory;

public interface FoodCategoryRepository extends CrudRepository<FoodCategory, Long> {
}
