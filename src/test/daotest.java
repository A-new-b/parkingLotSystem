package test;

import Dao.Dao;
import Service.car;
import Service.seat;
import Service.user;
import org.junit.Test;

import java.util.List;

public class daotest {
    @Test
    public void  testlogin(){
        user loginuser=new user();
        loginuser.setUsername("wangjue");
        loginuser.setPassword("wangjue");

        Dao dao=new Dao();
        user user=dao.login(loginuser);
        System.out.print(user);
    }
    @Test
    public void testfindcars(){
        String username="wangjue";
        Dao dao=new Dao();

        dao.occupy("1","2000");



    }
    @Test
    public void a(){
        System.out.print(System.currentTimeMillis());
    }
}
