package com.example.texteditor28;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends Activity {
  TextView txFname, txFcontent;
  String path;
  EditText et;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    txFname = findViewById(R.id.tx_file_name);
    txFcontent = findViewById(R.id.tx_file_content);
    et = findViewById(R.id.et_file_content);
    path = Environment.getExternalStorageDirectory() + "/Vision_Data/vision.txt";
    // readFile(path);
    editFile(path);
  }

  public void readFile(String path) {
    File f = new File(path);
    if (f.exists()) {
      try {
        txFname.setText(f.getAbsolutePath());
        BufferedReader br = new BufferedReader(new FileReader(f));
        String l;
        try {
          while ((l = br.readLine()) != null) {
            txFcontent.append(l + "\n");
          }
          br.close();
        } catch (IOException e) {
          Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
      } catch (FileNotFoundException e) {
        Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
      }

    } else
      Toast.makeText(this, "File Path Not Found Or File Not Exists", Toast.LENGTH_SHORT).show();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    super.onOptionsItemSelected(item);
    if (item.getItemId() == R.id.action_save) {
      Toast.makeText(this, "Click Save:", Toast.LENGTH_SHORT).show();
      
    }
    return true;
  }

  public void editFile(String path) {
    File f = new File(path);
    String s;
    if (f.exists()) {
      try {
        txFname.setText(f.getAbsolutePath());
        BufferedReader br = new BufferedReader(new FileReader(f));
        String l;
        try {
          while ((l = br.readLine()) != null) {
            et.append(l + "\n");
          }
          br.close();
        } catch (IOException e) {
          Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }
      } catch (FileNotFoundException e) {
        Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
      }
    }
  }
}