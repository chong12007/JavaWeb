/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author chong
 */
@Entity
@Table(name = "MANAGER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m"),
    @NamedQuery(name = "Manager.findByManagerId", query = "SELECT m FROM Manager m WHERE m.managerId = :managerId"),
    @NamedQuery(name = "Manager.findByName", query = "SELECT m FROM Manager m WHERE m.name = :name"),
    @NamedQuery(name = "Manager.findByEmail", query = "SELECT m FROM Manager m WHERE m.email = :email"),
    @NamedQuery(name = "Manager.findByPassword", query = "SELECT m FROM Manager m WHERE m.password = :password")})
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MANAGER_ID")
    private Integer managerId;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "managerId")
    private List<Staff> staffList;

    public Manager() {
    }

    public Manager(Integer managerId) {
        this.managerId = managerId;
    }

    public Manager(Integer managerId, String email, String password) {
        this.managerId = managerId;
        this.email = email;
        this.password = password;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (managerId != null ? managerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Manager))
            return false;
        Manager other = (Manager) object;
        if ((this.managerId == null && other.managerId != null) || (this.managerId != null && !this.managerId.equals(other.managerId)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "entity.Manager[ managerId=" + managerId + " ]";
    }
    
}
