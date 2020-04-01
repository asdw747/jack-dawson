package com.jack.jackdawson.repository.jack;

import com.jack.jackdawson.common.database.UseMaster;
import com.jack.jackdawson.entity.jack.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    @UseMaster
    List<User> findAllByName(String name);

}
