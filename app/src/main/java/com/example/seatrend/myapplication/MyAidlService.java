package com.example.seatrend.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by seatrend on 2018/6/26.
 */

public class MyAidlService extends Service {

    private List<User> userList;

    @Override
    public void onCreate() {
        super.onCreate();
        userList=new ArrayList<>();
        initData();
    }

    private void initData() {
        User user1=new User("张1","男",10);
        User user2=new User("张2","男",11);
        User user3=new User("张3","男",12);
        User user4=new User("张4","男",13);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return stub;
    }

    private final MyUserInterface.Stub stub=new MyUserInterface.Stub() {
        @Override
        public void addUser(User user) throws RemoteException {
            if(user!=null){
                Log.i("addUser"," ---"+user.toString());
            }else {
                Log.i("addUser"," --老子收到一个 空对象-");
            }

        }

        @Override
        public List<User> getUserList() throws RemoteException {
            return userList;
        }
    };
}
