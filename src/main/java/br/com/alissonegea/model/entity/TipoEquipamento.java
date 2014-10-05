package br.com.alissonegea.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "tipoequipamento")
public class TipoEquipamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "idtipoequipamento", nullable = false)
    private Integer idTipoEquipamento;
    @Column(name = "codigotipoequipamento", nullable = false, length = 30)
    private Integer codigoTipoEquipamento;
    @Column(name = "descricaotipoequipamento", nullable = false, length = 30)
    private String descricaoTipoEquipamento;
    
    @OneToMany(mappedBy = "tipoEquipamento", fetch = FetchType.LAZY)
    @ForeignKey(name = "EquipamentoTipoEquipamento")
    //Varios Equipamentos possuem o mesmo tipoEquipamento
    private List<Equipamento> equipamentos;

    public Integer getIdTipoEquipamento() {
        return idTipoEquipamento;
    }

    public void setIdTipoEquipamento(Integer idTipoEquipamento) {
        this.idTipoEquipamento = idTipoEquipamento;
    }

    public Integer getCodigoTipoEquipamento() {
        return codigoTipoEquipamento;
    }

    public void setCodigoTipoEquipamento(Integer codigoTipoEquipamento) {
        this.codigoTipoEquipamento = codigoTipoEquipamento;
    }

    public String getDescricaoTipoEquipamento() {
        return descricaoTipoEquipamento;
    }

    public void setDescricaoTipoEquipamento(String descricaoTipoEquipamento) {
        this.descricaoTipoEquipamento = descricaoTipoEquipamento;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (this.idTipoEquipamento != null ? this.idTipoEquipamento.hashCode() : 0);
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
        final TipoEquipamento other = (TipoEquipamento) obj;
        if (this.idTipoEquipamento != other.idTipoEquipamento && (this.idTipoEquipamento == null || !this.idTipoEquipamento.equals(other.idTipoEquipamento))) {
            return false;
        }
        return true;
    }

    
    
    
}
