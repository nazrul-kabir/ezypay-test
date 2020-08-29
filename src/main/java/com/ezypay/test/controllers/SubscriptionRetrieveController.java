package com.ezypay.test.controllers;

import java.util.List;

import com.ezypay.test.beans.SubscriptionRegistration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezypay.test.beans.Subscription;

@Controller
public class SubscriptionRetrieveController {
//	Get Method
	@RequestMapping(method = RequestMethod.GET, value="/subscription")
	@ResponseBody
	public List<Subscription> getStudent() {
		return SubscriptionRegistration.getInstance().getSubscriptionRecords();
	}


//	Post Method
	@RequestMapping(method = RequestMethod.POST, value="/subscription")
	@ResponseBody
	Subscription registerSubscription(@RequestBody Subscription subscription) {
		Subscription subscriptions = new Subscription();
		SubscriptionRegistration.getInstance().add(subscription);
		//We are setting the below value just to reply a message back to the caller
		subscriptions.setAmount(subscription.getAmount());
		subscriptions.setType(subscription.getType());
		subscriptions.setDays(subscription.getDays());
		subscriptions.setStartDate(subscription.getStartDate());
		subscriptions.setEndDate(subscription.getEndDate());
		return subscriptions;
	}

}
