package com.hotel.model;

import java.io.Serializable;
import java.util.Date;

public class PayReturnOrder implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.return_no
     *
     * @mbggenerated
     */
    private String returnNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.order_sn
     *
     * @mbggenerated
     */
    private String orderSn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.pay_no
     *
     * @mbggenerated
     */
    private String payNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.price
     *
     * @mbggenerated
     */
    private Integer price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.union_id
     *
     * @mbggenerated
     */
    private String unionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.open_id
     *
     * @mbggenerated
     */
    private String openId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.status
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.pay_id
     *
     * @mbggenerated
     */
    private Byte payId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.pay_name
     *
     * @mbggenerated
     */
    private String payName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.reason
     *
     * @mbggenerated
     */
    private String reason;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.memo
     *
     * @mbggenerated
     */
    private String memo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.created_at
     *
     * @mbggenerated
     */
    private Date createdAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_return_order.updated_at
     *
     * @mbggenerated
     */
    private Date updatedAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table pay_return_order
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.id
     *
     * @return the value of pay_return_order.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.id
     *
     * @param id the value for pay_return_order.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.return_no
     *
     * @return the value of pay_return_order.return_no
     *
     * @mbggenerated
     */
    public String getReturnNo() {
        return returnNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.return_no
     *
     * @param returnNo the value for pay_return_order.return_no
     *
     * @mbggenerated
     */
    public void setReturnNo(String returnNo) {
        this.returnNo = returnNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.order_sn
     *
     * @return the value of pay_return_order.order_sn
     *
     * @mbggenerated
     */
    public String getOrderSn() {
        return orderSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.order_sn
     *
     * @param orderSn the value for pay_return_order.order_sn
     *
     * @mbggenerated
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.pay_no
     *
     * @return the value of pay_return_order.pay_no
     *
     * @mbggenerated
     */
    public String getPayNo() {
        return payNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.pay_no
     *
     * @param payNo the value for pay_return_order.pay_no
     *
     * @mbggenerated
     */
    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.price
     *
     * @return the value of pay_return_order.price
     *
     * @mbggenerated
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.price
     *
     * @param price the value for pay_return_order.price
     *
     * @mbggenerated
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.union_id
     *
     * @return the value of pay_return_order.union_id
     *
     * @mbggenerated
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.union_id
     *
     * @param unionId the value for pay_return_order.union_id
     *
     * @mbggenerated
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.open_id
     *
     * @return the value of pay_return_order.open_id
     *
     * @mbggenerated
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.open_id
     *
     * @param openId the value for pay_return_order.open_id
     *
     * @mbggenerated
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.status
     *
     * @return the value of pay_return_order.status
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.status
     *
     * @param status the value for pay_return_order.status
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.pay_id
     *
     * @return the value of pay_return_order.pay_id
     *
     * @mbggenerated
     */
    public Byte getPayId() {
        return payId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.pay_id
     *
     * @param payId the value for pay_return_order.pay_id
     *
     * @mbggenerated
     */
    public void setPayId(Byte payId) {
        this.payId = payId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.pay_name
     *
     * @return the value of pay_return_order.pay_name
     *
     * @mbggenerated
     */
    public String getPayName() {
        return payName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.pay_name
     *
     * @param payName the value for pay_return_order.pay_name
     *
     * @mbggenerated
     */
    public void setPayName(String payName) {
        this.payName = payName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.reason
     *
     * @return the value of pay_return_order.reason
     *
     * @mbggenerated
     */
    public String getReason() {
        return reason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.reason
     *
     * @param reason the value for pay_return_order.reason
     *
     * @mbggenerated
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.memo
     *
     * @return the value of pay_return_order.memo
     *
     * @mbggenerated
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.memo
     *
     * @param memo the value for pay_return_order.memo
     *
     * @mbggenerated
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.created_at
     *
     * @return the value of pay_return_order.created_at
     *
     * @mbggenerated
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.created_at
     *
     * @param createdAt the value for pay_return_order.created_at
     *
     * @mbggenerated
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_return_order.updated_at
     *
     * @return the value of pay_return_order.updated_at
     *
     * @mbggenerated
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_return_order.updated_at
     *
     * @param updatedAt the value for pay_return_order.updated_at
     *
     * @mbggenerated
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_return_order
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", returnNo=").append(returnNo);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", payNo=").append(payNo);
        sb.append(", price=").append(price);
        sb.append(", unionId=").append(unionId);
        sb.append(", openId=").append(openId);
        sb.append(", status=").append(status);
        sb.append(", payId=").append(payId);
        sb.append(", payName=").append(payName);
        sb.append(", reason=").append(reason);
        sb.append(", memo=").append(memo);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}