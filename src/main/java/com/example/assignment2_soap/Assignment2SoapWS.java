package com.example.assignment2_soap;


import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Assignment2SoapWS {

    @WebMethod
    public static int[] fibonacci(){
        int[] fibArray = new int[10];
        int fib = 0;
        int a = 1;
        for (int i = 0; i < 10; i++) {
            fibArray[i] = fib;
            //System.out.println(fib);
            int temp = fib;
            fib = fib+a;
            a = temp;
        }
    return fibArray;}


}
