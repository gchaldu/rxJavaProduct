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
            System.out.println("1 - Agregar producto");
            System.out.println("2 - Eliminar producto");
            System.out.println("3 - Actualizar producto");
            System.out.println("4 - Salir");
            op = scanner.nextInt();
            switch(op){
                case 1:{
                    principal.add();
                    break;
                }
                case 2:{
                    principal.delete();
                    break;
                }
                case 3:{
                    principal.update();
                }
            }
        }while(op!=4);
    }}