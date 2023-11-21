package com.productstock.sspr.models;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long numeronota;
	
	@Column(nullable = false)
	private Long idproduto;
	
	@Column(nullable = false)
	private String nomeproduto;
	
	@Column(nullable = false)
	private BigDecimal valorunidade;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false)
	private BigDecimal desconto;
	
	@Column(nullable = false)
	private BigDecimal total;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusVenda status;
	
	@Column(nullable = false)
	private String formapag;
	
	@Column(nullable = false)
	private OffsetDateTime datavenda;
	
	

}
