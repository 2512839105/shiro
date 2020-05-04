package com.sdzy.mall.sale.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asdzy.common.exception.CustomerException;
import com.asdzy.common.page.DataGrid;
import com.asdzy.common.query.Condition;
import com.asdzy.common.query.QueryParams;
import com.asdzy.common.session.LocalUser;
import com.asdzy.common.session.SessionUtil;
import com.asdzy.common.utils.StringUtil;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.sdzy.mall.base.mapper.MallBaseProductMapper;
import com.sdzy.mall.base.model.MallBaseProduct;
import com.sdzy.mall.sale.mapper.MallSaleOrderDetailDAO;
import com.sdzy.mall.sale.model.MallSaleOrderDetail;
import com.sdzy.mall.sale.service.MallSaleOrderDetailService;
import com.sdzy.mall.stock.constant.StockConstant;
import com.sdzy.mall.stock.mapper.MallStockBatchInventoryDAO;
import com.sdzy.mall.stock.model.MallStockBatchInventory;
import com.sdzy.mall.util.BaseUtil;


@Service
public class MallSaleOrderDetailServiceImpl implements MallSaleOrderDetailService {

    @Resource
    private MallSaleOrderDetailDAO saleOrderDetailDAO;
    @Resource
    private MallBaseProductMapper baseProductDAO;
    @Resource
    private MallStockBatchInventoryDAO stockBatchInventoryDAO;

    private static final Logger logger = LoggerFactory.getLogger(MallSaleOrderDetailServiceImpl.class);

    @Override
    public MallSaleOrderDetail insert(MallSaleOrderDetail model) {
         saleOrderDetailDAO.insert(model);
		 return model;
    }

    @Override
    public MallSaleOrderDetail findById(String modelId) {
        return saleOrderDetailDAO.findById(modelId);
    }

    @Override
    public List<MallSaleOrderDetail> listByPage(Map<String, Object> paramMap) {
        return saleOrderDetailDAO.listByPage(paramMap);
    }

    @Override
   @Transactional
    public Integer deleteById(String modelId) {
        return saleOrderDetailDAO.deleteById(modelId);
    }

    @Override
    public Integer deleteByParam(Map<String, Object> paramMap) {
        return saleOrderDetailDAO.deleteByParam(paramMap);
    }

    @Override
    public Integer updateById(Map<String, Object> paramMap) {
        return saleOrderDetailDAO.updateById(paramMap);
    }

    @Override
    public Integer updateByParam(Map<String, Object> paramMap) {
        return saleOrderDetailDAO.updateByParam(paramMap);
    }

    @Override
    public List listByParam(Map<String, Object> map) {
        return saleOrderDetailDAO.listByParam(map);
    }

    @Override
    public DataGrid listReportListByPage(QueryParams queryParams, LocalUser currentUser, String... params) {
    	/*List<Condition> whereList = queryParams.filtersToDBConditionals();
        whereList.add(Condition.createEq("storeId",currentUser.getStoreId()));
    	PageHelper.offsetPage(queryParams.getOffset(), queryParams.getLimit());
        if(StringUtil.isNotEmpty(queryParams.getSort()) && StringUtil.isNotEmpty(queryParams.getOrder())){
            PageHelper.orderBy(queryParams.getSort() + " " + queryParams.getOrder());
        }
        //入库单类别
        whereList.add(Condition.create("IFNULL(deleteFlag,'')", -1 , Condition.OpType.NE));
        Map<String, Object> map = new HashMap<String, Object>();
        String typeFlag = params[0];
        List<SaleOrderDetail> list = null;
        if("1".equals(typeFlag)){//处方
            whereList.add(Condition.createEq("isRxDrug",1));
            map.put("whereList", whereList);
            list = saleOrderDetailDAO.listIsRxDrugReportListByPage(map);
        }
        else if("2".equals(typeFlag)){//拆零
            map.put("whereList", whereList);
            list = saleOrderDetailDAO.listSplitReportListByPage(map);
        }else {
            map.put("whereList", whereList);
            list = saleOrderDetailDAO.listReportListByPage(map);
        }
        PageInfo pageInfo = new PageInfo(list);
        return new DataGrid(pageInfo.getTotal(), pageInfo.getList());*/
        return new DataGrid();
    }

    @Override
    public List listReportListByPage(Map<String, Object> map) {
        return saleOrderDetailDAO.listReportListByPage(map);
    }

	@Override
	public List<MallSaleOrderDetail> listByLastestDate(Map<String, Object> map) {
		return saleOrderDetailDAO.listInterfaceData(map);
	}

	@Override
	public Date getMaxDate(String storeId) {
		return saleOrderDetailDAO.getMaxDate(storeId);
	}

    @Override
    public DataGrid findSaleDetaisByBarCode(QueryParams queryParams, String keyword, LocalUser currentUser) {
       /* //匹配条码
        if(BaseUtil.isBarCode(keyword)) {
            PageHelper.offsetPage(queryParams.getOffset(), queryParams.getLimit());
            if(StringUtil.isNotEmpty(queryParams.getSort()) && StringUtil.isNotEmpty(queryParams.getOrder())){
                PageHelper.orderBy(queryParams.getSort() + " " + queryParams.getOrder());
            }
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("storeId", currentUser.getStoreId());
            paramMap.put("keyword", keyword);
            List<SaleOrderDetail> list = saleOrderDetailDAO.findSaleDetaisByBarCode(paramMap);
            if(list.size()==0) throw new CustomerException("无此销售订单:"+keyword);
            PageInfo pageInfo = new PageInfo(list);
            return new DataGrid(pageInfo.getTotal(), pageInfo.getList());
        }else {
            throw new CustomerException("条码有误:"+keyword);
        }*/
        return new DataGrid();

    }

    /**
     *  收银页面查询  按照条码、编号、助记码、商品名查询批次库存表
     *  1、根据条形码查询，查询不分页
     *  2、根据其它属性查询，分页
     * @param keyword
     * @return
     */
    @Override
    public DataGrid findStockByKeyword(QueryParams queryParams , String keyword) {
        //匹配条码
        String barCodepattern = "^[0-9]{13}$";
        if (Pattern.matches(barCodepattern, keyword)) {
            return this.findStockByBarCode(keyword);
        } else {
            DataGrid dataGrid = this.findStockByProperties(keyword, queryParams);
            if(dataGrid.getRows().size()==0){
                throw new CustomerException("无此药品或本药品已无库存或者原价为零:"+keyword);
            }
            return dataGrid;
        }
    }

    /**
     * 查询所有的销售订单
     * @return
     */
    public DataGrid listAllStock(QueryParams queryParams) {
        /*Map<String, Object> paramMap = new HashMap<>();

        LocalUser localUser = SessionUtil.getLocalUser();
        paramMap.put("storeId", localUser.getStoreId());

        if(StringUtil.isNotEmpty(queryParams.getLimit()) && StringUtil.isNotEmpty(queryParams.getOffset())) {
            PageHelper.offsetPage(queryParams.getOffset(), queryParams.getLimit());
        }else {
            PageHelper.offsetPage(0, 10);
        }
        if(StringUtil.isNotEmpty(queryParams.getSort()) && StringUtil.isNotEmpty(queryParams.getOrder())){
            PageHelper.orderBy(queryParams.getSort() + " " + queryParams.getOrder());
        }else {
            PageHelper.orderBy("productCode asc");
        }
        paramMap.put("sort", "productCode");
        paramMap.put("order", "asc");

        List<BaseProduct> list = baseProductDAO.listAllStock(paramMap);
        if(list == null || list.size() == 0) throw new CustomerException("此产品无库存");

        PageInfo<BaseProduct> pageInfo = new PageInfo<>(list);

        List<Map<String, Object>> dataList = new ArrayList<>();

        Map<String, BigDecimal> stocksMap = new LinkedHashMap<>();
        for(MallBaseProduct product : list) {
            List<StockBatchInventory> stockBatchInventories = product.getStockBatchInventories();
            if(stockBatchInventories==null) continue;
            for(StockBatchInventory stockBatchInventory : stockBatchInventories) {
//                查询已过滤
                Map<String, Object> dataMap = BaseUtil.setDatas(stockBatchInventory, product);
                dataList.add(dataMap);
            }
        }

        return new DataGrid(pageInfo.getTotal(), dataList);*/
        return new DataGrid();
    }

    /**
     * 根据条形码查询库存并合并
     * 1、先找到产品,如果没有产品code的不显示
     * 2、根据产品id, code找到对应的库存
     * 3、以产品号与批号做为唯一码
     * 4、如果没有库存的不显示
     * 5、依据唯一码，遍历所有库存，相同的进行库存合并
     * @param barCode
     * @return
     */
    @Override
    public DataGrid findStockByBarCode(String barCode) {
       /* LocalUser localUser = SessionUtil.getLocalUser();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("storeId", localUser.getStoreId());
        //查询中药信息
        if(StringUtils.isNotEmpty(barCode) && barCode.startsWith("0")){
            map.put("unit", StockConstant.SPLIT_UNIT_KG);
        }else {
            map.put("keyword", barCode);
        }
        List<MallBaseProduct> list = baseProductDAO.findByBarCode(map);
        //数据集
        List<Map<String, Object>> dataList = new ArrayList<>();
        //库存map
        Map<String, BigDecimal> stocksMap = new LinkedHashMap<>();
        for(MallBaseProduct product : list) {
            if(StringUtil.isEmpty(product.getProductCode()) ||  product.getRetailPrice() == null || product.getTotalStorage()== null || product.getTotalStorage().doubleValue()<=0) continue;
            Map<String, Object> paramMap = new HashMap<>();
            List<Condition> whereList = new ArrayList<>();
            whereList.add(Condition.create("productId", product.getProductId(), Condition.OpType.EQ));
            whereList.add(Condition.create("productCode", product.getProductCode(), Condition.OpType.EQ));
            whereList.add(Condition.create("IFNULL(stockCount,'')", 0, Condition.OpType.NE));
            whereList.add(Condition.createEq("storeId", localUser.getStoreId()));
            paramMap.put("whereList", whereList);
            //查询出此产品所有不为空的批次
            List<StockBatchInventory> stockBatchInventories = stockBatchInventoryDAO.listByParam(paramMap);
            if(stockBatchInventories==null) continue;
            for(StockBatchInventory stockBatchInventory : stockBatchInventories) {
                String onlyCode = stockBatchInventory.getProductCode() + "," + stockBatchInventory.getBatchNo();
                if(stocksMap.get(onlyCode)==null) {

                    //小于或等于0不能销售
                    if(product.getRetailPrice().doubleValue()<=0) continue;
                    //设值到map
                    Map<String, Object> dataMap = BaseUtil.setDatas(stockBatchInventory, product);
                    dataList.add(dataMap);
                    //stocksMap.put(onlyCode, stockBatchInventory.getPurchaseCount());
                    stocksMap.put(onlyCode, stockBatchInventory.getStockCount());
                }else {
                    //stocksMap.put(onlyCode, stocksMap.get(onlyCode).add(stockBatchInventory.getPurchaseCount()));
                    stocksMap.put(onlyCode, stocksMap.get(onlyCode).add(stockBatchInventory.getStockCount()));
                }
            }
        }
        if(stocksMap.size()==0){
            throw new CustomerException("本药品已无库存:" + barCode);
        }

        if(dataList.size()==0){
            throw new CustomerException("无此药品或条码错误:"+ barCode);
        }

        return new DataGrid(dataList.size(), dataList);*/
        return new DataGrid();
    }

    @Override
    public DataGrid findStockByProperties(String keyword, QueryParams queryParams) {

       /* Map<String, Object> paramMap = new HashMap<>();

        LocalUser localUser = SessionUtil.getLocalUser();
        paramMap.put("storeId", localUser.getStoreId());

        if(StringUtil.isNotEmpty(queryParams.getLimit()) && StringUtil.isNotEmpty(queryParams.getOffset())) {
            PageHelper.offsetPage(queryParams.getOffset(), queryParams.getLimit());
        }else {
            PageHelper.offsetPage(0, 10);
        }
        if(StringUtil.isNotEmpty(queryParams.getSort()) && StringUtil.isNotEmpty(queryParams.getOrder())){
            PageHelper.orderBy(queryParams.getSort() + " " + queryParams.getOrder());
        }else {
            PageHelper.orderBy("productCode asc");
        }

        String keyName = null;
        //匹配货号
        Boolean productCodeMatch = Pattern.matches("^(?!([a-zA-Z]+|\\d+)$)[a-zA-Z\\d]{2,}$", keyword) || Pattern.matches("^[0-9]{5,}$", keyword);
        //匹配助记名
        Boolean mnemonicNameMatch = Pattern.matches("^[a-zA-Z]{3,}$", keyword);


        if(productCodeMatch) {
            keyName = "productCode";
        }else if(mnemonicNameMatch) {
            keyName = "mnemonicName";
        }else {
            keyName = "productName";
        }
        if(StringUtils.isNotEmpty(keyword)){
            if(keyword.startsWith(StockConstant.ZERO)){
                keyword = keyword.substring(1, keyword.length());
                Boolean chineseMathc = Pattern.matches("^[\\u4e00-\\u9fa5]*$", keyword);
                mnemonicNameMatch = Pattern.matches("^[a-zA-Z]{3,}$", keyword);
                productCodeMatch = Pattern.matches("^(?!([a-zA-Z]+|\\d+)$)[a-zA-Z\\d]{2,}$", keyword) || Pattern.matches("^[0-9]{5,}$", keyword);
                if(chineseMathc){ //中文查询中药
                    paramMap.put("chineseDrug", keyword);
                }else if(mnemonicNameMatch){ //助记码或条码查询中药
                    paramMap.put("chinaMnemonicDrug", keyword);
                }else if(productCodeMatch){ //助记码或条码查询中药
                    paramMap.put("chinaCodeDrug", keyword);
                }else {
                    paramMap.put("chinaAllDrug", keyword);
                }
            }else {
                paramMap.put(keyName, keyword);
            }
        }
        paramMap.put("sort", "productCode");
        paramMap.put("order", "asc");

        List<MallBaseProduct> list = baseProductDAO.listProductsAndStocks(paramMap);
        if(list == null || list.size() == 0) throw new CustomerException("此产品无库存");

        PageInfo<BaseProduct> pageInfo = new PageInfo<>(list);

        List<Map<String, Object>> dataList = new ArrayList<>();

        for(MallBaseProduct product : list) {
            List<StockBatchInventory> stockBatchInventories = product.getStockBatchInventories();
            if(stockBatchInventories==null)
                continue;
            for(StockBatchInventory stockBatchInventory : stockBatchInventories) {
                Map<String, Object> dataMap = BaseUtil.setDatas(stockBatchInventory, product);
                dataList.add(dataMap);
            }
        }
        return new DataGrid(pageInfo.getTotal(), dataList);*/
        return new DataGrid();
    }

	@Override
	public String  selectCount(String productCode, Date first, Date finall) {
		return saleOrderDetailDAO.selectCount(productCode, first, finall);
	}

	@Override
	public BigDecimal selectFeeCount(String productCode, Date first, Date finall) {
		return saleOrderDetailDAO.selectFeeCount(productCode, first, finall);
	}

	@Override
	public BigDecimal selectMember(String productCode, Date first, Date finall) {
		return saleOrderDetailDAO.selectMember(productCode, first, finall);
	}

}