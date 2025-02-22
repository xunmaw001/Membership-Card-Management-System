package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.GoodsOrderListDao;
import com.entity.GoodsOrderListEntity;
import com.service.GoodsOrderListService;
import com.entity.view.GoodsOrderListView;

/**
 * 购买订单详情 服务实现类
 * @author 
 * @since 2021-04-21
 */
@Service("goodsOrderListService")
@Transactional
public class GoodsOrderListServiceImpl extends ServiceImpl<GoodsOrderListDao, GoodsOrderListEntity> implements GoodsOrderListService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<GoodsOrderListView> page =new Query<GoodsOrderListView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
