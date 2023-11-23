package com.productstock.sspr.repositories;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productstock.sspr.models.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
	
	  List<Venda> findByDatavendaBetween(OffsetDateTime startOfDay, OffsetDateTime endOfDay);
	  List<Venda> findByDatavenda(OffsetDateTime date);

}
