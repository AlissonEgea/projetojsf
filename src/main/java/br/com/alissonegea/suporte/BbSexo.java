package br.com.alissonegea.suporte;

import br.com.alissonegea.model.dao.HibernateDAO;
import br.com.alissonegea.model.dao.InterfaceDAO;
import br.com.alissonegea.model.entity.Sexo;
import br.com.alissonegea.util.FacesContextUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "bbsexo")
@RequestScoped
public class BbSexo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public List<Sexo> getSexos(){
        InterfaceDAO<Sexo> sexoDAO = new HibernateDAO<Sexo>(Sexo.class,FacesContextUtil.getRequestSession());
        
        return sexoDAO.getEntities();
    }
    
}
