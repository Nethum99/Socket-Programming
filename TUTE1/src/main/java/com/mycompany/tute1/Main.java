/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tute1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Nethum
 */
public class Main {
    
    static boolean addmoreUsers = true;
    
    public static void main(String[] args){
        
        UserValidator validator = new UserValidator();
        UserDataStore dataStore = new UserDataStore();
        Scanner scanner = new Scanner(System.in);
        Object lock = new Object();
        List<Thread> threadList= new ArrayList<>();
        
        
        while(addmoreUsers){
            
            System.out.println("Enter user name");
            String name = scanner.nextLine();
            
            System.out.println("Enter user age");
            int age = scanner.nextInt();
            
            scanner.nextLine();
            
            UserProcessor userProcessor = new UserProcessor(validator, dataStore, lock, name, age );
            
            Thread t = new Thread(userProcessor);
            
            threadList.add(t);
            
            t.start();
            
            System.out.println("Do you want a add use again");
            String decission = scanner.nextLine();
            addmoreUsers = decission.equalsIgnoreCase("yes");
              
        }
        
        for(Thread t : threadList){
            try{
                t.join();
            }
            catch(InterruptedException e){
                System.out.println("Thread Interrupted"+ e);
            }
        }
        
        List<User> allusers = dataStore.gettAllUsers();
        System.out.println("Users Stored");
        for(User users : allusers){
            System.out.print(users+" ");
        }
        
    }
}
