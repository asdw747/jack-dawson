package com.jack.jackdawson.entity.jack;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "privilege")
@Data
public class Privilege {

    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String desc;

    @Column
    private String url;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;


}
