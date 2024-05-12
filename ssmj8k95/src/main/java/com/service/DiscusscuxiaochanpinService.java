package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusscuxiaochanpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusscuxiaochanpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusscuxiaochanpinView;


/**
 * 促销产品评论表
 *
 * @author 
 * @email 
 * @date 2022-02-21 09:43:46
 */
public interface DiscusscuxiaochanpinService extends IService<DiscusscuxiaochanpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusscuxiaochanpinVO> selectListVO(Wrapper<DiscusscuxiaochanpinEntity> wrapper);
   	
   	DiscusscuxiaochanpinVO selectVO(@Param("ew") Wrapper<DiscusscuxiaochanpinEntity> wrapper);
   	
   	List<DiscusscuxiaochanpinView> selectListView(Wrapper<DiscusscuxiaochanpinEntity> wrapper);
   	
   	DiscusscuxiaochanpinView selectView(@Param("ew") Wrapper<DiscusscuxiaochanpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusscuxiaochanpinEntity> wrapper);
   	

}

