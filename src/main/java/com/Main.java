package com;

import com.Utis.Car;
import com.Utis.NewHibernateUtil;
import com.Utis.RentPlace;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        Transaction t = s.beginTransaction();
        List<Car> cars = s.createQuery("from Car car where car.id in (select idCar from Order ord where ord.idCustomer " +
                "in (select id from Customer cust where cust.name = :name ))").setParameter("name", "Середеев С.С.").list();
        for (Car car : cars) {
            System.out.println("Марка: " + car.getBrands() + ", модель: " + car.getModel());
        }
        t.commit();

        Transaction t1 = s.beginTransaction();
        RentPlace rentPlaces = (RentPlace) s.createQuery("from RentPlace rent where rent.id in (select idRentPlace" +
                " from Car car where car.brands = :brands)").setParameter("brands", "Citroen").list().get(0);
        System.out.println("Название сервиса: " + rentPlaces.getName() + ", адресс:" + rentPlaces.getAddress());
        t1.commit();

        s.close();
        sf.close();
    }
}
