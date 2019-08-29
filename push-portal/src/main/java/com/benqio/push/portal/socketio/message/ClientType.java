package com.benqio.push.portal.socketio.message;

import java.util.Arrays;
import java.util.List;

public interface ClientType {

    public static final String WEB_CLIENT = "web";
    public static final String ANNOUNCEMENT_CLIENT = "announcement";
    public static final String MAIN_CONTROL_CLIENT = "mainControl";
    public static final String MEETING_CONTROL_CLIENT = "meetingControl";
    public static final String MEETING_PLAY_CLIENT = "meetingPlay";
    public static final String PUSHER_CLIENT = "pusher";
    public static final List<String> TYPES = Arrays.asList(MAIN_CONTROL_CLIENT,MEETING_CONTROL_CLIENT,MEETING_PLAY_CLIENT);
}
