package com.mkinfo.carhouse.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 审核表
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public class SysCheck implements Serializable {

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
     * 状态
     */
    @TableField("STATE")
    private String state;

    /**
     * 管理人员ID
     */
    @TableField("ADMINID")
    private String adminid;

    /**
     * 审核开始时间
     */
    @TableField("STARTTIME")
    private String starttime;

    /**
     * 审核结束时间
     */
    @TableField("ENDTIME")
    private String endtime;


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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    @Override
    public String toString() {
        return "SysCheck{" +
        "sheetid=" + sheetid +
        ", carid=" + carid +
        ", userid=" + userid +
        ", state=" + state +
        ", adminid=" + adminid +
        ", starttime=" + starttime +
        ", endtime=" + endtime +
        "}";
    }
}
