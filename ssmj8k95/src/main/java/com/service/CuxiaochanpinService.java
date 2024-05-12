package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CuxiaochanpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CuxiaochanpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CuxiaochanpinView;


/**
 * 促销产品
 *
 * @author 
 * @email 
 * @date 2022-02-21 09:43:45
 */
public interface CuxiaochanpinService extends IService<CuxiaochanpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CuxiaochanpinVO> selectListVO(Wrapper<CuxiaochanpinEntity> wrapper);
   	
   	CuxiaochanpinVO selectVO(@Param("ew") Wrapper<CuxiaochanpinEntity> wrapper);
   	
   	List<CuxiaochanpinView> selectListView(Wrapper<CuxiaochanpinEntity> wrapper);
   	
   	CuxiaochanpinView selectView(@Param("ew") Wrapper<CuxiaochanpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CuxiaochanpinEntity> wrapper);
   	

}

