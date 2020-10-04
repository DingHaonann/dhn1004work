package com.kgc.service.impl;

import com.kgc.mapper.GoodsMapper;
import com.kgc.pojo.Goods;
import com.kgc.pojo.GoodsExample;
import com.kgc.service.IndexService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {
    @Resource
    GoodsMapper goodsMapper;

    @Override
    public List<Goods> xiacha(Integer qu) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsdistrictEqualTo(qu);
        return goodsMapper.selectByExample(example);
    }

    @Override
    public Goods toupd(Long id) {
        return goodsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int upd(Goods goods, Long id) {
        GoodsExample example = new GoodsExample();
        GoodsExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return goodsMapper.updateByExampleSelective(goods, example);
    }
}
