package intership.dev.contact;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.NumberPicker;

import java.util.ArrayList;
/**
 * Created by conal_000 on 7/23/2015.
 */
public class ListContactsFragment extends Fragment{
    private ListContactsAdapter mAdapter;
    private ArrayList<ListContactsModel> mContacts;
    private ListView mListview;
    private ImageView mBack;
    private boolean isLoading = false;
    private ProgressDialog mProgressDialog;
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
        mListview.setOnScrollListener(new AbsListView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView arg0, int arg1) {

            }

            @Override
            public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
                // TODO event when scroll last item
                if (arg1 + arg2 == arg3) {
                    if (!isLoading) {
                        new LoadMoreContacts().execute();
                    }
                }
            }
        });
        mBack = (ImageView) v.findViewById(R.id.img_left);
        mListview.setAdapter(mAdapter);

        return v;
    }
    private class LoadMoreContacts extends AsyncTask<Void, ListContactsModel, Void> {
        public LoadMoreContacts() {
        // TODO construct
        isLoading = true;
        }
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setTitle("Load More Item");
            mProgressDialog.setMessage("Loading more...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... params) {
            // TODO load more contacts
            ArrayList<ListContactsModel> newList = getMore(mContacts.size());
            if (newList.size() == 0){
                isLoading = false;
                return null;
            }

            SystemClock.sleep(2000);
            for (ListContactsModel contact : newList) {
                publishProgress(contact);
            }
            isLoading = false;
            return null;
        }
        @Override
        protected void onProgressUpdate(ListContactsModel... values) {
           // TODO update contacts to contacts list
            mContacts.add(values[0]);
            mAdapter.notifyDataSetChanged();
            super.onProgressUpdate(values);
            mProgressDialog.dismiss();
            }
    }
    public ArrayList<ListContactsModel> getMore(int size){
        // TODO get contact to show in contacts list
        //contacts list get 8 contacts
        if (size == 0){
            for (int i = 0; i < 8; i++){
                mContacts.add(mContacts.get(i));
            }
            } else {
            if (size < mContacts.size()){
                mContacts.add(mContacts.get(8));
            }
            if (size + 1 < mContacts.size()){
                mContacts.add(mContacts.get(8));
            }
        }
        return mContacts;
    }

}
