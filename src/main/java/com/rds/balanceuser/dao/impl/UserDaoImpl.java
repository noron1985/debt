package com.rds.balanceuser.dao.impl;

import com.rds.balanceuser.dao.UserDao;
import com.rds.balanceuser.model.Balance;
import com.rds.balanceuser.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    private List<Balance> balances = new ArrayList<>();
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
            users.add(user);
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

    @PostConstruct
    public void onPostConstruct() {
        balances.add(new Balance(1, 2, 50, true));
        balances.add(new Balance(1, 3, 120, true));
        balances.add(new Balance(1, 4, 10, true));

        users.add(new User(1, "Ronald", "r@gmail.com", "lsfksldfks", balances));
/*        users.add(new User(2,"Tony", "t@gmail.com","slskfsksld", balances));
        users.add(new User(3,"Donovan","d@gmail.com", "slfmslmaz", balances));
        users.add(new User(4,"Cyril", "c@gmail.com", "sflsdmlmlf", balances));*/

    }

//    @Override
//    public User delete(int id) {
//        User userToDelete = findById(id);
//        if (userToDelete != null){
//            users.remove(userToDelete);
//        }
//        return findById(userToDelete.getId());
//    }
}
