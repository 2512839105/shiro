package com.sdzy.mall.sale.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.SessionUtil;
import com.sdzy.mall.sale.mapper.MallSalePayOrderDAO;
import com.sdzy.mall.sale.model.MallSalePayOrder;
import com.sdzy.mall.sale.service.MallSalePayOrderService;
import com.sdzy.mall.util.BaseUtil;

@Service
public class MallSalePayOrderServiceImpl implements MallSalePayOrderService {
    @Resource
    private MallSalePayOrderDAO salePayOrderDAO;

    private static final Logger logger = LoggerFactory.getLogger(MallSalePayOrderServiceImpl.class);

    @Override
    public MallSalePayOrder insert(MallSalePayOrder model) {
        salePayOrderDAO.insert(model); 
		 return model;
    }

    @Override
    public MallSalePayOrder findById(String modelId) {
        return salePayOrderDAO.findById(modelId);
    }

    @Override
    public List<MallSalePayOrder> listByPage(Map<String, Object> paramMap) {
        return salePayOrderDAO.listByPage(paramMap);
    }

    @Override
    public DataGrid listByPage(QueryParams queryParams) {
       /* Map<String, Object> pageMap = BaseUtil.getPageMap(queryParams, SessionUtil.getLocalUser(), true);
        List list = salePayOrderDAO.listByPage(pageMap);
        PageInfo pageInfo = new PageInfo(list);
        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }

    @Override
    public Integer deleteById(String modelId) {
        return salePayOrderDAO.deleteById(modelId);
    }

    @Override
    public Integer deleteByParam(Map<String, Object> paramMap) {
        return salePayOrderDAO.deleteByParam(paramMap);
    }

    @Override
    public Integer updateById(Map<String, Object> paramMap) {
        return salePayOrderDAO.updateById(paramMap);
    }

    @Override
    public Integer updateByParam(Map<String, Object> paramMap) {
        return salePayOrderDAO.updateByParam(paramMap);
    }
}