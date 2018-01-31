package me.xiaff.service.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * 网上购买的代理订单信息
 * Created by Lu Chenwei on 2017/8/23.
 */
@Entity
@Table(name = "proxy_order")
public class ProxyOrder {
    @Id
    @GeneratedValue
    private Long id;

    private String orderId;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createTime;

    public ProxyOrder() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ProxyOrder{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
