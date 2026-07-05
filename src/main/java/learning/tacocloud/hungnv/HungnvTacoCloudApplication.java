package learning.tacocloud.hungnv;

import learning.tacocloud.hungnv.domain.Ingredient.Type;
import learning.tacocloud.hungnv.repository.UserRepository;
import learning.tacocloud.hungnv.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class HungnvTacoCloudApplication {
	public static void main(String[] args) {
		SpringApplication.run(HungnvTacoCloudApplication.class, args);
	}

	@Autowired
	IngredientService ingredientService;

//	@Bean
//	public CommandLineRunner dataLoader(){
//		return args -> {
//			ingredientService.createIngredient("Flour Tortilla", Type.WRAP);
//			ingredientService.createIngredient("Corn Tortilla", Type.WRAP);
//			ingredientService.createIngredient("Ground Beef", Type.PROTEIN);
//			ingredientService.createIngredient("Carnitas", Type.PROTEIN);
//			ingredientService.createIngredient("Diced Tomatoes", Type.VEGGIES);
//			ingredientService.createIngredient("Lettuce", Type.VEGGIES);
//			ingredientService.createIngredient("Cheddar", Type.CHEESE);
//			ingredientService.createIngredient("Monterrey Jack", Type.CHEESE);
//			ingredientService.createIngredient("Salsa", Type.SAUCE);
//			ingredientService.createIngredient("Sour Cream", Type.SAUCE);
//		};
//	}

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		List<UserDetails> usersList = new ArrayList<>();
		usersList.add(new User(
				"buzz", encoder.encode("password"),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
		usersList.add(new User(
				"woody", encoder.encode("password"),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
		return new InMemoryUserDetailsManager(usersList);
	}

	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepository){
		return username -> {
			learning.tacocloud.hungnv.domain.User user = userRepository.findByUsername(username);
			if(user != null){
				return user;
			}
			throw new UsernameNotFoundException("User "+ username + " not found.");
		};
	}

}
