package com.entity.vo;

import com.entity.LiulangdongwuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 流浪动物领养申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("liulangdongwu_order")
public class LiulangdongwuOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
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
     * 创建时间 show3
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
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
