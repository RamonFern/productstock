package com.productstock.sspr.service;

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
		venda.setDataVenda(OffsetDateTime.now());
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
		vendaUpdate.setIdProduto(venda.getIdProduto());
		vendaUpdate.setNomeproduto(venda.getNomeproduto());
		vendaUpdate.setValorunidade(venda.getValorunidade());
		vendaUpdate.setQuantidade(venda.getQuantidade());
		vendaUpdate.setDesconto(venda.getDesconto());
		vendaUpdate.setStatus(venda.getStatus());
		vendaUpdate.setFormaPag(venda.getFormaPag());
		vendaUpdate.setTotal(venda.getTotal());
		return vendaUpdate;
	}
	
	
}
