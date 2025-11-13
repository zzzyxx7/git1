package org.example.demo1;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    //生成JWT令牌
    @Test
  public void testGenerateJwt(){
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("id",1);
        dataMap.put("username","zkj");
      String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256,"zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzkj")//签名算法,指定加密算法和密钥
                    .addClaims(dataMap)//添加自定义数据
                    .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*24))//设置过期时间
                    .compact();//compact()方法生成JWT令牌
        System.out.println(jwt);

  }
    //解析JWT令牌
    @Test
    public void testParseJwt(){
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJ6a2oiLCJleHAiOjE3NjMxMjg2Njh9.d6WcfB0NS_5R3opWY-XD_Y-TrJYcRCix4XFkebTssCE";
        Claims claims = Jwts.parser().setSigningKey("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzkj")
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println(claims);
    }
}
