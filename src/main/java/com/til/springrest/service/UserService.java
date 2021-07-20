package com.til.springrest.service;

import com.til.springrest.beans.UserBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService {
    private static List<UserBean> userRepo = new ArrayList<UserBean>();

    private static int counter = 3;
    static {
        userRepo.add(new UserBean(1,"Ram", "ram@til.in"));
        userRepo.add(new UserBean(2,"Ananya", "ananya@til.in"));
        userRepo.add(new UserBean(3,"Someone", "someone@til.in"));
    }

    public UserBean findOne(int id) {
        for (UserBean u : userRepo) {
            if(u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public List<UserBean> findAll() {
        return userRepo;
    }

    public UserBean add(UserBean u) {
        if(u.getId() == null) {
            u.setId(++counter);
            userRepo.add(u);
        }

        return u;
    }

}
