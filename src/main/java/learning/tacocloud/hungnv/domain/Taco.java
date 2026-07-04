package learning.tacocloud.hungnv.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Taco {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 5, message = "Taco name must be at least 5 character")
	private String name;

	private Date createdAt = new Date(0);

	@Size(min = 5, message = "You must choose at least 1 ingredient")
	@OneToMany
	private List<Ingredient> ingredients = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.ALL)
	private TacoOrder tacoOrder;
}
