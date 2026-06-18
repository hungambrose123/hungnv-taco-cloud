package learning.tacocloud.hungnv.web;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import learning.tacocloud.hungnv.data.IngredientRepository;
import learning.tacocloud.hungnv.entity.Ingredient;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient>{
    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id){
        return ingredientRepository.findById(id).orElse(null);
    }
}
