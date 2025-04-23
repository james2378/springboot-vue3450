package com.entity.vo;

import com.entity.YezhuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 业主
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yezhu")
public class YezhuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 业主姓名
     */

    @TableField(value = "yezhu_name")
    private String yezhuName;


    /**
     * 业主手机号
     */

    @TableField(value = "yezhu_phone")
    private String yezhuPhone;


    /**
     * 业主身份证号
     */

    @TableField(value = "yezhu_id_number")
    private String yezhuIdNumber;


    /**
     * 业主头像
     */

    @TableField(value = "yezhu_photo")
    private String yezhuPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "yezhu_email")
    private String yezhuEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：业主姓名
	 */
    public String getYezhuName() {
        return yezhuName;
    }


    /**
	 * 获取：业主姓名
	 */

    public void setYezhuName(String yezhuName) {
        this.yezhuName = yezhuName;
    }
    /**
	 * 设置：业主手机号
	 */
    public String getYezhuPhone() {
        return yezhuPhone;
    }


    /**
	 * 获取：业主手机号
	 */

    public void setYezhuPhone(String yezhuPhone) {
        this.yezhuPhone = yezhuPhone;
    }
    /**
	 * 设置：业主身份证号
	 */
    public String getYezhuIdNumber() {
        return yezhuIdNumber;
    }


    /**
	 * 获取：业主身份证号
	 */

    public void setYezhuIdNumber(String yezhuIdNumber) {
        this.yezhuIdNumber = yezhuIdNumber;
    }
    /**
	 * 设置：业主头像
	 */
    public String getYezhuPhoto() {
        return yezhuPhoto;
    }


    /**
	 * 获取：业主头像
	 */

    public void setYezhuPhoto(String yezhuPhoto) {
        this.yezhuPhoto = yezhuPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getYezhuEmail() {
        return yezhuEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setYezhuEmail(String yezhuEmail) {
        this.yezhuEmail = yezhuEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
