package cars.services;


import cars.Car;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DAO {


    public static <Car> List<Car> loadAllData(Class<Car> type) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
       return  session.createCriteria(cars.Car.class).list();
    }

    public static void newCar(Car car) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(car);
        tx1.commit();
        session.close();
    }

    public static cars.Car findCarById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(cars.Car.class, id);
    }
    public static void update(Car car) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(car);
        tx1.commit();
        session.close();
    }

    public static void delete(Car car) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(car);
        tx1.commit();
        session.close();
    }
}
