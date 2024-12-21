package com.handy.evaluation.subscriptions;

import com.handy.evaluation.products.Product;
import com.handy.evaluation.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String id;
    private LocalDate date;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private String totalAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product refProduct;

    @ManyToOne(fetch = FetchType.EAGER)
    private User refUser;
}
