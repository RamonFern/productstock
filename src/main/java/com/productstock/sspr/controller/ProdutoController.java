package com.productstock.sspr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.productstock.sspr.DTO.ProdutoDTO;
import com.productstock.sspr.mappers.ProdutoMapper;
import com.productstock.sspr.models.Produto;
import com.productstock.sspr.service.ProdutoService;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ProdutoMapper produtoMapper;
	
	
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
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		produtoService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
		Produto produto = produtoMapper.toProduto(produtoDTO);
		Produto produtoParaAtualizar = produtoService.update(id, produto);
		return ResponseEntity.ok(produtoMapper.toDTO(produtoParaAtualizar));
	}

}
