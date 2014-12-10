/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.panels;

import java.math.BigInteger;

/**
 *
 * @author Asus
 */
public interface TestServiceTeacher {
     Test[] getTeacherTests(BigInteger id);
     public Teacher getTeacherByLogin(String login);
}
