package com.itcm.example07;

import fastapi.*;

public class Main {
    public static void main(String[] args) {
        // 创建 FastAPI 应用实例
        FastAPI app = FastAPI();
        // 添加路由处理类
        app.addGet("/function/{path}", new Util());
        // 启动 FastAPI 应用，监听端口 8080
        app.run(8080);
    }
}