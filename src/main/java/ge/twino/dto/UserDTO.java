package ge.twino.dto;

import ge.twino.model.ImageVisibilityMode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by SHEMO on 12/21/2016.
 */
public class UserDTO {

    private Long id;
    private String name;
    private String phoneNumber;
    private Date birthday;
    private BigDecimal salary;
    private BigDecimal liabilities;
    private String username;
    private Date creationDate;
    private Date lastModifiedDate;
    private BigDecimal limits;
    public ImageVisibilityMode imageVisibilityMode;


    /*private byte[] image;*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(BigDecimal liabilities) {
        this.liabilities = liabilities;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public BigDecimal getLimits() {
        return limits;
    }

    public void setLimits(BigDecimal limits) {
        this.limits = limits;
    }

    public ImageVisibilityMode getImageVisibilityMode() {
        return imageVisibilityMode;
    }

    public void setImageVisibilityMode(ImageVisibilityMode imageVisibilityMode) {
        this.imageVisibilityMode = imageVisibilityMode;
    }
}
