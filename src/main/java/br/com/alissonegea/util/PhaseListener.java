package br.com.alissonegea.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.hibernate.Session;

public class PhaseListener implements javax.faces.event.PhaseListener {

    @Override
    public void beforePhase(PhaseEvent phase) {
        if (phase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
            System.out.println("Antes da Fase: " + phase.getPhaseId());
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
        }
    }

    @Override
    public void afterPhase(PhaseEvent phase) {
        System.out.println("Depois da Fase: " + phase.getPhaseId());
        if (phase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
            Session session = FacesContextUtil.getRequestSession();
            try {
                session.getTransaction().commit();
            } catch (Exception e) {
                if (session.getTransaction().isActive()) {
                    session.getTransaction().rollback();
                }
            } finally{
                session.close();
            }
        }
        
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
