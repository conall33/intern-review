package intership.dev.contact;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity{
    ListContactsAdapter mAdapter;
    ArrayList<ListContactsModel> mContacts;
    ListView mListview;
    ImageView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContacts = new ArrayList<ListContactsModel>();
        int i = 0;
        while (i < ListContactsData.getName().length) {
            ListContactsModel mContactsModel = new ListContactsModel(ListContactsData.getName()[i], ListContactsData.getAvatar()[i], ListContactsData.getDecription()[i]);
            mContacts.add(mContactsModel);
            i++;
        }

        mListview = (ListView) findViewById(R.id.list_contacts);
        mAdapter = new ListContactsAdapter(this, mContacts);

        mBack = (ImageView) findViewById(R.id.img_left);
        mListview.setAdapter(mAdapter);

        mBack.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();

            }
        });
    }

}

