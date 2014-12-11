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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author hp
 */

@Entity
@Proxy(lazy=false)
@Table(name = "answersstudent")
public class AnswersStudent implements Serializable{
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    private BigInteger id;
    
    
    @ManyToOne
    @JoinColumn(name="test_id", nullable = false, insertable = true, updatable = true)
    @OrderColumn(name = "test_id")
    private Test test;
    
    @ManyToOne
    @JoinColumn(name="student_id", nullable = false, insertable = true, updatable = true)
    @OrderColumn(name = "student_id")
    private Student student;
    
     @ManyToOne
    @JoinColumn(name="question_id", nullable = false, insertable = true, updatable = true)
     @OrderColumn(name = "question_id")
    private Question question;
     
     @ManyToOne
    @JoinColumn(name="answer_id", nullable = false, insertable = true, updatable = true)
     @OrderColumn(name = "answer_id")
    private Answer answer;
    
    
    
   /*@OneToMany(fetch = FetchType.EAGER, mappedBy = "answersstudent")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Student> students = new ArrayList<Student>();
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Test> tests = new ArrayList<Test>();
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "answersstudent")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Question> questions = new ArrayList<Question>();
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "answersstudent")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Answer> answers = new ArrayList<Answer>();
    
    */
    /*@ManyToMany(mappedBy="id")
    private Student student;
     
    @ManyToMany(mappedBy="id")
    private Test test;
    
    @ManyToMany(mappedBy="id")
    private Question question;
     
    @ManyToMany(mappedBy="id")
    private Answer answer;*/
    
   /* @OneToMany(fetch = FetchType.EAGER, mappedBy = "answersstudent")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Answer> answers = new ArrayList<Answer>();
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "answersstudent")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    private List<Question> questions = new ArrayList<Question>();
    */
     
     public AnswersStudent() {}
    
    public AnswersStudent(BigInteger id, Student student,Test test, Question question, Answer answer) {
        this.id = id;
        this.test = test;
        this.student=student;
        this.answer=answer;
        this.question=question;
    }  
    
    public AnswersStudent(Student student, Test test, Question question, Answer answer) {
        this.test = test;
        this.student=student;
        this.answer=answer;
       this.question=question;
    } 
    
    public AnswersStudent(BigInteger id) {
        this.id = id;
    } 
    
    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }
    
     public void setStudent(Student student) {
        this.student = student;
    }
    
    public Student getStudent() {
        return student;
    }

     public void setTest(Test test) {
        this.test = test;
    }
    
    public Test getTest() {
        return test;
    }
    
     public void setAnswer(Answer answer) {
        this.answer = answer;
    }
    
    public Answer  getAnswer() {
        return answer;
    }
    
     public void setQuestion(Question question) {
        this.question = question;
    }
    
    public Question  getQuestion() {
        return question;
    }
    
    
   
     
    
    
    
}
