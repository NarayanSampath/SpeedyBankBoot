package com.eg.speedybank.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController implements ErrorController {

    @RequestMapping("/index")
    public String home() {
        return "index.html";
    }

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

    @RequestMapping("/{path:[^\\.]+}/**")
    public String forward() {
        System.out.println("hi");
        return "forward:/index";
    }


}