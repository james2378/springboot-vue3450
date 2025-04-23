package com.entity.model;

import com.entity.YezhuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 业主
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YezhuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 业主姓名
     */
    private String yezhuName;


    /**
     * 业主手机号
     */
    private String yezhuPhone;


    /**
     * 业主身份证号
     */
    private String yezhuIdNumber;


    /**
     * 业主头像
     */
    private String yezhuPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String yezhuEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：业主姓名
	 */
    public String getYezhuName() {
        return yezhuName;
    }


    /**
	 * 设置：业主姓名
	 */
    public void setYezhuName(String yezhuName) {
        this.yezhuName = yezhuName;
    }
    /**
	 * 获取：业主手机号
	 */
    public String getYezhuPhone() {
        return yezhuPhone;
    }


    /**
	 * 设置：业主手机号
	 */
    public void setYezhuPhone(String yezhuPhone) {
        this.yezhuPhone = yezhuPhone;
    }
    /**
	 * 获取：业主身份证号
	 */
    public String getYezhuIdNumber() {
        return yezhuIdNumber;
    }


    /**
	 * 设置：业主身份证号
	 */
    public void setYezhuIdNumber(String yezhuIdNumber) {
        this.yezhuIdNumber = yezhuIdNumber;
    }
    /**
	 * 获取：业主头像
	 */
    public String getYezhuPhoto() {
        return yezhuPhoto;
    }


    /**
	 * 设置：业主头像
	 */
    public void setYezhuPhoto(String yezhuPhoto) {
        this.yezhuPhoto = yezhuPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getYezhuEmail() {
        return yezhuEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setYezhuEmail(String yezhuEmail) {
        this.yezhuEmail = yezhuEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
