package com.productstock.sspr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.productstock.sspr.DTO.ProdutoDTO;
import com.productstock.sspr.mappers.ProdutoMapper;
import com.productstock.sspr.models.Produto;
import com.productstock.sspr.service.ProdutoService;


@RestController
@RequestMapping("/api/produto")
//@CrossOrigin(origins = "http://localhost:4200/")
public class ProdutoController {

	private ProdutoService produtoService;
	private ProdutoMapper produtoMapper;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService, ProdutoMapper produtoMapper) {
		this.produtoService = produtoService;
		this.produtoMapper = produtoMapper;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProdutoDTO> createHero(@RequestBody ProdutoDTO produtoDto) {
		Produto produto = produtoMapper.toProduto(produtoDto);
		Produto produtoCriado = produtoService.createProduto(produto);
		ProdutoDTO dto = produtoMapper.toDTO(produtoCriado);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<Produto> list = produtoService.findAll();
		List<ProdutoDTO> produtoDtoList = produtoMapper.toProdutoDTOList(list);
		return ResponseEntity.ok(produtoDtoList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
		Produto produto = produtoService.findById(id);
		ProdutoDTO dto = produtoMapper.toDTO(produto);
		return ResponseEntity.ok(dto);
	}

}
