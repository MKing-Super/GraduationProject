package com.mkinfo.carhouse.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 人员表
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("SHEETID")
    private String sheetid;

    /**
     * 用户名
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 手机号
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 人员昵称
     */
    @TableField("PETNAME")
    private String petname;

    /**
     * 人员类别
     */
    @TableField("PERSONNALCATEGORY")
    private String personnalcategory;

    /**
     * 等级
     */
    @TableField("GRADE")
    private String grade;


    public String getSheetid() {
        return sheetid;
    }

    public void setSheetid(String sheetid) {
        this.sheetid = sheetid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getPersonnalcategory() {
        return personnalcategory;
    }

    public void setPersonnalcategory(String personnalcategory) {
        this.personnalcategory = personnalcategory;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "sheetid='" + sheetid + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", petname='" + petname + '\'' +
                ", personnalcategory='" + personnalcategory + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
