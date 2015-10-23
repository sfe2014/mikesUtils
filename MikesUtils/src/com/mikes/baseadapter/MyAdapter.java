package com.mikes.baseadapter;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikes.utils.R;

public class MyAdapter extends ABaseAdapter{
	private List<HashMap<String, String>> mDatas;
	
	public MyAdapter(Context context, List<HashMap<String, String>> datas) {
		super(context);//必须调用
		mDatas = datas;
	}

	@Override
	public int getCount() {
		return mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int itemLayoutRes() {
		return R.layout.layout_myadapter_item;//返回item布局resId
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent,
			ViewHolder holder) {
		HashMap<String, String> data = mDatas.get(position);
		TextView title = holder.obtainView(convertView, R.id.id_myadapter_title);
		return convertView;
	}
	
}
