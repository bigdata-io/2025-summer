//package com.itheima;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.JWTVerifier;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.interfaces.Claim;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.auth0.jwt.interfaces.Verification;
//import org.junit.jupiter.api.Test;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//public class JwtTest {
//
//@Test
//    public void test1(){
//    Map<String,Object> claims = new HashMap();
//    claims.put("username","fxt");
//    claims.put("id",1);
//
//    String token =JWT.create()
//            .withClaim("user",claims)
//            .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))
//            .sign(Algorithm.HMAC256("123456"));
//
//    System.out.println(token);
//    }
//
//
//    @Test
//    public void test2(){
//    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
//            ".eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6ImZ4dCJ9LCJleHAiOjE3NTQ1MTgzNzd9" +
//            ".xR_fEIJT3P1mDujKkdoYNilEkufPMz8KsYj9NT-1zvY";
//        JWTVerifier build =JWT.require(Algorithm.HMAC256("123456")).build();
//
//        DecodedJWT verify = build.verify(token);
//
//        Map<String,Claim>  claims=verify.getClaims();
//
//        System.out.println(claims.get("user"));
//    }
//
//
//    }