package com.turkcell.elearner.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "account_types")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AccountType {

    @Id
    @Column(name = "accountTypeId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountTypeId;

    @Column(name = "accountName")
    private String accountName;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;
}
