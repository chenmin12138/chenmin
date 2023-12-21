package com.itcm.example07;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class FastApi {
    //存储API路径和对应的方法映射关系
    private static final Map<String, Method> apiMap = new HashMap<>();
    //HTTP服务器监听的端口号
    private static final int PORT = 8080;
    //启动HTTP服务器
    public static void start() {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(PORT), 0);//创建服务器实例并绑定到指定端口
            server.createContext("/function/", new Util());//创建上下文，并指定处理API请求的处理器
            server.setExecutor(null); //设置执行器为null,使用默认执行器
            server.start();//启动服务器
            System.out.println("FastAPI服务器正在端口"+ PORT+"上运行");//输出服务器运行信息
        } catch (IOException e){
            e.printStackTrace();//打印异常堆栈信息
        }
    }