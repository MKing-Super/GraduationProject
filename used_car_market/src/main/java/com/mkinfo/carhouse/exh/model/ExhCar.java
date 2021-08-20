package com.mkinfo.carhouse.exh.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.mkinfo.carhouse.sys.model.SysUser;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 车辆信息
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public class ExhCar implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("SHEETID")
    private String sheetid;

    /**
     * 上牌时间
     */
    @TableField("REGISTRATIONTIME")
    private String registrationtime;

    /**
     * 表显里程
     */
    @TableField("MILEAGE")
    private String mileage;

    /**
     * 过户次数
     */
    @TableField("TRANSFERRECORD")
    private String transferrecord;

    /**
     * 车辆价格
     */
    @TableField("PRICE")
    private String price;

    /**
     * 使用性质
     */
    @TableField("USEPROPERTIES")
    private String useproperties;

    /**
     * 产权性质
     */
    @TableField("PROPERTYRIGHT")
    private String propertyright;

    /**
     * 车辆状态
     */
    @TableField("STATE")
    private String state;

    /**
     * 详细信息ID
     */
    @TableField("DETAILEDID")
    private String detailedid;

    /**
     * 人员ID(外键)
     */
    @TableField("USERID")
    private String userid;

    /**
     * 创建时间
     */
    @TableField("CREATETIME")
    private String createtime;

    /**
     * 车辆基本表，关联的车辆详细表
     */
    @TableField(exist = false)
    private ExhCarDetailed exhCarDetailed;

    /**
     * 用户
     */
    @TableField(exist = false)
    private SysUser sysUser;

    /**
     * 车辆配图，存放图片的存放地址
     */
    @TableField(exist = false)
    private List<ExhPictures> exhPicturesList;


    public String getSheetid() {
        return sheetid;
    }

    public void setSheetid(String sheetid) {
        this.sheetid = sheetid;
    }

    public String getRegistrationtime() {
        return registrationtime;
    }

    public void setRegistrationtime(String registrationtime) {
        this.registrationtime = registrationtime;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getTransferrecord() {
        return transferrecord;
    }

    public void setTransferrecord(String transferrecord) {
        this.transferrecord = transferrecord;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUseproperties() {
        return useproperties;
    }

    public void setUseproperties(String useproperties) {
        this.useproperties = useproperties;
    }

    public String getPropertyright() {
        return propertyright;
    }

    public void setPropertyright(String propertyright) {
        this.propertyright = propertyright;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDetailedid() {
        return detailedid;
    }

    public void setDetailedid(String detailedid) {
        this.detailedid = detailedid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public ExhCarDetailed getExhCarDetailed() {
        return exhCarDetailed;
    }

    public void setExhCarDetailed(ExhCarDetailed exhCarDetailed) {
        this.exhCarDetailed = exhCarDetailed;
    }

    public List<ExhPictures> getExhPicturesList() {
        return exhPicturesList;
    }

    public void setExhPicturesList(List<ExhPictures> exhPicturesList) {
        this.exhPicturesList = exhPicturesList;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    @Override
    public String toString() {
        return "ExhCar{" +
                "sheetid='" + sheetid + '\'' +
                ", registrationtime='" + registrationtime + '\'' +
                ", mileage='" + mileage + '\'' +
                ", transferrecord='" + transferrecord + '\'' +
                ", price='" + price + '\'' +
                ", useproperties='" + useproperties + '\'' +
                ", propertyright='" + propertyright + '\'' +
                ", state='" + state + '\'' +
                ", detailedid='" + detailedid + '\'' +
                ", userid='" + userid + '\'' +
                ", createtime='" + createtime + '\'' +
                ", exhCarDetailed=" + exhCarDetailed +
                ", sysUser=" + sysUser +
                ", exhPicturesList=" + exhPicturesList +
                '}';
    }
}
