package com.gl.website.web.controller;

import com.gl.website.entity.bo.BookFirstBO;
import com.gl.website.entity.bo.BookTwoBO;
import com.gl.website.entity.bo.CommunityFirstBO;
import com.gl.website.entity.bo.CommunityTwoBO;
import com.gl.website.entity.dto.ResultDTOBuilder;
import com.gl.website.service.BookService;
import com.gl.website.service.CommunityService;
import com.gl.website.util.JsonUtils;
import com.gl.website.web.controller.base.BaseCotroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController extends BaseCotroller {

    static final Logger log = LoggerFactory.getLogger(BookController.class);
    @Resource
    private BookService bookService;

    @RequestMapping("/query")//查询
    public void query(HttpServletResponse response, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        BookFirstBO list1 = bookService.getBookFirstMesg();
        List<BookTwoBO> list2 = bookService.getAllBookTwoMesg();
        if( list1==null || list2==null||list2.size()<1 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        map.put("one", list1);
        map.put("two", list2);
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(map));
        safeTextPrint(response, json);
    }
    @RequestMapping("/updateone")//修改one
    public void updateone(HttpServletResponse response,BookFirstBO bfbo) {
        Integer count=bookService.updateBookFirst(bfbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/deleteone")//删除one
    public void deleteone(HttpServletResponse response,BookFirstBO bfbo) {
        Integer count=bookService.deleteBookFirst(bfbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addone")//增加one
    public void addtwo(HttpServletResponse response,BookFirstBO bfbo) {
        Integer count=bookService.addBookFirst(bfbo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }


    @RequestMapping("/updatetwo")//修改two
    public void updatetwo(HttpServletResponse response,BookTwoBO btwobo) {
        Integer count=bookService.updateBookTwo(btwobo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/deletetwo")//删除two
    public void deletetwo(HttpServletResponse response,BookTwoBO btwobo) {
        Integer count=bookService.deleteBookTwo(btwobo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
    @RequestMapping("/addtwo")//增加two
    public void addone(HttpServletResponse response,BookTwoBO btwobo) {
        Integer count=bookService.addBookTwo(btwobo);
        if( count==0 ){
            String json=JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.failure("0000001"));
            safeTextPrint(response,json);
            return;
        }
        String json = JsonUtils.getJsonString4JavaPOJO(ResultDTOBuilder.success(count));
        safeTextPrint(response, json);
    }
}
