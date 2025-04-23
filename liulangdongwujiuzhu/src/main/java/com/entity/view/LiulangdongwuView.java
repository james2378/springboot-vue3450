package com.entity.view;

import com.entity.LiulangdongwuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 流浪动物
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("liulangdongwu")
public class LiulangdongwuView extends LiulangdongwuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 动物类型的值
		*/
		private String liulangdongwuValue;
		/**
		* 动物品种的值
		*/
		private String liulangdongwuPinzhongValue;
		/**
		* 是否救助的值
		*/
		private String jiuzhuValue;
		/**
		* 是否健康的值
		*/
		private String jiankangValue;
		/**
		* 是否绝育的值
		*/
		private String jueyuValue;
		/**
		* 是否打疫苗的值
		*/
		private String yimiaoValue;
		/**
		* 是否领养的值
		*/
		private String lingyangValue;



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

	public LiulangdongwuView() {

	}

	public LiulangdongwuView(LiulangdongwuEntity liulangdongwuEntity) {
		try {
			BeanUtils.copyProperties(this, liulangdongwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 动物类型的值
			*/
			public String getLiulangdongwuValue() {
				return liulangdongwuValue;
			}
			/**
			* 设置： 动物类型的值
			*/
			public void setLiulangdongwuValue(String liulangdongwuValue) {
				this.liulangdongwuValue = liulangdongwuValue;
			}
			/**
			* 获取： 动物品种的值
			*/
			public String getLiulangdongwuPinzhongValue() {
				return liulangdongwuPinzhongValue;
			}
			/**
			* 设置： 动物品种的值
			*/
			public void setLiulangdongwuPinzhongValue(String liulangdongwuPinzhongValue) {
				this.liulangdongwuPinzhongValue = liulangdongwuPinzhongValue;
			}
			/**
			* 获取： 是否救助的值
			*/
			public String getJiuzhuValue() {
				return jiuzhuValue;
			}
			/**
			* 设置： 是否救助的值
			*/
			public void setJiuzhuValue(String jiuzhuValue) {
				this.jiuzhuValue = jiuzhuValue;
			}
			/**
			* 获取： 是否健康的值
			*/
			public String getJiankangValue() {
				return jiankangValue;
			}
			/**
			* 设置： 是否健康的值
			*/
			public void setJiankangValue(String jiankangValue) {
				this.jiankangValue = jiankangValue;
			}
			/**
			* 获取： 是否绝育的值
			*/
			public String getJueyuValue() {
				return jueyuValue;
			}
			/**
			* 设置： 是否绝育的值
			*/
			public void setJueyuValue(String jueyuValue) {
				this.jueyuValue = jueyuValue;
			}
			/**
			* 获取： 是否打疫苗的值
			*/
			public String getYimiaoValue() {
				return yimiaoValue;
			}
			/**
			* 设置： 是否打疫苗的值
			*/
			public void setYimiaoValue(String yimiaoValue) {
				this.yimiaoValue = yimiaoValue;
			}
			/**
			* 获取： 是否领养的值
			*/
			public String getLingyangValue() {
				return lingyangValue;
			}
			/**
			* 设置： 是否领养的值
			*/
			public void setLingyangValue(String lingyangValue) {
				this.lingyangValue = lingyangValue;
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
