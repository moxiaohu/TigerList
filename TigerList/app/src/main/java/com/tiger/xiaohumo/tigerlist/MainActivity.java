package com.tiger.xiaohumo.tigerlist;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.tiger.xiaohumo.tigerlist.adapters.NormalRecyclerViewAdapter;
import com.tiger.xiaohumo.tigerlist.objects.DreamObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends Activity {

    @Bind(R.id.dream_list)
    RecyclerView mRecyclerView;

    //sfsdggreifdkjshjfkfg//dsdfsdf/
    ////sfsdfsdfsf

    @Bind(R.id.input_dream)
    EditText edtTxtInputDream;

    public static ArrayList<DreamObject> list;
    private NormalRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new NormalRecyclerViewAdapter(this, list);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        mRecyclerView.setAdapter(adapter);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
//dfdfsfdsfsfs
        //fsfsfsfdfdssgfffff
        //dsfsfsfagadf fuck
    }

    @OnClick(R.id.input_ok)
    public void OnClickOK(){
        if (edtTxtInputDream.getText() != null){
            DreamObject dreamObject = new DreamObject();
            dreamObject.setFinished(false);
            dreamObject.setTitle(edtTxtInputDream.getText().toString());
            list.add(0, dreamObject);
            adapter.notifyItemInserted(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            //Remove swiped item from list and notify the RecyclerView

            adapter.removeItem(viewHolder.getPosition(), adapter);
        }
    };
}
