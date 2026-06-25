package learning.tacocloud.hungnv.data;

import learning.tacocloud.hungnv.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
