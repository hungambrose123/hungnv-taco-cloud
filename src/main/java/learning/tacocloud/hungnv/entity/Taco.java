package learning.tacocloud.hungnv.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
public class Taco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 5, message = "Taco name must be at least 5 character")
	private String name;

	private Date createdAt = new Date(0);

	@NotNull
	@Size(min = 5, message = "You must choose at least 1 ingredient")
	@ManyToMany
	private List<Ingredient> ingredients = new ArrayList<>();

	public void addIngredient(Ingredient ingredient){
		this.ingredients.add(ingredient);
	}
}
