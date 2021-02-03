package springTest.web;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import springTest.Hamburger;

@Controller
@RequestMapping("/orderList")
public class orderLlistController {
	
	@GetMapping
	public String orderListController() {
		
		
		return "orderList";
	}
}
