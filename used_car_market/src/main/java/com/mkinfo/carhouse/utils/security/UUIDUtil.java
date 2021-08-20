/**
 * projectName: used_car_market
 * fileName: UUIDUtil.java
 * packageName: com.mkinfo.carhouse.utils.tools
 * date: 2020-12-28 20:58
 * copyright(c) 2020- xxx公司
 */
package com.mkinfo.carhouse.utils.security;

import java.util.UUID;

/**
 * @version: V1.0
 * @author: MK
 * @className: UUIDUtil
 * @packageName: com.mkinfo.carhouse.utils.tools
 * @description: 生成UUID
 * @date: 2020-12-28 20:58
 **/
public class UUIDUtil {
    /**
     * @title: getUUID
     * @description: 得到UUID
     * @author: MK
     * @date: 2020-12-28 21:00
     * @param: []
     * @return: java.lang.String
     * @throws:
     * @modefied: 2020-12-28 21:00 MK 修改
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
