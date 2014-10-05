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
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "idempresa", nullable = false)
    private Integer idEmpresa;
    @Column(name = "codigoempresa", nullable = false, length = 40)
    private String codigoEmpresa;
    @Column(name = "descricaoempresa", nullable = false, length = 40)
    private String descricaoEmpresa;
    @Column(name = "razaosocialempresa", nullable = false, length = 40)
    private String razaoSocialEmp;
    @Column(name = "emailempresa", nullable = false, length = 40)
    private String emailEmpresa;
    @Column(name = "cnpjempresa", nullable = false, length = 40)
    private String cnpjEmpresa;
    
    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    @ForeignKey(name = "EquipamentoEmpresa")
    //Varias Pessoas possuem o mesmo sexo
    private List<Equipamento> equipamentos;
    
    

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getDescricaoEmpresa() {
        return descricaoEmpresa;
    }

    public void setDescricaoEmpresa(String descricaoEmpresa) {
        this.descricaoEmpresa = descricaoEmpresa;
    }

    public String getRazaoSocialEmp() {
        return razaoSocialEmp;
    }

    public void setRazaoSocialEmp(String razaoSocialEmp) {
        this.razaoSocialEmp = razaoSocialEmp;
    }

    public String getEmailEmpresa() {
        return emailEmpresa;
    }

    public void setEmailEmpresa(String emailEmpresa) {
        this.emailEmpresa = emailEmpresa;
    }

    public String getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(String cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }

    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.idEmpresa != null ? this.idEmpresa.hashCode() : 0);
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
        final Empresa other = (Empresa) obj;
        if (this.idEmpresa != other.idEmpresa && (this.idEmpresa == null || !this.idEmpresa.equals(other.idEmpresa))) {
            return false;
        }
        return true;
    }

}
