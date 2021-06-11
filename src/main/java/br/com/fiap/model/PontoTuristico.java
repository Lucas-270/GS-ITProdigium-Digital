package br.com.fiap.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PontoTuristico {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idUser;

	private String endereco;

	private String categoria;

	private String status;

	private String nome;

	private String latitude;

	private String longitude;

	private String escalaPreco;

	private String tipo;

	private String companhia;

	private Calendar dtCriacao;

	private Calendar dtAtualizacao;

	public PontoTuristico() {
		
	}

	public PontoTuristico(Long idUser, String endereco, String categoria, String status, String nome,
			String latitude, String longitude, String escalaPreco, String tipo, String companhia,
			Calendar dtAtualizacao) {
		this.idUser = idUser;
		this.endereco = endereco;
		this.categoria = categoria;
		this.status = status;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
		this.escalaPreco = escalaPreco;
		this.tipo = tipo;
		this.companhia = companhia;
		this.dtAtualizacao = dtAtualizacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getEscalaPreco() {
		return escalaPreco;
	}

	public void setEscalaPreco(String escalaPreco) {
		this.escalaPreco = escalaPreco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCompanhia() {
		return companhia;
	}

	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}

	public Calendar getDtCriacao() {
		return dtCriacao;
	}

	public void setDtCriacao(Calendar dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	public Calendar getDtAtualizacao() {
		return dtAtualizacao;
	}

	public void setDtAtualizacao(Calendar dtAtualizacao) {
		this.dtAtualizacao = dtAtualizacao;
	}
	
}
