package intership.dev.contact;
import org.w3c.dom.Text;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

@SuppressLint("NewApi")
class Contact extends Fragment{
    int pos;
    ImageView mContactAvatar, mContact_img_left;
	TextView mContactName;
	EditText mContactEditName, mContactEditDecription;
	Button mContactSave,mContactCancel;
    ArrayList<ListContactsModel> mListContact;
    public Contact(ArrayList<ListContactsModel> mArr, int pos){
        this.mListContact=mArr;
        this.pos=pos;
    }
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		View v = inflater.inflate(R.layout.contact_fragment, container, false);
        mContact_img_left = (ImageView) v.findViewById(R.id.contact_fragment_img_left);
		mContactAvatar = (ImageView) v.findViewById(R.id.contact_avatar);
		mContactName = (TextView) v.findViewById(R.id.contact_name);
		mContactEditName = (EditText) v.findViewById(R.id.contact_editname);
		mContactEditDecription = (EditText) v.findViewById(R.id.contact_editdecription);
		mContactSave = (Button) v.findViewById(R.id.contact_bntsave);
		mContactCancel = (Button) v.findViewById(R.id.contact_bntcancel);

        mContactAvatar.setImageResource(mListContact.get(pos).getmAvtar());
        mContactName.setText(mListContact.get(pos).getmName());
        mContactEditName.setText(mListContact.get(pos).getmName());
        mContactEditDecription.setText(mListContact.get(pos).getmDecription());

        mContact_img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            getActivity().onBackPressed();
            }
        });

        mContactCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
		return v;
	}
}
