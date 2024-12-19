package com.gchaldu.product.view;

import com.gchaldu.product.excepciones.InputNumberException;
import com.gchaldu.product.model.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProductView {

    public Product add() throws InputNumberException {
        Scanner scanner = new Scanner(System.in);
        Product product;

        try {
            System.out.println("Ingrese el NOMBRE del product");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el PRECIO del producto");
            String input = scanner.nextLine(); // Primero leemos como String
            Double price = Double.parseDouble(input); // Intentamos convertir a Double

            if(price < 0) {
                throw new InputNumberException("El precio tiene que ser mayor a cero ni una cadena");
            }

            System.out.println("Ingrese el CANTIDAD del product");
            Integer quantity = scanner.nextInt();

            if(quantity < 0) {
                throw new InputNumberException("La cantidad tiene que ser mayor a cero");
            }

            product = new Product(nombre,price,quantity);

        } catch (NumberFormatException | InputMismatchException e) {
            throw new InputNumberException("El dato ingresado no es un número válido");
        }

        return product;
    }

    public Integer getById() throws InputNumberException{
        Scanner scanner = new Scanner(System.in);
        Integer id=null;

        while (id==null){
            try{
                System.out.println("Ingrese el id del producto");
                String txtId = scanner.nextLine();
                id = Integer.parseInt(txtId);

                if(id<0){
                    throw new InputNumberException("El id tiene que ser un numero mayor a cero");
                }
            } catch (NumberFormatException | InputMismatchException e) {
                throw new InputNumberException("El id tiene que ser un numero");
            }
        }
        return id;
    }

    public void view(Product product){
        System.out.println("Id: " +  product.getId());
        System.out.println("Nombre del Producto: " +  product.getNombre());
        System.out.println("Precio: " +  product.getPrice());
    }

    public Product update(Product product) throws InputNumberException {

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
    public Double setPrice() throws InputNumberException{

        Scanner scanner = new Scanner(System.in);
        Double price = 0d;

        try{
            System.out.println("Ingrese el PRECIO del product");
            String txtPrice = scanner.nextLine();
            price = Double.parseDouble(txtPrice);

            if(price<0){
                throw new InputNumberException("El dato ingresado es menor a cero");
            }

        }catch (InputMismatchException | NumberFormatException e){
            throw new InputNumberException("El numero ingreso no es un numero");
        }

        return price;
    }

    public Integer setQuantity() throws InputNumberException{

        Scanner scanner = new Scanner(System.in);
        Integer quantity=0;
        try{

            System.out.println("Ingrese el CANTIDAD del product");
            String txtQuantity = scanner.nextLine();
            quantity = Integer.parseInt(txtQuantity);

            if(quantity<0){
                throw new InputNumberException("La cantidad ingresada no puede ser menor a 0");
            }

        }catch (NumberFormatException | InputMismatchException e){
            throw new InputNumberException("La cantidad ingresada no es un numero");
        }

        return quantity;
    }

    public Product setAll() throws InputNumberException{

        Scanner scanner = new Scanner(System.in);
        Product product=null;

        try{

            System.out.println("Ingrese el NOMBRE del product");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese el PRECIO del product");
            String txtPrice = scanner.nextLine();
            Double price = Double.parseDouble(txtPrice);

            if(price<0){
                throw new InputNumberException("El dato ingresado no puede ser negativo");
            }

            System.out.println("Ingrese el CANTIDAD del product");
            String txtQuantity = scanner.nextLine();
            Integer quantity = Integer.parseInt(txtQuantity);


            if(quantity<0){
                throw new InputNumberException("El dato ingresado no puede ser negativo");
            }

            product = new Product(nombre,price,quantity);

        }catch (NumberFormatException | InputMismatchException e){
            throw new InputNumberException("El dato ingresado no es un numero");
        }

        return product;
    }


}
