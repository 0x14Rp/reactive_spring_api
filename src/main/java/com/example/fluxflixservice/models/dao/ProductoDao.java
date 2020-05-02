package com.example.fluxflixservice.models.dao;

import com.example.fluxflixservice.models.documents.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductoDao extends ReactiveMongoRepository<Producto,String> {

}
