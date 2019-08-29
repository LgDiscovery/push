package com.benqio.push.portal.socketio.message;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

@Data
public class SocketMessage {
    private String type;
    @NotEmpty
    private List<String> targetClientIds;
    private JSONObject data;
}
