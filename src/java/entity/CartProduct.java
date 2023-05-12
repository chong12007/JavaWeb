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
@Table(name = "CART_PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartProduct.findAll", query = "SELECT c FROM CartProduct c"),
    @NamedQuery(name = "CartProduct.findById", query = "SELECT c FROM CartProduct c WHERE c.id = :id"),
    @NamedQuery(name = "CartProduct.findByCartId", query = "SELECT c FROM CartProduct c WHERE c.cartId = :cartId"),
    @NamedQuery(name = "CartProduct.findByProductId", query = "SELECT c FROM CartProduct c WHERE c.productId = :productId"),
    @NamedQuery(name = "CartProduct.findByQuantity", query = "SELECT c FROM CartProduct c WHERE c.quantity = :quantity"),
    @NamedQuery(name = "CartProduct.findByPrice", query = "SELECT c FROM CartProduct c WHERE c.price = :price")})
public class CartProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "CART_ID")
    private Integer cartId;
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Column(name = "QUANTITY")
    private Integer quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;

    public CartProduct() {
    }

    public CartProduct(Integer id, Integer cartId, Integer productId, Integer quantity, Double price) {
        this.id = id;
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
    
    

    public CartProduct(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
        if (!(object instanceof CartProduct))
            return false;
        CartProduct other = (CartProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "entity.CartProduct[ id=" + id + " ]";
    }
    
}
