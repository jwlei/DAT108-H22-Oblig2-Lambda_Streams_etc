package ex2.task4.controller;

import ex2.task4.object.King;
import ex2.task4.object.ListOfKings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {

	@RequestMapping(value = "/")
	public RedirectView home() {
		return new RedirectView("/index.html");
	}


	@GetMapping(value = "/search")
	public String foundKing(@RequestParam("year") String yearString, Model model) {
		new ListOfKings();
		int year = Integer.parseInt(yearString);
		var foundKing = ListOfKings.getListOfKings().stream()
				.filter(king -> king.getReignStart() <= year && king.getReignEnd() >= year)
				.findFirst()
				.orElse(King.DEFAULT);

		model.addAttribute("king", foundKing);
		model.addAttribute("year", year);

		return "searchResult";
	}
}

