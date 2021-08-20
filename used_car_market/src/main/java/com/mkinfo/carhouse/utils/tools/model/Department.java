/**
 * projectName: used_car_market
 * fileName: Department.java
 * packageName: com.mkinfo.carhouse.utils.tools.model
 * date: 2021-01-14 13:41
 * copyright(c) 2020- xxx公司
 */
package com.mkinfo.carhouse.utils.tools.model;

import java.io.Serializable;

/**
 * @version: V1.0
 * @author: MK
 * @className: Department
 * @packageName: com.mkinfo.carhouse.utils.tools.model
 * @description: 部门表格
 * @date: 2021-01-14 13:41
 **/
public class Department implements Serializable {

    private static final long serialVersionUID=1L;

    private String ID;
    private String Name;
    private String Level;
    private String Desc;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    @Override
    public String toString() {
        return "Department{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Level='" + Level + '\'' +
                ", Desc='" + Desc + '\'' +
                '}';
    }
}
