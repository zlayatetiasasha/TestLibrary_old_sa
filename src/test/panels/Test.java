package test.panels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigInteger;

import org.hibernate.annotations.GenericGenerator;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Query;

import org.hibernate.Hibernate;

import org.hibernate.annotations.Cascade;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Proxy;
import org.hibernate.FetchMode;

/**
 * Created by Asus on 16.11.2014.
 */
@Entity
@Proxy(lazy=false)
@Table(name="test")
public class Test implements Serializable {

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy="increment")
    @Column(name="id")
    private BigInteger id;    
    
    
    @OneToMany(fetch=FetchType.EAGER,mappedBy = "id")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Question> questions = new ArrayList<Question>();
    
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "author")
    private String author;
    
    @Column(name = "theme")
    private String theme;
    
    @Column(name = "passScore")
    private Integer passScore;
    
    @Column(name = "date")
    private String date;
    
    @Column(name = "instruction")
    private String instructions;
    
    @Column(name = "access")
    private Integer access;
    
    @Column(name = "time")
    private Integer timeToPass;
    
    @Column(name = "poor")
    private Integer poor;
    
    @Column(name = "unsat")
    private Integer unsat;
    
    @Column(name = "sat")
    private Integer sat;
    
    @Column(name = "good")
    private Integer good;
    
    @Column(name = "exc")
    private Integer exc;
    
    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name="teacher_id", nullable = false, insertable = true, updatable = true)
    private Teacher teacher;
    
    @OneToMany( mappedBy = "id")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AnswersStudent> answersStudent = new ArrayList<AnswersStudent>();
    
    @OneToMany( mappedBy = "id")
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AnsweredTest> answeredTests = new ArrayList<AnsweredTest>();
     
   /* @OneToOne(mappedBy="test")
    private Statistics stat;*/
        
    public Test() {}
    
    public Test(BigInteger id, List<Question> questions, String title, String author, String theme, Integer passScore, String date,
                    String instructions, Integer timeToPass, Integer poor, Integer unsat, Integer sat, Integer good, Integer exc, Integer access) {
        this.id = id;
        this.questions = questions;
        this.title = title;
        this.theme = theme;
        this.passScore = passScore;
        this.date = date;
        this.instructions = instructions;
        this.timeToPass = timeToPass;
        this.poor = poor;
        this.unsat = unsat;
        this.sat = sat;
        this.good = good;
        this.exc = exc;
        this.access = access;
    }
    
    public Test(List<Question> questions, String title, String author, String theme,  Integer passScore, String date,
                    String instructions, Integer timeToPass, Integer poor, Integer unsat, Integer sat, Integer good, Integer exc, Integer access) {
        this.questions = questions;
        this.title = title;
        this.theme = theme;
        this.passScore = passScore;
        this.date = date;
        this.instructions = instructions;
        this.timeToPass = timeToPass;
        this.poor = poor;
        this.unsat = unsat;
        this.sat = sat;
        this.good = good;
        this.exc = exc;
        this.access = access;
    }
    
    public Test(List<Question> questions, String title, String author, String theme,  Integer passScore, String date,
                    String instructions, Integer timeToPass, Integer poor, Integer unsat, Integer sat, Integer good, Integer exc, Integer access,
                    Teacher teacher) {
        this.questions = questions;
        this.title = title;
        this.theme = theme;
        this.passScore = passScore;
        this.date = date;
        this.instructions = instructions;
        this.timeToPass = timeToPass;
        this.poor = poor;
        this.unsat = unsat;
        this.sat = sat;
        this.good = good;
        this.exc = exc;
        this.access = access;
        this.teacher=teacher;
    }
    
    public Test(BigInteger id) {
        this.id = id;
    } 

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getNumberOfQuestions() {
        return questions.size();
    }

    public Question getQuestion(int index) {
        return questions.get(index);
    }

    public void setQuestion(int index, Question question) {
        questions.set(index, question);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public Integer getPassScore() {
        return passScore;
    }

    public void setPassScore(Integer passScore) {
        this.passScore = passScore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }
    
    public void setTimeToPass(Integer timeToPass) {
        this.timeToPass = timeToPass;
    }

    public Integer getTimeToPass() {
        return timeToPass;
    }
    
    public Integer getPoor() {
        return poor;
    }

    public void setPoor(Integer poor) {
        this.poor = poor;
    }
    
    public Integer getUnsat() {
        return unsat;
    }

    public void setUnsat(Integer unsat) {
        this.unsat = unsat;
    }
    
    public Integer getSat() {
        return sat;
    }

    public void setSat(Integer sat) {
        this.sat = sat;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }
    
    public Integer getExc() {
        return exc;
    }

    public void setEXc(Integer exc) {
        this.exc = exc;
    }
    
    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }
    
  /*  public Statistics getStatistics() {
        return stat;
    }

    public void setStatistics(Statistics stat) {
        this.stat = stat;
    }
    */
    
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
     public void setAnswersStudent(List<AnswersStudent> answersStudent) {
        this.answersStudent = answersStudent;
    }
    
    public List<AnswersStudent> getAnswersStudent() {
        return answersStudent;
    }
}
