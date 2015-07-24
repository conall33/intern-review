package intership.dev.contact;
import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListContactsAdapter extends BaseAdapter {
	
	Context mContext;
	ArrayList<ListContactsModel> mListContacts=new ArrayList<ListContactsModel>();
	/**
	 * 
	 * @param mContext
	 * @param arr
	 */
	public ListContactsAdapter(Context mContext, ArrayList<ListContactsModel> arr){
		
		this.mContext=mContext;
		this.mListContacts=arr;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListContacts.size();
	}

	@Override
	public ListContactsModel getItem(int position) {
		// TODO Auto-generated method stub
		return mListContacts.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	
	public class ViewHolder {
		ImageView mAvatar;
		TextView mName;
		ImageView mEdit;
		ImageView mDelete;
	}
	
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		final ViewHolder holder;
		if (convertView == null) {
				
            convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_contacts, parent, false);
            holder = new ViewHolder();            
            holder.mAvatar = (ImageView) convertView.findViewById(R.id.img_avatar);
            holder.mName = (TextView) convertView.findViewById(R.id.txt_name);
            holder.mEdit = (ImageView) convertView.findViewById(R.id.img_edit);
            holder.mDelete = (ImageView) convertView.findViewById(R.id.img_delete);                    
            convertView.setTag(holder);
        } else {        	
            holder = (ViewHolder) convertView.getTag();
        }
			final ListContactsModel people= getItem(position);
			holder.mAvatar.setImageResource(people.getmAvtar());
		    holder.mName.setText(people.getmName());
		    holder.mEdit.setImageResource(R.drawable.icon_edit);
		    holder.mDelete.setImageResource(R.drawable.icon_detele);
		    
		    holder.mEdit.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					ContactFragment contact_fragment = new ContactFragment(mListContacts,position);
					FragmentManager fragmentManager = ((Activity) mContext).getFragmentManager();
					FragmentTransaction transaction = fragmentManager.beginTransaction();
					transaction.replace(R.id.frame_fragment, contact_fragment);
					transaction.addToBackStack(null);
					transaction.commit();
					notifyDataSetChanged();
				}
			});
		    
		    holder.mDelete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					final Dialog mDi = new Dialog(mContext);
					mDi.setContentView(R.layout.dialog_layout);
					TextView txt_title = (TextView)mDi.findViewById(R.id.dialog_txt);
					txt_title.setText("Are you sure you want to delete " + people.getmName() + " ?");
					Button bnt_ok = (Button) mDi.findViewById(R.id.btn_ok);
					bnt_ok.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View view) {
							mListContacts.remove(position);
							notifyDataSetChanged();
							mDi.dismiss();
						}
					});
					Button bnt_cancel = (Button) mDi.findViewById(R.id.bnt_cancel);
					bnt_cancel.setOnClickListener(new OnClickListener() {
						@Override
						public void onClick(View view) {
							mDi.dismiss();
						}
					});
					mDi.show();
				}
			});
    		
        return convertView;
	}
}
