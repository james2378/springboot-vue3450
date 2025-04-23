package com.entity.view;

import com.entity.LiulangdongwuOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 流浪动物领养申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("liulangdongwu_order")
public class LiulangdongwuOrderView extends LiulangdongwuOrderEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 申请状态的值
		*/
		private String liulangdongwuOrderYesnoValue;



		//级联表 liulangdongwu
			/**
			* 流浪动物 的 业主
			*/
			private Integer liulangdongwuYezhuId;
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
				* 动物类型的值
				*/
				private String liulangdongwuValue;
			/**
			* 动物品种
			*/
			private Integer liulangdongwuPinzhongTypes;
				/**
				* 动物品种的值
				*/
				private String liulangdongwuPinzhongValue;
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
				* 是否救助的值
				*/
				private String jiuzhuValue;
			/**
			* 是否健康
			*/
			private Integer jiankangTypes;
				/**
				* 是否健康的值
				*/
				private String jiankangValue;
			/**
			* 是否绝育
			*/
			private Integer jueyuTypes;
				/**
				* 是否绝育的值
				*/
				private String jueyuValue;
			/**
			* 是否打疫苗
			*/
			private Integer yimiaoTypes;
				/**
				* 是否打疫苗的值
				*/
				private String yimiaoValue;
			/**
			* 动物详细状况
			*/
			private String liulangdongwuContent;
			/**
			* 是否领养
			*/
			private Integer lingyangTypes;
				/**
				* 是否领养的值
				*/
				private String lingyangValue;
			/**
			* 逻辑删除
			*/
			private Integer liulangdongwuDelete;

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

	public LiulangdongwuOrderView() {

	}

	public LiulangdongwuOrderView(LiulangdongwuOrderEntity liulangdongwuOrderEntity) {
		try {
			BeanUtils.copyProperties(this, liulangdongwuOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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













				//级联表的get和set liulangdongwu

					/**
					* 获取：流浪动物 的 业主
					*/
					public Integer getLiulangdongwuYezhuId() {
						return liulangdongwuYezhuId;
					}
					/**
					* 设置：流浪动物 的 业主
					*/
					public void setLiulangdongwuYezhuId(Integer liulangdongwuYezhuId) {
						this.liulangdongwuYezhuId = liulangdongwuYezhuId;
					}


					/**
					* 获取： 流浪动物名称
					*/
					public String getLiulangdongwuName() {
						return liulangdongwuName;
					}
					/**
					* 设置： 流浪动物名称
					*/
					public void setLiulangdongwuName(String liulangdongwuName) {
						this.liulangdongwuName = liulangdongwuName;
					}

					/**
					* 获取： 流浪动物编号
					*/
					public String getLiulangdongwuUuidNumber() {
						return liulangdongwuUuidNumber;
					}
					/**
					* 设置： 流浪动物编号
					*/
					public void setLiulangdongwuUuidNumber(String liulangdongwuUuidNumber) {
						this.liulangdongwuUuidNumber = liulangdongwuUuidNumber;
					}

					/**
					* 获取： 动物照片
					*/
					public String getLiulangdongwuPhoto() {
						return liulangdongwuPhoto;
					}
					/**
					* 设置： 动物照片
					*/
					public void setLiulangdongwuPhoto(String liulangdongwuPhoto) {
						this.liulangdongwuPhoto = liulangdongwuPhoto;
					}

					/**
					* 获取： 动物类型
					*/
					public Integer getLiulangdongwuTypes() {
						return liulangdongwuTypes;
					}
					/**
					* 设置： 动物类型
					*/
					public void setLiulangdongwuTypes(Integer liulangdongwuTypes) {
						this.liulangdongwuTypes = liulangdongwuTypes;
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
					* 获取： 动物品种
					*/
					public Integer getLiulangdongwuPinzhongTypes() {
						return liulangdongwuPinzhongTypes;
					}
					/**
					* 设置： 动物品种
					*/
					public void setLiulangdongwuPinzhongTypes(Integer liulangdongwuPinzhongTypes) {
						this.liulangdongwuPinzhongTypes = liulangdongwuPinzhongTypes;
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
					* 获取： 流浪地点
					*/
					public String getLiulangdongwuDidian() {
						return liulangdongwuDidian;
					}
					/**
					* 设置： 流浪地点
					*/
					public void setLiulangdongwuDidian(String liulangdongwuDidian) {
						this.liulangdongwuDidian = liulangdongwuDidian;
					}

					/**
					* 获取： 动物年龄
					*/
					public String getLiulangdongwuAge() {
						return liulangdongwuAge;
					}
					/**
					* 设置： 动物年龄
					*/
					public void setLiulangdongwuAge(String liulangdongwuAge) {
						this.liulangdongwuAge = liulangdongwuAge;
					}

					/**
					* 获取： 宠物热度
					*/
					public Integer getLiulangdongwuClicknum() {
						return liulangdongwuClicknum;
					}
					/**
					* 设置： 宠物热度
					*/
					public void setLiulangdongwuClicknum(Integer liulangdongwuClicknum) {
						this.liulangdongwuClicknum = liulangdongwuClicknum;
					}

					/**
					* 获取： 是否救助
					*/
					public Integer getJiuzhuTypes() {
						return jiuzhuTypes;
					}
					/**
					* 设置： 是否救助
					*/
					public void setJiuzhuTypes(Integer jiuzhuTypes) {
						this.jiuzhuTypes = jiuzhuTypes;
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
					* 获取： 是否健康
					*/
					public Integer getJiankangTypes() {
						return jiankangTypes;
					}
					/**
					* 设置： 是否健康
					*/
					public void setJiankangTypes(Integer jiankangTypes) {
						this.jiankangTypes = jiankangTypes;
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
					* 获取： 是否绝育
					*/
					public Integer getJueyuTypes() {
						return jueyuTypes;
					}
					/**
					* 设置： 是否绝育
					*/
					public void setJueyuTypes(Integer jueyuTypes) {
						this.jueyuTypes = jueyuTypes;
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
					* 获取： 是否打疫苗
					*/
					public Integer getYimiaoTypes() {
						return yimiaoTypes;
					}
					/**
					* 设置： 是否打疫苗
					*/
					public void setYimiaoTypes(Integer yimiaoTypes) {
						this.yimiaoTypes = yimiaoTypes;
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
					* 获取： 动物详细状况
					*/
					public String getLiulangdongwuContent() {
						return liulangdongwuContent;
					}
					/**
					* 设置： 动物详细状况
					*/
					public void setLiulangdongwuContent(String liulangdongwuContent) {
						this.liulangdongwuContent = liulangdongwuContent;
					}

					/**
					* 获取： 是否领养
					*/
					public Integer getLingyangTypes() {
						return lingyangTypes;
					}
					/**
					* 设置： 是否领养
					*/
					public void setLingyangTypes(Integer lingyangTypes) {
						this.lingyangTypes = lingyangTypes;
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

					/**
					* 获取： 逻辑删除
					*/
					public Integer getLiulangdongwuDelete() {
						return liulangdongwuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setLiulangdongwuDelete(Integer liulangdongwuDelete) {
						this.liulangdongwuDelete = liulangdongwuDelete;
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
