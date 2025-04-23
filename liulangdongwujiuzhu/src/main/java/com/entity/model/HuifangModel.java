package com.entity.model;

import com.entity.HuifangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 回访
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuifangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 回访编号
     */
    private String huifangUuidNumber;


    /**
     * 宠物领养申请
     */
    private Integer liulangdongwuOrderId;


    /**
     * 志愿者
     */
    private Integer zhiyuanzheId;


    /**
     * 回访标题
     */
    private String huifangName;


    /**
     * 回访类型
     */
    private Integer huifangTypes;


    /**
     * 回访结果
     */
    private String huifangContent;


    /**
     * 回访时间
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
	 * 获取：回访编号
	 */
    public String getHuifangUuidNumber() {
        return huifangUuidNumber;
    }


    /**
	 * 设置：回访编号
	 */
    public void setHuifangUuidNumber(String huifangUuidNumber) {
        this.huifangUuidNumber = huifangUuidNumber;
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
	 * 获取：志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }


    /**
	 * 设置：志愿者
	 */
    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 获取：回访标题
	 */
    public String getHuifangName() {
        return huifangName;
    }


    /**
	 * 设置：回访标题
	 */
    public void setHuifangName(String huifangName) {
        this.huifangName = huifangName;
    }
    /**
	 * 获取：回访类型
	 */
    public Integer getHuifangTypes() {
        return huifangTypes;
    }


    /**
	 * 设置：回访类型
	 */
    public void setHuifangTypes(Integer huifangTypes) {
        this.huifangTypes = huifangTypes;
    }
    /**
	 * 获取：回访结果
	 */
    public String getHuifangContent() {
        return huifangContent;
    }


    /**
	 * 设置：回访结果
	 */
    public void setHuifangContent(String huifangContent) {
        this.huifangContent = huifangContent;
    }
    /**
	 * 获取：回访时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：回访时间
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
