package com.gft.imob.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;


@Entity
public class Imoveis {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@NotNull(message = "Você precisa cadastrar uma categoria!")
	private Categorias categoria;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@NotNull(message = "Você precisa cadastrar um negócio!")
	private Negocios negocio;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
	@NotNull(message = "Você precisa cadastrar um estado!")
	private Estados estado;
	
	@NotNull(message = "Número de quartos é obrigatório!")
	@Min(value = 0)
	private Integer quartos;
	
	@NotNull(message = "Data é obrigatória!")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@NotNull(message = "Valor é obrigatório!")
	@DecimalMin(value = "0.01", message = "Valor não pode ser menor que 0,01")
	@DecimalMax(value = "9999999999.99", message = "Valor não pode ser maior que 9.999.999.999,99")
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Negocios getNegocio() {
		return negocio;
	}
	public void setNegocio(Negocios negocio) {
		this.negocio = negocio;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	public Estados getEstado() {
		return estado;
	}
	public void setEstado(Estados estado) {
		this.estado = estado;
	}
	
	public Integer getQuartos() {
		return quartos;
	}
	public void setQuartos(Integer quartos) {
		this.quartos = quartos;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
