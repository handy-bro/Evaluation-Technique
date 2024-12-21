package com.handy.evaluation.subscriptions;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {
    private final SubscriptionService service;

    @PostMapping("/add")
    public Subscription createSubscription(@RequestBody Subscription subscription){
        return service.saveSubscriptions(subscription);
    }

    @GetMapping
    public List<Subscription> getSubscriptions(){
        return service.getAllSubscriptions();
    }

    @GetMapping("/{id}")
    public Subscription getSubscriptionById(@PathVariable String id){
        return service.getSubscriptionsById(id).orElseThrow(() -> new RuntimeException("subscription not found"));
    }

    @PutMapping("/{id}")
    public Subscription updateSubscription(@PathVariable String id, @RequestBody Subscription subscription){
        return service.updateSubscriptions(id, subscription);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable String id){
        service.deleteSubscriptions(id);
    }
}
