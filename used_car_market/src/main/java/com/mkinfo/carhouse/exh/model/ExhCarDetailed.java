package com.mkinfo.carhouse.exh.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 车辆详细信息
 * </p>
 *
 * @author MK
 * @since 2020-12-26
 */
public class ExhCarDetailed implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId("SHEETID")
    private String sheetid;

    /**
     * 品牌
     */
    @TableField("BRAND")
    private String brand;

    /**
     * 车系
     */
    @TableField("SERIES")
    private String series;

    /**
     * 车型
     */
    @TableField("MODEL")
    private String model;

    /**
     * 厂商
     */
    @TableField("MAUNFATURER")
    private String maunfaturer;

    /**
     * 等级
     */
    @TableField("LEVEL")
    private String level;

    /**
     * 发动机
     */
    @TableField("ENGINE")
    private String engine;

    /**
     * 变速箱
     */
    @TableField("GEARBOX")
    private String gearbox;

    /**
     * 尺寸
     */
    @TableField("SIZE")
    private String size;

    /**
     * 车身结构
     */
    @TableField("STRUCTURE")
    private String structure;

    /**
     * 排放标准
     */
    @TableField("EMISSIONSTANDARD")
    private String emissionstandard;

    /**
     * 排量
     */
    @TableField("DISPLACEMENT")
    private String displacement;

    /**
     * 燃油类型
     */
    @TableField("FUELTYPE")
    private String fueltype;


    public String getSheetid() {
        return sheetid;
    }

    public void setSheetid(String sheetid) {
        this.sheetid = sheetid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMaunfaturer() {
        return maunfaturer;
    }

    public void setMaunfaturer(String maunfaturer) {
        this.maunfaturer = maunfaturer;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getEmissionstandard() {
        return emissionstandard;
    }

    public void setEmissionstandard(String emissionstandard) {
        this.emissionstandard = emissionstandard;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    @Override
    public String toString() {
        return "ExhCarDetailed{" +
        "sheetid=" + sheetid +
        ", brand=" + brand +
        ", series=" + series +
        ", model=" + model +
        ", maunfaturer=" + maunfaturer +
        ", level=" + level +
        ", engine=" + engine +
        ", gearbox=" + gearbox +
        ", size=" + size +
        ", structure=" + structure +
        ", emissionstandard=" + emissionstandard +
        ", displacement=" + displacement +
        ", fueltype=" + fueltype +
        "}";
    }
}
