package TPSAnnotation;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;  
  
public class StoreData {  
  
    public static void main(String args[])  
    {  
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
        Session session=factory.openSession();  
          
         Transaction t=session.beginTransaction();    
            
            Employee e1=new Employee();    
            e1.setName("Anusha");    
                
            Regular_Employee e2=new Regular_Employee();    
            e2.setName("Anu");    
            e2.setSalary(50000);    
            e2.setBonus(5);    
                
            Contract_employee e3=new Contract_employee();    
            e3.setName("Asha");    
            e3.setPay_per_hour(1000);    
            e3.setContract_duration("15 hours");    
                
            session.persist(e1);    
            session.persist(e2);    
            session.persist(e3);    
                
            t.commit();    
            session.close();    
            System.out.println("success");        
    }  
}  