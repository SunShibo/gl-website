package com.gl.website.entity.bo;

import com.gl.website.common.base.BaseModel;

import java.util.Date;

public class RegisteredBO extends BaseModel {

    private int id;
    private String applicantName;//申请人姓名
    private String guardianName;//监护人的姓名
    private String applicantBirthday;//申请人生日
    private String gender   ;//性别
    private String phone   ;//电话
    private String email   ;//
    private String address   ;//
    private String emergencyContact   ;//紧急联系人
    private String emergencyContactNumber   ;//紧急联系人电话
    private String foodAllergy   ;//对食物是否过敏
    private String concerns   ;//健康问题或者顾虑
    private String chineseVisa   ;//是否有中国签证
    private Double paymentAmount;//缴费金额
    private Date paymentTime;//缴费时间
    private Double balanceof;//余额

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getApplicantBirthday() {
        return applicantBirthday;
    }

    public void setApplicantBirthday(String applicantBirthday) {
        this.applicantBirthday = applicantBirthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getFoodAllergy() {
        return foodAllergy;
    }

    public void setFoodAllergy(String foodAllergy) {
        this.foodAllergy = foodAllergy;
    }

    public String getConcerns() {
        return concerns;
    }

    public void setConcerns(String concerns) {
        this.concerns = concerns;
    }

    public String getChineseVisa() {
        return chineseVisa;
    }

    public void setChineseVisa(String chineseVisa) {
        this.chineseVisa = chineseVisa;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Double getBalanceof() {
        return balanceof;
    }

    public void setBalanceof(Double balanceof) {
        this.balanceof = balanceof;
    }
}
