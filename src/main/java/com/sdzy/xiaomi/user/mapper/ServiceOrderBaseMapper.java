package com.sdzy.xiaomi.user.mapper;

import com.sdzy.xiaomi.user.model.ServiceOrderBase;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 服务订单主表 Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-07-26
 */
public interface ServiceOrderBaseMapper extends BaseMapper<ServiceOrderBase> {

	void insertOrderBase(@Param("orderBaseId")String orderBaseId,@Param("orderNo")String orderNo,@Param("totalFee") Object totalFee,@Param("payment")Object payment,@Param("buyerId")Object buyerId, @Param("buyerName")Object buyerName, @Param("payType")Object payType,
			@Param("isPayed")Object isPayed, @Param("state")Object state,@Param("createTime")Object createTime);

	void insertOrderDetail(@Param("orderDetailId")String orderDetailId,@Param("companyId")Object companyId,@Param("orderNo")String orderNo,@Param("productName")Object productName,@Param("unit")Object unit,@Param("price")Object price,@Param("buyCount")Object buyCount,
			@Param("totalFee")Object totalFee,@Param("payment")Object payment,@Param("state")Object state,@Param("createTime")Date createTime);

	void updateBase(@Param("orderNo")String orderNo,@Param("payOrderNo")String payOrderNo,@Param("payTime")Date payTime,@Param("modifyTime")Date modifyTime,@Param("state")String state,@Param("isPay")int isPay);

	void updateDetail(@Param("orderNo")String orderNo,@Param("state")String state);

	Map<String, String> selectByOrderNo(String orderNo);

	List<Map<String,String>> selectBaseBybuyerId(String buyerId);
	
	List<Map<String,String>> selectDetail(String orderNo);

	void updateStat(@Param("buyerId")Object buyerId,@Param("count")BigDecimal count);
 
}
