package ar.com.ada.billeteravirtual;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class BilleteraManager {
    protected SessionFactory sessionFactory;

    protected void setup() {

        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures settings
                                                                                                  // from
                                                                                                  // hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw ex;
        }

    }

    protected void exit() {
        sessionFactory.close();
    }
    protected void create(Billetera billetera) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(billetera);

        session.getTransaction().commit();
        session.close();
    }

    public Billetera read(int billeteraId) {
        Session session = sessionFactory.openSession();

        Billetera billetera = session.get(Billetera.class, billeteraId);

        session.close();

        return billetera;
    }

    protected void update(Billetera billetera) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.update(billetera);

        session.getTransaction().commit();
        session.close();
    }

    protected void delete(Billetera billetera) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.delete(billetera);

        session.getTransaction().commit();
        session.close();
    }

    /**
     * Este metodo en la vida real no debe existir ya que puede haber miles de
     * usuarios
     * 
     * @return
     */
    public List<Persona> buscarTodas() {

        Session session = sessionFactory.openSession();

        /// NUNCA HARCODEAR SQLs nativos en la aplicacion.
        // ESTO es solo para nivel educativo
        Query query = session.createNativeQuery("SELECT * FROM persona", Persona.class);

        List<Persona> todas = query.getResultList();

        return todas;

    }

    /**
     * Busca una lista de personas por el nombre completo Esta armado para que se
     * pueda generar un SQL Injection y mostrar commo NO debe programarse.
     * 
     * @param nombre
     * @return
     */
    public List<Persona> buscarPor(String nombre) {

        Session session = sessionFactory.openSession();

        // SQL Injection vulnerability exposed.
        // Deberia traer solo aquella del nombre y con esto demostrarmos que trae todas
        // si pasamos
        // como nombre: "' or '1'='1"
        Query query = session.createNativeQuery("SELECT * FROM persona where nombre = '" + nombre + "'", Persona.class);

        List<Persona> personas = query.getResultList();

        return personas;

    }

}
