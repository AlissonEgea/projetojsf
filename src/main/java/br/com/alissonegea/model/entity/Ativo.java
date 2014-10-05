package br.com.alissonegea.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "ativo")
public class Ativo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "idnativo", nullable = false)
    private Integer idnAtivo;
    @Column(name = "descricaoativo", nullable = false, length = 9)
    private String descricaoAtivo;
    
    @OneToMany(mappedBy = "ativo", fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @ForeignKey(name = "CidadeAtivo")
    //Cidades possuem vários idnativos
    private List<Cidade> cidades;

    public Ativo() {
    }
    
    

    public Integer getIdnAtivo() {
        return idnAtivo;
    }

    public void setIdnAtivo(Integer idnAtivo) {
        this.idnAtivo = idnAtivo;
    }

    public String getDescricaoAtivo() {
        return descricaoAtivo;
    }

    public void setDescricaoAtivo(String descricaoAtivo) {
        this.descricaoAtivo = descricaoAtivo;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.idnAtivo != null ? this.idnAtivo.hashCode() : 0);
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
        final Ativo other = (Ativo) obj;
        if (this.idnAtivo != other.idnAtivo && (this.idnAtivo == null || !this.idnAtivo.equals(other.idnAtivo))) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
