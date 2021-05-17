package com.christian.map.hibernate.demo;

import com.christian.map.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class GetStudentImagesDemo {

    public static void main (String[]args){
        //create session factory
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class).buildSessionFactory();
        //create session
        Session session= factory.getCurrentSession();


        try{

            //start a transaction
            session.beginTransaction();

            //Get the student id
            int theId=1;
            Student student= session.get(Student.class,theId);

            //print the student detail
            System.out.println("Student details: "+ student);

            //print associated images
            System.out.println("The associated images: "+ student.getImages());
            //commit the txn
            session.getTransaction().commit();

            //commit the transaction
            System.out.println("Done");

        }finally{
            //clean up the code
            session.close();
            factory.close();
        }

    }
}
