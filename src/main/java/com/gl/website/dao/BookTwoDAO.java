package com.gl.website.dao;

import com.gl.website.entity.bo.BookTwoBO;
import com.gl.website.entity.bo.CommunityTwoBO;

import java.util.List;

public interface BookTwoDAO {
    //查询单条信息
    List<BookTwoBO> getAllBookTwoMesg();
   //修改信息
    Integer updateBookTwo(BookTwoBO btwobo);
    //删除信息
    Integer deleteBookTwo(BookTwoBO btwobo);
    //增加信息
    Integer addBookTwo(BookTwoBO btwobo);
}
