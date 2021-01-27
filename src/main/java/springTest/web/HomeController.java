package springTest.web;

import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.beans.factory.annotation.Autowired;

import springTest.Ingredient;
import springTest.data.IngredientRepository;
@Slf4j
@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping	
	public String home() {
		return "home";
	}
	
}
