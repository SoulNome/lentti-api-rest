/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api_rest.lentti.model;

import lombok.*;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 *
 */
@Entity
@Table(name = "users")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_document")
    @Getter
    @Setter
    private Long userDocument;
    @Basic(optional = false)
    @Column(name = "name")
    @Getter @Setter
    private String name;
    @Basic(optional = false)
    @Column(name = "phone")
    @Getter @Setter
    private long phone;
    @Basic(optional = false)
    @Column(name = "password")
    @Getter @Setter
    private String password;
    @Basic(optional = false)
    @Column(name = "email")
    @Getter @Setter
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userDocument")
    private Collection<Orders> ordersCollection;

}
