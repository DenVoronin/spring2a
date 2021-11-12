package cars.services;

import cars.Car;
import cars.Engine;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DAOForEngine {

    public static <Engine> List<Engine> loadAllData(Class<Engine> type) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        return  session.createCriteria(cars.Engine.class).list();
    }

    public static void newEngine(Engine engine) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(engine);
        tx1.commit();
        session.close();
    }

    public static cars.Engine findEngineById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(cars.Engine.class, id);
    }
    public static void update(Engine engine) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(engine);
        tx1.commit();
        session.close();
    }

    public static void delete(Engine engine) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(engine);
        tx1.commit();
        session.close();
    }
}
