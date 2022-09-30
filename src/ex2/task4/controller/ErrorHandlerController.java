package ex2.task4.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ErrorHandlerController implements ErrorController{

    @RequestMapping("/error")
    @ResponseBody
    public RedirectView getErrorPath() {
        /*
         * Create an error page with a redirect to the index page
         */
        return new RedirectView("error.html");
    }
}