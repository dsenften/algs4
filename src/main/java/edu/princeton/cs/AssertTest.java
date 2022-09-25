package edu.princeton.cs;

@SuppressWarnings("all")
public class AssertTest {

    public static void main(String args[])
    {
        int value = 15;
        assert value >= 20 : " Underweight";
        System.out.println("value is " + value);
    }
}
