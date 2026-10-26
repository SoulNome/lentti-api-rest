/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api_rest.lentti.model;

import lombok.*;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 *
 */
@Entity
@Table(name = "products")
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Products implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_product")
    @Getter
    @Setter
    private Integer idProduct;
    @Basic(optional = false)
    @Column(name = "price")
    @Getter @Setter
    private double price;
    @Basic(optional = false)
    @Column(name = "name")
    @Getter @Setter
    private String name;
    @Basic(optional = false)
    @Column(name = "company")
    @Getter @Setter
    private String company;


}
