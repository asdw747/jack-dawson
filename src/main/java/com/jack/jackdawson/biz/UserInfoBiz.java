package com.jack.jackdawson.biz;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import com.jack.jackdawson.annotation.ParamLog;
import com.jack.jackdawson.entity.jack.User;
import com.jack.jackdawson.repository.jack.UserDAO;

@Service
public class UserInfoBiz {

    @Resource
    private UserDAO userDAO;

    @ParamLog("getById")
    public User getById(long id) {
        Optional<User> userOptional = userDAO.findById(id);
        return userOptional.orElse(null);
    }

    public List<User> listByName(String name) {
        List<User> users = userDAO.findAllByName(name);
        return users;
    }

}
