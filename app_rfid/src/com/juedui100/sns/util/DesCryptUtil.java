package com.juedui100.sns.util;

import net.sourceforge.stripes.util.CryptoUtil;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * User:cjp
 * Date: 2006-3-13
 * Time: 9:42:11
 */
public class DesCryptUtil {

    /**
     * 生成加密字符串
     *
     * @return String 加密后的字符串
     */
    public static String encrypt(String oriStr, String key) {
      //  Blowfish cipher = new Blowfish(key);
//        Blowfish cipher=new Blowfish(ServerUtil.getCookieKey());
    //    return cipher.encryptString(oriStr);
    	return oriStr;
    }


    /**
     * 解密并将得到的用户名和密码保存到一个字符串数组
     *
     * @param value String
     * @return String
     */
    public static String dectrypt(String value, String key) {
//        Blowfish cipher=new Blowfish(ServerUtil.getCookieKey());
//        Blowfish cipher = new Blowfish(key);
//        value = cipher.decryptString(value);
        return value;
    }


    static byte[] SECRETKEY;
    private static BASE64Encoder base64en = new BASE64Encoder();
    private static BASE64Decoder base64de = new BASE64Decoder();

    public static String encrypts(String src) {
       /* key="63450642";
        SECRETKEY = key.getBytes();
        String ret = "";

        try {
            DESKeySpec dks = new DESKeySpec(SECRETKEY);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            javax.crypto.SecretKey securekey = keyFactory.generateSecret(dks);
            IvParameterSpec spec = new IvParameterSpec(SECRETKEY);
            Cipher encrypt_Cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            encrypt_Cipher.init(1, securekey, spec);
            byte dest[] = encrypt_Cipher.doFinal(src.getBytes());
            ret = base64en.encode(dest);
//            ret = java.net.URLEncoder.encode(ret, "gbk");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            return URLEncoder.encode(ret,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return ret;
        }*/
        return CryptoUtil.encrypt(src);
    }

    //字符串解密函数：
    public static String decrypts(String src) {
        /*key="63450642";
        SECRETKEY = key.getBytes();
        String ret = "";
        try {
            DESKeySpec dks = new DESKeySpec(SECRETKEY);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            javax.crypto.SecretKey securekey = keyFactory.generateSecret(dks);
            IvParameterSpec spec = new IvParameterSpec(SECRETKEY);
            Cipher decrypt_Cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            decrypt_Cipher.init(2, securekey, spec);
            byte buf[] = base64de.decodeBuffer(src);
            byte dest[] = decrypt_Cipher.doFinal(buf);
            ret = new String(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;*/
        return CryptoUtil.decrypt(src);
    }

    public static String encryptsWap(String src) {
        //return CryptoUtil.encrypt("txjdyb"+src);
        return CryptoUtil.encrypt(src);
    }

    public static String decryptsWap(String src) {
        //return CryptoUtil.decrypt(src).substring("txjdyb".length());
        return CryptoUtil.decrypt(src);
    }

    public static void main(String[] args) throws Exception {
        String enc = DesCryptUtil.encryptsWap("000000000000000000000123123EB");
        System.out.println(enc);
        enc = DesCryptUtil.decryptsWap(enc);
        System.out.println(enc);
//        System.out.println(encrypts("0000000000000000000000000ED1F727","63450642"));
      /*  String s = encrypts("0000000000000000000000000ED1F727","63450642");
        s = decrypts("yXjxljI0V7tbfEo8wZz0NfBLzpKSff9Xq859L++Wm6UjSovqTdy5eg==","12345678");
        System.out.println("sid="+s);
        CryptoUtil.encrypt("0000000000000000000000000ED1F727");*/
    }
}
