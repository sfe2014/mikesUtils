package com.mikes.event;

import de.greenrobot.event.EventBus;

/**
 * 事件发布
 * @author mikes
 *
 */
public class MyPublishActivity {
	public void publishEvent(){
		EventBus.getDefault().post(new MyEvent());//发布事件
	}
}
