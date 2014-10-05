package br.com.alissonegea.controller;

import br.com.alissonegea.model.dao.HibernateDAO;
import br.com.alissonegea.model.dao.InterfaceDAO;
import br.com.alissonegea.model.entity.Empresa;
import br.com.alissonegea.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "mbEmpresa")
@RequestScoped
public class MbEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;

    private Empresa empresa = new Empresa();
    private List<Empresa> empresas;

    private InterfaceDAO<Empresa> empresaDAO() {
        InterfaceDAO<Empresa> empresaDAO = new HibernateDAO<Empresa>(Empresa.class, FacesContextUtil.getRequestSession());

        return empresaDAO;
    }

    public String limpEmpresa() {
              
        empresa = new Empresa();
        return editEmpresa();
    }

    public String editEmpresa() {
        
        return "/restrict/cadastrarempresa.faces";
    }

    public String addEmpresa() {
        if (empresa.getIdEmpresa() == null || empresa.getIdEmpresa() == 0) {
            insertEmpresa();
        } else {
            updateEmpresa();
        }
        limpEmpresa();
        return null;

    }

    private void insertEmpresa() {
        empresaDAO().save(empresa);

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Gravacao efetuada com sucesso", ""));
    }

    private void updateEmpresa() {
        empresaDAO().update(empresa);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Editado com sucesso", ""));
    }

    public void deleteEmpresa() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro apagado com sucesso", ""));
        empresaDAO().remove(empresa);

    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getEmpresas() {
        empresas = empresaDAO().getEntities();
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

}
