package com.benqio.push.common.vo.datahandler;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 状态消息 原始消息
 *
 * @author YangGuang
 * @version v1.0.0
 * @since 2018-10-9 17:24:55
 */
@Setter
@Getter
@ToString
public class MessageRecord {

    /**
     * 设备ID
     */
    private Integer deviceId;

    /**
     * 通道号
     */
    private Integer channel;

    /**
     * 状态：1:在线0:离线
     */
    private Byte state;

    /**
     * 离线原因码
     */
    private String offlineCause;

    /**
     * 创建时间
     */
    private Integer createTime;

}
