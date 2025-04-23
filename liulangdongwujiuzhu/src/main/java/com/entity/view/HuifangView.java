package com.entity.view;

import com.entity.HuifangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 回访
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huifang")
public class HuifangView extends HuifangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 回访类型的值
		*/
		private String huifangValue;



		//级联表 liulangdongwu_order
			/**
			* 申请编号
			*/
			private String liulangdongwuOrderUuidNumber;
			/**
			* 流浪动物领养申请 的 业主
			*/
			private Integer liulangdongwuOrderYezhuId;
			/**
			* 个人条件
			*/
			private String tiaojianContent;
			/**
			* 申请状态
			*/
			private Integer liulangdongwuOrderYesnoTypes;
				/**
				* 申请状态的值
				*/
				private String liulangdongwuOrderYesnoValue;
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

		//级联表 zhiyuanzhe
			/**
			* 志愿者姓名
			*/
			private String zhiyuanzheName;
			/**
			* 志愿者手机号
			*/
			private String zhiyuanzhePhone;
			/**
			* 志愿者身份证号
			*/
			private String zhiyuanzheIdNumber;
			/**
			* 志愿者照片
			*/
			private String zhiyuanzhePhoto;
			/**
			* 电子邮箱
			*/
			private String zhiyuanzheEmail;

	public HuifangView() {

	}

	public HuifangView(HuifangEntity huifangEntity) {
		try {
			BeanUtils.copyProperties(this, huifangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 回访类型的值
			*/
			public String getHuifangValue() {
				return huifangValue;
			}
			/**
			* 设置： 回访类型的值
			*/
			public void setHuifangValue(String huifangValue) {
				this.huifangValue = huifangValue;
			}






















				//级联表的get和set liulangdongwu_order

					/**
					* 获取： 申请编号
					*/
					public String getLiulangdongwuOrderUuidNumber() {
						return liulangdongwuOrderUuidNumber;
					}
					/**
					* 设置： 申请编号
					*/
					public void setLiulangdongwuOrderUuidNumber(String liulangdongwuOrderUuidNumber) {
						this.liulangdongwuOrderUuidNumber = liulangdongwuOrderUuidNumber;
					}


					/**
					* 获取：流浪动物领养申请 的 业主
					*/
					public Integer getLiulangdongwuOrderYezhuId() {
						return liulangdongwuOrderYezhuId;
					}
					/**
					* 设置：流浪动物领养申请 的 业主
					*/
					public void setLiulangdongwuOrderYezhuId(Integer liulangdongwuOrderYezhuId) {
						this.liulangdongwuOrderYezhuId = liulangdongwuOrderYezhuId;
					}


					/**
					* 获取： 个人条件
					*/
					public String getTiaojianContent() {
						return tiaojianContent;
					}
					/**
					* 设置： 个人条件
					*/
					public void setTiaojianContent(String tiaojianContent) {
						this.tiaojianContent = tiaojianContent;
					}

					/**
					* 获取： 申请状态
					*/
					public Integer getLiulangdongwuOrderYesnoTypes() {
						return liulangdongwuOrderYesnoTypes;
					}
					/**
					* 设置： 申请状态
					*/
					public void setLiulangdongwuOrderYesnoTypes(Integer liulangdongwuOrderYesnoTypes) {
						this.liulangdongwuOrderYesnoTypes = liulangdongwuOrderYesnoTypes;
					}


						/**
						* 获取： 申请状态的值
						*/
						public String getLiulangdongwuOrderYesnoValue() {
							return liulangdongwuOrderYesnoValue;
						}
						/**
						* 设置： 申请状态的值
						*/
						public void setLiulangdongwuOrderYesnoValue(String liulangdongwuOrderYesnoValue) {
							this.liulangdongwuOrderYesnoValue = liulangdongwuOrderYesnoValue;
						}

					/**
					* 获取： 审核意见
					*/
					public String getLiulangdongwuOrderYesnoText() {
						return liulangdongwuOrderYesnoText;
					}
					/**
					* 设置： 审核意见
					*/
					public void setLiulangdongwuOrderYesnoText(String liulangdongwuOrderYesnoText) {
						this.liulangdongwuOrderYesnoText = liulangdongwuOrderYesnoText;
					}

					/**
					* 获取： 审核时间
					*/
					public Date getLiulangdongwuOrderShenheTime() {
						return liulangdongwuOrderShenheTime;
					}
					/**
					* 设置： 审核时间
					*/
					public void setLiulangdongwuOrderShenheTime(Date liulangdongwuOrderShenheTime) {
						this.liulangdongwuOrderShenheTime = liulangdongwuOrderShenheTime;
					}







				//级联表的get和set zhiyuanzhe

					/**
					* 获取： 志愿者姓名
					*/
					public String getZhiyuanzheName() {
						return zhiyuanzheName;
					}
					/**
					* 设置： 志愿者姓名
					*/
					public void setZhiyuanzheName(String zhiyuanzheName) {
						this.zhiyuanzheName = zhiyuanzheName;
					}

					/**
					* 获取： 志愿者手机号
					*/
					public String getZhiyuanzhePhone() {
						return zhiyuanzhePhone;
					}
					/**
					* 设置： 志愿者手机号
					*/
					public void setZhiyuanzhePhone(String zhiyuanzhePhone) {
						this.zhiyuanzhePhone = zhiyuanzhePhone;
					}

					/**
					* 获取： 志愿者身份证号
					*/
					public String getZhiyuanzheIdNumber() {
						return zhiyuanzheIdNumber;
					}
					/**
					* 设置： 志愿者身份证号
					*/
					public void setZhiyuanzheIdNumber(String zhiyuanzheIdNumber) {
						this.zhiyuanzheIdNumber = zhiyuanzheIdNumber;
					}

					/**
					* 获取： 志愿者照片
					*/
					public String getZhiyuanzhePhoto() {
						return zhiyuanzhePhoto;
					}
					/**
					* 设置： 志愿者照片
					*/
					public void setZhiyuanzhePhoto(String zhiyuanzhePhoto) {
						this.zhiyuanzhePhoto = zhiyuanzhePhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getZhiyuanzheEmail() {
						return zhiyuanzheEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setZhiyuanzheEmail(String zhiyuanzheEmail) {
						this.zhiyuanzheEmail = zhiyuanzheEmail;
					}



}
