package com.gchaldu.product.repository;

import com.gchaldu.product.model.Product;
import io.reactivex.subjects.PublishSubject;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private List<Product> productList;
    private PublishSubject<List<Product>> productPublishSubject;

    public ProductRepository() {
        productList = new ArrayList<>();
        productPublishSubject = PublishSubject.create();
    }

    public void addProduct(Product product){
        this.productList.add(product);
        productPublishSubject.onNext(productList);
    }

    public void listProducts(){
        productPublishSubject.subscribe( products -> {
            products.forEach( product -> {
                System.out.println("Producto: " + product.getNombre());
                System.out.println("Price: " + product.getPrice());
            });
        }, throwable -> {
            System.out.println("throwable = " + throwable);
        });
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
