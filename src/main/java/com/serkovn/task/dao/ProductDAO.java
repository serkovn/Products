package com.serkovn.task.dao;

import com.serkovn.task.entity.Product;

import java.util.List;

public interface ProductDAO {
    public List<Product> getAllProduct();
    public void save(Product product);

    public Product getProduct(Long id);

    public void deleteProduct(Long id);
}
