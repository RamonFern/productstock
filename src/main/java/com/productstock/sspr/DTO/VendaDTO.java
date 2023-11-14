package com.productstock.sspr.DTO;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.productstock.sspr.models.StatusVenda;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VendaDTO {
	
	private Long id;
	
	@NotBlank
	private Long numeronota;
	
	@NotBlank
	private Long idProduto;
	
	@NotBlank
	private String nomeproduto;
	
	@NotBlank
	private BigDecimal valorunidade;
	
	@NotBlank
	private Integer quantidade;
	
	private BigDecimal desconto;
	
	@NotBlank
	private BigDecimal total;
	
	@Enumerated(EnumType.STRING)
	private StatusVenda status;
	
	@NotBlank
	private String formaPag;
	
	@NotBlank
	private OffsetDateTime dataVenda;

}
