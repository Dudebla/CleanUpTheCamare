package service;

import dao.userDao;
import domain.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class userService {
    private userDao userDao;

    @Autowired
    public void setUserDao(userDao userDao){
        this.userDao = userDao;
    }

    public boolean hasMatchUser(String username){
        int matchCount = userDao.getMatchCount(username);
        return matchCount > 0;
    }

    public User findUserByName(String username){
        return userDao.findUserByName(username);
    }

    public boolean insertUser(User user){
        return userDao.insertUser(user);
    }

    @Transactional
    public void loginSuccess(){
        ;
    }
}
