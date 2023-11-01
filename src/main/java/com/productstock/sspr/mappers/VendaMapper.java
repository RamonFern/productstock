package com.productstock.sspr.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.productstock.sspr.DTO.VendaDTO;
import com.productstock.sspr.models.Venda;

@Component
public class VendaMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public Venda toVenda(VendaDTO dto) {
		return MODEL_MAPPER.map(dto, Venda.class);
	}

	public VendaDTO toDTO(Venda venda) {
		return MODEL_MAPPER.map(venda, VendaDTO.class);
	}

	public List<VendaDTO> toVendaDTOList(List<Venda> list) {
		return list.stream().map(this::toDTO).collect(Collectors.toList());
	}
}
