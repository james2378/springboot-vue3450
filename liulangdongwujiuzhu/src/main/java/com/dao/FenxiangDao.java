package com.dao;

import com.entity.FenxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FenxiangView;

/**
 * 宠物分享 Dao 接口
 *
 * @author 
 */
public interface FenxiangDao extends BaseMapper<FenxiangEntity> {

   List<FenxiangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
