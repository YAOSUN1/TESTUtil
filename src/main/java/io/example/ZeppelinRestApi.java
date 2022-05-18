package io.example;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class ZeppelinRestApi {
    public static String sendPost(String urlParam,String headerValue) throws HttpException, IOException {
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建post请求方法实例对象
        PostMethod postMethod = new PostMethod(urlParam);
        // 设置post请求超时时间
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        postMethod.addRequestHeader("Content-Type", headerValue);
        postMethod.setRequestBody("userName=admin&password=kjjr3306SXZQ");
        httpClient.executeMethod(postMethod);

        String result = postMethod.getResponseBodyAsString();
        postMethod.releaseConnection();
        return result;
    }
    public static String sendGet(String urlParam,String headerValue) throws HttpException, IOException {
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        // 创建GET请求方法实例对象
        GetMethod getMethod = new GetMethod(urlParam);
        // 设置post请求超时时间
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        getMethod.addRequestHeader("Content-Type", headerValue);
        getMethod.addRequestHeader("Cookie","JSESSIONID=c060aa73-9130-44cd-b09a-00a34ce305b5");
        httpClient.executeMethod(getMethod);

        String result = getMethod.getResponseBodyAsString();
        getMethod.releaseConnection();
        return result;
    }
    public static void main(String[] args) throws HttpException, IOException {
        String url1 ="http://pharos.sxzqkjjr.com:10080/zeppelin/api/version";
        String url2 ="http://pharos.sxzqkjjr.com:10080/zeppelin/api/login";
        String url3 ="http://pharos.sxzqkjjr.com:10080/zeppelin/api/interpreter/setting";
        //System.out.println(sendGet(url1));
        //System.out.println(sendPost(url2,"application/x-www-form-urlencoded"));
        System.out.println(sendGet(url3,"application/json"));
    }
}

