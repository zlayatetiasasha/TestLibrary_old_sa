/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.panels;

import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Asus
 */
@Entity
@Table(name="logstudent")
public class LogStudent {
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    private BigInteger id;
    
    @Column(name="login")
    private String login;
    
    @Column(name="password")
    private String password;
    
    @OneToOne
    @JoinColumn(name="s_id")
    private Student student;
    
    public LogStudent() { }
    
    public LogStudent(BigInteger id, String login, String password) { 
        this.id = id;
        this.login = login;
        this.password = password;
    }
    
    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    } 
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getLogin() {
        return login;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setStudent(Student student) {
        this.student = student;
    }
    
    public Student getStudent() {
        return student;
    }
}
