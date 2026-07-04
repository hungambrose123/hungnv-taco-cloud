package learning.tacocloud.hungnv.service;

import learning.tacocloud.hungnv.domain.Ingredient;
import learning.tacocloud.hungnv.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    @Autowired
    public IngredientRepository ingredientRepository;

    public Ingredient createIngredient(String name, Ingredient.Type type){
        return ingredientRepository.save(new Ingredient(name, type));
    }
}
