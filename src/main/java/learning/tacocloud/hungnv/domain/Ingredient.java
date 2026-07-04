package learning.tacocloud.hungnv.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class Ingredient {
	public Ingredient(String name, Ingredient.Type type){
		this.name = name;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Type type;

	public enum Type{
		WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
	}

	@ManyToOne(cascade = CascadeType.ALL)
	private Taco taco;
}
