/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chong
 */
@Entity
@Table(name = "PURCHASE_HISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseHistory.findAll", query = "SELECT p FROM PurchaseHistory p"),
    @NamedQuery(name = "PurchaseHistory.findByPurchaseHistoryId", query = "SELECT p FROM PurchaseHistory p WHERE p.purchaseHistoryId = :purchaseHistoryId"),
    @NamedQuery(name = "PurchaseHistory.findByProductId", query = "SELECT p FROM PurchaseHistory p WHERE p.productId = :productId"),
    @NamedQuery(name = "PurchaseHistory.findByName", query = "SELECT p FROM PurchaseHistory p WHERE p.name = :name"),
    @NamedQuery(name = "PurchaseHistory.findByQuantity", query = "SELECT p FROM PurchaseHistory p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "PurchaseHistory.findByPrice", query = "SELECT p FROM PurchaseHistory p WHERE p.price = :price"),
    @NamedQuery(name = "PurchaseHistory.findByDescription", query = "SELECT p FROM PurchaseHistory p WHERE p.description = :description"),
    @NamedQuery(name = "PurchaseHistory.findByPurchaseddate", query = "SELECT p FROM PurchaseHistory p WHERE p.purchaseddate = :purchaseddate")})
public class PurchaseHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PURCHASE_HISTORY_ID")
    private Integer purchaseHistoryId;
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITY")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "PURCHASEDDATE")
    @Temporal(TemporalType.TIME)
    private Date purchaseddate;
    
    @Transient
    private String status;
    @Transient
    private String ImgPath;
    @Transient
    private byte [] image;

    public PurchaseHistory() {
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImgPath() {
        return ImgPath;
    }

    public void setImgPath(String ImgPath) {
        this.ImgPath = ImgPath;
    }
    
    
    
    

    public PurchaseHistory(Integer purchaseHistoryId) {
        this.purchaseHistoryId = purchaseHistoryId;
    }

    public PurchaseHistory(Integer purchaseHistoryId, String name, int quantity) {
        this.purchaseHistoryId = purchaseHistoryId;
        this.name = name;
        this.quantity = quantity;
    }

    public PurchaseHistory(Integer purchaseHistoryId, Integer productId, String name, int quantity, Double price, String description, Date purchaseddate) {
        this.purchaseHistoryId = purchaseHistoryId;
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.purchaseddate = purchaseddate;
    }

    
    
    public Integer getPurchaseHistoryId() {
        return purchaseHistoryId;
    }

    public void setPurchaseHistoryId(Integer purchaseHistoryId) {
        this.purchaseHistoryId = purchaseHistoryId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPurchaseddate() {
        return purchaseddate;
    }

    public void setPurchaseddate(Date purchaseddate) {
        this.purchaseddate = purchaseddate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (purchaseHistoryId != null ? purchaseHistoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseHistory))
            return false;
        PurchaseHistory other = (PurchaseHistory) object;
        if ((this.purchaseHistoryId == null && other.purchaseHistoryId != null) || (this.purchaseHistoryId != null && !this.purchaseHistoryId.equals(other.purchaseHistoryId)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "entity.PurchaseHistory[ purchaseHistoryId=" + purchaseHistoryId + " ]";
    }
    
}
