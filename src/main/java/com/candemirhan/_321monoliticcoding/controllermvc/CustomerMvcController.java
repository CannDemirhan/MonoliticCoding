package com.candemirhan._321monoliticcoding.controllermvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/WEB/customer")
public class CustomerMvcController {

    @GetMapping("/index")
    public ModelAndView index()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customer");
        String manset = "MVC with Thymeleaf";
        List<String> nameList =
                Arrays.asList("Ahmet","Mehmet","Ali","Veli","Ayşe","Fatma","Zeynep");
        modelAndView.addObject("names",nameList);
        modelAndView.addObject("manset",manset);
        return modelAndView;
    }
}
