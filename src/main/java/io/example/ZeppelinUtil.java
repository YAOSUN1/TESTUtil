package io.example;


import org.apache.zeppelin.client.ClientConfig;
import org.apache.zeppelin.client.ZeppelinClient;

public class ZeppelinUtil {

    public static void main(String[] args) throws Exception{
        ClientConfig clientConfig = new ClientConfig("http://pharos.sxzqkjjr.com:10080/zeppelin/");
        ZeppelinClient zClient = new ZeppelinClient(clientConfig);

        String zeppelinVersion = zClient.getVersion();
        System.out.println("Zeppelin version: " + zeppelinVersion);

    }
}
