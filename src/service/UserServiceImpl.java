package service;

import java.util.List;

import dao.*;
import entities.*;

public class UserServiceImpl implements UserService{

    UserDao userdao = (UserDao) new UserDaoImpl();

    @Override
    public boolean login(String email, String password) {
        return userdao.login(email,password);
    }
}