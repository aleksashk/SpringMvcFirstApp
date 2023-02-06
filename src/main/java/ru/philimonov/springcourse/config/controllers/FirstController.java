package ru.philimonov.springcourse.config.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname, Model model) {
//        System.out.println("Person: " + surname + " " + name);
        model.addAttribute("message", "Hello " + surname + " " + name);
        return "first/hello";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a", required = false) int a, @RequestParam(value = "b", required = false) int b, @RequestParam(value = "action", required = false) String action, Model model) {
        String result;
        switch (action) {
            case ("-"):
                result = a + " " + action + " " + b + " = " + (a - b);
                break;
            case ("*"):
                result = a + " " + action + " " + b + " = " + (a * b);
                break;
            case ("/"):
                result = a + " " + action + " " + b + " = " + (a * 1. / b);
                break;
            default:
                result = a + " + " + b + " = " + (a + b);
                break;
        }

        model.addAttribute("solution", result);
        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

}
