package com.ynz.front.demothymeleaf.security;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserSecurityDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "LOGIN_NAME", length = 128, nullable = false, unique = true)
    private String loginName;

    @Column(name = "PASSWORD", length = 128, nullable = false)
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "USER_ROLE", joinColumns = @JoinColumn(name = "FK_USER_ID"))
    private Set<ROLE> roles = new HashSet<>();

    @Column(name = "ACCOUNT_NON_EXPIRED")
    private boolean accountNonExpired;

    @Column(name = "ACCOUNT_NON_LOCKED")
    private boolean accountNonLocked;

    @Column(name = "CREDENTIALS_NON_EXPIRED")
    private boolean credentialsNonExpired;

    @Column(name = "ENABLED")
    private boolean enabled;

    @Builder
    public UserSecurityDetails(String loginName, String password, Set<ROLE> roles) {
        this.loginName = loginName;
        this.password = password;
        this.roles = roles;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }
}
