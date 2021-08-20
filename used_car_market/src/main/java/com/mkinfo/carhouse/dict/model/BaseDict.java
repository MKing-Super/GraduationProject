package com.mkinfo.carhouse.dict.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 数据字典
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public class BaseDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId("SHEETID")
    private String sheetid;

    /**
     * 数据字典类别代码
     */
    @TableField("DICTTYPECODE")
    private String dicttypecode;

    /**
     * 数据字典类别名称
     */
    @TableField("DICTTYPENAME")
    private String dicttypename;

    /**
     * 是否可用：1：使用0：停用
     */
    @TableField("DICTENABLE")
    private String dictenable;

    /**
     * 创建时间
     */
    @TableField("CREATETIME")
    private String createtime;


    public String getSheetid() {
        return sheetid;
    }

    public void setSheetid(String sheetid) {
        this.sheetid = sheetid;
    }

    public String getDicttypecode() {
        return dicttypecode;
    }

    public void setDicttypecode(String dicttypecode) {
        this.dicttypecode = dicttypecode;
    }

    public String getDicttypename() {
        return dicttypename;
    }

    public void setDicttypename(String dicttypename) {
        this.dicttypename = dicttypename;
    }

    public String getDictenable() {
        return dictenable;
    }

    public void setDictenable(String dictenable) {
        this.dictenable = dictenable;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "BaseDict{" +
                "sheetid='" + sheetid + '\'' +
                ", dicttypecode='" + dicttypecode + '\'' +
                ", dicttypename='" + dicttypename + '\'' +
                ", dictenable='" + dictenable + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
