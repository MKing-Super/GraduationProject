/**
 * projectName: used_car_market
 * fileName: MD5Util.java
 * packageName: com.mkinfo.carhouse.utils.security
 * date: 2020-12-28 20:48
 * copyright(c) 2020- xxx公司
 */
package com.mkinfo.carhouse.utils.security;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @version: V1.0
 * @author: MK
 * @className: MD5Util
 * @packageName: com.mkinfo.carhouse.utils.security
 * @description: MD5加密
 * @date: 2020-12-28 20:48
 **/
public class MD5Util {
    /**
     * @title: getMD5Str
     * @description:
     * @author: MK
     * @date: 2020-12-28 20:50
     * @param: [password]
     * @return: java.lang.String
     * @throws:
     * @modefied: 2020-12-28 20:50 MK 修改
     */
    public static String getMD5Str(String password) {
        MessageDigest md;
        try {
            // 生成一个MD5加密计算摘要
            md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(password.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //BigInteger(1,md.digest()),其中1表示是正数，-1表示负数，0表示0
            //java.math.BigInteger.toString(int radix) 返回此BigInteger在给定的基数的字符串表示形式。
            //如果基数是从Character.MIN_RADIX到Character.MAX_RADIX包容的范围内，它会默认为10(因为Integer.toString的情况下)。
            String pwd = new BigInteger(1, md.digest()).toString(16);
            return pwd;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return password;
    }
}
