/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chong
 */
@Entity
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description"),
    @NamedQuery(name = "Product.findByCategory", query = "SELECT p FROM Product p WHERE p.category = :category"),
    @NamedQuery(name = "Product.findByStatus", query = "SELECT p FROM Product p WHERE p.status = :status"),
    @NamedQuery(name = "Product.findByCreatedby", query = "SELECT p FROM Product p WHERE p.createdby = :createdby"),
    @NamedQuery(name = "Product.findByCreatedtime", query = "SELECT p FROM Product p WHERE p.createdtime = :createdtime"),
    @NamedQuery(name = "Product.findByUpdatedby", query = "SELECT p FROM Product p WHERE p.updatedby = :updatedby"),
    @NamedQuery(name = "Product.findByUpdatedtime", query = "SELECT p FROM Product p WHERE p.updatedtime = :updatedtime")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCT_ID")
    private Integer productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRICE")
    private Double price;
    @Size(max = 500)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 100)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 50)
    @Column(name = "STATUS")
    private String status;
    @Lob
    @Column(name = "IMAGE")
    private byte[] image;
    @Size(max = 50)
    @Column(name = "CREATEDBY")
    private String createdby;
    @Column(name = "CREATEDTIME")
    @Temporal(TemporalType.TIME)
    private Date createdtime;
    @Size(max = 50)
    @Column(name = "UPDATEDBY")
    private String updatedby;
    @Column(name = "UPDATEDTIME")
    @Temporal(TemporalType.TIME)
    private Date updatedtime;
    @OneToMany(mappedBy = "productId",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inventory> inventoryList;
    
     @Transient
    private int quantity;
    @Transient
    private String ImgPath;
    @Transient
    private int cartProductId;

    public Product() {
    }

    public Product(Integer productId, String name, Double price, String description, String category, String status, byte[] image, String createdby, Date createdtime) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.status = status;
        this.image = image;
        this.createdby = createdby;
        this.createdtime = createdtime;
    }

    public int getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(int cartProductId) {
        this.cartProductId = cartProductId;
    }
    
    
    
    

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImgPath() {
        return ImgPath;
    }

    public void setImgPath(String ImgPath) {
        this.ImgPath = ImgPath;
    }
    
    

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String name) {
        this.productId = productId;
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte [] getImage() {
        return image;
    }

    public void setImage(byte [] image) {
        this.image = image;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getUpdatedby() {
        return updatedby;
    }

    public void setUpdatedby(String updatedby) {
        this.updatedby = updatedby;
    }

    public Date getUpdatedtime() {
        return updatedtime;
    }

    public void setUpdatedtime(Date updatedtime) {
        this.updatedtime = updatedtime;
    }

    @XmlTransient
    public List<Inventory> getInventoryList() {
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product))
            return false;
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ productId=" + productId + " ]";
    }
    
}
