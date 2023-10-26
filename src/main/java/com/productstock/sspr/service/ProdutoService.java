package com.productstock.sspr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.productstock.sspr.exception.ProdutoNotFoundException;
import com.productstock.sspr.models.Produto;
import com.productstock.sspr.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	private ProdutoRepository produtoRepository;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public Produto createProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Produto findById(Long id) {
		return produtoRepository.findById(id).orElseThrow(() -> new ProdutoNotFoundException(id));
	}

}
