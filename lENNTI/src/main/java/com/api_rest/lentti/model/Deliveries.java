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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 *
 */
@Entity
@Table(name = "deliveries")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Deliveries implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "delivery_document")
    @Getter
    @Setter
    private Long deliveryDocument;
    @Basic(optional = false)
    @Column(name = "name")
    @Getter @Setter
    private String name;
    @Basic(optional = false)
    @Column(name = "phone")
    @Getter @Setter
    private long phone;
    @Basic(optional = false)
    @Column(name = "address")
    @Getter @Setter
    private String address;
    @Basic(optional = false)
    @Column(name = "vehicle")
    @Getter @Setter
    private String vehicle;
    @Basic(optional = false)
    @Column(name = "Password")
    @Getter @Setter
    private String password;
    @Basic(optional = false)
    @Column(name = "email")
    @Getter @Setter
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryDocument")
    private Collection<Orders> ordersCollection;


    
}
