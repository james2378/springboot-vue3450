
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
 * 回访
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huifang")
public class HuifangController {
    private static final Logger logger = LoggerFactory.getLogger(HuifangController.class);

    @Autowired
    private HuifangService huifangService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private LiulangdongwuOrderService liulangdongwuOrderService;
    @Autowired
    private ZhiyuanzheService zhiyuanzheService;

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
        PageUtils page = huifangService.queryPage(params);

        //字典表数据转换
        List<HuifangView> list =(List<HuifangView>)page.getList();
        for(HuifangView c:list){
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
        HuifangEntity huifang = huifangService.selectById(id);
        if(huifang !=null){
            //entity转view
            HuifangView view = new HuifangView();
            BeanUtils.copyProperties( huifang , view );//把实体数据重构到view中

                //级联表
                LiulangdongwuOrderEntity liulangdongwuOrder = liulangdongwuOrderService.selectById(huifang.getLiulangdongwuOrderId());
                if(liulangdongwuOrder != null){
                    BeanUtils.copyProperties( liulangdongwuOrder , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLiulangdongwuOrderId(liulangdongwuOrder.getId());
                }
                //级联表
                ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(huifang.getZhiyuanzheId());
                if(zhiyuanzhe != null){
                    BeanUtils.copyProperties( zhiyuanzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhiyuanzheId(zhiyuanzhe.getId());
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
    public R save(@RequestBody HuifangEntity huifang, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huifang:{}",this.getClass().getName(),huifang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("志愿者".equals(role))
            huifang.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<HuifangEntity> queryWrapper = new EntityWrapper<HuifangEntity>()
            .eq("huifang_uuid_number", huifang.getHuifangUuidNumber())
            .eq("liulangdongwu_order_id", huifang.getLiulangdongwuOrderId())
            .eq("zhiyuanzhe_id", huifang.getZhiyuanzheId())
            .eq("huifang_name", huifang.getHuifangName())
            .eq("huifang_types", huifang.getHuifangTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuifangEntity huifangEntity = huifangService.selectOne(queryWrapper);
        if(huifangEntity==null){
            huifang.setInsertTime(new Date());
            huifang.setCreateTime(new Date());
            huifangService.insert(huifang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuifangEntity huifang, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,huifang:{}",this.getClass().getName(),huifang.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("志愿者".equals(role))
//            huifang.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<HuifangEntity> queryWrapper = new EntityWrapper<HuifangEntity>()
            .notIn("id",huifang.getId())
            .andNew()
            .eq("huifang_uuid_number", huifang.getHuifangUuidNumber())
            .eq("liulangdongwu_order_id", huifang.getLiulangdongwuOrderId())
            .eq("zhiyuanzhe_id", huifang.getZhiyuanzheId())
            .eq("huifang_name", huifang.getHuifangName())
            .eq("huifang_types", huifang.getHuifangTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuifangEntity huifangEntity = huifangService.selectOne(queryWrapper);
        if(huifangEntity==null){
            huifangService.updateById(huifang);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        huifangService.deleteBatchIds(Arrays.asList(ids));
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
            List<HuifangEntity> huifangList = new ArrayList<>();//上传的东西
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
                            HuifangEntity huifangEntity = new HuifangEntity();
//                            huifangEntity.setHuifangUuidNumber(data.get(0));                    //回访编号 要改的
//                            huifangEntity.setLiulangdongwuOrderId(Integer.valueOf(data.get(0)));   //宠物领养申请 要改的
//                            huifangEntity.setZhiyuanzheId(Integer.valueOf(data.get(0)));   //志愿者 要改的
//                            huifangEntity.setHuifangName(data.get(0));                    //回访标题 要改的
//                            huifangEntity.setHuifangTypes(Integer.valueOf(data.get(0)));   //回访类型 要改的
//                            huifangEntity.setHuifangContent("");//详情和图片
//                            huifangEntity.setInsertTime(date);//时间
//                            huifangEntity.setCreateTime(date);//时间
                            huifangList.add(huifangEntity);


                            //把要查询是否重复的字段放入map中
                                //回访编号
                                if(seachFields.containsKey("huifangUuidNumber")){
                                    List<String> huifangUuidNumber = seachFields.get("huifangUuidNumber");
                                    huifangUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huifangUuidNumber = new ArrayList<>();
                                    huifangUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huifangUuidNumber",huifangUuidNumber);
                                }
                        }

                        //查询是否重复
                         //回访编号
                        List<HuifangEntity> huifangEntities_huifangUuidNumber = huifangService.selectList(new EntityWrapper<HuifangEntity>().in("huifang_uuid_number", seachFields.get("huifangUuidNumber")));
                        if(huifangEntities_huifangUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuifangEntity s:huifangEntities_huifangUuidNumber){
                                repeatFields.add(s.getHuifangUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [回访编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huifangService.insertBatch(huifangList);
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
        PageUtils page = huifangService.queryPage(params);

        //字典表数据转换
        List<HuifangView> list =(List<HuifangView>)page.getList();
        for(HuifangView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuifangEntity huifang = huifangService.selectById(id);
            if(huifang !=null){


                //entity转view
                HuifangView view = new HuifangView();
                BeanUtils.copyProperties( huifang , view );//把实体数据重构到view中

                //级联表
                    LiulangdongwuOrderEntity liulangdongwuOrder = liulangdongwuOrderService.selectById(huifang.getLiulangdongwuOrderId());
                if(liulangdongwuOrder != null){
                    BeanUtils.copyProperties( liulangdongwuOrder , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLiulangdongwuOrderId(liulangdongwuOrder.getId());
                }
                //级联表
                    ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(huifang.getZhiyuanzheId());
                if(zhiyuanzhe != null){
                    BeanUtils.copyProperties( zhiyuanzhe , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhiyuanzheId(zhiyuanzhe.getId());
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
    public R add(@RequestBody HuifangEntity huifang, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,huifang:{}",this.getClass().getName(),huifang.toString());
        Wrapper<HuifangEntity> queryWrapper = new EntityWrapper<HuifangEntity>()
            .eq("huifang_uuid_number", huifang.getHuifangUuidNumber())
            .eq("liulangdongwu_order_id", huifang.getLiulangdongwuOrderId())
            .eq("zhiyuanzhe_id", huifang.getZhiyuanzheId())
            .eq("huifang_name", huifang.getHuifangName())
            .eq("huifang_types", huifang.getHuifangTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuifangEntity huifangEntity = huifangService.selectOne(queryWrapper);
        if(huifangEntity==null){
            huifang.setInsertTime(new Date());
            huifang.setCreateTime(new Date());
        huifangService.insert(huifang);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
