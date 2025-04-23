package com.entity.vo;

import com.entity.FenxiangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 宠物分享
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fenxiang")
public class FenxiangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 分享编号
     */

    @TableField(value = "fenxiang_uuid_number")
    private String fenxiangUuidNumber;


    /**
     * 宠物领养申请
     */

    @TableField(value = "liulangdongwu_order_id")
    private Integer liulangdongwuOrderId;


    /**
     * 业主
     */

    @TableField(value = "yezhu_id")
    private Integer yezhuId;


    /**
     * 分享标题
     */

    @TableField(value = "fenxiang_name")
    private String fenxiangName;


    /**
     * 分享类型
     */

    @TableField(value = "fenxiang_types")
    private Integer fenxiangTypes;


    /**
     * 分享内容
     */

    @TableField(value = "fenxiang_content")
    private String fenxiangContent;


    /**
     * 分享时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


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
	 * 设置：分享编号
	 */
    public String getFenxiangUuidNumber() {
        return fenxiangUuidNumber;
    }


    /**
	 * 获取：分享编号
	 */

    public void setFenxiangUuidNumber(String fenxiangUuidNumber) {
        this.fenxiangUuidNumber = fenxiangUuidNumber;
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
	 * 设置：分享标题
	 */
    public String getFenxiangName() {
        return fenxiangName;
    }


    /**
	 * 获取：分享标题
	 */

    public void setFenxiangName(String fenxiangName) {
        this.fenxiangName = fenxiangName;
    }
    /**
	 * 设置：分享类型
	 */
    public Integer getFenxiangTypes() {
        return fenxiangTypes;
    }


    /**
	 * 获取：分享类型
	 */

    public void setFenxiangTypes(Integer fenxiangTypes) {
        this.fenxiangTypes = fenxiangTypes;
    }
    /**
	 * 设置：分享内容
	 */
    public String getFenxiangContent() {
        return fenxiangContent;
    }


    /**
	 * 获取：分享内容
	 */

    public void setFenxiangContent(String fenxiangContent) {
        this.fenxiangContent = fenxiangContent;
    }
    /**
	 * 设置：分享时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：分享时间
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

}
