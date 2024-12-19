package com.gchaldu.product.view;

import com.gchaldu.product.excepciones.InputNumberException;
import com.gchaldu.product.model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductView {

    public Product add() throws InputNumberException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el NOMBRE del product");
        String nombre = scanner.nextLine();
        Double price;
        Product product;

        try {
            System.out.println("Ingrese el PRECIO del producto");
            String input = scanner.nextLine(); // Primero leemos como String
            price = Double.parseDouble(input); // Intentamos convertir a Double

            if(price < 0) {
                throw new InputNumberException("El precio no puede ser negativo");
            }

            System.out.println("Ingrese el CANTIDAD del product");
            Integer quantity = scanner.nextInt();

            product = new Product(nombre,price,quantity);

        } catch (NumberFormatException e) {
            throw new InputNumberException("El dato ingresado no es un número válido");
        } catch (InputMismatchException e) {
            scanner.nextLine(); // Limpiamos el buffer del scanner
            throw new InputNumberException("El dato ingresado no es un número válido");
        }

        return product;
    }

    public Integer getById(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el id del producto");
        Integer id = scanner.nextInt();

        return id;
    }

    public void view(Product product){
        System.out.println("Id: " +  product.getId());
        System.out.println("Nombre del Producto: " +  product.getNombre());
        System.out.println("Precio: " +  product.getPrice());
    }

    public Product update(Product product){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un opcion para actualizar el producto");
        System.out.println("1 - El NOMBRE");
        System.out.println("2 - El PRECIO");
        System.out.println("3 - El CANTIDAD");
        System.out.println("4 - TODO");
        Integer opcion = scanner.nextInt();

        switch (opcion){
            case 1:{
                String nombre = setNombre();
                product.setNombre(nombre);
                break;
            }
            case 2:{
                Double price = setPrice();
                product.setPrice(price);
                break;
            }
            case 3:{
                Integer quantity = setQuantity();
                product.setQuantity(quantity);
                break;
            }
            case 4:{
                Product p = setAll();
                product.setNombre(p.getNombre());
                product.setPrice(p.getPrice());
                product.setQuantity(p.getQuantity());
                break;
            }
        }

        return product;
    }

    public String setNombre(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el NOMBRE del product");
        String nombre = scanner.nextLine();

        return nombre;
    }
    public Double setPrice(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el PRECIO del product");
        Double price = scanner.nextDouble();

        return price;
    }

    public Integer setQuantity(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el CANTIDAD del product");
        Integer quantity = scanner.nextInt();

        return quantity;
    }

    public Product setAll(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el NOMBRE del product");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el PRECIO del product");
        Double price = scanner.nextDouble();

        System.out.println("Ingrese el CANTIDAD del product");
        Integer quantity = scanner.nextInt();

        Product product = new Product(nombre,price,quantity);

        return product;
    }


}
