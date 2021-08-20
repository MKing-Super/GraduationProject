package com.mkinfo.carhouse.exh.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 车辆图片
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public class ExhPictures implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId("SHEETID")
    private String sheetid;

    /**
     * 图片路径
     */
    @TableField("PATH")
    private String path;

    /**
     * 车辆ID
     */
    @TableField("CARID")
    private String carid;


    public String getSheetid() {
        return sheetid;
    }

    public void setSheetid(String sheetid) {
        this.sheetid = sheetid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    @Override
    public String toString() {
        return "ExhPictures{" +
        "sheetid=" + sheetid +
        ", path=" + path +
        ", carid=" + carid +
        "}";
    }
}
