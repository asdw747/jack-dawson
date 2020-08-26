package com.jack.jackdawson.biz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import com.jack.jackdawson.annotation.ParamLog;
import com.jack.jackdawson.entity.jack.User;
import com.jack.jackdawson.repository.jack.UserDAO;

@Slf4j
@Service
public class UserInfoBiz {

    @Resource
    private UserDAO userDAO;

    public List<User> listAll() {
        return userDAO.findAll();
    }

    public List<User> listByName(String name) {
        return userDAO.findAllByName(name);
    }

    @ParamLog("getById")
    public User getById(long id) {
        Optional<User> userOptional = userDAO.findById(id);
        return userOptional.orElse(null);
    }

}
