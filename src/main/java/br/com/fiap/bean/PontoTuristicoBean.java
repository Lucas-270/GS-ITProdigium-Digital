package br.com.fiap.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.PontoTuristicoDao;
import br.com.fiap.model.PontoTuristico;

@Named
@RequestScoped
public class PontoTuristicoBean {

	protected PontoTuristico ponto = new PontoTuristico();

	public void save() {
		System.out.println(this.ponto);
		new PontoTuristicoDao().save(this.ponto);
		System.out.println(this.ponto);
		FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage("Ponto cadastrado com sucesso!"));
	}
	
	public void executar() {
		System.out.println("Acionando o bean");
	}
	
	public List<PontoTuristico> getPontos(){
		return new PontoTuristicoDao().getAll();
	}
	
	public List<PontoTuristico> getPontosPerUser(){
		return new PontoTuristicoDao().getAllPerUser();
	}

	public PontoTuristico getPonto() {
		return ponto;
	}

	public void setPonto(PontoTuristico ponto) {
		this.ponto = ponto;
	}
	
}
