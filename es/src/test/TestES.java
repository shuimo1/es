package test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/12.
 */
public class TestES
{
    //访问es的客户端对象
   static PreBuiltTransportClient client;
    static {
        Settings setting = Settings.builder().build();
        client = new PreBuiltTransportClient(setting);
        try {
            InetAddress host = InetAddress.getByName("127.0.0.1");
            //连接到es
            client.addTransportAddress(new InetSocketTransportAddress(host,9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    };
    //添加数据
    public static void insert(){
       // Map<String,Object> data=new HashMap<>();
        Book bk=new Book("红aaa",789);
        String data = JSON.toJSONString(bk);
        System.out.println(data);
        //添加数据
        client.prepareIndex("books","book").setSource(data).get();

    }
    //更新
    public static void update(){
        Book bk=new Book("红qqq",888);
        String data = JSON.toJSONString(bk);
        UpdateResponse res = client.prepareUpdate("books", "book", "AV00diT6tncdU2jurBUO").setDoc(data).get();
        System.out.println(res.getResult().getLowercase());
    }
    //简单查询
    public static void query(){
        GetResponse res = client.prepareGet("books","book","1").get();
        System.out.println(res.getSourceAsString());

    }
    public static void delete(){
        DeleteResponse res = client.prepareDelete("books", "book", "2").get();
        System.out.println(res.getId());
    }
    public static void main(String[] args) {
//  insert();
//        update();
//        query();;
        delete();
    }

}
