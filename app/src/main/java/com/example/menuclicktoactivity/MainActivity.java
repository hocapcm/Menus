package com.example.menuclicktoactivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {


    Button btnPopupMenu,btnContextMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPopupMenu = (Button) findViewById(R.id.btnPopupMenu);
        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopupMenu();
            }
        });

        btnContextMenu = (Button) findViewById(R.id.btnContextMenu);
        // đăng ký view cho context menu
        registerForContextMenu(btnContextMenu);

    }

    private void ShowPopupMenu(){
        PopupMenu popupMenu = new PopupMenu(this,btnPopupMenu);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.m2Them:
                        openThem();
                        break;
                    case R.id.m2Xoa:
                        openXoa();
                        break;
                    case R.id.m2Sua:
                        openSua();
                        break;
                }

                return false;
            }
        });
        popupMenu.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.m1Search:
                openSearch();
                break;
            case R.id.m1Setting:
                openSetting();
                break;
            case R.id.m1Share:
                openShare();
                break;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu1, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu1);


        super.onCreateContextMenu(menu1, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.m3Vang:
                openVang();
                break;
            case R.id.m3Xanh:
                openXanh();
                break;
            case R.id.m3Do:
                openDo();
                break;
        }

        return super.onContextItemSelected(item);
    }

    public void openSetting(){
        Intent intent = new Intent(this,Activity_Setting.class);
        startActivity(intent);
    }
    public void openShare(){
        Intent intent = new Intent(this,Activity_Share.class);
        startActivity(intent);
    }
    public void openSearch(){
        Intent intent = new Intent(this,Activity_Search.class);
        startActivity(intent);
    }
    public void openThem(){
        Intent intent = new Intent(this,Activity_Them.class);
        startActivity(intent);
    }
    public void openXoa(){
        Intent intent = new Intent(this,Activity_Xoa.class);
        startActivity(intent);
    }
    public void openSua(){
        Intent intent = new Intent(this,Activity_Sua.class);
        startActivity(intent);
    }
    public void openVang(){
        Intent intent = new Intent(this,Activity_Vang.class);
        startActivity(intent);
    }
    public void openXanh(){
        Intent intent = new Intent(this,Activity_Xanh.class);
        startActivity(intent);
    }
    public void openDo(){
        Intent intent = new Intent(this,Activity_Do.class);
        startActivity(intent);
    }


}