package io.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;

public class ZeppelinClearNotebookOutPut {
    public static void main(String[] args) throws Exception {
        ZeppelinAddNotebook zeppelinRestApi = new ZeppelinAddNotebook();
        HttpClient httpClient = zeppelinRestApi.getHttpClient();
        zeppelinRestApi.getZeppelinVersion(zeppelinRestApi,httpClient);
        zeppelinRestApi.loginZeppelin(zeppelinRestApi,httpClient);
        String result = zeppelinRestApi.getAllNotebooks(zeppelinRestApi,httpClient);
        System.out.println(result);

        JSONObject jsonObject = JSON.parseObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("body");
        for(int i=0;i<jsonArray.size();i++) {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
            String noteId = jsonObject1.get("id").toString();
            zeppelinRestApi.clearNotebookOutPut(zeppelinRestApi,httpClient,noteId);
        }
    }
}
