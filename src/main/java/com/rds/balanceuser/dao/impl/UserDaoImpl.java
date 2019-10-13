package com.rds.balanceuser.dao.impl;

import com.rds.balanceuser.dao.UserDao;
import com.rds.balanceuser.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
//    private List<Balance> balances = new ArrayList<>();

    @Autowired
    private BalanceDaoImpl balanceDao;

    private List<User> users = new ArrayList<>();

    @Override
    public User findById(int id) {
        return users.stream().filter(user -> user.getId()==id).findFirst().orElse(null);
    }

    @Override
    public User findByName(String name) {
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public User save(User user) {
        int userIndex = users.indexOf(user);
        if (userIndex == -1) {
            users.add(new User(
                    user.getId(),
                    user.getName().toLowerCase(),
                    user.getMail(),
                    user.getPassword(),
                    user.getBalances())
            );
//            user.getBalances().forEach(balance -> balanceDao.add(balance));
            logger.debug("User" + user.getId() + " created to list");
            return users.get(users.size() - 1);
        } else {
            users.set(userIndex, user);
            logger.debug("User" + user.getId() + " uptated to list");
            return users.get(userIndex);
        }
    }

    @Override
    public List<User> findAll() {
        return users;
    }

//    @PostConstruct
//    public void onPostConstruct() {
//        users.add(new User(1, "ronald", "r@gmail.com", "lsfksldfks", balanceDao.findAll()));
//    }

//    @Override
//    public User delete(int id) {
//        User userToDelete = findById(id);
//        if (userToDelete != null){
//            users.remove(userToDelete);
//        }
//        return findById(userToDelete.getId());
//    }

}
