package com.sdzy.xiaomi.report.mapper;

import com.sdzy.xiaomi.report.model.SalePayOrder;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author charlin
 * @since 2018-05-28
 */
public interface SalePayOrderMapper extends BaseMapper<SalePayOrder> {

	int insertSalePayOrder(SalePayOrder salePayOrder);

}
