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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Created by Asus on 16.11.2014.
 */
@Entity
@Table(name="answer")
public class Answer implements Serializable {
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    private BigInteger id;
    
    @Column(name="isRight")
    private Integer isRight;
    
    @Column(name="text")
    private String text;
    
    @ManyToOne
    @JoinColumn(name="question_id", nullable = false, insertable = true, updatable = true)
    private Question question;
    
    @OneToMany( mappedBy = "id")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AnswersStudent> answersStudent = new ArrayList<AnswersStudent>();
    
    /*@ManyToOne
    @JoinColumn(name="id", nullable = false, insertable = true, updatable = true)
    private AnswersStudent answersStudent;
    */
    
    
    
    public Answer() {}
    
    public Answer(BigInteger id, Integer isRight, String text) {
        this.id = id;
        this.isRight = isRight;
        this.text = text;
    }  
    
    public Answer(Integer isRight, String text) {
        this.isRight = isRight;
        this.text = text;
    }  
    
    public Answer(BigInteger id) {
        this.id = id;
    } 

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }    
    
    public void setIsRight(Integer isRight) {
        this.isRight = isRight;
    }
    
    public Integer getIsRight() {
        return isRight;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getText() {
        return text;
    }
    
    public void setQuestion(Question question) {
        this.question = question;
    }
    
    public Question getQuestion() {
        return question;
    }
    
    public void setAnswersStudent(List<AnswersStudent> answersStudent) {
        this.answersStudent = answersStudent;
    }
    
    public List<AnswersStudent> getAnswersStudent() {
        return answersStudent;
    }
}
