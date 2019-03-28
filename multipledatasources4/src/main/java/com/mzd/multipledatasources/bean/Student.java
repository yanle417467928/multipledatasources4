package com.mzd.multipledatasources.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Student {
    private Long id;
    private String studentName;
    private Long classId;
    private int score;


}
