package com.example.mybatisplus1.api.dao.mapper;

import com.example.mybatisplus1.api.dao.entity.BrokerMessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author juwencheng
 * @since 2020-03-26
 */
public interface BrokerMessageMapper extends BaseMapper<BrokerMessageEntity> {

    @Select("select * from broker_message")
    List<BrokerMessageEntity> customQueryAllWithAnnotation();

    List<BrokerMessageEntity> customQueryAllWithXml();
}
