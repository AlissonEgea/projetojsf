package br.com.alissonegea.suporte;

import br.com.alissonegea.model.dao.HibernateDAO;
import br.com.alissonegea.model.dao.InterfaceDAO;
import br.com.alissonegea.model.entity.Ativo;

import br.com.alissonegea.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.hibernate.Session;

@ManagedBean(name = "bbativo")
@RequestScoped
public class BbAtivo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
     public List<Ativo> getAtivos() {
        Session session = FacesContextUtil.getRequestSession();
        InterfaceDAO<Ativo> ativoDAO = new HibernateDAO<Ativo>(Ativo.class, session);
        return ativoDAO.getEntities();
    }
    
}