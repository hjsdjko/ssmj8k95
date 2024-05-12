package com.dao;

import com.entity.CuxiaochanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CuxiaochanpinVO;
import com.entity.view.CuxiaochanpinView;


/**
 * 促销产品
 * 
 * @author 
 * @email 
 * @date 2022-02-21 09:43:45
 */
public interface CuxiaochanpinDao extends BaseMapper<CuxiaochanpinEntity> {
	
	List<CuxiaochanpinVO> selectListVO(@Param("ew") Wrapper<CuxiaochanpinEntity> wrapper);
	
	CuxiaochanpinVO selectVO(@Param("ew") Wrapper<CuxiaochanpinEntity> wrapper);
	
	List<CuxiaochanpinView> selectListView(@Param("ew") Wrapper<CuxiaochanpinEntity> wrapper);

	List<CuxiaochanpinView> selectListView(Pagination page,@Param("ew") Wrapper<CuxiaochanpinEntity> wrapper);
	
	CuxiaochanpinView selectView(@Param("ew") Wrapper<CuxiaochanpinEntity> wrapper);
	

}
