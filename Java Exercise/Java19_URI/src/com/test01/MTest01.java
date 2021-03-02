package com.test01;

import java.net.URI;
import java.net.URISyntaxException;

public class MTest01 {

    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI("http://localhost:8787/res.jsp?name=%EB%B0%95%EA%B4%80%EC%9A%B0&addr=%EC%9D%B8%EC%B2%9C%EC%8B%9C");

        System.out.println(uri.getScheme());
        System.out.println(uri.getHost());
        System.out.println(uri.getPort());
        System.out.println(uri.getPath());
        System.out.println(uri.getQuery());
    }
}
