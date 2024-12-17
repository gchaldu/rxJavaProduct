package com.gchaldu.product.controller;

import com.gchaldu.product.model.Product;
import com.gchaldu.product.repository.ProductRepository;
import com.gchaldu.product.view.ProductView;

public class ProductController {

    private ProductRepository productRepository;
    private ProductView productView;

    public ProductController(ProductRepository productRepository, ProductView productView) {
        this.productRepository = productRepository;
        this.productView = productView;
    }

    public void add(){
        Product product = productView.add();
        productRepository.addProduct(product);
    }

    public void list(){
        productRepository.listProducts();
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductView getProductView() {
        return productView;
    }

    public void setProductView(ProductView productView) {
        this.productView = productView;
    }
}
