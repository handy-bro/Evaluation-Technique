package com.handy.evaluation.subscriptions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    public List<Subscription> getAllSubscriptions(){
        return subscriptionRepository.findAll();
    }

    public Optional<Subscription> getSubscriptionsById(String id){
        return subscriptionRepository.findById(id);
    }

    public Subscription saveSubscriptions(Subscription subscription){
        return subscriptionRepository.save(subscription);
    }

    public Subscription save(Subscription subscriptionDetails){
        var subscription = Subscription.builder()
                .date(LocalDate.now())
                .startingDate(subscriptionDetails.getStartingDate())
                .endingDate(subscriptionDetails.getEndingDate())
                .totalAmount(subscriptionDetails.getTotalAmount())
                .refProduct(subscriptionDetails.getRefProduct())
                .refUser(subscriptionDetails.getRefUser())
                .build();
        subscriptionRepository.save(subscription);
        return subscription;
    }

    public void deleteSubscriptions(String id){
        subscriptionRepository.deleteById(id);
    }

    public Subscription updateSubscriptions(String id, Subscription subscriptionDetails){
        Subscription subscription = getSubscriptionsById(id).orElseThrow(() -> new RuntimeException("subscription not found"));
        subscription.setDate(subscriptionDetails.getDate());
        subscription.setStartingDate(subscriptionDetails.getStartingDate());
        subscription.setEndingDate(subscriptionDetails.getEndingDate());
        subscription.setTotalAmount(subscriptionDetails.getTotalAmount());
        subscription.setRefProduct(subscriptionDetails.getRefProduct());
        subscription.setRefUser(subscriptionDetails.getRefUser());
        return subscriptionRepository.save(subscription);
    }
}
