package com.tester;

import core.dao.UserDao;
import core.model.User;

import java.util.List;


public class UserDaoMock implements UserDao {
    @Override
    public User selectByUName(String userName) {
        User tester = new User();
        tester.setUid(1);
        tester.setUserName("test");
        tester.setPassWord("123");
        tester.setRole("tea");

        return tester;
    }

    @Override
    public List selectAllStu() {
        return selectAll();
    }

    @Override
    public List selectAllTea() {
        return null;
    }

    @Override
    public List selectAll() {
        return null;
    }

    @Override
    public Object select(Class c, int paperid) {
        return null;
    }

    @Override
    public void add(Object object) {

    }

    @Override
    public void del(Object x) {

    }

}
