package com.xh.learn.website.webProducts.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class DemoTask implements SchedulingConfigurer {
//	private static Logger logger = LoggerFactory.getLogger(DemoTask.class);

//	private static String cron = "0/5 * * * * ?";

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//		Runnable runnable = new Runnable() {
//			@Override
//			public void run() {
//				logger.debug("runnable.....");
//			}
//		};
//
//		Trigger trigger = new Trigger() {
//			@Override
//			public Date nextExecutionTime(TriggerContext triggerContext) {
//				Date nextExec = new CronTrigger(cron).nextExecutionTime(triggerContext);
//				return nextExec;
//			}
//		};
//
//		taskRegistrar.addTriggerTask(runnable, trigger);
	}

}
