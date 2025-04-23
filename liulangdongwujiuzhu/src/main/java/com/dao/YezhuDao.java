package com.dao;

import com.entity.YezhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YezhuView;

/**
 * 业主 Dao 接口
 *
 * @author 
 */
public interface YezhuDao extends BaseMapper<YezhuEntity> {

   List<YezhuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
