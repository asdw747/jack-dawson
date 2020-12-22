package com.jack.jackdawson.repository.jack;

import com.jack.jackdawson.entity.jack.Privilege;
import com.jack.jackdawson.entity.jack.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PrivilegeDAO extends JpaRepository<Privilege, Long> {


}
