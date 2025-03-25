package com.stlang.store.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Accounts")
public class Account  implements Serializable {

    @Id
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String photo;

    @JsonIgnore
    @OneToMany (mappedBy = "account")
    private List<Authority> authorities;

    @JsonIgnore
    @OneToMany (mappedBy = "account")
    private List<Order> orders;

}
