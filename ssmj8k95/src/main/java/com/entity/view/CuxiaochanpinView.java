package com.entity.view;

import com.entity.CuxiaochanpinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 促销产品
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-02-21 09:43:45
 */
@TableName("cuxiaochanpin")
public class CuxiaochanpinView  extends CuxiaochanpinEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CuxiaochanpinView(){
	}
 
 	public CuxiaochanpinView(CuxiaochanpinEntity cuxiaochanpinEntity){
 	try {
			BeanUtils.copyProperties(this, cuxiaochanpinEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
