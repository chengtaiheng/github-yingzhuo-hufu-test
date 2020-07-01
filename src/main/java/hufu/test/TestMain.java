package hufu.test;


import com.github.yingzhuo.hufu.api.*;
import com.github.yingzhuo.hufu.core.Hufu;
import hufu.test.domain.Doctor;

import java.nio.charset.StandardCharsets;

public class TestMain {

    public static void main(String[] args) {

        //生成密钥工厂
        SecretFactory secretFactory = Hufu.createSecretFactory();

        //生成密钥对
        Secret secret = secretFactory.createRandom();

        //公钥私钥对像
        PublicKey pkr = secret;
        PrivateKey skr = secret;

        System.out.println(secret);

        //生成签名
        Signature signature = Hufu.createSignature();
        Doctor doctor = Doctor.builder().id(3l)
                .age(38)
                .name("李医生")
                .build();

        byte[] data = doctor.toString().getBytes(StandardCharsets.UTF_8);
        //签名
        String sign = signature.sign(data, skr);

        System.out.println("pkr = " + pkr.getPublicKey());
        System.out.println("skr = " + skr.getPrivateKey());

        //验证签名
        boolean ok = signature.verify(data, sign,pkr);
        if (ok) {
            System.out.println("签名正确");
        } else {
            System.out.println("签名错误");
        }
    }
}
