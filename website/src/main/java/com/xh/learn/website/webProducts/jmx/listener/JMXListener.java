package com.xh.learn.website.webProducts.jmx.listener;

import javax.management.Notification;
import javax.management.NotificationListener;

import org.springframework.stereotype.Component;

@Component
public class JMXListener implements NotificationListener {

	@Override
	public void handleNotification(Notification notification, Object handback) {
		System.out.println("I am receiver... [" + notification.getType() + "][" + notification.getMessage() + "]");
	}

}
