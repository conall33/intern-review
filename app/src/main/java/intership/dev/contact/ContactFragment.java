package intership.dev.contact;

import android.annotation.SuppressLint;
import android.widget.Button;
import android.app.Fragment;
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
class ContactFragment extends Fragment{
    int pos;
    ListContactsModel mModel;
    ListContactsData mContactData;
    ImageView mContactAvatar, mContact_img_left;
	TextView mContactName;
	EditText mContactEditName, mContactEditDecription;
	Button mContactSave,mContactCancel;
    ArrayList<ListContactsModel> mListContact;
    public ContactFragment(ArrayList<ListContactsModel> mArr, int pos){
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
        mContactEditName.setText(mListContact.get(pos).getmName());
        mContactEditDecription.setText(mListContact.get(pos).getmDecription());
        mContactName.setText(mContactEditName.getText().toString());
        mContactSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mName = mContactEditName.getText().toString();
                String mDecription = mContactEditDecription.getText().toString();
                mListContact.get(pos).setmName(mName);
                mListContact.get(pos).setmDecription(mDecription);
                getActivity().onBackPressed();
            }
        });
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
