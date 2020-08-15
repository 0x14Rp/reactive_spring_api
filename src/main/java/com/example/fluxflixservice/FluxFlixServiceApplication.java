package com.example.fluxflixservice;

import com.example.fluxflixservice.models.dao.ProductoDao;
import com.example.fluxflixservice.models.documents.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class FluxFlixServiceApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(FluxFlixServiceApplication.class);
    private ProductoDao dao;
    private ReactiveMongoTemplate mongoTemplate;

    public FluxFlixServiceApplication(ProductoDao dao, ReactiveMongoTemplate mongoTemplate) {
        this.dao = dao;
        this.mongoTemplate = mongoTemplate;

    }

    public static void main(String[] args) {
        SpringApplication.run(FluxFlixServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mongoTemplate.dropCollection("productos").subscribe();
        Flux.just(
                new Producto("playstation 5", 200.000),
                new Producto("lenovo legion", 320.980),
                new Producto("dell xps 15", 543.980),
                new Producto("tv sansumg", 150.000)


        )
                .flatMap(producto -> {
                    producto.setCreateAt(Instant.now());
                    return dao.save(producto);
                })
                .subscribe(producto -> log.info("Insert:" + producto.getId() + "" + producto.getNombre()));
    }
}
