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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chong
 */
@Entity
@Table(name = "PURCHASE_HISTORY_PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PurchaseHistoryProduct.findAll", query = "SELECT p FROM PurchaseHistoryProduct p"),
    @NamedQuery(name = "PurchaseHistoryProduct.findById", query = "SELECT p FROM PurchaseHistoryProduct p WHERE p.id = :id"),
    @NamedQuery(name = "PurchaseHistoryProduct.findByPurchaseHistoryProductId", query = "SELECT p FROM PurchaseHistoryProduct p WHERE p.purchaseHistoryProductId = :purchaseHistoryProductId"),
    @NamedQuery(name = "PurchaseHistoryProduct.findByPurchaseId", query = "SELECT p FROM PurchaseHistoryProduct p WHERE p.purchaseId = :purchaseId"),
    @NamedQuery(name = "PurchaseHistoryProduct.findByPurchaseHistoryId", query = "SELECT p FROM PurchaseHistoryProduct p WHERE p.purchaseHistoryId = :purchaseHistoryId")})
public class PurchaseHistoryProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PURCHASE_HISTORY_PRODUCT_ID")
    private Integer purchaseHistoryProductId;
    @Column(name = "PURCHASE_ID")
    private Integer purchaseId;
    @Column(name = "PURCHASE_HISTORY_ID")
    private Integer purchaseHistoryId;

    public PurchaseHistoryProduct() {
    }

    public PurchaseHistoryProduct(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public PurchaseHistoryProduct(Integer id, Integer purchaseHistoryProductId, Integer purchaseId, Integer purchaseHistoryId) {
        this.id = id;
        this.purchaseHistoryProductId = purchaseHistoryProductId;
        this.purchaseId = purchaseId;
        this.purchaseHistoryId = purchaseHistoryId;
    }

    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPurchaseHistoryProductId() {
        return purchaseHistoryProductId;
    }

    public void setPurchaseHistoryProductId(Integer purchaseHistoryProductId) {
        this.purchaseHistoryProductId = purchaseHistoryProductId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getPurchaseHistoryId() {
        return purchaseHistoryId;
    }

    public void setPurchaseHistoryId(Integer purchaseHistoryId) {
        this.purchaseHistoryId = purchaseHistoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PurchaseHistoryProduct))
            return false;
        PurchaseHistoryProduct other = (PurchaseHistoryProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "entity.PurchaseHistoryProduct[ id=" + id + " ]";
    }
    
}
