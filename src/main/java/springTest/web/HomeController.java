package springTest.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import springTest.Hamburger;
@Slf4j

@Controller
@RequestMapping("/")
public class HomeController {
	
	
	@GetMapping	
	public String home(Model model) {
		
		return "home";
	}
	
}
