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


import com.dao.CuxiaochanpinDao;
import com.entity.CuxiaochanpinEntity;
import com.service.CuxiaochanpinService;
import com.entity.vo.CuxiaochanpinVO;
import com.entity.view.CuxiaochanpinView;

@Service("cuxiaochanpinService")
public class CuxiaochanpinServiceImpl extends ServiceImpl<CuxiaochanpinDao, CuxiaochanpinEntity> implements CuxiaochanpinService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CuxiaochanpinEntity> page = this.selectPage(
                new Query<CuxiaochanpinEntity>(params).getPage(),
                new EntityWrapper<CuxiaochanpinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CuxiaochanpinEntity> wrapper) {
		  Page<CuxiaochanpinView> page =new Query<CuxiaochanpinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CuxiaochanpinVO> selectListVO(Wrapper<CuxiaochanpinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CuxiaochanpinVO selectVO(Wrapper<CuxiaochanpinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CuxiaochanpinView> selectListView(Wrapper<CuxiaochanpinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CuxiaochanpinView selectView(Wrapper<CuxiaochanpinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
