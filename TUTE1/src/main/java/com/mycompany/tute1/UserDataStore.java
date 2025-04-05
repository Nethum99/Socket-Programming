/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tute1;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Nethum
 */
public class UserDataStore {
    
    private List<User> userList;
    
    public UserDataStore(){
        userList = new ArrayList<>();
    }
    
    public synchronized void addUser(User user){
        userList.add(user);
    }
    
    public synchronized List<User> gettAllUsers(){
        return new ArrayList<>(userList);
    }


}
