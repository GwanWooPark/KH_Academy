package com.sms;

import org.apache.commons.codec.binary.Hex;
import org.ini4j.Ini;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

class APIInit {
    static String getHeaders() {
        try {
            Ini ini = new Ini(new File(APIInit.class.getResource("").getPath() + "/config.ini")); //현재 위치의 config.ini파일을 읽어 온다
            String apiKey = ini.get("AUTH", "api_key"); //api 및 시크릿 키 추출
            String apiSecret = ini.get("AUTH", "api_secret");
            String salt = UUID.randomUUID().toString().replaceAll("-", ""); //랜덤 UUID생성 후 -빼기
            String date = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toString().split("\\[")[0]; 

            Mac sha256_HMAC = Mac.getInstance("HmacSHA256"); //여러가지 암호화 작업
            SecretKeySpec secret_key = new SecretKeySpec(apiSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            String signature = new String(Hex.encodeHex(sha256_HMAC.doFinal((date + salt).getBytes(StandardCharsets.UTF_8))));
            return "HMAC-SHA256 ApiKey=" + apiKey + ", Date=" + date + ", salt=" + salt + ", signature=" + signature; //증명 발급
        } catch (InvalidKeyException | NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
