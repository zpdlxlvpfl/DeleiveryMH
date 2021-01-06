package com.hwyj.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class FileVO {
	private Integer articleNo;
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private int viewCnt;
    private int replyCnt;

    private String[] files;
    private int fileCnt;
}
