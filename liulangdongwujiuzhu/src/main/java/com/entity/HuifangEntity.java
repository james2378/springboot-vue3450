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
 * 回访
 *
 * @author 
 * @email
 */
@TableName("huifang")
public class HuifangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuifangEntity() {

	}

	public HuifangEntity(T t) {
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
     * 回访编号
     */
    @TableField(value = "huifang_uuid_number")

    private String huifangUuidNumber;


    /**
     * 宠物领养申请
     */
    @TableField(value = "liulangdongwu_order_id")

    private Integer liulangdongwuOrderId;


    /**
     * 志愿者
     */
    @TableField(value = "zhiyuanzhe_id")

    private Integer zhiyuanzheId;


    /**
     * 回访标题
     */
    @TableField(value = "huifang_name")

    private String huifangName;


    /**
     * 回访类型
     */
    @TableField(value = "huifang_types")

    private Integer huifangTypes;


    /**
     * 回访结果
     */
    @TableField(value = "huifang_content")

    private String huifangContent;


    /**
     * 回访时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 设置：回访编号
	 */
    public String getHuifangUuidNumber() {
        return huifangUuidNumber;
    }
    /**
	 * 获取：回访编号
	 */

    public void setHuifangUuidNumber(String huifangUuidNumber) {
        this.huifangUuidNumber = huifangUuidNumber;
    }
    /**
	 * 设置：宠物领养申请
	 */
    public Integer getLiulangdongwuOrderId() {
        return liulangdongwuOrderId;
    }
    /**
	 * 获取：宠物领养申请
	 */

    public void setLiulangdongwuOrderId(Integer liulangdongwuOrderId) {
        this.liulangdongwuOrderId = liulangdongwuOrderId;
    }
    /**
	 * 设置：志愿者
	 */
    public Integer getZhiyuanzheId() {
        return zhiyuanzheId;
    }
    /**
	 * 获取：志愿者
	 */

    public void setZhiyuanzheId(Integer zhiyuanzheId) {
        this.zhiyuanzheId = zhiyuanzheId;
    }
    /**
	 * 设置：回访标题
	 */
    public String getHuifangName() {
        return huifangName;
    }
    /**
	 * 获取：回访标题
	 */

    public void setHuifangName(String huifangName) {
        this.huifangName = huifangName;
    }
    /**
	 * 设置：回访类型
	 */
    public Integer getHuifangTypes() {
        return huifangTypes;
    }
    /**
	 * 获取：回访类型
	 */

    public void setHuifangTypes(Integer huifangTypes) {
        this.huifangTypes = huifangTypes;
    }
    /**
	 * 设置：回访结果
	 */
    public String getHuifangContent() {
        return huifangContent;
    }
    /**
	 * 获取：回访结果
	 */

    public void setHuifangContent(String huifangContent) {
        this.huifangContent = huifangContent;
    }
    /**
	 * 设置：回访时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：回访时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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
        return "Huifang{" +
            "id=" + id +
            ", huifangUuidNumber=" + huifangUuidNumber +
            ", liulangdongwuOrderId=" + liulangdongwuOrderId +
            ", zhiyuanzheId=" + zhiyuanzheId +
            ", huifangName=" + huifangName +
            ", huifangTypes=" + huifangTypes +
            ", huifangContent=" + huifangContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
