package com.entity.view;

import com.entity.FenxiangEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 宠物分享
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fenxiang")
public class FenxiangView extends FenxiangEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 分享类型的值
		*/
		private String fenxiangValue;



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

		//级联表 yezhu
			/**
			* 业主姓名
			*/
			private String yezhuName;
			/**
			* 业主手机号
			*/
			private String yezhuPhone;
			/**
			* 业主身份证号
			*/
			private String yezhuIdNumber;
			/**
			* 业主头像
			*/
			private String yezhuPhoto;
			/**
			* 电子邮箱
			*/
			private String yezhuEmail;

	public FenxiangView() {

	}

	public FenxiangView(FenxiangEntity fenxiangEntity) {
		try {
			BeanUtils.copyProperties(this, fenxiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 分享类型的值
			*/
			public String getFenxiangValue() {
				return fenxiangValue;
			}
			/**
			* 设置： 分享类型的值
			*/
			public void setFenxiangValue(String fenxiangValue) {
				this.fenxiangValue = fenxiangValue;
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




				//级联表的get和set yezhu

					/**
					* 获取： 业主姓名
					*/
					public String getYezhuName() {
						return yezhuName;
					}
					/**
					* 设置： 业主姓名
					*/
					public void setYezhuName(String yezhuName) {
						this.yezhuName = yezhuName;
					}

					/**
					* 获取： 业主手机号
					*/
					public String getYezhuPhone() {
						return yezhuPhone;
					}
					/**
					* 设置： 业主手机号
					*/
					public void setYezhuPhone(String yezhuPhone) {
						this.yezhuPhone = yezhuPhone;
					}

					/**
					* 获取： 业主身份证号
					*/
					public String getYezhuIdNumber() {
						return yezhuIdNumber;
					}
					/**
					* 设置： 业主身份证号
					*/
					public void setYezhuIdNumber(String yezhuIdNumber) {
						this.yezhuIdNumber = yezhuIdNumber;
					}

					/**
					* 获取： 业主头像
					*/
					public String getYezhuPhoto() {
						return yezhuPhoto;
					}
					/**
					* 设置： 业主头像
					*/
					public void setYezhuPhoto(String yezhuPhoto) {
						this.yezhuPhoto = yezhuPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getYezhuEmail() {
						return yezhuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYezhuEmail(String yezhuEmail) {
						this.yezhuEmail = yezhuEmail;
					}






}
