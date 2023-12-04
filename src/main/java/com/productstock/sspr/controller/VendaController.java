package com.productstock.sspr.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.productstock.sspr.DTO.VendaDTO;
import com.productstock.sspr.mappers.VendaMapper;
import com.productstock.sspr.models.Venda;
import com.productstock.sspr.service.VendaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/venda")
public class VendaController {
	
	@Autowired
	private VendaService vendaService;
	@Autowired
	private VendaMapper vendaMapper;
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<VendaDTO> createVenda(@RequestBody VendaDTO vendaDto) {
		Venda venda = vendaMapper.toVenda(vendaDto);
		Venda vendaCriada = vendaService.criar(venda);
		VendaDTO dto = vendaMapper.toDTO(vendaCriada);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
		
	@GetMapping("/{id}")
	public ResponseEntity<VendaDTO> findById(@PathVariable Long id) {
		//vendaService.findById(id);
		Venda venda = vendaService.findById(id);
		
		VendaDTO dto = vendaMapper.toDTO(venda);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<VendaDTO>> findAll() {
		List<Venda> list = vendaService.findAll();
		List<VendaDTO> vendaDtoList = vendaMapper.toVendaDTOList(list);
		return ResponseEntity.ok(vendaDtoList);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<VendaDTO> update(@PathVariable Long id, @RequestBody VendaDTO vendaDTO) {
		Venda venda = vendaMapper.toVenda(vendaDTO);
		Venda vendaParaAtualizar = vendaService.update(id, venda);
		return ResponseEntity.ok(vendaMapper.toDTO(vendaParaAtualizar));
	}
	
	@GetMapping("/hoje")
    public List<Venda> getVendasDoDia() {
        return vendaService.getVendasDoDia();
    }
	
	 @GetMapping("/por-data")
    public List<Venda> getVendasPorData(@RequestParam("data")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return vendaService.getVendasPorData(data);
    }
	 
	@GetMapping("/ultimaNota")
	public Long obterNumeroUltimaNota() {
	    return vendaService.obterNumeroUltimaNota();
	}
	

}
