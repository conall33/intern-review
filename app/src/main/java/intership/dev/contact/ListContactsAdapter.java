package intership.dev.contact;
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Filter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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
//					Intent goCotact = new Intent(mContext, Contact.class);
//					mContext.startActivity(goCotact);
					Fragment fragment_main = new Contact(mListContacts, position);
					FragmentManager fragmentManager = ((Activity) mContext).getFragmentManager();
					fragmentManager.beginTransaction().replace(R.id.frame_main, fragment_main).commit();
					fragmentManager.beginTransaction().addToBackStack(null);
				}
			});
		    
		    holder.mDelete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					AlertDialog.Builder mBui=new AlertDialog.Builder(mContext);
					mBui.setMessage("Are you sure you want to delete "+ people.getmName()+ " ?");
					mBui.setBa
					mBui.setPositiveButton("Yes", new DialogInterface. OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which){
							mListContacts.remove(position);
							notifyDataSetChanged();
						}});
					mBui.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
						public void onClick(DialogInterface dialog, int which){
							dialog.cancel();
						}
					});
					mBui.create().show();
				}
			});
    		
        return convertView;
	}
}
