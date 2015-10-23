package com.mikes.event;

import de.greenrobot.event.EventBus;
import android.app.Activity;
import android.app.usage.UsageEvents.Event;
import android.os.Bundle;

/**
 * 事件订阅
 * @author mikes
 *
 */
public class MySubscriberActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EventBus.getDefault().register(this);//订阅事件
	}
	
	
	@Override
	protected void onDestroy() {
		EventBus.getDefault().unregister(this);//取消订阅事件
	};
	
}
