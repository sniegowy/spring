package pl.snowball.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(RuntimeException.class)
	public static ModelAndView handleException(RuntimeException ex) {
		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("errorMsg", ex.getMessage());
		return model;
	}
}
