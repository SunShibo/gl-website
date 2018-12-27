package com.gl.website.dao;

import com.gl.website.entity.bo.BookFirstBO;


public interface BookFirstDAO {
    //查询单条信息
    BookFirstBO getBookFirstMesg();
   //修改信息
    Integer updateBookFirst(BookFirstBO bfbo);
    //删除信息
    Integer deleteBookFirst(BookFirstBO bfbo);
    //增加信息
    Integer addBookFirst(BookFirstBO bfbo);
}
