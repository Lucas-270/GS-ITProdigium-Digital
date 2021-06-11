package br.com.fiap.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.PesquisaSatisfacaoDao;
import br.com.fiap.model.PesquisaSatisfacao;

@Named
@RequestScoped
public class PesquisaSatisfacaoBean {

	protected PesquisaSatisfacao pesquisa = new PesquisaSatisfacao();

	public void save() {
		new PesquisaSatisfacaoDao().save(this.pesquisa);
		FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage("Pesquisa cadastrada com sucesso!"));
	}
	
	public void executar() {
		System.out.println("Acionando o bean");
	}
	
	public List<PesquisaSatisfacao> getPesquisas(){
		return new PesquisaSatisfacaoDao().getAll();
	}
	
	public List<PesquisaSatisfacao> getPesquisasPerUser(){
		return new PesquisaSatisfacaoDao().getAllPerUser();
	}

	public PesquisaSatisfacao getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(PesquisaSatisfacao pesquisa) {
		this.pesquisa = pesquisa;
	}
	
}
