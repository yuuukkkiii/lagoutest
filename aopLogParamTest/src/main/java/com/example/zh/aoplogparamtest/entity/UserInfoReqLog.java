package com.example.zh.aoplogparamtest.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName user_info_req_log
 */
@TableName(value ="user_info_req_log")
public class UserInfoReqLog implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Long timeFlag;

    /**
     * 
     */
    private String userCode;

    /**
     * 
     */
    private String userName;

    /**
     * 
     */
    private String requestName;

    /**
     * 
     */
    private String paramName;

    /**
     * 
     */
    private String paramIndex;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     */
    public Long getTimeFlag() {
        return timeFlag;
    }

    /**
     * 
     */
    public void setTimeFlag(Long timeFlag) {
        this.timeFlag = timeFlag;
    }

    /**
     * 
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * 
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 
     */
    public String getRequestName() {
        return requestName;
    }

    /**
     * 
     */
    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    /**
     * 
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * 
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * 
     */
    public String getParamIndex() {
        return paramIndex;
    }

    /**
     * 
     */
    public void setParamIndex(String paramIndex) {
        this.paramIndex = paramIndex;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        UserInfoReqLog other = (UserInfoReqLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTimeFlag() == null ? other.getTimeFlag() == null : this.getTimeFlag().equals(other.getTimeFlag()))
            && (this.getUserCode() == null ? other.getUserCode() == null : this.getUserCode().equals(other.getUserCode()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getRequestName() == null ? other.getRequestName() == null : this.getRequestName().equals(other.getRequestName()))
            && (this.getParamName() == null ? other.getParamName() == null : this.getParamName().equals(other.getParamName()))
            && (this.getParamIndex() == null ? other.getParamIndex() == null : this.getParamIndex().equals(other.getParamIndex()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTimeFlag() == null) ? 0 : getTimeFlag().hashCode());
        result = prime * result + ((getUserCode() == null) ? 0 : getUserCode().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getRequestName() == null) ? 0 : getRequestName().hashCode());
        result = prime * result + ((getParamName() == null) ? 0 : getParamName().hashCode());
        result = prime * result + ((getParamIndex() == null) ? 0 : getParamIndex().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", timeFlag=").append(timeFlag);
        sb.append(", userCode=").append(userCode);
        sb.append(", userName=").append(userName);
        sb.append(", requestName=").append(requestName);
        sb.append(", paramName=").append(paramName);
        sb.append(", paramIndex=").append(paramIndex);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}