package com.serkovn.task.service;

import com.serkovn.task.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProduct();
    public void save(Product product);
    public Product getProduct(Long id);
    public void deleteProduct(Long id);
}
