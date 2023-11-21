package com.productstock.sspr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.productstock.sspr.models.Produto;
import com.productstock.sspr.repositories.ProdutoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto createProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Produto findById(Long id) {
		//return produtoRepository.findById(id).orElseThrow(() -> new ProdutoNotFoundException(id));
		Optional<Produto> produtoOp = produtoRepository.findById(id);
		return produtoOp.orElse(null);
	}

	@Transactional
	public void deletar(Long id) {
		findById(id);
		produtoRepository.deleteById(id);
		
	}

	@Transactional
	public Produto update(Long id, Produto produto) {
		Produto produtoUpdate = findById(id);
		produtoUpdate.setNome(produto.getNome());
		produtoUpdate.setMarca(produto.getMarca());
		produtoUpdate.setQntdestoque(produto.getQntdestoque());
		produtoUpdate.setValor(produto.getValor());
		produtoUpdate.setValorentrada(produto.getValorentrada());
		produtoRepository.save(produtoUpdate);
		return produtoUpdate;
	}

}
