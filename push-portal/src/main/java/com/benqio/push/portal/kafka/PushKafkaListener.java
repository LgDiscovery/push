package com.benqio.push.portal.kafka;

import com.alibaba.fastjson.JSONObject;
import com.benqio.push.common.vo.datahandler.MessageRecord;
import com.benqio.push.portal.service.WorkBenchService;
import com.benqio.push.portal.service.impl.WorkBenchServiceImpl;
import com.benqio.push.portal.socket.SocketManage;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangguang
 */
@Slf4j
@Component
public class PushKafkaListener {

    @KafkaListener(topics = "messageState")
    public void listenMessage(ConsumerRecord<?, ?> record) {
        MessageRecord messageRecord = JSONObject.parseObject(record.value().toString(), MessageRecord.class);
        log.debug("=================VSOM监听currentState信息" + messageRecord.toString() + "==================");
    }

}
