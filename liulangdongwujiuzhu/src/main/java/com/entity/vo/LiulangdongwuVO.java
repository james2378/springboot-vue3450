package com.entity.vo;

import com.entity.LiulangdongwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 流浪动物
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("liulangdongwu")
public class LiulangdongwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 业主
     */

    @TableField(value = "yezhu_id")
    private Integer yezhuId;


    /**
     * 流浪动物名称
     */

    @TableField(value = "liulangdongwu_name")
    private String liulangdongwuName;


    /**
     * 流浪动物编号
     */

    @TableField(value = "liulangdongwu_uuid_number")
    private String liulangdongwuUuidNumber;


    /**
     * 动物照片
     */

    @TableField(value = "liulangdongwu_photo")
    private String liulangdongwuPhoto;


    /**
     * 动物类型
     */

    @TableField(value = "liulangdongwu_types")
    private Integer liulangdongwuTypes;


    /**
     * 动物品种
     */

    @TableField(value = "liulangdongwu_pinzhong_types")
    private Integer liulangdongwuPinzhongTypes;


    /**
     * 流浪地点
     */

    @TableField(value = "liulangdongwu_didian")
    private String liulangdongwuDidian;


    /**
     * 动物年龄
     */

    @TableField(value = "liulangdongwu_age")
    private String liulangdongwuAge;


    /**
     * 宠物热度
     */

    @TableField(value = "liulangdongwu_clicknum")
    private Integer liulangdongwuClicknum;


    /**
     * 是否救助
     */

    @TableField(value = "jiuzhu_types")
    private Integer jiuzhuTypes;


    /**
     * 是否健康
     */

    @TableField(value = "jiankang_types")
    private Integer jiankangTypes;


    /**
     * 是否绝育
     */

    @TableField(value = "jueyu_types")
    private Integer jueyuTypes;


    /**
     * 是否打疫苗
     */

    @TableField(value = "yimiao_types")
    private Integer yimiaoTypes;


    /**
     * 动物详细状况
     */

    @TableField(value = "liulangdongwu_content")
    private String liulangdongwuContent;


    /**
     * 是否领养
     */

    @TableField(value = "lingyang_types")
    private Integer lingyangTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "liulangdongwu_delete")
    private Integer liulangdongwuDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：流浪动物名称
	 */
    public String getLiulangdongwuName() {
        return liulangdongwuName;
    }


    /**
	 * 获取：流浪动物名称
	 */

    public void setLiulangdongwuName(String liulangdongwuName) {
        this.liulangdongwuName = liulangdongwuName;
    }
    /**
	 * 设置：流浪动物编号
	 */
    public String getLiulangdongwuUuidNumber() {
        return liulangdongwuUuidNumber;
    }


    /**
	 * 获取：流浪动物编号
	 */

    public void setLiulangdongwuUuidNumber(String liulangdongwuUuidNumber) {
        this.liulangdongwuUuidNumber = liulangdongwuUuidNumber;
    }
    /**
	 * 设置：动物照片
	 */
    public String getLiulangdongwuPhoto() {
        return liulangdongwuPhoto;
    }


    /**
	 * 获取：动物照片
	 */

    public void setLiulangdongwuPhoto(String liulangdongwuPhoto) {
        this.liulangdongwuPhoto = liulangdongwuPhoto;
    }
    /**
	 * 设置：动物类型
	 */
    public Integer getLiulangdongwuTypes() {
        return liulangdongwuTypes;
    }


    /**
	 * 获取：动物类型
	 */

    public void setLiulangdongwuTypes(Integer liulangdongwuTypes) {
        this.liulangdongwuTypes = liulangdongwuTypes;
    }
    /**
	 * 设置：动物品种
	 */
    public Integer getLiulangdongwuPinzhongTypes() {
        return liulangdongwuPinzhongTypes;
    }


    /**
	 * 获取：动物品种
	 */

    public void setLiulangdongwuPinzhongTypes(Integer liulangdongwuPinzhongTypes) {
        this.liulangdongwuPinzhongTypes = liulangdongwuPinzhongTypes;
    }
    /**
	 * 设置：流浪地点
	 */
    public String getLiulangdongwuDidian() {
        return liulangdongwuDidian;
    }


    /**
	 * 获取：流浪地点
	 */

    public void setLiulangdongwuDidian(String liulangdongwuDidian) {
        this.liulangdongwuDidian = liulangdongwuDidian;
    }
    /**
	 * 设置：动物年龄
	 */
    public String getLiulangdongwuAge() {
        return liulangdongwuAge;
    }


    /**
	 * 获取：动物年龄
	 */

    public void setLiulangdongwuAge(String liulangdongwuAge) {
        this.liulangdongwuAge = liulangdongwuAge;
    }
    /**
	 * 设置：宠物热度
	 */
    public Integer getLiulangdongwuClicknum() {
        return liulangdongwuClicknum;
    }


    /**
	 * 获取：宠物热度
	 */

    public void setLiulangdongwuClicknum(Integer liulangdongwuClicknum) {
        this.liulangdongwuClicknum = liulangdongwuClicknum;
    }
    /**
	 * 设置：是否救助
	 */
    public Integer getJiuzhuTypes() {
        return jiuzhuTypes;
    }


    /**
	 * 获取：是否救助
	 */

    public void setJiuzhuTypes(Integer jiuzhuTypes) {
        this.jiuzhuTypes = jiuzhuTypes;
    }
    /**
	 * 设置：是否健康
	 */
    public Integer getJiankangTypes() {
        return jiankangTypes;
    }


    /**
	 * 获取：是否健康
	 */

    public void setJiankangTypes(Integer jiankangTypes) {
        this.jiankangTypes = jiankangTypes;
    }
    /**
	 * 设置：是否绝育
	 */
    public Integer getJueyuTypes() {
        return jueyuTypes;
    }


    /**
	 * 获取：是否绝育
	 */

    public void setJueyuTypes(Integer jueyuTypes) {
        this.jueyuTypes = jueyuTypes;
    }
    /**
	 * 设置：是否打疫苗
	 */
    public Integer getYimiaoTypes() {
        return yimiaoTypes;
    }


    /**
	 * 获取：是否打疫苗
	 */

    public void setYimiaoTypes(Integer yimiaoTypes) {
        this.yimiaoTypes = yimiaoTypes;
    }
    /**
	 * 设置：动物详细状况
	 */
    public String getLiulangdongwuContent() {
        return liulangdongwuContent;
    }


    /**
	 * 获取：动物详细状况
	 */

    public void setLiulangdongwuContent(String liulangdongwuContent) {
        this.liulangdongwuContent = liulangdongwuContent;
    }
    /**
	 * 设置：是否领养
	 */
    public Integer getLingyangTypes() {
        return lingyangTypes;
    }


    /**
	 * 获取：是否领养
	 */

    public void setLingyangTypes(Integer lingyangTypes) {
        this.lingyangTypes = lingyangTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getLiulangdongwuDelete() {
        return liulangdongwuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setLiulangdongwuDelete(Integer liulangdongwuDelete) {
        this.liulangdongwuDelete = liulangdongwuDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
