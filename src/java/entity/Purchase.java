/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chong
 */
@Entity
@Table(name = "PURCHASE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Purchase.findAll", query = "SELECT p FROM Purchase p"),
    @NamedQuery(name = "Purchase.findByPurchaseId", query = "SELECT p FROM Purchase p WHERE p.purchaseId = :purchaseId"),
    @NamedQuery(name = "Purchase.findByTotalPrice", query = "SELECT p FROM Purchase p WHERE p.totalPrice = :totalPrice"),
    @NamedQuery(name = "Purchase.findByShippingAddress", query = "SELECT p FROM Purchase p WHERE p.shippingAddress = :shippingAddress"),
    @NamedQuery(name = "Purchase.findByStatus", query = "SELECT p FROM Purchase p WHERE p.status = :status"),
    @NamedQuery(name = "Purchase.findByPurchaseHistoryId", query = "SELECT p FROM Purchase p WHERE p.purchaseHistoryId = :purchaseHistoryId"),
    @NamedQuery(name = "Purchase.findByCustomerId", query = "SELECT p FROM Purchase p WHERE p.customerId = :customerId")})
public class Purchase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PURCHASE_ID")
    private Integer purchaseId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL_PRICE")
    private double totalPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "SHIPPING_ADDRESS")
    private String shippingAddress;
    @Size(max = 100)
    @Column(name = "STATUS")
    private String status;
    @Column(name = "PURCHASE_HISTORY_ID")
    private Integer purchaseHistoryId;
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

    public Purchase() {
    }

    public Purchase(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Purchase(Integer purchaseId, double totalPrice, String shippingAddress) {
        this.purchaseId = purchaseId;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPurchaseHistoryId() {
        return purchaseHistoryId;
    }

    public void setPurchaseHistoryId(Integer purchaseHistoryId) {
        this.purchaseHistoryId = purchaseHistoryId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseId != null ? purchaseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Purchase))
            return false;
        Purchase other = (Purchase) object;
        if ((this.purchaseId == null && other.purchaseId != null) || (this.purchaseId != null && !this.purchaseId.equals(other.purchaseId)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "entity.Purchase[ purchaseId=" + purchaseId + " ]";
    }
    
}
