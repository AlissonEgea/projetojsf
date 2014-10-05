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
@Table(name = "setorempresa")
public class SetorEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "idsetorempresa", nullable = false)
    private Integer idSetorEmpresa;
    @Column(name = "codigosetorempresa", nullable = false, length = 40)
    private String codigoSetorEmpresa;
    @Column(name = "descricaosetorempresa", nullable = false, length = 40)
    private String descricaoSetorEmpresa;
    
    @OneToMany(mappedBy = "setorEmpresa", fetch = FetchType.LAZY)
    @ForeignKey(name = "EquipamentoSetorEmpresa")
    //Varias Pessoas possuem o mesmo sexo
    private List<Equipamento> equipamentos;

    public Integer getIdSetorEmpresa() {
        return idSetorEmpresa;
    }

    public void setIdSetorEmpresa(Integer idSetorEmpresa) {
        this.idSetorEmpresa = idSetorEmpresa;
    }

    public String getCodigoSetorEmpresa() {
        return codigoSetorEmpresa;
    }

    public void setCodigoSetorEmpresa(String codigoSetorEmpresa) {
        this.codigoSetorEmpresa = codigoSetorEmpresa;
    }

    public String getDescricaoSetorEmpresa() {
        return descricaoSetorEmpresa;
    }

    public void setDescricaoSetorEmpresa(String descricaoSetorEmpresa) {
        this.descricaoSetorEmpresa = descricaoSetorEmpresa;
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
        hash = 41 * hash + (this.idSetorEmpresa != null ? this.idSetorEmpresa.hashCode() : 0);
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
        final SetorEmpresa other = (SetorEmpresa) obj;
        if (this.idSetorEmpresa != other.idSetorEmpresa && (this.idSetorEmpresa == null || !this.idSetorEmpresa.equals(other.idSetorEmpresa))) {
            return false;
        }
        return true;
    }
    
    
    
    
}