package com.entity.model;

import com.entity.LiulangdongwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 流浪动物
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class LiulangdongwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 业主
     */
    private Integer yezhuId;


    /**
     * 流浪动物名称
     */
    private String liulangdongwuName;


    /**
     * 流浪动物编号
     */
    private String liulangdongwuUuidNumber;


    /**
     * 动物照片
     */
    private String liulangdongwuPhoto;


    /**
     * 动物类型
     */
    private Integer liulangdongwuTypes;


    /**
     * 动物品种
     */
    private Integer liulangdongwuPinzhongTypes;


    /**
     * 流浪地点
     */
    private String liulangdongwuDidian;


    /**
     * 动物年龄
     */
    private String liulangdongwuAge;


    /**
     * 宠物热度
     */
    private Integer liulangdongwuClicknum;


    /**
     * 是否救助
     */
    private Integer jiuzhuTypes;


    /**
     * 是否健康
     */
    private Integer jiankangTypes;


    /**
     * 是否绝育
     */
    private Integer jueyuTypes;


    /**
     * 是否打疫苗
     */
    private Integer yimiaoTypes;


    /**
     * 动物详细状况
     */
    private String liulangdongwuContent;


    /**
     * 是否领养
     */
    private Integer lingyangTypes;


    /**
     * 逻辑删除
     */
    private Integer liulangdongwuDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：流浪动物名称
	 */
    public String getLiulangdongwuName() {
        return liulangdongwuName;
    }


    /**
	 * 设置：流浪动物名称
	 */
    public void setLiulangdongwuName(String liulangdongwuName) {
        this.liulangdongwuName = liulangdongwuName;
    }
    /**
	 * 获取：流浪动物编号
	 */
    public String getLiulangdongwuUuidNumber() {
        return liulangdongwuUuidNumber;
    }


    /**
	 * 设置：流浪动物编号
	 */
    public void setLiulangdongwuUuidNumber(String liulangdongwuUuidNumber) {
        this.liulangdongwuUuidNumber = liulangdongwuUuidNumber;
    }
    /**
	 * 获取：动物照片
	 */
    public String getLiulangdongwuPhoto() {
        return liulangdongwuPhoto;
    }


    /**
	 * 设置：动物照片
	 */
    public void setLiulangdongwuPhoto(String liulangdongwuPhoto) {
        this.liulangdongwuPhoto = liulangdongwuPhoto;
    }
    /**
	 * 获取：动物类型
	 */
    public Integer getLiulangdongwuTypes() {
        return liulangdongwuTypes;
    }


    /**
	 * 设置：动物类型
	 */
    public void setLiulangdongwuTypes(Integer liulangdongwuTypes) {
        this.liulangdongwuTypes = liulangdongwuTypes;
    }
    /**
	 * 获取：动物品种
	 */
    public Integer getLiulangdongwuPinzhongTypes() {
        return liulangdongwuPinzhongTypes;
    }


    /**
	 * 设置：动物品种
	 */
    public void setLiulangdongwuPinzhongTypes(Integer liulangdongwuPinzhongTypes) {
        this.liulangdongwuPinzhongTypes = liulangdongwuPinzhongTypes;
    }
    /**
	 * 获取：流浪地点
	 */
    public String getLiulangdongwuDidian() {
        return liulangdongwuDidian;
    }


    /**
	 * 设置：流浪地点
	 */
    public void setLiulangdongwuDidian(String liulangdongwuDidian) {
        this.liulangdongwuDidian = liulangdongwuDidian;
    }
    /**
	 * 获取：动物年龄
	 */
    public String getLiulangdongwuAge() {
        return liulangdongwuAge;
    }


    /**
	 * 设置：动物年龄
	 */
    public void setLiulangdongwuAge(String liulangdongwuAge) {
        this.liulangdongwuAge = liulangdongwuAge;
    }
    /**
	 * 获取：宠物热度
	 */
    public Integer getLiulangdongwuClicknum() {
        return liulangdongwuClicknum;
    }


    /**
	 * 设置：宠物热度
	 */
    public void setLiulangdongwuClicknum(Integer liulangdongwuClicknum) {
        this.liulangdongwuClicknum = liulangdongwuClicknum;
    }
    /**
	 * 获取：是否救助
	 */
    public Integer getJiuzhuTypes() {
        return jiuzhuTypes;
    }


    /**
	 * 设置：是否救助
	 */
    public void setJiuzhuTypes(Integer jiuzhuTypes) {
        this.jiuzhuTypes = jiuzhuTypes;
    }
    /**
	 * 获取：是否健康
	 */
    public Integer getJiankangTypes() {
        return jiankangTypes;
    }


    /**
	 * 设置：是否健康
	 */
    public void setJiankangTypes(Integer jiankangTypes) {
        this.jiankangTypes = jiankangTypes;
    }
    /**
	 * 获取：是否绝育
	 */
    public Integer getJueyuTypes() {
        return jueyuTypes;
    }


    /**
	 * 设置：是否绝育
	 */
    public void setJueyuTypes(Integer jueyuTypes) {
        this.jueyuTypes = jueyuTypes;
    }
    /**
	 * 获取：是否打疫苗
	 */
    public Integer getYimiaoTypes() {
        return yimiaoTypes;
    }


    /**
	 * 设置：是否打疫苗
	 */
    public void setYimiaoTypes(Integer yimiaoTypes) {
        this.yimiaoTypes = yimiaoTypes;
    }
    /**
	 * 获取：动物详细状况
	 */
    public String getLiulangdongwuContent() {
        return liulangdongwuContent;
    }


    /**
	 * 设置：动物详细状况
	 */
    public void setLiulangdongwuContent(String liulangdongwuContent) {
        this.liulangdongwuContent = liulangdongwuContent;
    }
    /**
	 * 获取：是否领养
	 */
    public Integer getLingyangTypes() {
        return lingyangTypes;
    }


    /**
	 * 设置：是否领养
	 */
    public void setLingyangTypes(Integer lingyangTypes) {
        this.lingyangTypes = lingyangTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getLiulangdongwuDelete() {
        return liulangdongwuDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setLiulangdongwuDelete(Integer liulangdongwuDelete) {
        this.liulangdongwuDelete = liulangdongwuDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
