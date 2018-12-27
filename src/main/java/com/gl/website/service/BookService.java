package com.gl.website.service;

import com.gl.website.dao.BookFirstDAO;
import com.gl.website.dao.BookTwoDAO;
import com.gl.website.dao.CommunityFirstDAO;
import com.gl.website.dao.CommunityTwoDAO;
import com.gl.website.entity.bo.BookFirstBO;
import com.gl.website.entity.bo.BookTwoBO;
import com.gl.website.entity.bo.CommunityFirstBO;
import com.gl.website.entity.bo.CommunityTwoBO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("bookService")
@Transactional
public class BookService {
    @Resource
    private BookFirstDAO bfDAO;
    @Resource
    private BookTwoDAO btwoDao;

    //查询单条信息one
    public BookFirstBO getBookFirstMesg(){
        BookFirstBO list1= bfDAO.getBookFirstMesg();
       return  list1;
    }
    //查询所有信息two
    public List<BookTwoBO> getAllBookTwoMesg(){
        List<BookTwoBO>list2= btwoDao.getAllBookTwoMesg();
        return  list2;
    }
    //修改信息one
    public Integer updateBookFirst(BookFirstBO bfbo){
       return bfDAO.updateBookFirst(bfbo);
    }
    //删除信息one
    public Integer deleteBookFirst(BookFirstBO bfbo){
        return bfDAO.deleteBookFirst(bfbo);
    }
    //增加信息one
    public Integer addBookFirst(BookFirstBO bfbo){
        return bfDAO.addBookFirst(bfbo);
    }


    //修改信息two
    public Integer updateBookTwo(BookTwoBO btwobo){
        return btwoDao.updateBookTwo(btwobo);
    }
    //删除信息two
    public Integer deleteBookTwo(BookTwoBO btwobo){
        return btwoDao.deleteBookTwo(btwobo);
    }
    //增加信息two
    public Integer addBookTwo(BookTwoBO btwobo){
        return btwoDao.addBookTwo(btwobo);
    }

}
