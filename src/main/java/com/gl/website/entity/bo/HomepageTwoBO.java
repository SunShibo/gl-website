package com.gl.website.entity.bo;

import com.gl.website.common.base.BaseModel;

import java.util.Date;

public class HomepageTwoBO extends BaseModel {
    private Integer id;
    private String image;  //图片
    private String url;//图片地址
    private Date createTime;   //创建时间
    private String createUser;     //创建人
    private Date updateTime;//修改时间
    private String updateUser;//修改人
    private String  title   ;//标题
    private String  content ;//内容
    private String  subtitle ;//副标题
    private Integer pictureSort  ;//图片序列号
    private String  introduce   ;//介绍
    private String  source    ;//来源

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getPictureSort() {
        return pictureSort;
    }

    public void setPictureSort(Integer pictureSort) {
        this.pictureSort = pictureSort;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
