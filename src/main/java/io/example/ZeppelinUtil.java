package io.example;


import org.apache.zeppelin.client.ClientConfig;
import org.apache.zeppelin.client.ZeppelinClient;
import org.apache.zeppelin.interpreter.Interpreter;
import org.apache.zeppelin.interpreter.InterpreterContext;
import org.apache.zeppelin.interpreter.InterpreterGroup;

public class ZeppelinUtil {

    public static void main(String[] args) throws Exception{
        ClientConfig clientConfig = new ClientConfig("http://pharos.sxzqkjjr.com:10080/zeppelin/");
        ZeppelinClient zClient = new ZeppelinClient(clientConfig);

        String zeppelinVersion = zClient.getVersion();
        System.out.println("Zeppelin version: " + zeppelinVersion);
        System.out.println("clientConfig.getKnoxSSOUrl()"+clientConfig.getKnoxSSOUrl());
        System.out.println("clientConfig.getKnoxSSOUrl()"+clientConfig.getZeppelinRestUrl());
        //zClient.createNote();
        zClient.login("admin","kjjr3306SXZQ");

        //zClient.createNote("new","jdbcSource1");
        //zClient.stopInterpreter();

    }
}
