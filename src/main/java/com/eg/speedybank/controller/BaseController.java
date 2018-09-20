package com.eg.speedybank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController implements ErrorController {

	@RequestMapping("/error")
	@ResponseBody
	public String handleError(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		return String.format(
				"<html>" + "<head>" + "<title>Error Page</title>" + "</head>" + "<body>"
						+ "<div style='display:flex; position:absolute; top:0; bottom:0; right:0; left:0;'>"
						+ "<div style='margin:auto'>" + "<h1>Error Page</h1>" + "<h2>Status code: %s</h2>"
						+ "<div>Exception Message: %s</div>" + "</div>" + "</div>" + "</body>" + "</html>",
				statusCode, exception == null ? "N/A" : exception.getMessage());
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping("/")
	public String home() {
		return "home.html";
	}

	@RequestMapping("/signin")
	public String login() {
		return "signin.html";
	}

	@RequestMapping("/reg")
	public String register() {
		return "register.html";
	}
	@RequestMapping("/userdash")
	public ModelAndView userDashboard() {
		return new ModelAndView("userDash.html");
	}
	@RequestMapping("/admindash")
	public ModelAndView adminDashboard() {
		return new ModelAndView("adminDash.html");
	}
	
}