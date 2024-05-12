package com.dao;

import com.entity.DiscusscuxiaochanpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusscuxiaochanpinVO;
import com.entity.view.DiscusscuxiaochanpinView;


/**
 * 促销产品评论表
 * 
 * @author 
 * @email 
 * @date 2022-02-21 09:43:46
 */
public interface DiscusscuxiaochanpinDao extends BaseMapper<DiscusscuxiaochanpinEntity> {
	
	List<DiscusscuxiaochanpinVO> selectListVO(@Param("ew") Wrapper<DiscusscuxiaochanpinEntity> wrapper);
	
	DiscusscuxiaochanpinVO selectVO(@Param("ew") Wrapper<DiscusscuxiaochanpinEntity> wrapper);
	
	List<DiscusscuxiaochanpinView> selectListView(@Param("ew") Wrapper<DiscusscuxiaochanpinEntity> wrapper);

	List<DiscusscuxiaochanpinView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusscuxiaochanpinEntity> wrapper);
	
	DiscusscuxiaochanpinView selectView(@Param("ew") Wrapper<DiscusscuxiaochanpinEntity> wrapper);
	

}
