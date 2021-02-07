package springTest.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springTest.Hamburger;
import springTest.data.HamburgerRepository;

@Controller
@RequestMapping("/orderList")
public class orderListController {
	private HamburgerRepository hamburgerRepo;
	
	@Autowired
	public orderListController(HamburgerRepository hamburgerRepo) {
		this.hamburgerRepo = hamburgerRepo;
	}
	
	@GetMapping
	public String orderListController(Model model) {
		List<Hamburger> hamburgers = new ArrayList<>();
		
		hamburgerRepo.findAll().forEach(i->hamburgers.add(i));
		
		model.addAttribute("hamburgers", hamburgers);
		
		return "orderList";
	}
}
