/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tute1;


public class UserValidator {

    private int age ;
    
    public static boolean isValidAge(int age){
    
        if(age> 0){
            return true;
        }
        else{
            return false;
        }
    }
}
