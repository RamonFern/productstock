package com.productstock.sspr.service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.productstock.sspr.models.Venda;
import com.productstock.sspr.repositories.VendaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	@Transactional
	public Venda criar(Venda venda) {
		venda.setDatavenda(OffsetDateTime.now());
		return vendaRepository.save(venda);
	}

	@Transactional(readOnly = true)
	public Venda findById(Long id) {
		//return produtoRepository.findById(id).orElseThrow(() -> new ProdutoNotFoundException(id));
		Optional<Venda> vendaOp = vendaRepository.findById(id);
		return vendaOp.orElse(null);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Venda> findAll() {
		return vendaRepository.findAll();
	}
	
	@Transactional
	public Venda update(Long id, Venda venda) {
		Venda vendaUpdate = findById(id);
		vendaUpdate.setNumeronota(venda.getNumeronota());
		vendaUpdate.setIdproduto(venda.getIdproduto());
		vendaUpdate.setNomeproduto(venda.getNomeproduto());
		vendaUpdate.setValorunidade(venda.getValorunidade());
		vendaUpdate.setQuantidade(venda.getQuantidade());
		vendaUpdate.setDesconto(venda.getDesconto());
		vendaUpdate.setStatus(venda.getStatus());
		vendaUpdate.setFormapag(venda.getFormapag());
		vendaUpdate.setTotal(venda.getTotal());
		return vendaUpdate;
	}
	
	public List<Venda> getVendasDoDia() {
	    OffsetDateTime startOfDay = OffsetDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
	    OffsetDateTime endOfDay = OffsetDateTime.now().withHour(23).withMinute(59).withSecond(59).withNano(999999999);
	
	    return vendaRepository.findByDatavendaBetween(startOfDay, endOfDay);
	}
	
	 public List<Venda> getVendasPorData(LocalDate data) {
        OffsetDateTime startOfDay = data.atStartOfDay().atOffset(OffsetDateTime.now().getOffset());
        OffsetDateTime endOfDay = startOfDay.plusDays(1).minusNanos(1);

        return vendaRepository.findByDatavendaBetween(startOfDay, endOfDay);
    }
	
	
}
