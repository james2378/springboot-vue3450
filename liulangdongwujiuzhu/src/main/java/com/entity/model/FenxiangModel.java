package com.entity.model;

import com.entity.FenxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 宠物分享
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FenxiangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 分享编号
     */
    private String fenxiangUuidNumber;


    /**
     * 宠物领养申请
     */
    private Integer liulangdongwuOrderId;


    /**
     * 业主
     */
    private Integer yezhuId;


    /**
     * 分享标题
     */
    private String fenxiangName;


    /**
     * 分享类型
     */
    private Integer fenxiangTypes;


    /**
     * 分享内容
     */
    private String fenxiangContent;


    /**
     * 分享时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


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
	 * 获取：分享编号
	 */
    public String getFenxiangUuidNumber() {
        return fenxiangUuidNumber;
    }


    /**
	 * 设置：分享编号
	 */
    public void setFenxiangUuidNumber(String fenxiangUuidNumber) {
        this.fenxiangUuidNumber = fenxiangUuidNumber;
    }
    /**
	 * 获取：宠物领养申请
	 */
    public Integer getLiulangdongwuOrderId() {
        return liulangdongwuOrderId;
    }


    /**
	 * 设置：宠物领养申请
	 */
    public void setLiulangdongwuOrderId(Integer liulangdongwuOrderId) {
        this.liulangdongwuOrderId = liulangdongwuOrderId;
    }
    /**
	 * 获取：业主
	 */
    public Integer getYezhuId() {
        return yezhuId;
    }


    /**
	 * 设置：业主
	 */
    public void setYezhuId(Integer yezhuId) {
        this.yezhuId = yezhuId;
    }
    /**
	 * 获取：分享标题
	 */
    public String getFenxiangName() {
        return fenxiangName;
    }


    /**
	 * 设置：分享标题
	 */
    public void setFenxiangName(String fenxiangName) {
        this.fenxiangName = fenxiangName;
    }
    /**
	 * 获取：分享类型
	 */
    public Integer getFenxiangTypes() {
        return fenxiangTypes;
    }


    /**
	 * 设置：分享类型
	 */
    public void setFenxiangTypes(Integer fenxiangTypes) {
        this.fenxiangTypes = fenxiangTypes;
    }
    /**
	 * 获取：分享内容
	 */
    public String getFenxiangContent() {
        return fenxiangContent;
    }


    /**
	 * 设置：分享内容
	 */
    public void setFenxiangContent(String fenxiangContent) {
        this.fenxiangContent = fenxiangContent;
    }
    /**
	 * 获取：分享时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：分享时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
