package br.com.fiap.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PesquisaSatisfacao {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long idUser;

	private String nomePonto;

	private Long notaAvaliacao;

	private String tipo;

	private String companhia;

	private String comentario;

	private Calendar dtPesquisa;

	private Calendar dtCadastro;

	public PesquisaSatisfacao() {
	}

	public PesquisaSatisfacao(Long idUser, String nomePonto, Long notaAvaliacao, String tipo,
			String companhia, String comentario, Calendar dtPesquisa, Calendar dtCadastro) {
		this.idUser = idUser;
		this.nomePonto = nomePonto;
		this.notaAvaliacao = notaAvaliacao;
		this.tipo = tipo;
		this.companhia = companhia;
		this.comentario = comentario;
		this.dtPesquisa = dtPesquisa;
		this.dtCadastro = dtCadastro;
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

	public String getNomePonto() {
		return nomePonto;
	}

	public void setNomePonto(String nomePonto) {
		this.nomePonto = nomePonto;
	}

	public Long getNotaAvalicao() {
		return notaAvaliacao;
	}

	public void setNotaAvalicao(Long notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Calendar getDtPesquisa() {
		return dtPesquisa;
	}

	public void setDtPesquisa(Calendar dtPesquisa) {
		this.dtPesquisa = dtPesquisa;
	}

	public Calendar getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Calendar dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

}