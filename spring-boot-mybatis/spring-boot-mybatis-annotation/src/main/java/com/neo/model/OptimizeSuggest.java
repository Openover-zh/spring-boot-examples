package com.neo.model;

/**
 * @author zhangJiaHao
 * @date 2022/8/12 16:52
 */
public class OptimizeSuggest {
    private Integer id;

    private Integer ruleId;

    private String objId;

    private String objName;

    @Override
    public String toString() {
        return "OptimizeSuggest{" +
                "id=" + id +
                ", ruleId=" + ruleId +
                ", objId='" + objId + '\'' +
                ", objName='" + objName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }
}
