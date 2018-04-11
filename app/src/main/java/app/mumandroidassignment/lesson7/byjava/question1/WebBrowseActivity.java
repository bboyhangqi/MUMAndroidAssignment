package app.mumandroidassignment.lesson7.byjava.question1;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.mumandroidassignment.R;

public class WebBrowseActivity extends AppCompatActivity implements TabListener{

    private static final int POSITION_PERSONAL_SITE = 0 ;
    private static final int POSITION_MOIVE = 1 ;
    private static final int POSITION_SOFTWARE = 2 ;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        recyclerView=findViewById(R.id.rv_web);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ActionBar actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Personal Site").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Moive").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("Software").setTabListener(this));
        loadPersonalSiteData();
    }


    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        switch (tab.getPosition()){
            case POSITION_PERSONAL_SITE:
                loadPersonalSiteData();
                break;
            case POSITION_MOIVE:
                loadMoiveData();
                break;
            case POSITION_SOFTWARE:
                loadSoftwareData();
                break;
        }
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    private void loadPersonalSiteData(){
        WebInfo webInfo1 = new WebInfo("http://google.com",R.mipmap.google);
        WebInfo webInfo2 = new WebInfo("https://netflix.com",R.mipmap.netflix);
        WebInfo webInfo3 = new WebInfo("https://github.com",R.mipmap.github);
        WebInfo webInfo4 = new WebInfo("https://youtube.com",R.mipmap.youtube);
        WebInfo webInfo5 = new WebInfo("https://youku.com",R.mipmap.youku);
        List<WebInfo> webInfos = new ArrayList<>();
        webInfos.add(webInfo1);
        webInfos.add(webInfo2);
        webInfos.add(webInfo3);
        webInfos.add(webInfo4);
        webInfos.add(webInfo5);
        WebItemAdpter webItemAdpter = new WebItemAdpter(webInfos);
        recyclerView.setAdapter(webItemAdpter);
    }

    private void loadMoiveData(){
        WebInfo webInfo1 = new WebInfo("http://www.dailymotion.com/us",R.mipmap.dailymotion);
        WebInfo webInfo2 = new WebInfo("https://netflix.com",R.mipmap.netflix);
        WebInfo webInfo3 = new WebInfo("https://view.yahoo.com",R.mipmap.yahoo_screen);
        WebInfo webInfo4 = new WebInfo("https://youtube.com",R.mipmap.youtube);
        WebInfo webInfo5 = new WebInfo("https://youku.com",R.mipmap.youku);
        List<WebInfo> webInfos = new ArrayList<>();
        webInfos.add(webInfo4);
        webInfos.add(webInfo2);
        webInfos.add(webInfo5);
        webInfos.add(webInfo1);
        webInfos.add(webInfo3);
        WebItemAdpter webItemAdpter = new WebItemAdpter(webInfos);
        recyclerView.setAdapter(webItemAdpter);
    }

    private void loadSoftwareData(){
        WebInfo webInfo1 = new WebInfo("https://github.com",R.mipmap.github);
        WebInfo webInfo2 = new WebInfo("http://www.lintcode.com",R.mipmap.lintcode);
        WebInfo webInfo3 = new WebInfo("https://www.udemy.com",R.mipmap.udemy);
        WebInfo webInfo4 = new WebInfo("https://www.codecademy.com",R.mipmap.codecademy);
        WebInfo webInfo5 = new WebInfo("https://www.codeschool.com",R.mipmap.codeschool);
        List<WebInfo> webInfos = new ArrayList<>();
        webInfos.add(webInfo1);
        webInfos.add(webInfo2);
        webInfos.add(webInfo3);
        webInfos.add(webInfo4);
        webInfos.add(webInfo5);
        WebItemAdpter webItemAdpter = new WebItemAdpter(webInfos);
        recyclerView.setAdapter(webItemAdpter);
    }
}
