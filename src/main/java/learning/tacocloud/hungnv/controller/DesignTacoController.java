package learning.tacocloud.hungnv.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import learning.tacocloud.hungnv.repository.IngredientRepository;
import learning.tacocloud.hungnv.domain.Ingredient;
import learning.tacocloud.hungnv.domain.Ingredient.Type;
import learning.tacocloud.hungnv.domain.Taco;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

  @Autowired
  private IngredientRepository ingredientRepository;

@ModelAttribute
public void addIngredientsToModel(Model model) {
    Iterable<Ingredient> ingredients = ingredientRepository.findAll();
    Type[] types = Ingredient.Type.values();
    for (Type type : types) {
      model.addAttribute(type.toString().toLowerCase(),
          filterByType((List<Ingredient>) ingredients, type));
    }
}
  @GetMapping
  public String showDesignForm(Model model) {
    model.addAttribute("taco", new Taco());
    return "design";
  }
  @PostMapping
  public String processTaco(@Valid @ModelAttribute("taco") Taco taco, Errors errors){
    if(errors.hasErrors()){
      return "design";
    }
    log.info("Processing taco: ", taco);
    return "redirect:/orders/current";
  }

  private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
    return ingredients
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
  }

  
}
