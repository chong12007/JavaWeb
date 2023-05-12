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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "STAFF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByStaffId", query = "SELECT s FROM Staff s WHERE s.staffId = :staffId"),
    @NamedQuery(name = "Staff.findByUsername", query = "SELECT s FROM Staff s WHERE s.username = :username"),
    @NamedQuery(name = "Staff.findByNickname", query = "SELECT s FROM Staff s WHERE s.nickname = :nickname"),
    @NamedQuery(name = "Staff.findByPassword", query = "SELECT s FROM Staff s WHERE s.password = :password"),
    @NamedQuery(name = "Staff.findByStaffRole", query = "SELECT s FROM Staff s WHERE s.staffRole = :staffRole"),
    @NamedQuery(name = "Staff.findByEmail", query = "SELECT s FROM Staff s WHERE s.email = :email"),
    @NamedQuery(name = "Staff.findByAddress", query = "SELECT s FROM Staff s WHERE s.address = :address"),
    @NamedQuery(name = "Staff.findByPhonenumber", query = "SELECT s FROM Staff s WHERE s.phonenumber = :phonenumber"),
@NamedQuery(name = "Staff.countAll", query = "SELECT COUNT(s) FROM Staff s")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "STAFF_ID")
    private Integer staffId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 50)
    @Column(name = "NICKNAME")
    private String nickname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "STAFF_ROLE")
    private String staffRole;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @Size(max = 20)
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "MANAGER_ID")
    @ManyToOne
    private Manager managerId;

    public Staff() {
    }

    public Staff(Integer staffId) {
        this.staffId = staffId;
    }

    public Staff(String username, String password, String staffRole) {
        this.username = username;
        this.password = password;
        this.staffRole = staffRole;
    }

    public Staff(Integer staffId, String username, String password, String staffRole, Manager managerId) {
        this.staffId = staffId;
        this.username = username;
        this.password = password;
        this.staffRole = staffRole;
        this.managerId = managerId;
    }

    public Staff(Integer staffId, String username, String nickname, String password, String staffRole, String email, String address, String phonenumber, Manager managerId) {
        this.staffId = staffId;
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.staffRole = staffRole;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
        this.managerId = managerId;
    }

    public Staff(String nickname, String password, String email, String address, String phonenumber) {
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.address = address;
        this.phonenumber = phonenumber;
    }

    public Staff(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    
    

    public Staff(Integer staffId, String username, String password, String staffRole) {
        this.staffId = staffId;
        this.username = username;
        this.password = password;
        this.staffRole = staffRole;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(String staffRole) {
        this.staffRole = staffRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Manager getManagerId() {
        return managerId;
    }

    public void setManagerId(Manager managerId) {
        this.managerId = managerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffId != null ? staffId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff))
            return false;
        Staff other = (Staff) object;
        if ((this.staffId == null && other.staffId != null) || (this.staffId != null && !this.staffId.equals(other.staffId)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "entity.Staff[ staffId=" + staffId + " ]";
    }
    
}
