
package test.panels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Created by Asus on 16.11.2014.
 */
@Entity
@Table(name = "question")
public class Question implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    private BigInteger id;
    
    @Column(name = "text")
    private String text;
    
    @Column(name = "value")
    private Integer value;
    
    @ManyToOne
    @JoinColumn(name="test_id", nullable = false, insertable = true, updatable = true)
    private Test test;
    
    @OneToMany( mappedBy = "question")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Answer> answers = new ArrayList<Answer>();
    
    @OneToOne(mappedBy="question")
    private QuestionType qtype;
    
    @OneToMany(mappedBy = "id")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AnswersStudent> answersStudent = new ArrayList<AnswersStudent>();
    
    
  /*  @ManyToOne
    @JoinColumn(name="id", nullable = false, insertable = true, updatable = true)
    private AnswersStudent answersStudent;*/
        
    public Question() {
        text = "";
    }
    
    public Question(BigInteger id, String text, Integer value) {
        this.id = id;
        this.text = text;
        this.qtype = qtype;
        this.value = value;
    }
    
    public Question(String text, Integer valu) {
        this.text = text;
        this.value = value;
        this.qtype = qtype;
    }
    
    public Question(BigInteger id) {
        this.id = id;
    } 
    
    
    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public Integer getValue() {
        return value;
    }
    
    public void setValue(Integer value) {
        this.value = value;
    }
    
    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Answer getAnswer(int index) {
        return answers.get(index);
    }

    public void setAnswer(int index, Answer answer) {
        answers.set(index, answer);
    }

    public int getNumAnswers() {
        return answers.size();
    }   
    
    public void setTest(Test test) {
        this.test = test;
    }
    
    public Test getTest() {
        return test;
    }
    
    public void setQuestionType(QuestionType qtype) {
        this.qtype = qtype;
    }
    
    public QuestionType getQuestionType() {
        return qtype;
    }
    
     public void setAnswersStudent(List<AnswersStudent> answersStudent) {
        this.answersStudent = answersStudent;
    }
    
    public List<AnswersStudent> getAnswersStudent() {
        return answersStudent;
    }
}
