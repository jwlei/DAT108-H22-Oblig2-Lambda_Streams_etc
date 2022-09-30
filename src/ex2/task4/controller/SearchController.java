package ex2.task4.controller;

import ex2.task4.model.King;
import ex2.task4.model.ListOfKings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {

	@RequestMapping(value = "/")
	public RedirectView home() {
		/*
		 * Redirect to the index page
		 */
		return new RedirectView("/index.html");
	}


	@GetMapping(value = "/search")
	public String foundKing(@RequestParam("year") String yearString, Model model) {
		/**
		 * Initialize the list of kings
		 * Search for the king with the given year
		 * Add the king to the model
		 * Return the search result page
		 */
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

