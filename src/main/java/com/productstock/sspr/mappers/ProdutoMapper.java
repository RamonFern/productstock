package com.productstock.sspr.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.productstock.sspr.DTO.ProdutoDTO;
import com.productstock.sspr.models.Produto;

@Component
public class ProdutoMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();


	public Produto toProduto(ProdutoDTO dto) {
		return MODEL_MAPPER.map(dto, Produto.class);
	}

	public ProdutoDTO toDTO(Produto produto) {
		return MODEL_MAPPER.map(produto, ProdutoDTO.class);
	}

	public List<ProdutoDTO> toProdutoDTOList(List<Produto> list) {
		return list.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
