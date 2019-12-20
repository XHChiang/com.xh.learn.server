package com.xh.learn.website.webProducts.jmx;

import javax.management.Notification;

import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Service;

@Service
@ManagedResource(objectName="BS-SUPER:name=JMXService")
@ManagedNotification(notificationTypes="ten-multiple", name="NTFK")
public class JMXService implements IJmx, NotificationPublisherAware {

	private NotificationPublisher notificationPublisher;

	@Override
	public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
		this.notificationPublisher = notificationPublisher;
	}

	private int times = 0;

	private int flag = 0;
	
	@ManagedOperation
	public int plus(int para) {
		this.flag += para;

		if (this.flag % 10 == 0) {
			sendNotification("ten-multiple", "[PLUS] Integer multiple of 10");
		}

		return flag;
	}

	@ManagedOperation
	public int minus(int para) {
		this.flag -= para;

		if (this.flag % 10 == 0) {
			sendNotification("ten-multiple", "[MINUS] Integer multiple of 10");
		}

		return flag;
	}

	@ManagedOperation
	public int assignment(int flag) {
		this.flag = flag;

		if (this.flag % 10 == 0) {
			sendNotification("ten-multiple", "[ASSIGNMENT] Integer multiple of 10");
		}

		return flag;
	}

	/**
	 * 发送通知
	 * 
	 * @param name
	 * @param msg
	 */
	private void sendNotification(String type, String msg) {
		times += 1;
		notificationPublisher.sendNotification(new Notification(type, this, times, msg));
	}

}
