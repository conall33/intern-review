package intership.dev.contact;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
/**
 * Created by conal_000 on 7/23/2015.
 */
public class ListContactsFragment extends Fragment{
    ListContactsAdapter mAdapter;
    ArrayList<ListContactsModel> mContacts;
    ListView mListview;
    ImageView mBack;
    public ListContactsFragment(ArrayList<ListContactsModel> arr){
        super();
        this.mContacts=arr;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        View v = inflater.inflate(R.layout.listcontacts_fragment, container, false);

        mListview = (ListView) v.findViewById(R.id.list_contacts);
        mAdapter = new ListContactsAdapter(getActivity(), mContacts);

        mBack = (ImageView) v.findViewById(R.id.img_left);
        mListview.setAdapter(mAdapter);

        mBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                getActivity().finish();
            }
        });

        return v;
    }
}
