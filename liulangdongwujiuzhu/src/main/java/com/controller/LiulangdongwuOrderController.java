
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 流浪动物领养申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/liulangdongwuOrder")
public class LiulangdongwuOrderController {
    private static final Logger logger = LoggerFactory.getLogger(LiulangdongwuOrderController.class);

    @Autowired
    private LiulangdongwuOrderService liulangdongwuOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private LiulangdongwuService liulangdongwuService;
    @Autowired
    private YezhuService yezhuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("业主".equals(role))
            params.put("yezhuId",request.getSession().getAttribute("userId"));
        else if("志愿者".equals(role))
            params.put("zhiyuanzheId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = liulangdongwuOrderService.queryPage(params);

        //字典表数据转换
        List<LiulangdongwuOrderView> list =(List<LiulangdongwuOrderView>)page.getList();
        for(LiulangdongwuOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LiulangdongwuOrderEntity liulangdongwuOrder = liulangdongwuOrderService.selectById(id);
        if(liulangdongwuOrder !=null){
            //entity转view
            LiulangdongwuOrderView view = new LiulangdongwuOrderView();
            BeanUtils.copyProperties( liulangdongwuOrder , view );//把实体数据重构到view中

                //级联表
                LiulangdongwuEntity liulangdongwu = liulangdongwuService.selectById(liulangdongwuOrder.getLiulangdongwuId());
                if(liulangdongwu != null){
                    BeanUtils.copyProperties( liulangdongwu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yezhuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLiulangdongwuId(liulangdongwu.getId());
                    view.setLiulangdongwuYezhuId(liulangdongwu.getYezhuId());
                }
                //级联表
                YezhuEntity yezhu = yezhuService.selectById(liulangdongwuOrder.getYezhuId());
                if(yezhu != null){
                    BeanUtils.copyProperties( yezhu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYezhuId(yezhu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody LiulangdongwuOrderEntity liulangdongwuOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,liulangdongwuOrder:{}",this.getClass().getName(),liulangdongwuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("业主".equals(role))
            liulangdongwuOrder.setYezhuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        liulangdongwuOrder.setInsertTime(new Date());
        liulangdongwuOrder.setCreateTime(new Date());
        liulangdongwuOrderService.insert(liulangdongwuOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LiulangdongwuOrderEntity liulangdongwuOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,liulangdongwuOrder:{}",this.getClass().getName(),liulangdongwuOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("业主".equals(role))
//            liulangdongwuOrder.setYezhuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<LiulangdongwuOrderEntity> queryWrapper = new EntityWrapper<LiulangdongwuOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiulangdongwuOrderEntity liulangdongwuOrderEntity = liulangdongwuOrderService.selectOne(queryWrapper);
        if(liulangdongwuOrderEntity==null){
            liulangdongwuOrderService.updateById(liulangdongwuOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody LiulangdongwuOrderEntity liulangdongwuOrder, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,liulangdongwuOrder:{}",this.getClass().getName(),liulangdongwuOrder.toString());

        if(liulangdongwuOrder.getLiulangdongwuOrderYesnoTypes() == 2){//通过
            LiulangdongwuOrderEntity liulangdongwuOrderEntity = liulangdongwuOrderService.selectById(liulangdongwuOrder.getId());
            LiulangdongwuEntity liulangdongwuEntity = liulangdongwuService.selectById(liulangdongwuOrderEntity.getLiulangdongwuId());
            if(liulangdongwuEntity == null)
                return R.error("查不到流浪动物");
            else if(liulangdongwuEntity.getLingyangTypes() ==2)
                return R.error("流浪动物已被领养");

            liulangdongwuEntity.setLingyangTypes(2);
            liulangdongwuService.updateById(liulangdongwuEntity);
        }else if(liulangdongwuOrder.getLiulangdongwuOrderYesnoTypes() == 3){//拒绝
        }
        liulangdongwuOrder.setLiulangdongwuOrderShenheTime(new Date());//审核时间
        liulangdongwuOrderService.updateById(liulangdongwuOrder);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        liulangdongwuOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<LiulangdongwuOrderEntity> liulangdongwuOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            LiulangdongwuOrderEntity liulangdongwuOrderEntity = new LiulangdongwuOrderEntity();
//                            liulangdongwuOrderEntity.setLiulangdongwuOrderUuidNumber(data.get(0));                    //申请编号 要改的
//                            liulangdongwuOrderEntity.setLiulangdongwuId(Integer.valueOf(data.get(0)));   //流浪动物 要改的
//                            liulangdongwuOrderEntity.setYezhuId(Integer.valueOf(data.get(0)));   //业主 要改的
//                            liulangdongwuOrderEntity.setTiaojianContent("");//详情和图片
//                            liulangdongwuOrderEntity.setInsertTime(date);//时间
//                            liulangdongwuOrderEntity.setLiulangdongwuOrderYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            liulangdongwuOrderEntity.setLiulangdongwuOrderYesnoText(data.get(0));                    //审核意见 要改的
//                            liulangdongwuOrderEntity.setLiulangdongwuOrderShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            liulangdongwuOrderEntity.setCreateTime(date);//时间
                            liulangdongwuOrderList.add(liulangdongwuOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //申请编号
                                if(seachFields.containsKey("liulangdongwuOrderUuidNumber")){
                                    List<String> liulangdongwuOrderUuidNumber = seachFields.get("liulangdongwuOrderUuidNumber");
                                    liulangdongwuOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> liulangdongwuOrderUuidNumber = new ArrayList<>();
                                    liulangdongwuOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("liulangdongwuOrderUuidNumber",liulangdongwuOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //申请编号
                        List<LiulangdongwuOrderEntity> liulangdongwuOrderEntities_liulangdongwuOrderUuidNumber = liulangdongwuOrderService.selectList(new EntityWrapper<LiulangdongwuOrderEntity>().in("liulangdongwu_order_uuid_number", seachFields.get("liulangdongwuOrderUuidNumber")));
                        if(liulangdongwuOrderEntities_liulangdongwuOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LiulangdongwuOrderEntity s:liulangdongwuOrderEntities_liulangdongwuOrderUuidNumber){
                                repeatFields.add(s.getLiulangdongwuOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [申请编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        liulangdongwuOrderService.insertBatch(liulangdongwuOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = liulangdongwuOrderService.queryPage(params);

        //字典表数据转换
        List<LiulangdongwuOrderView> list =(List<LiulangdongwuOrderView>)page.getList();
        for(LiulangdongwuOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LiulangdongwuOrderEntity liulangdongwuOrder = liulangdongwuOrderService.selectById(id);
            if(liulangdongwuOrder !=null){


                //entity转view
                LiulangdongwuOrderView view = new LiulangdongwuOrderView();
                BeanUtils.copyProperties( liulangdongwuOrder , view );//把实体数据重构到view中

                //级联表
                    LiulangdongwuEntity liulangdongwu = liulangdongwuService.selectById(liulangdongwuOrder.getLiulangdongwuId());
                if(liulangdongwu != null){
                    BeanUtils.copyProperties( liulangdongwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLiulangdongwuId(liulangdongwu.getId());
                }
                //级联表
                    YezhuEntity yezhu = yezhuService.selectById(liulangdongwuOrder.getYezhuId());
                if(yezhu != null){
                    BeanUtils.copyProperties( yezhu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYezhuId(yezhu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody LiulangdongwuOrderEntity liulangdongwuOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,liulangdongwuOrder:{}",this.getClass().getName(),liulangdongwuOrder.toString());
            LiulangdongwuEntity liulangdongwuEntity = liulangdongwuService.selectById(liulangdongwuOrder.getLiulangdongwuId());
            if(liulangdongwuEntity == null){
                return R.error(511,"查不到该流浪动物");
            }
            // Double liulangdongwuNewMoney = liulangdongwuEntity.getLiulangdongwuNewMoney();

        ArrayList<Integer> liulangdongwu_order_yesno_types = new ArrayList<>();
        liulangdongwu_order_yesno_types.add(3);
        LiulangdongwuOrderEntity liulangdongwuOrderEntity = liulangdongwuOrderService.selectOne(new EntityWrapper<LiulangdongwuOrderEntity>()
                .eq("liulangdongwu_id", liulangdongwuOrder.getLiulangdongwuId())
                .eq("yezhu_id", liulangdongwuOrder.getYezhuId())
                .notIn("liulangdongwu_order_yesno_types", liulangdongwu_order_yesno_types)
        );




        if(liulangdongwuOrderEntity != null)
            return R.error("当前流浪动物你已经预约了");

        //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            liulangdongwuOrder.setYezhuId(userId); //设置订单支付人id
            liulangdongwuOrder.setLiulangdongwuOrderUuidNumber(String.valueOf(new Date().getTime()));
            liulangdongwuOrder.setInsertTime(new Date());
            liulangdongwuOrder.setCreateTime(new Date());
                liulangdongwuOrderService.insert(liulangdongwuOrder);//新增订单
            return R.ok();
    }



}
