package com.gchaldu;

import com.gchaldu.product.controller.ProductController;
import com.gchaldu.product.repository.ProductRepository;
import com.gchaldu.product.view.ProductView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProductView productView = new ProductView();
        ProductRepository productRepository = new ProductRepository();

        ProductController productController = new ProductController(productRepository, productView);
        productController.getProductRepository().listProducts();
        Main.menu(productController);
    }

    public static void menu(ProductController principal){
        Scanner scanner = new Scanner(System.in);
        Integer op;
        do{
            principal.add();
            System.out.println("Ingrese 1 si quiero salir");
            op = scanner.nextInt();
        }while(op!=1);
    }
}