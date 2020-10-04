package com.kgc.service;

import com.kgc.pojo.Goods;

import java.util.List;

/**
 * @author shkstart
 */
public interface IndexService {
    List<Goods> xiacha(Integer qu);
    Goods toupd(Long id);
    int upd(Goods goods,Long id);
}
