package com.newProject.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "billing_master")
@Data
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bill_id")
    private Long billId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "total_amount")
    private float billAmt;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_quan")
    private Long billProductQuan;

    @Column(name = "bill_date")
    private LocalDate billDate;

    @Column(name = "is_cancelled")
    private boolean isCancelled;

}
