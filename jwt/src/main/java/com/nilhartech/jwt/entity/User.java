package com.nilhartech.jwt.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Audited
@AuditTable(value = "users_audit")
@Entity
@Table(name = "users")
public class User {

    @Id
    private int id;
    @Column(name = "user_name")
    private String userName;
    @NotAudited
    private String password;
    private String email;

}
