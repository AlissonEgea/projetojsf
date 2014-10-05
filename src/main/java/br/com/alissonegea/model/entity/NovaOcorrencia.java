package br.com.alissonegea.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
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
@Table(name = "novaocorrencia")
public class NovaOcorrencia implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idnovaocorrencia", nullable = false)
    private Integer idNovaOcorrencia;
    @Column(name = "dataocorrencia", nullable = false)
    private Date dataOcorrencia;
    @Column(name = "anexoOcorrencia", nullable = true)
    private byte anexoOcorrencia;
    @Column(name = "descricaoOcorrencia", nullable = true)
    private String descricaoOcorrencia;
    
    @ManyToOne(optional = false)
    @ForeignKey(name = "EquipamentoOcorrencia")
    @JoinColumn(name = "idequipamento", referencedColumnName = "idequipamento")
    private Equipamento equipamento;

    public NovaOcorrencia() {
        this.equipamento = new Equipamento();
    }

    public Integer getIdNovaOcorrencia() {
        return idNovaOcorrencia;
    }

    public void setIdNovaOcorrencia(Integer idNovaOcorrencia) {
        this.idNovaOcorrencia = idNovaOcorrencia;
    }

    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }

    public byte getAnexoOcorrencia() {
        return anexoOcorrencia;
    }

    public void setAnexoOcorrencia(byte anexoOcorrencia) {
        this.anexoOcorrencia = anexoOcorrencia;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public String getDescricaoOcorrencia() {
        return descricaoOcorrencia;
    }

    public void setDescricaoOcorrencia(String descricaoOcorrencia) {
        this.descricaoOcorrencia = descricaoOcorrencia;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.idNovaOcorrencia != null ? this.idNovaOcorrencia.hashCode() : 0);
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
        final NovaOcorrencia other = (NovaOcorrencia) obj;
        if (this.idNovaOcorrencia != other.idNovaOcorrencia && (this.idNovaOcorrencia == null || !this.idNovaOcorrencia.equals(other.idNovaOcorrencia))) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
    

   