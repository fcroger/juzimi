package com.example.dabutaizha.lines.mvp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dabutaizha.lines.ActivityManager;
import com.example.dabutaizha.lines.R;
import com.example.dabutaizha.lines.ResUtil;
import com.example.dabutaizha.lines.TimeUtil;
import com.example.dabutaizha.lines.databinding.ActivityMainBinding;
import com.example.dabutaizha.lines.mvp.adapter.TabAdapter;
import com.example.dabutaizha.lines.mvp.contract.MainActivityContract;

import java.util.List;

public class MainActivity extends BaseActivity implements MainActivityContract.View {

    private ActivityMainBinding activityMainBinding;

    private TextView mAddSentences;
    private TextView mAccountInfo;
    private TabAdapter mTabAdapter;
    private ImageView mNavHeaderBackground;

    private MainActivityContract.Presenter mPresenter;


    /**
     *Description: 双击退出
     */
    @Override
    public void onBackPressed() {
        if (TimeUtil.checkDoubleClick()) {
            super.onBackPressed();
            ActivityManager.finishAllActivities();
        } else {
            showMessage(ResUtil.getString(R.string.click_finish));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
    }

    @Override
    protected void initViewListener() {

    }

    @Override
    protected void initTheme(int themeId) {

    }

    @Override
    protected void process() {

    }

    @Override
    protected int getPageLayoutID() {
        return 0;
    }

    @Override
    public void setSelectPage(int item) {

    }

    @Override
    public void setTab(List<Fragment> fragmentList, String[] titles) {

    }

    @Override
    public void showUpdateDialog(Bundle bundle) {

    }

    @Override
    public void refreshView(int collectSize) {

    }

    @Override
    public void showMessage(String msg) {

    }
}