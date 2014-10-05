package br.com.alissonegea.controller;

import br.com.alissonegea.conversores.ConverterSHA1;
import br.com.alissonegea.model.dao.HibernateDAO;
import br.com.alissonegea.model.dao.InterfaceDAO;
import br.com.alissonegea.model.entity.Endereco;
import br.com.alissonegea.model.entity.Pessoa;
import br.com.alissonegea.util.FacesContextUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class MbPessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private String confereSenha;
    private Pessoa pessoa = new Pessoa();
    private Endereco endereco = new Endereco();
    private List<Pessoa> pessoas;
    private List<Endereco> enderecos;

    public MbPessoa() {
    }

    private InterfaceDAO<Pessoa> pessoaDAO() {
        InterfaceDAO<Pessoa> pessoaDAO = new HibernateDAO<Pessoa>(Pessoa.class, FacesContextUtil.getRequestSession());
        return pessoaDAO;
    }

    private InterfaceDAO<Endereco> enderecoDAO() {
        InterfaceDAO<Endereco> enderecoDAO = new HibernateDAO<Endereco>(Endereco.class, FacesContextUtil.getRequestSession());
        return enderecoDAO;
    }

    public String limpPessoa() {
        pessoa = new Pessoa();
        endereco = new Endereco();
        return editPessoa();
    }

    public String editPessoa() {
        return "/restrict/cadastrarpessoa.faces";
    }

    public String consultarPessoa() {
        return "/restrict/consultarpessoa.faces";
    }

    public String addPessoa() {
        Date data = new Date();
        if (pessoa.getIdPessoa() == null || pessoa.getIdPessoa() == 0) {
            pessoa.setDataCadastro(data);
            pessoa.setDataultimaatt(data);
            insertPessoa();
        } else {
            updatePessoa();
            pessoa.setDataultimaatt(data);
        }
        limpPessoa();
        return null;
    }

    private void insertPessoa() {
       pessoa.setSenha(ConverterSHA1.cipher(pessoa.getSenha()));
        if (pessoa.getSenha() == null ? confereSenha == null : pessoa.getSenha().equals(ConverterSHA1.cipher(confereSenha))) {
            pessoa.setPermissao("ROLE_ADMIN");
            pessoaDAO().save(pessoa);
            endereco.setPessoa(pessoa);
            enderecoDAO().save(endereco);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Inserido com sucesso", ""));
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "As senhas nao conferem", ""));
        }
    }

    private void updatePessoa() {
        pessoaDAO().update(pessoa);
        enderecoDAO().update(endereco);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Editado com sucesso", ""));
        consultarPessoa();
    }

    public void deletePessoa() {
        pessoaDAO().remove(pessoa);
        enderecoDAO().remove(endereco);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro apagado com sucesso", ""));

    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Pessoa> getPessoas() {
        pessoas = pessoaDAO().getEntities();
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<Endereco> getEnderecos() {
        enderecos = enderecoDAO().getEntities();
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public String getConfereSenha() {
        return confereSenha;
    }

    public void setConfereSenha(String confereSenha) {
        this.confereSenha = confereSenha;
    }

}
