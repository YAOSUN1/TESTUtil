package io.example;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ZeppelinSetInterpreterPermission {
    public static void main(String[] args) throws IOException {
        ZeppelinAddNotebook zeppelinRestApi = new ZeppelinAddNotebook();
        HttpClient httpClient = zeppelinRestApi.getHttpClient();
        zeppelinRestApi.getZeppelinVersion(zeppelinRestApi,httpClient);
        zeppelinRestApi.loginZeppelin(zeppelinRestApi,httpClient);
        String result = zeppelinRestApi.getAllInterpreterSettings(zeppelinRestApi,httpClient);
        JSONObject jsonObject = JSON.parseObject(result);
        JSONArray jsonArray = jsonObject.getJSONArray("body");
        List<String> jdbcList = new ArrayList<String>();
        //迅兔
        //jdbcList.add("jdbcSource30");
        //资管投研
        //jdbcList.add("jdbcSource19");jdbcList.add("jdbcSource20");jdbcList.add("jdbcSource50");jdbcList.add("jdbcSource23");jdbcList.add("jdbcSource28")
        //;jdbcList.add("jdbcSource31");jdbcList.add("jdbcSource30");jdbcList.add("jdbcSource94");jdbcList.add("jdbcSource33");jdbcList.add("jdbcSource293");jdbcList.add("jdbcSource236");
        //山证科技
        jdbcList.add("jdbcSource313");
        jdbcList.add("jdbc133");jdbcList.add("jdbcDCAPP");jdbcList.add("jdbcOA");jdbcList.add("jdbcSource1");jdbcList.add("jdbcSource11");jdbcList.add("jdbcSource14");
        jdbcList.add("jdbcSource18");jdbcList.add("jdbcSource19");jdbcList.add("jdbcSource20");jdbcList.add("jdbcSource23");jdbcList.add("jdbcSource236");jdbcList.add("jdbcSource247");
        jdbcList.add("jdbcSource251");jdbcList.add("jdbcSource251new");jdbcList.add("jdbcSource258");jdbcList.add("jdbcSource272");jdbcList.add("jdbcSource28");jdbcList.add("jdbcSource30");jdbcList.add("jdbcSource31");
        jdbcList.add("jdbcSource33");jdbcList.add("jdbcSource34");jdbcList.add("jdbcSource5");jdbcList.add("jdbcSource50");jdbcList.add("jdbcSource61");jdbcList.add("jdbcSource64");
        jdbcList.add("jdbcSource70");jdbcList.add("jdbcSource77");jdbcList.add("jdbcSource8");jdbcList.add("jdbcSource80");jdbcList.add("jdbcSource87");jdbcList.add("jdbcSource9");
        jdbcList.add("jdbcSource91");jdbcList.add("jdbcSource92");jdbcList.add("jdbcSource94");jdbcList.add("jdbcSource95");jdbcList.add("jdbcSource99");
        jdbcList.add("jdbcWIKI");jdbcList.add("jdbcsourcce122new");jdbcList.add("jdbcsource167");jdbcList.add("jdbcsource277");
        jdbcList.add("jdbcsource68");jdbcList.add("jdbcsource85");jdbcList.add("jdbcsource88");jdbcList.add("jdbcSource100");jdbcList.add("sh");
        jdbcList.add("jdbcSource293");jdbcList.add("jdbcSource168");jdbcList.add("jdbcSource302");jdbcList.add("jdbcSource135");jdbcList.add("jdbcSource321");jdbcList.add("jdbcSource312");
        jdbcList.add("jdbcSource162");jdbcList.add("jdbcSource22");jdbcList.add("jdbcSource246");jdbcList.add("jdbcSource261");
        jdbcList.add("jdbcSource329");
        //固收
        //jdbcList.add("jdbcSource30");jdbcList.add("jdbcSource33");jdbcList.add("jdbcSource9");jdbcList.add("jdbcSource9");jdbcList.add("jdbcsource85");jdbcList.add("jdbcSource94");
        //jdbcList.add("jdbcSource313");
        List<String> userList = new ArrayList<String>();
        //资管投研
        //userList.add("zhoubo");userList.add("baofei");userList.add("hejie");userList.add("liuziming");userList.add("zhongyanlin");userList.add("tuzhidong");userList.add("chenhao");
        //userList.add("zengxiaozhen");userList.add("chenruiquan");
        //山证科技
        //userList.add("admin");userList.add("liyuhan");userList.add("dingyanxia");userList.add("sunyao");userList.add("zhangzhenfan");userList.add("niuhuixia");
        //userList.add("liumeifang");userList.add("wushuning");userList.add("hequanquan");userList.add("wangxiaolong");userList.add("xiaoyaowen");
        //userList.add("chenghua");userList.add("xinyangyang");userList.add("chenan");userList.add("sunliuyang");userList.add("lizhenglong");userList.add("shixinrui");
        //userList.add("wengran");userList.add("tanrui");userList.add("jiansijie");userList.add("wangqiukai");userList.add("heyingying");userList.add("chengleiyu");
        //userList.add("wutingting");userList.add("taoxiaoshan");userList.add("wangjiajia");
        //userList.add("xuyang");userList.add("chenmeiling");userList.add("chenxiang");
        //userList.add("liulu");userList.add("liangying");userList.add("yangwei");userList.add("koudou");userList.add("wutingting");userList.add("wanghengde");userList.add("mengmingfan");
        //userList.add("liuyang1");userList.add("lisicong");
        //userList.add("liwei");userList.add("liangdeyu");userList.add("liumanlin");
        userList.add("fengchong");userList.add("chenjiayi");userList.add("dingjie");
        //固收
        //userList.add("yanlaiqiong");userList.add("guoguangkui");userList.add("lirui");userList.add("sunzhehao");
        //迅兔
        //userList.add("zhanglifan");userList.add("liuzongchen");userList.add("kanghuayong");userList.add("chenleilei");userList.add("liyingcong");
        //userList.add("xuyongming");userList.add("yuhan");userList.add("luwen");userList.add("zhangjingtian");
        for(int i=0;i<jdbcList.size();i++){
            String result1 = zeppelinRestApi.getInterpreterSetting(zeppelinRestApi,httpClient,jdbcList.get(i));
            JSONObject jsonObjectBody = JSON.parseObject(result1).getJSONObject("body");
            JSONObject jsonObjectOption = jsonObjectBody.getJSONObject("option");
            jsonObjectOption.put("setPermission",true);
            JSONArray jsonArrayOwners = jsonObjectOption.getJSONArray("owners");
            List<String> addUserList = new ArrayList<String>();
            for(int j=0;j<userList.size();j++){
                //用户不在配置中才能添加权限
                if (jsonArrayOwners.contains(userList.get(j))==false) {
                    addUserList.add(userList.get(j));
                }
            }
            for(int j=0;j<addUserList.size();j++){
                jsonArrayOwners.add(jsonArrayOwners.size(),addUserList.get(j));
            }
            String result3 = zeppelinRestApi.setInterpreterSetting(zeppelinRestApi,httpClient,jdbcList.get(i),jsonObjectBody.toJSONString());
            //System.out.println(jsonObjectBody);
            System.out.println(result3);
        }

    }
}
