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
 * 流浪动物收藏
 *
 * @author 
 * @email
 */
@TableName("liulangdongwu_collection")
public class LiulangdongwuCollectionEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiulangdongwuCollectionEntity() {

	}

	public LiulangdongwuCollectionEntity(T t) {
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
     * 类型
     */
    @TableField(value = "liulangdongwu_collection_types")

    private Integer liulangdongwuCollectionTypes;


    /**
     * 收藏时间
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
	 * 设置：类型
	 */
    public Integer getLiulangdongwuCollectionTypes() {
        return liulangdongwuCollectionTypes;
    }
    /**
	 * 获取：类型
	 */

    public void setLiulangdongwuCollectionTypes(Integer liulangdongwuCollectionTypes) {
        this.liulangdongwuCollectionTypes = liulangdongwuCollectionTypes;
    }
    /**
	 * 设置：收藏时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：收藏时间
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
        return "LiulangdongwuCollection{" +
            "id=" + id +
            ", liulangdongwuId=" + liulangdongwuId +
            ", yezhuId=" + yezhuId +
            ", liulangdongwuCollectionTypes=" + liulangdongwuCollectionTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
