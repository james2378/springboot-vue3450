
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
 * 流浪动物
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/liulangdongwu")
public class LiulangdongwuController {
    private static final Logger logger = LoggerFactory.getLogger(LiulangdongwuController.class);

    @Autowired
    private LiulangdongwuService liulangdongwuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YezhuService yezhuService;

    @Autowired
    private ZhiyuanzheService zhiyuanzheService;


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
        params.put("liulangdongwuDeleteStart",1);params.put("liulangdongwuDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = liulangdongwuService.queryPage(params);

        //字典表数据转换
        List<LiulangdongwuView> list =(List<LiulangdongwuView>)page.getList();
        for(LiulangdongwuView c:list){
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
        LiulangdongwuEntity liulangdongwu = liulangdongwuService.selectById(id);
        if(liulangdongwu !=null){
            //entity转view
            LiulangdongwuView view = new LiulangdongwuView();
            BeanUtils.copyProperties( liulangdongwu , view );//把实体数据重构到view中

                //级联表
                YezhuEntity yezhu = yezhuService.selectById(liulangdongwu.getYezhuId());
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
    public R save(@RequestBody LiulangdongwuEntity liulangdongwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,liulangdongwu:{}",this.getClass().getName(),liulangdongwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("业主".equals(role)){
            liulangdongwu.setYezhuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            liulangdongwu.setJiuzhuTypes(1);
        }

        Wrapper<LiulangdongwuEntity> queryWrapper = new EntityWrapper<LiulangdongwuEntity>()
            .eq("yezhu_id", liulangdongwu.getYezhuId())
            .eq("liulangdongwu_name", liulangdongwu.getLiulangdongwuName())
            .eq("liulangdongwu_uuid_number", liulangdongwu.getLiulangdongwuUuidNumber())
            .eq("liulangdongwu_types", liulangdongwu.getLiulangdongwuTypes())
            .eq("liulangdongwu_pinzhong_types", liulangdongwu.getLiulangdongwuPinzhongTypes())
            .eq("liulangdongwu_didian", liulangdongwu.getLiulangdongwuDidian())
            .eq("liulangdongwu_age", liulangdongwu.getLiulangdongwuAge())
            .eq("liulangdongwu_clicknum", liulangdongwu.getLiulangdongwuClicknum())
            .eq("jiuzhu_types", liulangdongwu.getJiuzhuTypes())
            .eq("jiankang_types", liulangdongwu.getJiankangTypes())
            .eq("jueyu_types", liulangdongwu.getJueyuTypes())
            .eq("yimiao_types", liulangdongwu.getYimiaoTypes())
            .eq("lingyang_types", liulangdongwu.getLingyangTypes())
            .eq("liulangdongwu_delete", liulangdongwu.getLiulangdongwuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiulangdongwuEntity liulangdongwuEntity = liulangdongwuService.selectOne(queryWrapper);
        if(liulangdongwuEntity==null){
            liulangdongwu.setLiulangdongwuClicknum(1);
            liulangdongwu.setLiulangdongwuDelete(1);
            liulangdongwu.setCreateTime(new Date());
            liulangdongwuService.insert(liulangdongwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody LiulangdongwuEntity liulangdongwu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,liulangdongwu:{}",this.getClass().getName(),liulangdongwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("业主".equals(role))
//            liulangdongwu.setYezhuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<LiulangdongwuEntity> queryWrapper = new EntityWrapper<LiulangdongwuEntity>()
            .notIn("id",liulangdongwu.getId())
            .andNew()
            .eq("yezhu_id", liulangdongwu.getYezhuId())
            .eq("liulangdongwu_name", liulangdongwu.getLiulangdongwuName())
            .eq("liulangdongwu_uuid_number", liulangdongwu.getLiulangdongwuUuidNumber())
            .eq("liulangdongwu_types", liulangdongwu.getLiulangdongwuTypes())
            .eq("liulangdongwu_pinzhong_types", liulangdongwu.getLiulangdongwuPinzhongTypes())
            .eq("liulangdongwu_didian", liulangdongwu.getLiulangdongwuDidian())
            .eq("liulangdongwu_age", liulangdongwu.getLiulangdongwuAge())
            .eq("liulangdongwu_clicknum", liulangdongwu.getLiulangdongwuClicknum())
            .eq("jiuzhu_types", liulangdongwu.getJiuzhuTypes())
            .eq("jiankang_types", liulangdongwu.getJiankangTypes())
            .eq("jueyu_types", liulangdongwu.getJueyuTypes())
            .eq("yimiao_types", liulangdongwu.getYimiaoTypes())
            .eq("lingyang_types", liulangdongwu.getLingyangTypes())
            .eq("liulangdongwu_delete", liulangdongwu.getLiulangdongwuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiulangdongwuEntity liulangdongwuEntity = liulangdongwuService.selectOne(queryWrapper);
        if("".equals(liulangdongwu.getLiulangdongwuPhoto()) || "null".equals(liulangdongwu.getLiulangdongwuPhoto())){
                liulangdongwu.setLiulangdongwuPhoto(null);
        }
        if(liulangdongwuEntity==null){
            liulangdongwuService.updateById(liulangdongwu);//根据id更新
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
        ArrayList<LiulangdongwuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            LiulangdongwuEntity liulangdongwuEntity = new LiulangdongwuEntity();
            liulangdongwuEntity.setId(id);
            liulangdongwuEntity.setLiulangdongwuDelete(2);
            list.add(liulangdongwuEntity);
        }
        if(list != null && list.size() >0){
            liulangdongwuService.updateBatchById(list);
        }
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
            List<LiulangdongwuEntity> liulangdongwuList = new ArrayList<>();//上传的东西
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
                            LiulangdongwuEntity liulangdongwuEntity = new LiulangdongwuEntity();
//                            liulangdongwuEntity.setYezhuId(Integer.valueOf(data.get(0)));   //业主 要改的
//                            liulangdongwuEntity.setLiulangdongwuName(data.get(0));                    //流浪动物名称 要改的
//                            liulangdongwuEntity.setLiulangdongwuUuidNumber(data.get(0));                    //流浪动物编号 要改的
//                            liulangdongwuEntity.setLiulangdongwuPhoto("");//详情和图片
//                            liulangdongwuEntity.setLiulangdongwuTypes(Integer.valueOf(data.get(0)));   //动物类型 要改的
//                            liulangdongwuEntity.setLiulangdongwuPinzhongTypes(Integer.valueOf(data.get(0)));   //动物品种 要改的
//                            liulangdongwuEntity.setLiulangdongwuDidian(data.get(0));                    //流浪地点 要改的
//                            liulangdongwuEntity.setLiulangdongwuAge(data.get(0));                    //动物年龄 要改的
//                            liulangdongwuEntity.setLiulangdongwuClicknum(Integer.valueOf(data.get(0)));   //宠物热度 要改的
//                            liulangdongwuEntity.setJiuzhuTypes(Integer.valueOf(data.get(0)));   //是否救助 要改的
//                            liulangdongwuEntity.setJiankangTypes(Integer.valueOf(data.get(0)));   //是否健康 要改的
//                            liulangdongwuEntity.setJueyuTypes(Integer.valueOf(data.get(0)));   //是否绝育 要改的
//                            liulangdongwuEntity.setYimiaoTypes(Integer.valueOf(data.get(0)));   //是否打疫苗 要改的
//                            liulangdongwuEntity.setLiulangdongwuContent("");//详情和图片
//                            liulangdongwuEntity.setLingyangTypes(Integer.valueOf(data.get(0)));   //是否领养 要改的
//                            liulangdongwuEntity.setLiulangdongwuDelete(1);//逻辑删除字段
//                            liulangdongwuEntity.setCreateTime(date);//时间
                            liulangdongwuList.add(liulangdongwuEntity);


                            //把要查询是否重复的字段放入map中
                                //流浪动物编号
                                if(seachFields.containsKey("liulangdongwuUuidNumber")){
                                    List<String> liulangdongwuUuidNumber = seachFields.get("liulangdongwuUuidNumber");
                                    liulangdongwuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> liulangdongwuUuidNumber = new ArrayList<>();
                                    liulangdongwuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("liulangdongwuUuidNumber",liulangdongwuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //流浪动物编号
                        List<LiulangdongwuEntity> liulangdongwuEntities_liulangdongwuUuidNumber = liulangdongwuService.selectList(new EntityWrapper<LiulangdongwuEntity>().in("liulangdongwu_uuid_number", seachFields.get("liulangdongwuUuidNumber")).eq("liulangdongwu_delete", 1));
                        if(liulangdongwuEntities_liulangdongwuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(LiulangdongwuEntity s:liulangdongwuEntities_liulangdongwuUuidNumber){
                                repeatFields.add(s.getLiulangdongwuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [流浪动物编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        liulangdongwuService.insertBatch(liulangdongwuList);
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
        PageUtils page = liulangdongwuService.queryPage(params);

        //字典表数据转换
        List<LiulangdongwuView> list =(List<LiulangdongwuView>)page.getList();
        for(LiulangdongwuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        LiulangdongwuEntity liulangdongwu = liulangdongwuService.selectById(id);
            if(liulangdongwu !=null){

                //点击数量加1
                liulangdongwu.setLiulangdongwuClicknum(liulangdongwu.getLiulangdongwuClicknum()+1);
                liulangdongwuService.updateById(liulangdongwu);

                //entity转view
                LiulangdongwuView view = new LiulangdongwuView();
                BeanUtils.copyProperties( liulangdongwu , view );//把实体数据重构到view中

                //级联表
                    YezhuEntity yezhu = yezhuService.selectById(liulangdongwu.getYezhuId());
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
    public R add(@RequestBody LiulangdongwuEntity liulangdongwu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,liulangdongwu:{}",this.getClass().getName(),liulangdongwu.toString());
        Wrapper<LiulangdongwuEntity> queryWrapper = new EntityWrapper<LiulangdongwuEntity>()
            .eq("yezhu_id", liulangdongwu.getYezhuId())
            .eq("liulangdongwu_name", liulangdongwu.getLiulangdongwuName())
            .eq("liulangdongwu_uuid_number", liulangdongwu.getLiulangdongwuUuidNumber())
            .eq("liulangdongwu_types", liulangdongwu.getLiulangdongwuTypes())
            .eq("liulangdongwu_pinzhong_types", liulangdongwu.getLiulangdongwuPinzhongTypes())
            .eq("liulangdongwu_didian", liulangdongwu.getLiulangdongwuDidian())
            .eq("liulangdongwu_age", liulangdongwu.getLiulangdongwuAge())
            .eq("liulangdongwu_clicknum", liulangdongwu.getLiulangdongwuClicknum())
            .eq("jiuzhu_types", liulangdongwu.getJiuzhuTypes())
            .eq("jiankang_types", liulangdongwu.getJiankangTypes())
            .eq("jueyu_types", liulangdongwu.getJueyuTypes())
            .eq("yimiao_types", liulangdongwu.getYimiaoTypes())
            .eq("lingyang_types", liulangdongwu.getLingyangTypes())
            .eq("liulangdongwu_delete", liulangdongwu.getLiulangdongwuDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        LiulangdongwuEntity liulangdongwuEntity = liulangdongwuService.selectOne(queryWrapper);
        if(liulangdongwuEntity==null){
            liulangdongwu.setLiulangdongwuDelete(1);
            liulangdongwu.setCreateTime(new Date());
        liulangdongwuService.insert(liulangdongwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
