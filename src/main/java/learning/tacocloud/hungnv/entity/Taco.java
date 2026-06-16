package learning.tacocloud.hungnv.entity;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {
	@NotNull
	@Size(min = 5, message = "Taco name must be at least 5 character")
	private String name;
	@NotNull
	@Size(min = 5, message = "You must choose at least 1 ingredient")
	private List<Ingredient> ingredients;
}
