package com.itcm.example07;
import com.sun.net.httpserver.HttpHandler;
import org.springframework.web.bind.annotation.*;

public class Util  {
    @Api("/function/") // 在方法上添加自定义注解
    public int add(int a, int b) {
        return a + b;
    }
}