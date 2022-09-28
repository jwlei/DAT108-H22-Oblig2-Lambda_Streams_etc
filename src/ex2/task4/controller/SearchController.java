package ex2.task4.controller;

import ex2.task4.object.King;
import ex2.task4.object.ListOfKings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class SearchController {

	@RequestMapping(value = "/")
	public RedirectView home() {
		return new RedirectView("/index.html");
	}


	@RequestMapping(value = "/search", method = GET)
	public String foundKing(@RequestParam("year") String yearString, Model model) {
		new ListOfKings();
		int year = Integer.parseInt(yearString);
		var resultingKing = ListOfKings.getListOfKings().stream()
				.filter(king -> king.getReignStart() <= year && king.getReignEnd() >= year)
				.collect(Collectors.toList()).get(0);



//		model.addAttribute("king", Objects.requireNonNullElse(resultingKing, King.DEFAULT));
		System.out.println(resultingKing.toString());
		model.addAttribute("king", resultingKing.toString());
		model.addAttribute("img", resultingKing.getImg());

		return "searchResult";
	}
}

