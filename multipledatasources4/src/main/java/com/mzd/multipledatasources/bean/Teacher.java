package com.mzd.multipledatasources.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Teacher {
	private Long id;
	private String teacherName;
	private Long classId;
}
