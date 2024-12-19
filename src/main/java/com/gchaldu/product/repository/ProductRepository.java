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

    public Product getProductById(Integer id){
        for (Product p: productList){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    public boolean deleteProduct(Product p){
        if(p!=null){
            productList.remove(p);
            productPublishSubject.onNext(productList);
            return true;
        }
        return false;
    }

    public void updateProduct(Product p){
        if(p!=null){
            int index = productList.indexOf(p);
            productList.set(index, p);
            productPublishSubject.onNext(productList);
        }
    }

    public void listProducts(){
        System.out.println("LISTADO DE PRODUCTOS");

        productPublishSubject.subscribe( products -> {

            products.forEach( product -> {
                System.out.println("\n");
                System.out.println("Id: " + product.getId());
                System.out.println("Producto: " + product.getNombre());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Quantity: " + product.getQuantity());
                System.out.println("______________________________________");

            });
        }, throwable -> {
            System.out.println("throwable = " + throwable);
        });

        System.out.println("----------------------------------------");
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
