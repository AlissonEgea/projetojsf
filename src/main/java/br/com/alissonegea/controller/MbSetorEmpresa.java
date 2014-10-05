package br.com.alissonegea.controller;

import br.com.alissonegea.model.dao.HibernateDAO;
import br.com.alissonegea.model.dao.InterfaceDAO;
import br.com.alissonegea.model.entity.SetorEmpresa;
import br.com.alissonegea.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="mbSetorEmpresa")
@RequestScoped
public class MbSetorEmpresa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private SetorEmpresa setorEmpresa = new SetorEmpresa();
    private List<SetorEmpresa> setorempresas;


    
    private InterfaceDAO<SetorEmpresa> setorempresaDAO(){
    InterfaceDAO<SetorEmpresa> setorempresaDAO = new HibernateDAO<SetorEmpresa>(SetorEmpresa.class, FacesContextUtil.getRequestSession());
    
        return setorempresaDAO;
    }
    
    public String limpSetorEmpresa() {
        setorEmpresa = new SetorEmpresa();
        return editSetorEmpresa();
    }
    
    public String editSetorEmpresa(){
        return "/restrict/cadastrarsetorempresa.faces";
    }
    
    public String addSetorEmpresa(){
        if(setorEmpresa.getIdSetorEmpresa() == null || setorEmpresa.getIdSetorEmpresa() == 0){
            insertSetorEmpresa();
        }else{
            updateSetorEmpresa();
        }
        limpSetorEmpresa();
        return null;
        
        
    }

    private void insertSetorEmpresa() {
        setorempresaDAO().save(setorEmpresa);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gravacao efetuada com sucesso",""));
    }

    private void updateSetorEmpresa() {
        setorempresaDAO().update(setorEmpresa);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente Editado com sucesso",""));
    }
    
    public void deleteSetorEmpresa(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro apagado com sucesso",""));
        setorempresaDAO().remove(setorEmpresa);
        

    }
    
    
    public SetorEmpresa getSetorEmpresa() {
        return setorEmpresa;
    }

    public void setSetorEmpresa(SetorEmpresa setorempresa) {
        this.setorEmpresa = setorempresa;
    }

    public List<SetorEmpresa> getSetorEmpresas() {
        setorempresas = setorempresaDAO().getEntities();
        return setorempresas;
    }

    public void setSetorEmpresas(List<SetorEmpresa> setorempresas) {
        this.setorempresas = setorempresas;
    }

    public MbSetorEmpresa() {
        
    }
}
