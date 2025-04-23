package com.entity.model;

import com.entity.LiulangdongwuOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 流浪动物领养申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LiulangdongwuOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 申请编号
     */
    private String liulangdongwuOrderUuidNumber;


    /**
     * 流浪动物
     */
    private Integer liulangdongwuId;


    /**
     * 业主
     */
    private Integer yezhuId;


    /**
     * 个人条件
     */
    private String tiaojianContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 申请状态
     */
    private Integer liulangdongwuOrderYesnoTypes;


    /**
     * 审核意见
     */
    private String liulangdongwuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date liulangdongwuOrderShenheTime;


    /**
     * 创建时间 show3
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
	 * 获取：申请编号
	 */
    public String getLiulangdongwuOrderUuidNumber() {
        return liulangdongwuOrderUuidNumber;
    }


    /**
	 * 设置：申请编号
	 */
    public void setLiulangdongwuOrderUuidNumber(String liulangdongwuOrderUuidNumber) {
        this.liulangdongwuOrderUuidNumber = liulangdongwuOrderUuidNumber;
    }
    /**
	 * 获取：流浪动物
	 */
    public Integer getLiulangdongwuId() {
        return liulangdongwuId;
    }


    /**
	 * 设置：流浪动物
	 */
    public void setLiulangdongwuId(Integer liulangdongwuId) {
        this.liulangdongwuId = liulangdongwuId;
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
	 * 获取：个人条件
	 */
    public String getTiaojianContent() {
        return tiaojianContent;
    }


    /**
	 * 设置：个人条件
	 */
    public void setTiaojianContent(String tiaojianContent) {
        this.tiaojianContent = tiaojianContent;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getLiulangdongwuOrderYesnoTypes() {
        return liulangdongwuOrderYesnoTypes;
    }


    /**
	 * 设置：申请状态
	 */
    public void setLiulangdongwuOrderYesnoTypes(Integer liulangdongwuOrderYesnoTypes) {
        this.liulangdongwuOrderYesnoTypes = liulangdongwuOrderYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getLiulangdongwuOrderYesnoText() {
        return liulangdongwuOrderYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setLiulangdongwuOrderYesnoText(String liulangdongwuOrderYesnoText) {
        this.liulangdongwuOrderYesnoText = liulangdongwuOrderYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getLiulangdongwuOrderShenheTime() {
        return liulangdongwuOrderShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setLiulangdongwuOrderShenheTime(Date liulangdongwuOrderShenheTime) {
        this.liulangdongwuOrderShenheTime = liulangdongwuOrderShenheTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
