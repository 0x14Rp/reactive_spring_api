package com.example.fluxflixservice.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "productos")
public class Producto {

    public Producto(){}

    @Id
    private String id;
    private String nombre;
    private Double precio;
    private Date createAt;

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Producto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getId() {
        return id;
    }

    public Producto setId(String id) {
        this.id = id;
        return this;
    }

    public Double getPrecio() {
        return precio;
    }

    public Producto setPrecio(Double precio) {
        this.precio = precio;
        return this;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Producto setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

}
