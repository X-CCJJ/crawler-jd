package com.jd.service.impl;

import com.jd.dao.ItemDao;
import com.jd.pojo.Item;
import com.jd.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;

    @Override
    @Transactional
    public void save(Item item) {
        this.itemDao.save(item);
    }

    @Override
    public List<Item> findAll(Item item) {
        // 声明查询条件
        Example<Item> example = Example.of(item);
        // 根据查询条件进行查询数据
        List<Item> list = this.itemDao.findAll(example);
        return list;
    }
}
