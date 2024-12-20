package com.gchaldu.product.controller;

import com.gchaldu.product.excepciones.InputNumberException;
import com.gchaldu.product.model.Product;
import com.gchaldu.product.repository.ProductRepository;
import com.gchaldu.product.view.ProductView;

import java.util.InputMismatchException;

public class ProductController {

    private ProductRepository productRepository;
    private ProductView productView;

    public ProductController(ProductRepository productRepository, ProductView productView) {
        this.productRepository = productRepository;
        this.productView = productView;
    }

    public void add(){
        Product product = null;
        try {
            product = productView.add();
        } catch (InputNumberException e) {
            System.out.println(e.getMessage());
        }
        productRepository.addProduct(product);
    }

    public void list(){
        productRepository.listProducts();
    }

    public void delete() {

        Integer id = null;
        try {
            id = productView.getById();
            Product product = productRepository.getProductById(id);
            productRepository.deleteProduct(product);
        } catch (InputNumberException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update() throws InputNumberException {

        Integer id=null;

        try{
            id = productView.getById();
            Product product = productRepository.getProductById(id);
            if(product!=null){
                productView.view(product);
                product = productView.update(product);
                productRepository.updateProduct(product);
            }
        } catch (InputNumberException e) {
            System.out.println(e.getMessage());
        }
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
