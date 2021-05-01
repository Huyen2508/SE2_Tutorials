/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

/**
 *
 * @author Win 8.1 Version 2
 */
public class Child extends Person {

    public Child(String name, int age) {
        super(name, age);
    }

    @Override
    public void setAge(int age) throws IllegalArgumentException {
        if (age > 15) {
            throw new IllegalArgumentException("Child's age must\n"
                    + "be lesser than 15!\"");
        }
        super.setAge(age);
    }

}
