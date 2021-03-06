package springTest.web;





import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springTest.Hamburger;
import springTest.Ingredient;
import springTest.Ingredient.Type;
import springTest.data.HamburgerRepository;
import springTest.data.IngredientRepository;


@Controller
@RequestMapping("/design")
public class DesignController {
	private IngredientRepository ingredientRepo;
	private HamburgerRepository  hamburgerRepo;
	
	@Autowired
	public DesignController(IngredientRepository ingredientRepo, HamburgerRepository hamburgerRepo) {
		this.ingredientRepo = ingredientRepo;
		this.hamburgerRepo = hamburgerRepo;
	}
	
	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = new ArrayList<>();
		
		ingredientRepo.findAll().forEach(i->ingredients.add(i));
		
		Type[] types = Ingredient.Type.values();
		
		for(Type type: types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
		
		return "design";
	}
	
	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type){
		return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
	}
	
	@ModelAttribute("hamburger")
	public Hamburger hamburger() {
		return new Hamburger();
	}
	
	@PostMapping	
	public String postDesignForm(Hamburger hamburger) {
		hamburgerRepo.save(hamburger);
		
		return "redirect:/orderList";
	}
}
