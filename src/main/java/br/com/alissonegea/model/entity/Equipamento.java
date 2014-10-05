package br.com.alissonegea.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "equipamento")
public class Equipamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "idequipamento", nullable = false)
    private Integer idEquipamento;
    @Column(name = "codigoequipamento", nullable = false, length = 30)
    private Integer codigoEquipamento;
    @Column(name = "datacadastro", nullable = false)
    private Date dataCadastro;
    @Column(name = "dataultimamodificacao", nullable = false)
    private Date dataUltimaModificacao;
    @Column(name = "marcaequipamento", nullable = false, length = 30)
    private String marcaEquipamento;
    @Column(name = "modeloequipamento", nullable = false, length = 30)
    private String modeloEquipamento;
    @Column(name = "numeroserieequipamento", nullable = false, length = 30)
    private Integer numeroSerieEquipamento;
    @Column(name = "patrimonioequipamento", nullable = false, length = 30)
    private String patrimonioEquipamento;
    
    @OneToMany(mappedBy = "equipamento", fetch = FetchType.LAZY)
    @ForeignKey(name = "EquipamentoOcorrencia")
    //Varias Pessoas possuem o mesmo sexo
    private List<NovaOcorrencia> novaocorrencias;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "EquipamentoEmpresa")
    @JoinColumn(name = "idempresa", referencedColumnName = "idempresa")
    private Empresa empresa;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "EquipamentoTipoEquipamento")
    @JoinColumn(name = "idtipoequipamento", referencedColumnName = "idtipoequipamento")
    private TipoEquipamento tipoEquipamento;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "EquipamentoSetorEmpresa")
    @JoinColumn(name = "idsetorempresa", referencedColumnName = "idsetorempresa")
    private SetorEmpresa setorEmpresa;

    public Equipamento() {
        this.tipoEquipamento = new TipoEquipamento();
        this.setorEmpresa = new SetorEmpresa();
        this.empresa = new Empresa();
    }
    
    
    
    

    public Integer getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Integer idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public Integer getCodigoEquipamento() {
        return codigoEquipamento;
    }

    public void setCodigoEquipamento(Integer codigoEquipamento) {
        this.codigoEquipamento = codigoEquipamento;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataUltimaModificacao() {
        return dataUltimaModificacao;
    }

    public void setDataUltimaModificacao(Date dataUltimaModificacao) {
        this.dataUltimaModificacao = dataUltimaModificacao;
    }

    public String getMarcaEquipamento() {
        return marcaEquipamento;
    }

    public void setMarcaEquipamento(String marcaEquipamento) {
        this.marcaEquipamento = marcaEquipamento;
    }

    public String getModeloEquipamento() {
        return modeloEquipamento;
    }

    public void setModeloEquipamento(String modeloEquipamento) {
        this.modeloEquipamento = modeloEquipamento;
    }

    public Integer getNumeroSerieEquipamento() {
        return numeroSerieEquipamento;
    }

    public void setNumeroSerieEquipamento(Integer numeroSerieEquipamento) {
        this.numeroSerieEquipamento = numeroSerieEquipamento;
    }

    public String getPatrimonioEquipamento() {
        return patrimonioEquipamento;
    }

    public void setPatrimonioEquipamento(String patrimonioEquipamento) {
        this.patrimonioEquipamento = patrimonioEquipamento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public TipoEquipamento getTipoEquipamento() {
        return tipoEquipamento;
    }

    public void setTipoEquipamento(TipoEquipamento tipoEquipamento) {
        this.tipoEquipamento = tipoEquipamento;
    }

    public SetorEmpresa getSetorEmpresa() {
        return setorEmpresa;
    }

    public void setSetorEmpresa(SetorEmpresa setorEmpresa) {
        this.setorEmpresa = setorEmpresa;
    }

    public List<NovaOcorrencia> getNovaocorrencias() {
        return novaocorrencias;
    }

    public void setNovaocorrencias(List<NovaOcorrencia> novaocorrencias) {
        this.novaocorrencias = novaocorrencias;
    }

    

    
    
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.idEquipamento != null ? this.idEquipamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipamento other = (Equipamento) obj;
        if (this.idEquipamento != other.idEquipamento && (this.idEquipamento == null || !this.idEquipamento.equals(other.idEquipamento))) {
            return false;
        }
        return true;
    }
    
    
    
    
    

}