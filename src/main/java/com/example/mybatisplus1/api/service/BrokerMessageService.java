package com.example.mybatisplus1.api.service;

import com.example.mybatisplus1.api.dao.entity.BrokerMessageEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author juwencheng
 * @since 2020-03-26
 */
public interface BrokerMessageService extends IService<BrokerMessageEntity> {
    List<BrokerMessageEntity> customQueryAllWithAnnotation();
}
