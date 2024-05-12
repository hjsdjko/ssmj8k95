package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.CuxiaochanpinEntity;
import com.entity.view.CuxiaochanpinView;

import com.service.CuxiaochanpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 促销产品
 * 后端接口
 * @author 
 * @email 
 * @date 2022-02-21 09:43:45
 */
@RestController
@RequestMapping("/cuxiaochanpin")
public class CuxiaochanpinController {
    @Autowired
    private CuxiaochanpinService cuxiaochanpinService;


    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,CuxiaochanpinEntity cuxiaochanpin, 
		HttpServletRequest request){

        EntityWrapper<CuxiaochanpinEntity> ew = new EntityWrapper<CuxiaochanpinEntity>();
		PageUtils page = cuxiaochanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cuxiaochanpin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,CuxiaochanpinEntity cuxiaochanpin, 
		HttpServletRequest request){
        EntityWrapper<CuxiaochanpinEntity> ew = new EntityWrapper<CuxiaochanpinEntity>();
		PageUtils page = cuxiaochanpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, cuxiaochanpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( CuxiaochanpinEntity cuxiaochanpin){
       	EntityWrapper<CuxiaochanpinEntity> ew = new EntityWrapper<CuxiaochanpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( cuxiaochanpin, "cuxiaochanpin")); 
        return R.ok().put("data", cuxiaochanpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(CuxiaochanpinEntity cuxiaochanpin){
        EntityWrapper< CuxiaochanpinEntity> ew = new EntityWrapper< CuxiaochanpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( cuxiaochanpin, "cuxiaochanpin")); 
		CuxiaochanpinView cuxiaochanpinView =  cuxiaochanpinService.selectView(ew);
		return R.ok("查询促销产品成功").put("data", cuxiaochanpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        CuxiaochanpinEntity cuxiaochanpin = cuxiaochanpinService.selectById(id);
        return R.ok().put("data", cuxiaochanpin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        CuxiaochanpinEntity cuxiaochanpin = cuxiaochanpinService.selectById(id);
        return R.ok().put("data", cuxiaochanpin);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CuxiaochanpinEntity cuxiaochanpin, HttpServletRequest request){
    	cuxiaochanpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cuxiaochanpin);

        cuxiaochanpinService.insert(cuxiaochanpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody CuxiaochanpinEntity cuxiaochanpin, HttpServletRequest request){
    	cuxiaochanpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(cuxiaochanpin);

        cuxiaochanpinService.insert(cuxiaochanpin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CuxiaochanpinEntity cuxiaochanpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(cuxiaochanpin);
        cuxiaochanpinService.updateById(cuxiaochanpin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        cuxiaochanpinService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<CuxiaochanpinEntity> wrapper = new EntityWrapper<CuxiaochanpinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = cuxiaochanpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}
