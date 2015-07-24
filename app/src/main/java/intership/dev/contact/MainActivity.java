package intership.dev.contact;

import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Activity;
import java.util.ArrayList;

public class MainActivity extends Activity{
    ArrayList<ListContactsModel> mContacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContacts = new ArrayList<>();
        int i = 0;
        while (i < ListContactsData.getName().length) {
            ListContactsModel mContactsModel = new ListContactsModel(ListContactsData.getName()[i], ListContactsData.getAvatar()[i], ListContactsData.getDecription()[i]);
            mContacts.add(mContactsModel);
            i++;
        }
        setUpFragment();
    }
    void setUpFragment(){
        ListContactsFragment listcontacts_fragment = new ListContactsFragment(mContacts);
        FragmentManager fragmentManager = this.getFragmentManager();
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_fragment, listcontacts_fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }




}

