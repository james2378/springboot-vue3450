package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 流浪动物领养申请
 *
 * @author 
 * @email
 */
@TableName("liulangdongwu_order")
public class LiulangdongwuOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiulangdongwuOrderEntity() {

	}

	public LiulangdongwuOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 申请编号
     */
    @TableField(value = "liulangdongwu_order_uuid_number")

    private String liulangdongwuOrderUuidNumber;


    /**
     * 流浪动物
     */
    @TableField(value = "liulangdongwu_id")

    private Integer liulangdongwuId;


    /**
     * 业主
     */
    @TableField(value = "yezhu_id")

    private Integer yezhuId;


    /**
     * 个人条件
     */
    @TableField(value = "tiaojian_content")

    private String tiaojianContent;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 申请状态
     */
    @TableField(value = "liulangdongwu_order_yesno_types")

    private Integer liulangdongwuOrderYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "liulangdongwu_order_yesno_text")

    private String liulangdongwuOrderYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "liulangdongwu_order_shenhe_time")

    private Date liulangdongwuOrderShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：申请编号
	 */
    public String getLiulangdongwuOrderUuidNumber() {
        return liulangdongwuOrderUuidNumber;
    }
    /**
	 * 获取：申请编号
	 */

    public void setLiulangdongwuOrderUuidNumber(String liulangdongwuOrderUuidNumber) {
        this.liulangdongwuOrderUuidNumber = liulangdongwuOrderUuidNumber;
    }
    /**
	 * 设置：流浪动物
	 */
    public Integer getLiulangdongwuId() {
        return liulangdongwuId;
    }
    /**
	 * 获取：流浪动物
	 */

    public void setLiulangdongwuId(Integer liulangdongwuId) {
        this.liulangdongwuId = liulangdongwuId;
    }
    /**
	 * 设置：业主
	 */
    public Integer getYezhuId() {
        return yezhuId;
    }
    /**
	 * 获取：业主
	 */

    public void setYezhuId(Integer yezhuId) {
        this.yezhuId = yezhuId;
    }
    /**
	 * 设置：个人条件
	 */
    public String getTiaojianContent() {
        return tiaojianContent;
    }
    /**
	 * 获取：个人条件
	 */

    public void setTiaojianContent(String tiaojianContent) {
        this.tiaojianContent = tiaojianContent;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getLiulangdongwuOrderYesnoTypes() {
        return liulangdongwuOrderYesnoTypes;
    }
    /**
	 * 获取：申请状态
	 */

    public void setLiulangdongwuOrderYesnoTypes(Integer liulangdongwuOrderYesnoTypes) {
        this.liulangdongwuOrderYesnoTypes = liulangdongwuOrderYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getLiulangdongwuOrderYesnoText() {
        return liulangdongwuOrderYesnoText;
    }
    /**
	 * 获取：审核意见
	 */

    public void setLiulangdongwuOrderYesnoText(String liulangdongwuOrderYesnoText) {
        this.liulangdongwuOrderYesnoText = liulangdongwuOrderYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getLiulangdongwuOrderShenheTime() {
        return liulangdongwuOrderShenheTime;
    }
    /**
	 * 获取：审核时间
	 */

    public void setLiulangdongwuOrderShenheTime(Date liulangdongwuOrderShenheTime) {
        this.liulangdongwuOrderShenheTime = liulangdongwuOrderShenheTime;
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

    @Override
    public String toString() {
        return "LiulangdongwuOrder{" +
            "id=" + id +
            ", liulangdongwuOrderUuidNumber=" + liulangdongwuOrderUuidNumber +
            ", liulangdongwuId=" + liulangdongwuId +
            ", yezhuId=" + yezhuId +
            ", tiaojianContent=" + tiaojianContent +
            ", insertTime=" + insertTime +
            ", liulangdongwuOrderYesnoTypes=" + liulangdongwuOrderYesnoTypes +
            ", liulangdongwuOrderYesnoText=" + liulangdongwuOrderYesnoText +
            ", liulangdongwuOrderShenheTime=" + liulangdongwuOrderShenheTime +
            ", createTime=" + createTime +
        "}";
    }
}
