package com.mikes.baseadapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class ABaseAdapter extends BaseAdapter {
	Context context;

	protected ABaseAdapter(Context context) {
		this.context = context;
	}

	protected ABaseAdapter() {
	}

	/**
	 * 各个控件的缓存
	 * 
	 * @author mikes
	 * 
	 */
	public class ViewHolder {
		public SparseArray<View> views = new SparseArray<View>();

		/**
		 * 指定resId和类型即可获取到相应的view
		 * 
		 * @param convertView
		 * @param resId
		 * @return
		 */
		public <T extends View> T obtainView(View convertView, int resId) {
			View v = views.get(resId);
			if (null == v) {
				v = convertView.findViewById(resId);
				views.put(resId, v);
			}

			return (T) v;
		}
	}

	/**
	 * 该方法需子类实现，返回item布局的resId
	 * 
	 * @return
	 */
	public abstract int itemLayoutRes();

	/**
	 * 该方法需子类实现,替换掉原来的getView
	 * 
	 * @param position
	 * @param convertView
	 * @param parent
	 * @param holder
	 * @return
	 */
	public abstract View getView(int position, View convertView,
			ViewGroup parent, ViewHolder holder);

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (null == convertView) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(itemLayoutRes(),
					null);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		return getView(position, convertView, parent, holder);
	}

}
