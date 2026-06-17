package learning.tacocloud.hungnv.data;

import java.util.Optional;

import learning.tacocloud.hungnv.entity.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);
}
