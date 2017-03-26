import model.Address;
import model.Student;
import utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by ud on 18/3/17.
 */
public class HibernateMain {

    public static void main(String arg[]){
        Student student = new Student("Sam","Disilva","Maths");
        Address address = new Address("10 Silver street","NYC","USA");


        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        //session.persist(student);

        //address.setId(student.getId());
        student.setAddress(address);
        address.setStudent(student);
        session.save(student);

        List<Student> students = (List<Student>)session.createQuery("from Student ").list();
        for(Student s: students){
            System.out.println("Details : "+s);
        }

        session.getTransaction().commit();
        session.close();
        HibernateUtils.getSessionFactory().close();
    }

}
