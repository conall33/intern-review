package intership.dev.contact;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.app.Activity;
public class MainActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listcontacts_fragment);
        setUpFragment();
    }
    void setUpFragment(){
        ListContactsFragment listcontacts_fragment = new ListContactsFragment();
        FragmentManager fragmentManager = this.getFragmentManager();
        android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_fragment, listcontacts_fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }




}

