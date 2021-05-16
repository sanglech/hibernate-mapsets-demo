package com.christian.map.hibernate.demo;

import com.christian.map.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class CreateStudentImageSetDemo {
    public static void main (String[]args){
        //create session factory
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session= factory.getCurrentSession();


        try{

            //create the object
            Student tempStudent= new Student("John","Doe","john@doe.com");
            Set<String> imgs= tempStudent.getImages(); //duplicates removed in hashset
            imgs.add("image1.jpg");
            imgs.add("image2.jpg");
            imgs.add("image3.jpg");
            imgs.add("image4.jpg");
            imgs.add("image5.jpg");
            //start a transaction
            session.beginTransaction();

            //save the obj
            System.out.println("Saving the student");
            session.persist(tempStudent);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done");

        }finally{
            //clean up the code
            session.close();
            factory.close();
        }

    }
}
