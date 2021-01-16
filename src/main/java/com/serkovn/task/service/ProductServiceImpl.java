package com.serkovn.task.service;

import com.serkovn.task.dao.ProductDAO;
import com.serkovn.task.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDAO productDAO;

    @Override
    @Transactional
    public List<Product> getAllProduct() {
        return productDAO.getAllProduct();
    }

    @Override
    @Transactional
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    @Transactional
    public Product getProduct(Long id) {
        return productDAO.getProduct(id);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productDAO.deleteProduct(id);
    }
}
