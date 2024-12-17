package com.gchaldu.product.model;

public class Product {
    private Integer id;
    private static Integer counter = 0;
    private String nombre;
    private Double price;
    private Integer quantity;

    public Product(String nombre, Double price, Integer quantity) {
        this.nombre = nombre;
        this.price = price;
        this.quantity = quantity;
        this.id=++counter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static Integer getCounter() {
        return counter;
    }

    public static void setCounter(Integer counter) {
        Product.counter = counter;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
