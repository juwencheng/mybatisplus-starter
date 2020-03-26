package com.example.mybatisplus1.api.service.impl;

import com.example.mybatisplus1.api.dao.entity.BrokerMessageEntity;
import com.example.mybatisplus1.api.dao.mapper.BrokerMessageMapper;
import com.example.mybatisplus1.api.service.BrokerMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author juwencheng
 * @since 2020-03-26
 */
@Service
public class BrokerMessageServiceImpl extends ServiceImpl<BrokerMessageMapper, BrokerMessageEntity> implements BrokerMessageService {

    @Override
    public List<BrokerMessageEntity> customQueryAllWithAnnotation() {
        return this.baseMapper.customQueryAllWithAnnotation();
    }

    @Override
    public List<BrokerMessageEntity> customQueryAllWithXml() {
        return this.baseMapper.customQueryAllWithXml();
    }
}
