package br.com.alissonegea.controller;

import br.com.alissonegea.model.dao.HibernateDAO;
import br.com.alissonegea.model.dao.InterfaceDAO;
import br.com.alissonegea.model.entity.Ativo;
import br.com.alissonegea.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="mbAtivo")
@RequestScoped
public class MbAtivo implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Ativo ativo = new Ativo();
    private List<Ativo> ativos;


    
    private InterfaceDAO<Ativo> ativoDAO(){
    InterfaceDAO<Ativo> ativoDAO = new HibernateDAO<Ativo>(Ativo.class, FacesContextUtil.getRequestSession());
    
        return ativoDAO;
    }
    
    public String limpAtivo() {
        ativo = new Ativo();
        return editAtivo();
    }
    
    public String editAtivo(){
        return "/restrict/cadastrarativo.faces";
    }
    
    public String addAtivo(){
        if(ativo.getIdnAtivo() == null || ativo.getIdnAtivo() == 0){
            insertAtivo();
        }else{
            updateAtivo();
        }
        limpAtivo();
        return null;
        
        
    }

    private void insertAtivo() {
        ativoDAO().save(ativo);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gravacao efetuada com sucesso",""));
    }

    private void updateAtivo() {
        ativoDAO().update(ativo);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente Editado com sucesso",""));
    }
    
    public void deleteAtivo(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro apagado com sucesso",""));
        ativoDAO().remove(ativo);
        

    }
    
    
    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public List<Ativo> getAtivos() {
        ativos = ativoDAO().getEntities();
        return ativos;
    }

    public void setAtivos(List<Ativo> ativos) {
        this.ativos = ativos;
    }

    public MbAtivo() {
        
    }
}
