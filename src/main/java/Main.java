
import enams.Type;
import models.Car;
import models.DriveLicense;
import models.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;



public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml")
                .build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(DriveLicense.class)
                .addAnnotatedClass(Owner.class)
                .getMetadataBuilder()
                .build();

        try (
                SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
                Session session = sessionFactory.openSession();
                ) {
            Transaction transaction = session.beginTransaction();

//            Owner owner = new Owner("Kira", new DriveLicense("B"));
//            session.save(owner);
            Owner owner = session.find(Owner.class, 1);
//            Car bmw = new Car("BMW", Type.SEDAN, 200, 20000, 2013, owner);
//            Car audi = new Car("AUDI", Type.HATCHBACK, 190, 24000, 2018, owner);
            Owner owner1 = session.find(Owner.class, 2);
//            Car volvo = new Car("Volvo", Type.HATCHBACK, 220, 25000, 2022, owner1);
//            session.save(volvo);
//            System.out.println(owner);
            Car car = session.find(Car.class, 3);
            System.out.println(car.getOwner());

//            Car car = new Car();
//            car.setModel("BMW");
//            car.setBody(Type.HATCHBACK);
//            car.setPower(200);
//            car.setPrice(2000);
//            car.setYear(2022);
//            session.save(car);
//
//            List<Car> cars = session.createQuery("from Car", Car.class).list();
//            System.out.println(cars);
            transaction.commit();

        }
    }
}
