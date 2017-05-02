package com.android.benben.navigation;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.android.benben.library.TabContainerView;
import com.android.benben.library.adapter.DefaultAdapter;
import com.android.benben.navigation.adapter.ExampleOneAdapter;
import com.android.benben.navigation.adapter.ExampleTwoAdapter;
import com.android.benben.navigation.fragment.AppFragment;
import com.android.benben.navigation.fragment.MainFragment;
import com.android.benben.navigation.fragment.MineFragment;
import com.android.benben.navigation.fragment.WorkFragment;


public class MainActivity extends AppCompatActivity {

    private TabContainerView tabContainerView;
    private int[] iconImageArray, selectedIconImageArray;
    private Fragment[] fragments;

    private int[][] mIconArray;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initToolBar();
    }

    private void initView() {
        mIconArray = new int[][] {{R.drawable.icon_main, R.drawable.icon_main_selected}, {R.drawable.icon_work, R.drawable.icon_work_selected},
                {R.drawable.icon_app, R.drawable.icon_app_selected}, {R.drawable.icon_mine, R.drawable.icon_mine_selected}};

        iconImageArray = new int[]{R.drawable.icon_main, R.drawable.icon_work, R.drawable.icon_app, R.drawable.icon_mine};
        selectedIconImageArray = new int[]{R.drawable.icon_main_selected, R.drawable.icon_work_selected, R.drawable.icon_app_selected, R.drawable.icon_mine_selected};
        fragments = new Fragment[] {new MainFragment(), new WorkFragment(), new AppFragment(), new MineFragment()};

        tabContainerView = (TabContainerView) findViewById(R.id.tab_containerview_main);
        tabContainerView.setAdapter(new DefaultAdapter(this, fragments, getSupportFragmentManager(), getResources().getStringArray(R.array.titleArray),
                getResources().getColor(R.color.colorPrimary), iconImageArray, selectedIconImageArray));
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_bar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("TabContainerView");
        toolbar.inflateMenu(R.menu.base_toolbar_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.action_default) {
                    tabContainerView.setAdapter(new DefaultAdapter(MainActivity.this, fragments, getSupportFragmentManager(), getResources().getStringArray(R.array.titleArray),
                            getResources().getColor(R.color.colorPrimary), iconImageArray, selectedIconImageArray));
                }
                if(item.getItemId() == R.id.action_one) {
                    tabContainerView.setAdapter(new ExampleOneAdapter(MainActivity.this, fragments, getSupportFragmentManager(),
                            getResources().getStringArray(R.array.exampleOneArray)));
                }
                if(item.getItemId() == R.id.action_two) {
                    tabContainerView.setAdapter(new ExampleTwoAdapter(MainActivity.this, fragments, getSupportFragmentManager(),
                            mIconArray));
                }
                return true;
            }
        });
    }
}
