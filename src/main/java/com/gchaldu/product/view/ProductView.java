package com.gchaldu.product.view;

import com.gchaldu.product.model.Product;

import java.util.Scanner;

public class ProductView {

    public Product add(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del product");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el precio del product");
        Double price = scanner.nextDouble();

        System.out.println("Ingrese el nombre del product");
        Integer quantity = scanner.nextInt();

        Product product = new Product(nombre,price,quantity);

        return product;
    }
}
