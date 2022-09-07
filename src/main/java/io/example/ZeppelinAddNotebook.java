package io.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class ZeppelinAddNotebook {
    private static String jSessionId = null;
    public HttpClient getHttpClient(){
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        return httpClient;
    }
    public PostMethod sendPost(String urlParam) throws HttpException, IOException {
        // 创建post请求方法实例对象
        PostMethod postMethod = new PostMethod(urlParam);
        // 设置post请求超时时间
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        return postMethod;
    }
    public GetMethod sendGet(String urlParam) throws HttpException, IOException {
        // 创建GET请求方法实例对象
        GetMethod getMethod = new GetMethod(urlParam);
        // 设置post请求超时时间
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        //getMethod.addRequestHeader("Cookie","JSESSIONID=c060aa73-9130-44cd-b09a-00a34ce305b5");
        //getMethod.addRequestHeader("Cookie","JSESSIONID=2defde1c-9542-4651-9d4d-2248228d3245");
        return getMethod;
    }
    public PutMethod sendPut(String urlParam) throws HttpException, IOException {
        // 创建GET请求方法实例对象
        PutMethod getMethod = new PutMethod(urlParam);
        // 设置post请求超时时间
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        //getMethod.addRequestHeader("Cookie","JSESSIONID=c060aa73-9130-44cd-b09a-00a34ce305b5");
        //getMethod.addRequestHeader("Cookie","JSESSIONID=2defde1c-9542-4651-9d4d-2248228d3245");
        return getMethod;
    }
    public String getZeppelinVersion(ZeppelinAddNotebook zeppelinRestApi, HttpClient httpClient) throws IOException {
        GetMethod getMethod = zeppelinRestApi.sendGet("http://pharos.sxzqkjjr.com:10080/zeppelin/api/version");
        getMethod.addRequestHeader("Content-Type", "application/json");
        httpClient.executeMethod(getMethod);
        String result = getMethod.getResponseBodyAsString();
        getMethod.releaseConnection();
        return result;
    }
    public String loginZeppelin(ZeppelinAddNotebook zeppelinRestApi, HttpClient httpClient) throws IOException{
        PostMethod postMethod = zeppelinRestApi.sendPost("http://pharos.sxzqkjjr.com:10080/zeppelin/api/login");
        postMethod.addRequestHeader("Content-Type","application/x-www-form-urlencoded");
        postMethod.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        postMethod.setRequestBody("userName=admin&password=kjjr3306SXZQ");
        httpClient.executeMethod(postMethod);
        Cookie[] cookies = httpClient.getState().getCookies();
        String result = postMethod.getResponseBodyAsString();
        for(Cookie cookie:cookies){
            jSessionId = cookie.toString();

        }
        postMethod.releaseConnection();
        return result;
    }
    public String getAllInterpreterSettings(ZeppelinAddNotebook zeppelinRestApi, HttpClient httpClient) throws IOException{
        GetMethod getMethod2 = zeppelinRestApi.sendGet("http://pharos.sxzqkjjr.com:10080/zeppelin/api/interpreter/setting");
        getMethod2.addRequestHeader("Content-Type", "application/json");
        getMethod2.addRequestHeader("Cookie",jSessionId);
        httpClient.executeMethod(getMethod2);
        String result = getMethod2.getResponseBodyAsString();
        getMethod2.releaseConnection();
        return result;
    }
    public String getInterpreterSetting(ZeppelinAddNotebook zeppelinRestApi, HttpClient httpClient, String interpreterID) throws IOException{
        GetMethod getMethod2 = zeppelinRestApi.sendGet("http://pharos.sxzqkjjr.com:10080/zeppelin/api/interpreter/setting/"+interpreterID);
        getMethod2.addRequestHeader("Content-Type", "application/json");
        getMethod2.addRequestHeader("Cookie",jSessionId);
        httpClient.executeMethod(getMethod2);
        String result = getMethod2.getResponseBodyAsString();
        getMethod2.releaseConnection();
        return result;
    }
    public String setInterpreterSetting(ZeppelinAddNotebook zeppelinRestApi, HttpClient httpClient, String interpreterID, String json) throws IOException{
        PutMethod putMethod = zeppelinRestApi.sendPut("http://pharos.sxzqkjjr.com:10080/zeppelin/api/interpreter/setting/"+interpreterID);
        putMethod.addRequestHeader("Content-Type", "text/plain");
        putMethod.addRequestHeader("Cookie",jSessionId);
        RequestEntity stringRequestEntity = new StringRequestEntity(json,"application/json","utf-8");
        putMethod.setRequestEntity(stringRequestEntity);
        //getMethod2.addRequestHeader();
        httpClient.executeMethod(putMethod);
        String result = putMethod.getResponseBodyAsString();
        putMethod.releaseConnection();
        //System.out.println(result);
        return result;
    }
    public String getAllNotebooks(ZeppelinAddNotebook zeppelinRestApi, HttpClient httpClient) throws IOException{
        GetMethod getMethod2 = zeppelinRestApi.sendGet("http://pharos.sxzqkjjr.com:10080/zeppelin/api/notebook");
        getMethod2.addRequestHeader("Content-Type", "application/json");
        getMethod2.addRequestHeader("Cookie",jSessionId);
        httpClient.executeMethod(getMethod2);
        String result = getMethod2.getResponseBodyAsString();
        getMethod2.releaseConnection();
        return result;
    }
    public String getNotebookInfo(ZeppelinAddNotebook zeppelinRestApi, HttpClient httpClient, String noteId) throws IOException{
        GetMethod getMethod2 = zeppelinRestApi.sendGet("http://pharos.sxzqkjjr.com:10080/zeppelin/api/notebook/"+noteId);
        getMethod2.addRequestHeader("Content-Type", "application/json");
        getMethod2.addRequestHeader("Cookie",jSessionId);
        httpClient.executeMethod(getMethod2);
        String result = getMethod2.getResponseBodyAsString();
        getMethod2.releaseConnection();
        return result;
    }
    public String createNotebook(ZeppelinAddNotebook zeppelinRestApi, HttpClient httpClient, String createNote) throws IOException{
        PostMethod postMethod2 = zeppelinRestApi.sendPost("http://pharos.sxzqkjjr.com:10080/zeppelin/api/notebook");
        postMethod2.addRequestHeader("Content-Type", "application/json");
        postMethod2.addRequestHeader("Cookie",jSessionId);
        RequestEntity stringRequestEntity = new StringRequestEntity(createNote,"application/json","utf-8");
        postMethod2.setRequestEntity(stringRequestEntity);
        httpClient.executeMethod(postMethod2);
        String result = postMethod2.getResponseBodyAsString();
        postMethod2.releaseConnection();
        return result;
    }
    public String createParagraph(ZeppelinAddNotebook zeppelinRestApi,HttpClient httpClient,String noteId,String createNote) throws IOException{
        PostMethod postMethod2 = zeppelinRestApi.sendPost("http://pharos.sxzqkjjr.com:10080/zeppelin/api/notebook/"+noteId+"/paragraph");
        postMethod2.addRequestHeader("Content-Type", "application/json");
        postMethod2.addRequestHeader("Cookie",jSessionId);
        RequestEntity stringRequestEntity = new StringRequestEntity(createNote,"application/json","utf-8");
        postMethod2.setRequestEntity(stringRequestEntity);
        httpClient.executeMethod(postMethod2);
        String result = postMethod2.getResponseBodyAsString();
        postMethod2.releaseConnection();
        return result;
    }
    public String getNotebookPermissions(ZeppelinAddNotebook zeppelinRestApi, HttpClient httpClient, String noteId) throws IOException{
        GetMethod getMethod2 = zeppelinRestApi.sendGet("http://pharos.sxzqkjjr.com:10080/zeppelin/api/notebook/"+noteId+"/permissions");
        getMethod2.addRequestHeader("Content-Type", "application/json");
        getMethod2.addRequestHeader("Cookie",jSessionId);
        httpClient.executeMethod(getMethod2);
        String result = getMethod2.getResponseBodyAsString();
        getMethod2.releaseConnection();
        return result;
    }
    public String setNotebookPermissions(ZeppelinAddNotebook zeppelinRestApi, HttpClient httpClient, String noteId, String json) throws IOException{
        PutMethod putMethod = zeppelinRestApi.sendPut("http://pharos.sxzqkjjr.com:10080/zeppelin/api/notebook/"+noteId+"/permissions");
        putMethod.addRequestHeader("Content-Type", "application/json");
        System.out.println(noteId);
        putMethod.addRequestHeader("Cookie",jSessionId);
        RequestEntity stringRequestEntity = new StringRequestEntity(json,"application/json","utf-8");
        putMethod.setRequestEntity(stringRequestEntity);
        httpClient.executeMethod(putMethod);
        String result = putMethod.getResponseBodyAsString();
        putMethod.releaseConnection();
        return result;
    }
    public static void main(String[] args) throws IOException {
        ZeppelinAddNotebook zeppelinRestApi = new ZeppelinAddNotebook();
        HttpClient httpClient = zeppelinRestApi.getHttpClient();
        zeppelinRestApi.getZeppelinVersion(zeppelinRestApi,httpClient);
        zeppelinRestApi.loginZeppelin(zeppelinRestApi,httpClient);
        List<String> jdbcList = new ArrayList<String>();
        //迅兔
        //jdbcList.add("jdbcSource30");
        //资管投研
        //jdbcList.add("jdbcSource19");jdbcList.add("jdbcSource20");jdbcList.add("jdbcSource50");jdbcList.add("jdbcSource23");jdbcList.add("jdbcSource28");jdbcList.add("jdbcSource9");
        //山证科技
        jdbcList.add("jdbc133");jdbcList.add("jdbcDCAPP");jdbcList.add("jdbcOA");jdbcList.add("jdbcSource1");jdbcList.add("jdbcSource11");jdbcList.add("jdbcSource14");
        jdbcList.add("jdbcSource18");jdbcList.add("jdbcSource19");jdbcList.add("jdbcSource20");jdbcList.add("jdbcSource23");jdbcList.add("jdbcSource236");jdbcList.add("jdbcSource247");
        jdbcList.add("jdbcSource251");jdbcList.add("jdbcSource251new");jdbcList.add("jdbcSource258");jdbcList.add("jdbcSource272");jdbcList.add("jdbcSource28");jdbcList.add("jdbcSource31");
        jdbcList.add("jdbcSource33");jdbcList.add("jdbcSource34");jdbcList.add("jdbcSource5");jdbcList.add("jdbcSource50");jdbcList.add("jdbcSource61");jdbcList.add("jdbcSource64");
        jdbcList.add("jdbcSource70");jdbcList.add("jdbcSource77");jdbcList.add("jdbcSource8");jdbcList.add("jdbcSource80");jdbcList.add("jdbcSource87");jdbcList.add("jdbcSource9");
        jdbcList.add("jdbcSource91");jdbcList.add("jdbcSource92");jdbcList.add("jdbcSource94");jdbcList.add("jdbcSource95");jdbcList.add("jdbcSource99");
        jdbcList.add("jdbcWIKI");jdbcList.add("jdbcsourcce122new");jdbcList.add("jdbcsource167");jdbcList.add("jdbcsource277");
        jdbcList.add("jdbcsource68");jdbcList.add("jdbcsource85");jdbcList.add("jdbcsource88");jdbcList.add("jdbcSource100");jdbcList.add("jdbcSource168");
        //固收
        //jdbcList.add("jdbcSource30");
        List<String> userList = new ArrayList<String>();
        //迅兔
        //userList.add("zhanglifan");userList.add("liuzongchen");userList.add("kanghuayong");userList.add("chenleilei");userList.add("liyingcong");
        //userList.add("xuyongming");userList.add("yuhan");userList.add("luwen");userList.add("zhangjingtian");
        //资管投研
        //userList.add("zhoubo");userList.add("baofei");userList.add("hejie");userList.add("liuziming");userList.add("zhongyanlin");userList.add("tuzhidong");userList.add("chenhao");
        //山证科技
        userList.add("admin");
        userList.add("liyuhan");userList.add("dingyanxia");userList.add("sunyao");userList.add("zhangzhenfan");userList.add("niuhuixia");
        userList.add("liumeifang");userList.add("wushuning");userList.add("hequanquan");userList.add("wangxiaolong");userList.add("xiaoyaowen");
        userList.add("chenghua");userList.add("xinyangyang");userList.add("chenan");userList.add("sunliuyang");userList.add("lizhenglong");userList.add("shixinrui");
        userList.add("wengran");userList.add("tanrui");userList.add("jiansijie");userList.add("wangqiukai");userList.add("heyingying");userList.add("chengleiyu");
        userList.add("wutingting");userList.add("taoxiaoshan");userList.add("wangjiajia");
        userList.add("xuyang");userList.add("chenmeiling");userList.add("chenxiang");userList.add("liangying");
        userList.add("yangwei");userList.add("koudou");userList.add("wutingting");userList.add("wanghengde");userList.add("mengmingfan");
        //固收
        //userList.add("yanlaiqiong");userList.add("guoguangkui");
        for(int j=0;j<userList.size();j++){
            String createNote = "{\"name\":\""+userList.get(j)+"\",\"paragraphs\":[{\"title\":\"jdbcsourcexxx\",\"text\":\"To use data source,add % before the jdbc name,such as %jdbcSource1\n\r"+jdbcList.toString()+"\"}],\"defaultInterpreterGroup\":\"spark\",\"version\":\"0.10.0\",\"config\":{\"isZeppelinNotebookCronEnable\":false},\"info\":{}}";
            System.out.println(createNote);
            String result = zeppelinRestApi.createNotebook(zeppelinRestApi,httpClient,createNote);
            System.out.println(result);
        }

        String result = zeppelinRestApi.getAllNotebooks(zeppelinRestApi,httpClient);
        JSONObject jsonObject = JSON.parseObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("body");
        for(int i=0;i<jsonArray.size();i++){
            JSONObject jsonObject1 = (JSONObject)jsonArray.get(i);
            String path = jsonObject1.get("path").toString();
            String noteId = jsonObject1.get("id").toString();
            String result2 = zeppelinRestApi.getNotebookPermissions(zeppelinRestApi,httpClient,path);
            JSONObject jsonObject2 = JSON.parseObject(result2);
            JSONObject jsonObject3 =jsonObject2.getJSONObject("body");
            jsonObject3.getJSONArray("readers").add(path.replaceAll("/",""));
            jsonObject3.getJSONArray("owners").add("admin");
            jsonObject3.getJSONArray("writers").add(path.replaceAll("/",""));
            jsonObject3.getJSONArray("runners").add(path.replaceAll("/",""));
            System.out.println(jsonObject3);
            String result3 = zeppelinRestApi.setNotebookPermissions(zeppelinRestApi,httpClient,noteId,jsonObject3.toJSONString());
            System.out.println(result3);
            String createParagraph = "{\"title\":\"jdbcsourcexxx\",\"text\":\"To use data source,add % before the jdbc name,such as %jdbcSource1\n\r"+jdbcList.toString()+"\"}";
            System.out.println(createParagraph);
            String result5 = zeppelinRestApi.createParagraph(zeppelinRestApi,httpClient,noteId,createParagraph);
            System.out.println(result5);
        }
        //System.out.println(jsonArray);
    }
}

