package com.serkovn.task.controller;

import com.serkovn.task.entity.Product;
import com.serkovn.task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MyController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String getAllProduct(Model model) {
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("AllProducts", productList);
        return "all-products";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String searchProduct( @RequestParam(required = false, value = "name", defaultValue = "") String name,
                                 @RequestParam(required = false, value = "countMin", defaultValue = "0") Long countMin,
                                 @RequestParam(required = false, value = "countMax", defaultValue = "0") Long countMax,
                                 @RequestParam(required = false, value = "priceMin", defaultValue = "0") Double priceMin,
                                 @RequestParam(required = false, value = "priceMax", defaultValue = "0") Double priceMax,
                                 Model model) {
        List<Product> productList = productService.getAllProduct().stream().filter(x -> x.getName().contains(name) || x.getName().equalsIgnoreCase(name)).
                filter(x -> x.getCount() >= countMin && (x.getCount()<= countMax || countMax == 0)).
                filter(x -> x.getPrice() >= priceMin && (x.getPrice()<= priceMax || priceMax == 0)).
                collect(Collectors.toList());
        model.addAttribute("AllProducts", productList);
        return "all-products";
    }

    @RequestMapping("/add")
    public String addNewProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product",product);
        return "product-info";
    }
    @RequestMapping("/save")
    public String saveProduct(@ModelAttribute("product") Product product){
        productService.save(product);
        return "redirect:/";
    }
    @RequestMapping("/update")
    public String update(@RequestParam("prodId") Long id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product",product);

        return "product-info";
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("prodId") Long id) {
        productService.deleteProduct(id);

        return "redirect:/";
    }
}
