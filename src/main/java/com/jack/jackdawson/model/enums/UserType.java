package com.jack.jackdawson.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public enum  UserType {

    NORMAL(1, "", Arrays.asList("1", "6", "4"));

    @Getter
    private int value;
    @Getter
    private String desc;
    @Getter
    private List<String> extraInfos;

}
