package com.mkinfo.carhouse.user.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mkinfo.carhouse.exh.model.ExhCar;
import com.mkinfo.carhouse.exh.model.ExhCarDetailed;

import java.io.Serializable;

/**
 * <p>
 * 车辆浏览历史
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public class UserHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId("SHEETID")
    private String sheetid;

    /**
     * 车辆ID
     */
    @TableField("CARID")
    private String carid;

    /**
     * 人员ID
     */
    @TableField("USERID")
    private String userid;

    /**
     * 浏览时间
     */
    @TableField("TIME")
    private String time;
    /**
     * 车辆基本信息
     */
    @TableField(exist = false)
    private ExhCar exhCar;

    /**
     * 车辆详细信息
     */
    @TableField(exist = false)
    private ExhCarDetailed exhCarDetailed;


    public String getSheetid() {
        return sheetid;
    }

    public void setSheetid(String sheetid) {
        this.sheetid = sheetid;
    }

    public String getCarid() {
        return carid;
    }

    public void setCarid(String carid) {
        this.carid = carid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ExhCar getExhCar() {
        return exhCar;
    }

    public void setExhCar(ExhCar exhCar) {
        this.exhCar = exhCar;
    }

    public ExhCarDetailed getExhCarDetailed() {
        return exhCarDetailed;
    }

    public void setExhCarDetailed(ExhCarDetailed exhCarDetailed) {
        this.exhCarDetailed = exhCarDetailed;
    }

    @Override
    public String toString() {
        return "UserHistory{" +
                "sheetid='" + sheetid + '\'' +
                ", carid='" + carid + '\'' +
                ", userid='" + userid + '\'' +
                ", time='" + time + '\'' +
                ", exhCar=" + exhCar +
                ", exhCarDetailed=" + exhCarDetailed +
                '}';
    }
}
