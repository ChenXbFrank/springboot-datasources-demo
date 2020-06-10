package com.cxb.database.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cxb.database.datasource.DataSourceType;
import com.cxb.database.datasource.MyDataSource;
import com.cxb.database.mapper.TestMapper;
import com.cxb.database.service.TestService;

@Service
public class TestServiceImpl implements TestService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TestMapper testMapper;

    @Override
    @MyDataSource(DataSourceType.Master)
    public Integer queryCountByMester() {
        return testMapper.queryCount();
    }

    @Override
    @MyDataSource(DataSourceType.Slave)
    @Transactional
    public Integer queryCountBySavle(String name) {
        //测试事务
        Integer rows = testMapper.updateBookByName(name);
        if (rows <= 0) {
            logger.info("更新小于1 执行回滚");
            throw new RuntimeException();
        }
        return rows;
    }

}
