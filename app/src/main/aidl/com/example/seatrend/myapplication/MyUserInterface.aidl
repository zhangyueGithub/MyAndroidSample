// User.aidl
package com.example.seatrend.myapplication;

// Declare any non-default types here with import statements
import com.example.seatrend.myapplication.User;

interface MyUserInterface {
           void addUser(inout User user);
           List<User> getUserList();
}
