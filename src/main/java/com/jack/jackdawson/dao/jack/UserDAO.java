package com.jack.jackdawson.dao.jack;

import com.jack.jackdawson.entity.jack.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

}
