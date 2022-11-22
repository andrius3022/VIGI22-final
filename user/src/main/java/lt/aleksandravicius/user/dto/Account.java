package lt.aleksandravicius.user.dto;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table (name = "user_accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Account account;

    @NotBlank (message = "Enter account name")
    private String accName;

    private String vipStatus;

    @UpdateTimestamp
    private Date updatedAt;


    public Account() {
    }

    public Account(String accName, String vipStatus, Date updatedAt) {
        this.accName = accName;
        this.vipStatus = vipStatus;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(String status) {
        this.vipStatus = status;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    }

