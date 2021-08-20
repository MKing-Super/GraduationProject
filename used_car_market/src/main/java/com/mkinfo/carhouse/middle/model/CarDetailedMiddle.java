package com.mkinfo.carhouse.middle.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 车辆详细信息中间表
 * </p>
 *
 * @author MK
 * @since 2021-01-21
 */
public class CarDetailedMiddle implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId("SHEETID")
    private String sheetid;

    /**
     * 父级ID
     */
    @TableField("PARENTID")
    private String parentid;

    /**
     * 子级ID
     */
    @TableField("CHILDREN")
    private String children;


    public String getSheetid() {
        return sheetid;
    }

    public void setSheetid(String sheetid) {
        this.sheetid = sheetid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "CarDetailedMiddle{" +
        "sheetid=" + sheetid +
        ", parentid=" + parentid +
        ", children=" + children +
        "}";
    }
}
