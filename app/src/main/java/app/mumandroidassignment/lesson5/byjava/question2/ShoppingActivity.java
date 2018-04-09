package app.mumandroidassignment.lesson5.byjava.question2;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.mumandroidassignment.R;
import app.mumandroidassignment.lesson5.bykotlin.question2.bean.Product;

/**
 * Created by CodingHome on 4/8/18.
 */

public class ShoppingActivity extends AppCompatActivity implements ActionBar.TabListener {

    private LinearLayout rootLayout;
    private static final int POSITION_ELECTRONICS = 0;
    private static final int POSITION_CLOTHING = 1;
    private static final int POSITION_BEAUTY = 2;
    private static final int POSITION_FOOD = 3;
    private static final int POSITION_LOGOUT = 4;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping2);
        rootLayout = findViewById(R.id.root);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Shopping");
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Electronics").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Clothing").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Beauty").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Food").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Logout").setTabListener(this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_lesson5, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        int position = tab.getPosition();
        switch (position) {
            case POSITION_ELECTRONICS:
                loadElectronicView();
                break;
            case POSITION_CLOTHING:
                loadClothingView();
                break;
            case POSITION_BEAUTY:
                loadBeautyView();
                break;
            case POSITION_FOOD:
                loadFoodView();
                break;
            case POSITION_LOGOUT:
                handleLogout();
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }


    private void loadElectronicView() {
        View view = getLayoutInflater().inflate(R.layout.activity_electronic, rootLayout, false);
        RecyclerView rv = view.findViewById(R.id.rv_products);
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<Product> list = new ArrayList<>();
        list.add(new Product("RGA Voyager 7 16GB Android Tablet", 35.0f, "Black", "http://www.pcmuseum.ca/gallery/0610-02-750.JPG", "555948101",
                "Introducing the RGA Voyager 7-inch Google Certified Table"));
        list.add(new Product("HP Flyer Red 15.6 Latop", 299.0f, "Black & Red", "https://ssl-product-images.www8-hp.com/digmedialib/prodimg/lowres/c05474585.png", "555948102",
                "Introducing the HP Flyer Red 1298.6-inch Laptop"));
        list.add(new Product("VIZIO 70 Class 4K", 35.0f, "Black", "https://pisces.bbystatic.com/image2/BestBuy_US/images/products/5947/5947110_sd.jpg", "555948103",
                "Introducing the VIZIO 70 Class 4K TV"));
        list.add(new Product("Epson WorkForce WF-2750", 69.0f, "Black", "https://assets.pcmag.com/media/images/472712-epson-expression-et-2750-ecotank-all-in-one-supertank-printer.jpg", "555948104",
                "Introducing the Epson WorkForce WF-2750 Printer"));
        ElectronicAdpter adpter = new ElectronicAdpter(list);
        rv.setAdapter(adpter);
        addView(view);
    }

    private void loadClothingView() {
        View view = getLayoutInflater().inflate(R.layout.activity_clothing, rootLayout, false);
        ListView lv = view.findViewById(R.id.lv_clothing);
        String[] clothingList = getResources().getStringArray(R.array.clothing);
        ArrayAdapter arrayAdapt = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, clothingList);
        lv.setAdapter(arrayAdapt);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ShoppingActivity.this, "select item: " + parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }
        });
        addView(view);
    }

    private void loadBeautyView() {
        View view = getLayoutInflater().inflate(R.layout.activity_beauty, rootLayout, false);
        addView(view);
    }

    private void loadFoodView() {
        View view = getLayoutInflater().inflate(R.layout.activity_food, rootLayout, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_foods);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleFoodAdpter simpleFoodAdpter = new SimpleFoodAdpter(getResources().getStringArray(R.array.food));
        recyclerView.setAdapter(simpleFoodAdpter);
        addView(view);
    }

    private void handleLogout(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Do you want to Exit ?");
        alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        alertDialogBuilder.show();
        rootLayout.removeAllViews();
    }


    private void addView(View view) {
        rootLayout.removeAllViews();
        rootLayout.addView(view);
    }


}
