package com.dsy.rsa;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * RSA签名验签类
 */
public class RSASignature{
    private final static Base64.Decoder decoder = Base64.getDecoder();

    private final static Base64.Encoder encoder = Base64.getEncoder();

    private static String pri =
        "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIhMnRjpbQIcrcN1lZtuz1qpLS1psFdBxgvvbbBNdCy2Qp7oX+3mpt7j9ATk17VavQQpISTqDr8GEfd+16SeEyZlRAtM8rYMC+2qvYPErT/B+RlGXMG8GTXZBbnA7AtxT2ozaKuQ2tO+NtJc/dxELBIFTsZToOx50Ko71pmM6EJHAgMBAAECgYBi5sz73a224Z6I/VKw9chKrgXVNSK7PkP6NyNt0dYh96MB8fZiB4NAq0JPJssLkqsjUMD3K0vF+x6ga48IqZeUq5ghd3g3nODlZjPMTRWwNoflyzWc/vfFBAwuqcJYWsABM4iytqrKoKSGyxQg+PfYm3JVB9MrSxL8Clh+nTqAOQJBANmW3mtt2GGgoM4EggjxenPLk1dePGlzTHvqTCi5bu4Xz2R8iXEqPY4MwAKJMuGvi4eTILQRxbx+ZJY2dRY+bAUCQQCgXCV97OWE8vTXHh9zD05mMR4QOQe2ar00ufSQPcEK8AIErLIjwF0Fa6tlRsTuI7GDLmCdWzq1xceV+p5n+5LbAkEAn3e5tORBZHOTxsl4/9LymrEFYE+5WNNep6Z0gJg+m5KptYysMlrx2AyyIGmq98pvKUKEAlTQJbBASfLJZy8CfQJAVk5Bv2xoew1nyP9lXb+3Kjj1PTX0eLEp897BSYBzDTfvXiS0G5nEds5kCLX191UujLPBO++FwZ8YtBeWedBkUQJAUHpENLOsLcL85E/e4AQ9TJOKdHc6KhRtjMOzUaA1R/wXhwc62hfSsPDn7m1EIjOIfcVfcwF16MVrVGM6HvAzQg==";

    private static String pub =
        "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCITJ0Y6W0CHK3DdZWbbs9aqS0tabBXQcYL722wTXQstkKe6F/t5qbe4/QE5Ne1Wr0EKSEk6g6/BhH3fteknhMmZUQLTPK2DAvtqr2DxK0/wfkZRlzBvBk12QW5wOwLcU9qM2irkNrTvjbSXP3cRCwSBU7GU6DsedCqO9aZjOhCRwIDAQAB";

    /**
     * 签名算法
     */
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    public static void main(String[] args) {
        String content = "123456";
        String sign = sign(content, pri, "UTF-8");
        System.out.println(sign);
        System.out.println(doCheck("123456", sign, pub, "UTF-8"));
    }

    /**
     * RSA签名
     * @param content 待签名数据
     * @param privateKey 商户私钥
     * @param encode 字符集编码
     * @return 签名值
     */
    public static String sign(String content, String privateKey, String encode) {
        try {
            PKCS8EncodedKeySpec priPKCS8    = new PKCS8EncodedKeySpec( decoder.decode(privateKey) );
            KeyFactory keyf                 = KeyFactory.getInstance("RSA");
            PrivateKey priKey               = keyf.generatePrivate(priPKCS8);
            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
            signature.initSign(priKey);
            signature.update( content.getBytes(encode));
            byte[] signed = signature.sign();
            return encoder.encodeToString(signed);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * RSA验签名检查
     * @param content 待签名数据
     * @param sign 签名值
     * @param publicKey 分配给开发商公钥
     * @param encode 字符集编码
     * @return 布尔值
     */
    public static boolean doCheck(String content, String sign, String publicKey,String encode) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            byte[] encodedKey = decoder.decode(publicKey);
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));
            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);
            signature.initVerify(pubKey);
            signature.update( content.getBytes(encode) );
            return signature.verify( decoder.decode(sign));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}