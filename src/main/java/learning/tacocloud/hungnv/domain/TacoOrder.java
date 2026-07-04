package learning.tacocloud.hungnv.domain;


import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TacoOrder{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String deliveryName;
	@NotBlank
	private String deliveryStreet;
	@NotBlank
	private String deliveryCity;
	@NotBlank
	private String deliveryState;
	@NotBlank	
	private String deliveryZip;
	@CreditCardNumber(message = "Not a credit card number")	
	private String ccNumber;
	@Pattern(regexp = "0[1-9]|1[0-2]([\\/])([1-9][0-9])$", message = "Must be a formatted MM/YY")
	private String ccExpiration;
	@Digits(integer = 3, fraction = 0, message = "Invalid CVV")
	private String ccCVV;

	private Date placedAt = new Date();

	@OneToMany
	List<Taco> tacos = new ArrayList<>();
}
