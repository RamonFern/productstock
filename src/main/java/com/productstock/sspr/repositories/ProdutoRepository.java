package com.productstock.sspr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productstock.sspr.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
