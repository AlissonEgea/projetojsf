package br.com.alissonegea.controller;

import br.com.alissonegea.model.dao.HibernateDAO;
import br.com.alissonegea.model.dao.InterfaceDAO;
import br.com.alissonegea.model.entity.Ativo;
import br.com.alissonegea.model.entity.TipoEquipamento;
import br.com.alissonegea.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="mbTipoEquipamento")
@RequestScoped
public class MbTipoEquipamento implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private TipoEquipamento tipoEquipamento = new TipoEquipamento();
    private List<TipoEquipamento> tipoEquipamentos;


    
    private InterfaceDAO<TipoEquipamento> tipoequipamentoDAO(){
    InterfaceDAO<TipoEquipamento> tipoequipamentoDAO = new HibernateDAO<TipoEquipamento>(TipoEquipamento.class, FacesContextUtil.getRequestSession());
    
        return tipoequipamentoDAO;
    }
    
    public String limpTipoEquipamento() {
        tipoEquipamento = new TipoEquipamento();
        return editTipoEquipamento();
    }
    
    public String editTipoEquipamento(){
        return "/restrict/cadastrartipoequipamento.faces";
    }
    
    public String addTipoEquipamento(){
        if(tipoEquipamento.getIdTipoEquipamento() == null || tipoEquipamento.getIdTipoEquipamento() == 0){
            insertTipoEquipamento();
        }else{
            updateTipoEquipamento();
        }
        limpTipoEquipamento();
        return null;
        
        
    }

    private void insertTipoEquipamento() {
        tipoequipamentoDAO().save(tipoEquipamento);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gravacao efetuada com sucesso",""));
    }

    private void updateTipoEquipamento() {
        tipoequipamentoDAO().update(tipoEquipamento);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente Editado com sucesso",""));
    }
    
    public void deleteTipoEquipamento(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro apagado com sucesso",""));
        tipoequipamentoDAO().remove(tipoEquipamento);
        

    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public List<TipoEquipamento> getTipoEquipamentos() {
        tipoEquipamentos = tipoequipamentoDAO().getEntities();
        return tipoEquipamentos;
    }

    public void setTipoEquipamentos(List<TipoEquipamento> tipoEquipamentos) {
        this.tipoEquipamentos = tipoEquipamentos;
    }
 
    
   }
