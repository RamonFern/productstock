package com.productstock.sspr.DTO;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProdutoDTO {
	
	private Long id;

	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String marca;
	
	@NotEmpty
	private Integer qntdEstoque;
	
	@NotEmpty
	private BigDecimal valor;

}
