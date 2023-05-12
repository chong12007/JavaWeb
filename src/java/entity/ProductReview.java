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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chong
 */
@Entity
@Table(name = "PRODUCT_REVIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductReview.findAll", query = "SELECT p FROM ProductReview p"),
    @NamedQuery(name = "ProductReview.findByProductReviewId", query = "SELECT p FROM ProductReview p WHERE p.productReviewId = :productReviewId"),
    @NamedQuery(name = "ProductReview.findByRatingStart", query = "SELECT p FROM ProductReview p WHERE p.ratingStart = :ratingStart"),
    @NamedQuery(name = "ProductReview.findByComment", query = "SELECT p FROM ProductReview p WHERE p.comment = :comment"),
    @NamedQuery(name = "ProductReview.findByCreatedtime", query = "SELECT p FROM ProductReview p WHERE p.createdtime = :createdtime"),
    @NamedQuery(name = "ProductReview.findByProductId", query = "SELECT p FROM ProductReview p WHERE p.productId = :productId"),
    @NamedQuery(name = "ProductReview.findByCustomerId", query = "SELECT p FROM ProductReview p WHERE p.customerId = :customerId")})
public class ProductReview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCT_REVIEW_ID")
    private Integer productReviewId;
    @Column(name = "RATING_START")
    private Integer ratingStart;
    @Size(max = 50)
    @Column(name = "COMMENT")
    private String comment;
    @Lob
    @Column(name = "IMAGE")
    private Serializable image;
    @Column(name = "CREATEDTIME")
    @Temporal(TemporalType.TIME)
    private Date createdtime;
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;

    public ProductReview() {
    }

    public ProductReview(Integer productReviewId) {
        this.productReviewId = productReviewId;
    }

    public Integer getProductReviewId() {
        return productReviewId;
    }

    public void setProductReviewId(Integer productReviewId) {
        this.productReviewId = productReviewId;
    }

    public Integer getRatingStart() {
        return ratingStart;
    }

    public void setRatingStart(Integer ratingStart) {
        this.ratingStart = ratingStart;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Serializable getImage() {
        return image;
    }

    public void setImage(Serializable image) {
        this.image = image;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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
        hash += (productReviewId != null ? productReviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductReview))
            return false;
        ProductReview other = (ProductReview) object;
        if ((this.productReviewId == null && other.productReviewId != null) || (this.productReviewId != null && !this.productReviewId.equals(other.productReviewId)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "entity.ProductReview[ productReviewId=" + productReviewId + " ]";
    }
    
}
