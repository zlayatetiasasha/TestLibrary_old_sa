/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.panels;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author hp
 */

@Entity
@Table(name = "AnsweredTest")
public class AnsweredTest implements Serializable{
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    private BigInteger id;
      
    
    @ManyToOne
    @JoinColumn(name="test_id", nullable = false, insertable = true, updatable = true)
     @OrderColumn(name = "test_id")
    private Test test;
    
    @Column(name = "result")
    private BigInteger result;
    
    @ManyToOne
    @JoinColumn(name="student_id", nullable = false, insertable = true, updatable = true)
     @OrderColumn(name = "student_id")
    private Student student;
    
   
    
    
    public AnsweredTest() {}
    
    public AnsweredTest(BigInteger id, Test test, BigInteger result, Student student) {
        this.id = id;
        this.test = test;
        this.result = result;
        this.student=student;
    }  
    
    public AnsweredTest(Test test, BigInteger result, Student student) {
        this.test = test;
        this.result = result;
        this.student=student;
    }  
    
    public AnsweredTest(BigInteger id) {
        this.id = id;
    } 
    
    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }
    
    public void setTest(Test test) {
        this.test = test;
    }

    public Test getTest() {
        return test;
    }
    
     public void setResult(BigInteger result) {
        this.result = result;
    }

    public BigInteger getResult() {
        return result;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
    
}
