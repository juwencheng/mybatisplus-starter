package com.example.mybatisplus1.api.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author juwencheng
 * @since 2020-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("broker_message")
public class BrokerMessageEntity implements Serializable {

    private static final long serialVersionUID=1L;

    @TableField("message_id")
    private String messageId;

    @TableField("message")
    private String message;

    @TableField("try_count")
    private Integer tryCount;

    @TableField("status")
    private String status;

    @TableField("next_retry")
    private LocalDateTime nextRetry;

    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


}
