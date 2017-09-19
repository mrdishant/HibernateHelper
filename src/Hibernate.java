import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class Hibernate<T> {

    Configuration configuration;
    Session session;
    SessionFactory sessionFactory;
    Transaction transaction;

    public Hibernate(String configname){
        configuration=new Configuration();
        configuration.configure(configname);
        sessionFactory=configuration.buildSessionFactory();
        session=sessionFactory.openSession();
    }

    public void insert(T a){
        transaction=session.beginTransaction();
        try{
            session.save(a);
            transaction.commit();
            System.out.println("Record Inserted");
        }catch (Exception e){
         System.out.println("Exception : "+e);
         transaction.rollback();
        }
    }

    public T retreive(int id){
        transaction=session.beginTransaction();
        T s=null;
        try{
            s=(T) session.get(Student.class,id);

        }catch (Exception e){
            System.out.println("Exception : "+e);
            transaction.rollback();
        }
        return s;
    }


    public ArrayList<T> retreiveall(){
        transaction=session.beginTransaction();
        ArrayList s=null;
        try{

            Criteria criteria=session.createCriteria(Student.class);
            s=(ArrayList<T>) criteria.list();

        }catch (Exception e){
            System.out.println("Exception : "+e);
            transaction.rollback();
        }
        return s;
    }


    public void delete(T a){
        transaction=session.beginTransaction();
        try{

            session.delete(a);
            transaction.commit();
            System.out.println("Record Deleted");

        }catch (Exception e){
            System.out.println("Exception : "+e);
            transaction.rollback();
        }
    }


    public void update(T a){
        transaction=session.beginTransaction();
        try{
            session.update(a);
            transaction.commit();
            System.out.println("Record Updated");
        }catch (Exception e){
            System.out.println("Exception : "+e);
            transaction.rollback();
        }
    }

}
