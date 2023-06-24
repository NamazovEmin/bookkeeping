/*
 * Copyright (c) 2023, TopS BI LLC. All rights reserved.
 * http://www.topsbi.ru
 */

package az.namazov.bookkeeping.entity;

import java.util.Date;

import az.namazov.bookkeeping.controller.enums.Category;
import az.namazov.bookkeeping.controller.enums.Source;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "operations")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Operation {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "source", nullable = false)
    private Source source;

    @Column(name = "cost", nullable = false)
    private double cost;

    @Column(name = "details", nullable = false)
    private String details;

    @Column(name = "category", nullable = false)
    private Category category;
}
