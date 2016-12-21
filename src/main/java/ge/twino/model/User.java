package ge.twino.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "USERS")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String name;
    private String phoneNumber;
    private Date birthday;
    private BigDecimal salary;
    private BigDecimal liabilities;
    @Column(nullable = false)
    private String password;
    private String username;
    private Date creationDate;
    private Date lastModifiedDate;
    private BigDecimal limits;
    private boolean birthdayChanged;
    @Enumerated(EnumType.STRING)
    public ImageVisibilityMode imageVisibilityMode;

    @Column(nullable = true, columnDefinition = "VARBINARY(MAX)")
    private byte[] image;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Role> roles = new HashSet<>();



    @PrePersist
    void updateCreatedDate() {
        this.creationDate = new Date();
    }

    @PreUpdate
    void updateLastModifiedDate() {
        this.lastModifiedDate = new Date();
    }


    public User(){

    }

/*
    public User() {
        this.salary = BigDecimal.ZERO;
        this.liabilities = BigDecimal.ZERO;
        this.limits = BigDecimal.ZERO;
    }*/



    public boolean isBirthdayChanged() {
        return birthdayChanged;
    }

    public void setBirthdayChanged(boolean birthdayChanged) {
        this.birthdayChanged = birthdayChanged;
    }

    public ImageVisibilityMode getImageVisibilityMode() {
        return imageVisibilityMode;
    }

    public void setImageVisibilityMode(ImageVisibilityMode imageVisibilityMode) {
        this.imageVisibilityMode = imageVisibilityMode;
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

    public BigDecimal getLimits() {
        return limits;
    }

    public void setLimits(BigDecimal limits) {
        this.limits = limits;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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


}