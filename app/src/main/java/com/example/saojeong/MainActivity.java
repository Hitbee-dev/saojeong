package com.example.saojeong;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.example.saojeong.fragment.PriceFragment;

import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.saojeong.fragment.HomeFragment;
import com.example.saojeong.fragment.MyPageFragment;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private HomeFragment homeFragment;
    private MyPageFragment myPageFragment;
    private PriceFragment priceFragment;

    private InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        homeFragment = new HomeFragment(); // 홈 Fragment 선언
        myPageFragment = new MyPageFragment(); // MyPage Fragment 선언
        priceFragment = new PriceFragment(); // 시세 Fragment 선언

        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        transaction.replace(R.id.frameLayout_main, homeFragment)
                .commitAllowingStateLoss(); //시작화면에 Home 띄우기
    }
    public void clickHandler(View view) {
        transaction = fragmentManager.beginTransaction();
        switch (view.getId())
        {
            case R.id.ll_home:
                    transaction.replace(R.id.frameLayout_main, homeFragment) // frameLayout에 홈 Fragment 호출
                            .commitAllowingStateLoss();
                break;

            case R.id.ll_price:
                transaction.replace(R.id.frameLayout_main, priceFragment) // frameLayout에 홈 Fragment 호출
                        .commitAllowingStateLoss();
                break;

            case R.id.ll_community:
                break;

            case R.id.ll_chatbot:
                break;

            case R.id.ll_myPage:
                transaction.replace(R.id.frameLayout_main, myPageFragment).commitAllowingStateLoss(); // frameLayout에 MyPage Fragment 호출
                break;
        }
    }

    public void replaceFragment(Fragment newFragment) {
        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frameLayout_main, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void signOut(View view) {
        Toast.makeText(view.getContext(),"test", Toast.LENGTH_LONG).show();
    }

    public void closeKeyBoard(View view) {
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}
