package br.com.fiap.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fiap.dao.SetupDao;
import br.com.fiap.model.Setup;

@Named
@RequestScoped
public class SetupBean {

	private Setup setup = new Setup();

	public void save() {
		System.out.println(this.setup);
		new SetupDao().save(this.setup);
		System.out.println(this.setup);
		//this.setup = new Setup();
		FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage("Setup cadastrado com sucesso!"));
	}
	
	public void executar() {
		System.out.println("Acionando o bean");
	}
	
	public List<Setup> getSetups(){
		return new SetupDao().getAll();
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	
}
