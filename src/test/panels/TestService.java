package test.panels;

import java.math.BigInteger;

/**
 * Created by Asus on 16.11.2014.
 */
public interface TestService {
    boolean addTest(Test t);
    Test getTestById(BigInteger id);
    Test getTestWithQuestions(Test test);
    
    boolean addAnswersStudent(AnswersStudent answ);
}

