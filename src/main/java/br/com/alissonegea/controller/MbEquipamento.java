package br.com.alissonegea.controller;

import br.com.alissonegea.model.dao.HibernateDAO;
import br.com.alissonegea.model.dao.InterfaceDAO;
import br.com.alissonegea.model.entity.Equipamento;
import br.com.alissonegea.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="mbEquipamento")
@RequestScoped
public class MbEquipamento implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Equipamento equipamento = new Equipamento();
    private List<Equipamento> equipamentos;

    public MbEquipamento() {
    }
    
    private InterfaceDAO<Equipamento> equipamentoDAO(){
    InterfaceDAO<Equipamento> equipamentoDAO = new HibernateDAO<Equipamento>(Equipamento.class, FacesContextUtil.getRequestSession());
    
        return equipamentoDAO;
    }
    
    public String limpEquipamento() {
        equipamento = new Equipamento();
        return editEquipamento();
    }
    
    public String editEquipamento(){
        return "/restrict/cadastrarequipamento.faces";
    }
    
    public String addEquipamento(){
        Date data = new Date();
        if(equipamento.getIdEquipamento() == null || equipamento.getIdEquipamento() == 0){
            equipamento.setDataCadastro(data);
            equipamento.setDataUltimaModificacao(data);
            insertEquipamento();
            
        }else{
            equipamento.setDataUltimaModificacao(data);
            equipamento.setDataCadastro(data);
            updateEquipamento();
            
        }
        limpEquipamento();
        return null;
        
        
    }

    private void insertEquipamento() {
        equipamentoDAO().save(equipamento);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Gravacao efetuada com sucesso",""));
    }

    private void updateEquipamento() {
        equipamentoDAO().update(equipamento);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Cliente Editado com sucesso",""));
    }
    
    public void deleteEquipamento(){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Registro apagado com sucesso",""));
        equipamentoDAO().remove(equipamento);
        

    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public List<Equipamento> getEquipamentos() {
        equipamentos = equipamentoDAO().getEntities();
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    

    
    
    
    
    
}
