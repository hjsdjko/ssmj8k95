package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusscuxiaochanpinDao;
import com.entity.DiscusscuxiaochanpinEntity;
import com.service.DiscusscuxiaochanpinService;
import com.entity.vo.DiscusscuxiaochanpinVO;
import com.entity.view.DiscusscuxiaochanpinView;

@Service("discusscuxiaochanpinService")
public class DiscusscuxiaochanpinServiceImpl extends ServiceImpl<DiscusscuxiaochanpinDao, DiscusscuxiaochanpinEntity> implements DiscusscuxiaochanpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusscuxiaochanpinEntity> page = this.selectPage(
                new Query<DiscusscuxiaochanpinEntity>(params).getPage(),
                new EntityWrapper<DiscusscuxiaochanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusscuxiaochanpinEntity> wrapper) {
		  Page<DiscusscuxiaochanpinView> page =new Query<DiscusscuxiaochanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusscuxiaochanpinVO> selectListVO(Wrapper<DiscusscuxiaochanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusscuxiaochanpinVO selectVO(Wrapper<DiscusscuxiaochanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusscuxiaochanpinView> selectListView(Wrapper<DiscusscuxiaochanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusscuxiaochanpinView selectView(Wrapper<DiscusscuxiaochanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
