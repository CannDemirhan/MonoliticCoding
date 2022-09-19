package com.candemirhan._321monoliticcoding.controllermvc;

import com.candemirhan._321monoliticcoding.service.CustomerService;
import com.candemirhan._321monoliticcoding.service.ProductService;
import com.candemirhan._321monoliticcoding.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/WEB/sale")
@RequiredArgsConstructor
public class SaleMvcController {

    @Autowired private SaleService saleService;
    @Autowired private CustomerService customerService;
    @Autowired private ProductService productService;

    @GetMapping("/index")
    public ModelAndView index()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sale");
        modelAndView.addObject("salelist", saleService.findAllDto());
        modelAndView.addObject("customerlist", customerService.findAll());
        modelAndView.addObject("productlist", productService.findAll());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView sale(Long customerid, Long productid, Integer amonth, Double price)
    {
        saleService.save(customerid, productid, amonth, price);
        return new ModelAndView("redirect:index");
    }

    @PostMapping("/delete")
    public ModelAndView delete(Long id){
        saleService.deleteById(id);
        return new ModelAndView("redirect:index");
    }

    @PostMapping("/update")
    public ModelAndView update(Long id, Long customerid, Long productid, Integer amonth, Double price){
        saleService.update(id, customerid, productid, amonth, price);
        return new ModelAndView("redirect:index");
    }


}
