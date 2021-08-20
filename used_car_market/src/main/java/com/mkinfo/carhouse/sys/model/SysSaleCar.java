package com.mkinfo.carhouse.sys.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mkinfo.carhouse.exh.model.ExhCar;

import java.io.Serializable;

/**
 * <p>
 * 已售出车辆
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public class SysSaleCar implements Serializable {

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
     * 卖方ID
     */
    @TableField("SELLERID")
    private String sellerid;

    /**
     * 买方ID
     */
    @TableField("BUYERID")
    private String buyerid;

    /**
     * 交易时间
     */
    @TableField("DEALTIME")
    private String dealtime;

    /**
     * 交易价格
     */
    @TableField("DEALPRICE")
    private String dealprice;

    /**
     * 用户
     */
    @TableField(exist = false)
    private SysUser sysUser;

    /**
     * 车辆信息基本表
     */
    @TableField(exist = false)
    private ExhCar exhCar;


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

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public String getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(String buyerid) {
        this.buyerid = buyerid;
    }

    public String getDealtime() {
        return dealtime;
    }

    public void setDealtime(String dealtime) {
        this.dealtime = dealtime;
    }

    public String getDealprice() {
        return dealprice;
    }

    public void setDealprice(String dealprice) {
        this.dealprice = dealprice;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public ExhCar getExhCar() {
        return exhCar;
    }

    public void setExhCar(ExhCar exhCar) {
        this.exhCar = exhCar;
    }

    @Override
    public String toString() {
        return "SysSaleCar{" +
        "sheetid=" + sheetid +
        ", carid=" + carid +
        ", sellerid=" + sellerid +
        ", buyerid=" + buyerid +
        ", dealtime=" + dealtime +
        ", dealprice=" + dealprice +
        "}";
    }
}
