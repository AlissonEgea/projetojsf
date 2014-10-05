package br.com.alissonegea.controller;

import br.com.alissonegea.model.dao.HibernateDAO;
import br.com.alissonegea.model.dao.InterfaceDAO;
import br.com.alissonegea.model.entity.NovaOcorrencia;
import br.com.alissonegea.util.FacesContextUtil;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;

@ManagedBean(name="mbNovaOcorrencia")
@RequestScoped
public class MbNovaOcorrencia implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private NovaOcorrencia novaOcorrencia = new NovaOcorrencia();
    private List<NovaOcorrencia> novaOcorrencias;
    
    
  


    

    private InterfaceDAO<NovaOcorrencia> novaOcorrenciaDAO(){
    InterfaceDAO<NovaOcorrencia> novaOcorrenciaDAO = new HibernateDAO<NovaOcorrencia>(NovaOcorrencia.class, FacesContextUtil.getRequestSession());
    
        return novaOcorrenciaDAO;
    }
    
    public String limpNovaOcorrencia() {
        novaOcorrencia = new NovaOcorrencia();
        return editNovaOcorrencia();
    }
    
    public String editNovaOcorrencia(){
        return "/restrict/cadastrarnovaocorrencia.faces";
    }
    
    public String addNovaOcorrencia() throws IOException{
        if(novaOcorrencia.getIdNovaOcorrencia() == null || novaOcorrencia.getIdNovaOcorrencia() == 0){
            insertNovaOcorrencia();
        }else{
            updateNovaOcorrencia();
        }
        limpNovaOcorrencia();
        return null;
        
        
    }

    private void insertNovaOcorrencia() {
        novaOcorrenciaDAO().save(novaOcorrencia);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gravacao efetuada com sucesso",""));
    }

    private void updateNovaOcorrencia() {
        novaOcorrenciaDAO().update(novaOcorrencia);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente Editado com sucesso",""));
    }
    
    public void deleteNovaOcorrencia(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro apagado com sucesso",""));
        novaOcorrenciaDAO().remove(novaOcorrencia);
        

    }
    
    
    public NovaOcorrencia getNovaOcorrencia() {
        return novaOcorrencia;
    }

    public void setNovaOcorrencia(NovaOcorrencia novaOcorrencia) {
        this.novaOcorrencia = novaOcorrencia;
    }

    public List<NovaOcorrencia> getNovaOcorrencias() {
        novaOcorrencias = novaOcorrenciaDAO().getEntities();
        return novaOcorrencias;
    }

    public void setNovaOcorrencias(List<NovaOcorrencia> novaOcorrencias) {
        this.novaOcorrencias = novaOcorrencias;
    }

    public MbNovaOcorrencia() {
        
    }
}
