/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.panels;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author hp
 */

@Entity
@Table(name = "AnswersStudent")
public class AnswersStudent implements Serializable{
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    private BigInteger id;
    
    @OneToOne(mappedBy="student_id")
    private Student student;
    
    @OneToOne(mappedBy="question_id")
    private Question question;
     
    @OneToOne(mappedBy="test_id")
    private Test test;
    
    @OneToOne(mappedBy="answer_id")
    private Answer answer;
    
    @OneToOne(mappedBy="text")
    private String text;
    
     
    
    
    
}
