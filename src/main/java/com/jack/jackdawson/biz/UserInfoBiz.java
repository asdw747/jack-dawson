package com.jack.jackdawson.biz;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Optional;
import com.jack.jackdawson.annotation.ParamLog;
import com.jack.jackdawson.entity.jack.User;
import com.jack.jackdawson.repository.jack.UserDAO;

@Service
public class UserInfoBiz {

    @Resource
    private UserDAO userDAO;

    @ParamLog(value = "aaa")
    public User getById(long id) {
        Optional<User> userOptional = userDAO.findById(id);
        return userOptional.orElse(null);
    }

}
