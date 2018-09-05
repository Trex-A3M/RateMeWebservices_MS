package model.entity;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Date;

public class BaseEntity implements Serializable {

    @Column(name = "Create_Time")
    private Date createTime;

    @Column(name = "Update_Time")
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
