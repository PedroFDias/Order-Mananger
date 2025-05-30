package com.pedro.ordermanager.repository;

import com.pedro.ordermanager.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByNameContainingIgnoreCase(String name);
    @Query("SELECT p FROM Product p Where p.name LIKE %:part%")
    Optional<List<Product>> findByPartOfTheName(String part);

    Optional<List<Product>> findTop5ByOrderByPriceDesc();

    List<Product> findAllByAvailableTrue();
    Page<Product> findAllByAvailableTrue(Pageable pageable);
}
