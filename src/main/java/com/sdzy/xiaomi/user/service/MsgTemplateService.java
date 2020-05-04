package com.sdzy.xiaomi.user.service;

 
import com.baomidou.mybatisplus.service.IService;
import com.sdzy.xiaomi.user.model.MsgTemplate;
import com.asdzy.common.query.QueryParams;
import java.io.Serializable;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * <p>
 * 短信模板 服务类
 * </p>
 *
 * @author charlin
 * @since 2018-07-09
 */
public interface MsgTemplateService extends IService<MsgTemplate> {

    /**
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	boolean deleteModelById(Serializable id);


	/**
	 * 新增或者更新实体，存在主键为更新，反正新增
	 * @param api
	 * @return
	 */
	MsgTemplate insertOrUpdateModel(MsgTemplate msgTemplate);

	
	/**
	 * 分页查询
	 * @param queryParams
	 * @return
	 */
	Page<MsgTemplate> selectModelsByPage(QueryParams queryParams);
}
