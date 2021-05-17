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

    // For Sets
    @ElementCollection
    //@SortComparator(ReverseStringComparator.class)
    @OrderBy("file_name DESC")
    //@org.hibernate.annotations.OrderBy (clause="file_name desc")
    @CollectionTable(name="image")
    @Column(name="file_name")
    private Set<String> images=new LinkedHashSet<String>();

    //if want to sort in memory instead of in db 
    public static class ReverseStringComparator implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }

    /*
    //For mapping
    @ElementCollection
    @CollectionTable(name="image")
    @MapKeyColumn(name="file_name")
    @Column(name="image_name")
    private Map<String,String> images=new HashMap<String,String>();
*/
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

    public Student() {

    }


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

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
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
