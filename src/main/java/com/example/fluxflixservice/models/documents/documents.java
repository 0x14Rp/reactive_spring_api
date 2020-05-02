package com.example.fluxflixservice.models.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "productos")
public class documents {

    @Id
    private String id;
    private Double precio;
    private Date createAt;
    public String getId() {
        return id;
    }

    public documents setId(String id) {
        this.id = id;
        return this;
    }

    public Double getPrecio() {
        return precio;
    }

    public documents setPrecio(Double precio) {
        this.precio = precio;
        return this;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public documents setCreateAt(Date createAt) {
        this.createAt = createAt;
        return this;
    }

}
