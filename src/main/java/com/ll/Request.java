package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private final String actionCode;
    private final Map<String, String> params =  new HashMap<>();
    public Request(String command) {
        String[] commandList = command.split("\\?", 2);//수정?id=2&title=제목1&content=가나다
        actionCode = commandList[0];
        if(commandList.length == 1) return;
        String[] paramList = commandList[1].split("&"); //id=2 & title=제목1 & content=가나다
        for(String paramsRow :  paramList) {
            String[] paramStr = paramsRow.split("=",2);
            String key = paramStr[0];
            String value = paramStr[1];
            params.put(key, value);
        }
    }
    public String getActionCode() {
        return actionCode;
    }
    public String getParam(String key) {
        return params.get(key);
    }

}
