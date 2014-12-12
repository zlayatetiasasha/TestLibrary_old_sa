package test.panels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cascade;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;

/**
 * Created by Asus on 16.11.2014.
 */
@Entity
@Table(name="teacher")
@Proxy(lazy=false)
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    private BigInteger id;
    
    @OneToMany( mappedBy = "teacher")
    @LazyCollection(LazyCollectionOption.FALSE)
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Test> tests = new ArrayList<Test>();
    
   // @OneToOne(mappedBy="log")
   // private LogTeacher log;

    public Teacher() { }
    
    
    public Teacher(BigInteger id) {
        this.id = id;
    }
    
    public Teacher(BigInteger id, List<Test> tests) {
        this.id = id;
        this.tests=tests;
    }
    
      
    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }
    
    
     public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    
    public List<Test> getTests() {
        return tests;
    }
    
    
    
    /*public void setLogTeacher(LogTeacher faculty) {
        this.log = log;
    }

    public LogTeacher getLogTeacher() {
        return log;
    }*/
}
