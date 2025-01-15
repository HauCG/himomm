package com.example.customerman.model;

import jakarta.persistence.*;
/**
 * 
 */
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "account_name", nullable = false)
    private String accountName;
    
    @Column(name = "account_password", nullable = false)
    private String accountPassword;
    
    @Column(name = "account_email")
    private String accountEmail;

    // Getter v` Setter
    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountEmail() {
        return accountEmail;
    }

    public void setAccountEmail(String accountEmail) {
        this.accountEmail = accountEmail;
    }
}