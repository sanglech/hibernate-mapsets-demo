package com.christian.map.hibernate.demo.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElements;
import java.util.*;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;


    //For mapping
    @ElementCollection
    @CollectionTable(name="image")
    @MapKeyColumn(name="file_name")
    @Column(name="image_name")
    private Map<String,String> images=new HashMap<String,String>();


/*
//for mapping ordered lists
    @ElementCollection
    @CollectionTable(name="image")
    @OrderColumn
    @Column(name="file_name")
    private List<String> images=new ArrayList<>();
*/
    /*
    // For Sets
    @ElementCollection
    @CollectionTable(name="image", //defaults to student_images if not specified
            joinColumns=@JoinColumn(name="student_id"))
    @Column(name="file_name")
    private Set<String> images=new HashSet<String>();
*/
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String,String> getImages() {
        return images;
    }

    public void setImages(Map<String,String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
