package com.cl.dubbo.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;



public class HTTPTest {
	@Test
	public void test1() throws Exception {
		System.out.println(URLDecoder.decode("orderLeaseDTO=%7B%22name%22%3A%22dd%22%2C%22idCardNo%22%3A%22dd1%22%7D", "utf-8"));
	}

	@Test
	public void test5() throws Exception {
		// 创建一个与服务器的连接
		ZooKeeper zk = new ZooKeeper("stable.zk.scsite.net:2181", 100000, new Watcher() {
			// 监控所有被触发的事件
			public void process(WatchedEvent event) {
				System.out.println("已经触发了" + event.getType() + "事件！");
			}
		});
		zk.addAuthInfo("digest","read:souche-read".getBytes());
		//String dir = "/dubbo/com.souche.consumer.loan.facade.order.ConsumerLoanOrderService";
		String dir = "/dubbo/com.souche.consumer.loan.facade.lease.Order4LeaseService";
		
		list(zk, dir);
		// 关闭连接
		zk.close();
	}
	
	private void list(ZooKeeper zk, String dir) throws Exception{
		System.out.println(URLDecoder.decode(dir, "utf-8"));
		try{
			List<String> serviceList = zk.getChildren(dir, false);
			for(String name : serviceList) {
				list(zk, (dir.equals("/") ? "" : dir) + "/"+ name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testString() throws Exception {
		String url = "dubbo://10.255.15.92:20880/com.souche.consumer.loan.facade.order.ConsumerLoanOrderService?application=consumer-loan-service_test&default.export=true&default.retries=0&dubbo=2.6.6&export=true&generic=false&interface=com.souche.consumer.loan.facade.order.ConsumerLoanOrderService&pid=10936&revision=3.5.0-SNAPSHOT&side=provider&timestamp=1530759821734";
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("orderId", "101236");
        send(url, paramMap, "findByOrderId");
	}
	
	@Test
	public void testObj() throws Exception{
		String url = "dubbo://10.255.15.92:20880/com.souche.consumer.loan.facade.lease.Order4LeaseService?application=consumer-loan-service_test&default.export=true&default.retries=0&dubbo=2.6.6&export=true&generic=false&interface=com.souche.consumer.loan.facade.lease.Order4LeaseService&pid=17078&revision=3.5.0-SNAPSHOT&side=provider&timestamp=1530772504470";
        Map<String, String> paramMap = new HashMap<String, String>();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "dd");
        jsonObj.put("idCardNo", "dd1");
        
        paramMap.put("orderLeaseDTO", jsonObj.toJSONString());
        send(url, paramMap, "generateLoanOrder");

	}
	
	private void send(String url, Map<String, String> paramMap, String methodName) throws Exception{
		Set<Entry<String, String>> entrySet = paramMap.entrySet();
		StringBuilder paramBuilder = new StringBuilder();
		for(Entry<String, String> entry : entrySet) {
			paramBuilder.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "utf-8")).append("&");
		}
		String param = paramBuilder.toString();
		if(paramMap.size() > 0) {
			param = paramBuilder.substring(0, paramBuilder.length() - 1);
		}
		send(url, param, methodName);
	}
	
	private void send(String url, String param, String methodName) throws Exception{
		String dubboToken = getDubboToken(url);
        url = url.replace("dubbo://", "http://");
        url = url.substring(0, url.indexOf("?"));
        String returnStr = sendPost(url, param, methodName, dubboToken);
        System.out.println(returnStr);
	}

	
	private String getDubboToken(String url){
	        String dubboToken = "souche_http_token";
            if(url.contains("default.token")){
                String arr[] = url.split("&");
                for (int i=0;i<arr.length;i++){
                    if(arr[i].contains("default.token")){
                        dubboToken = arr[i].split("=")[1];
                    }
                }
            }
	        return dubboToken;
	    }
	
	
	private String sendPost(String url, String param,String headerMethod,String dubboToken) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            java.net.URL realUrl = new java.net.URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            conn.setConnectTimeout(3000);
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("_method_name",headerMethod);
            conn.setRequestProperty("_dubbo_token",dubboToken);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }
}
