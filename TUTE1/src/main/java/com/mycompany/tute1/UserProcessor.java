/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tute1;

/**
 *
 * @author Nethum
 */
public class UserProcessor implements Runnable {
    
    private UserValidator validator;
    private UserDataStore dataStore;
    private Object lock;
    private String name;
    private int age;
    
    public UserProcessor(UserValidator validator, UserDataStore dataStore, Object lock, String name, int age){
        this.validator = validator;
        this.dataStore = dataStore;
        this.lock = lock;
        this.name = name;
        this.age = age;
    }
    
    @Override
    public void run(){
        synchronized(lock){
            if (validator.isValidAge(age)){
                User user = new User(name, age);
                dataStore.addUser(user);
            }
            else{
                System.out.println("Invalid age for user");
            }
        }
    }
    
}
