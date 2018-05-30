package pl.kuba.systemyprojekt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class MainActivity extends AppCompatActivity {

    private MyBluetooth myBluetooth;
    private Button openButton;
    private Button closeButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openButton = (Button)findViewById(R.id.open);
        closeButton = (Button)findViewById(R.id.close);
        textView = (TextView)findViewById(R.id.textView);
        myBluetooth = new MyBluetooth(getApplicationContext(), textView );
    }

    public void click(View view) {
        if(view == openButton) {
            try {
                myBluetooth.findBT();
                myBluetooth.openBT();
            }
            catch(IOException e){}
        }

        if(view == closeButton) {
            try {
                myBluetooth.closeBT();
            }
            catch(IOException e){}
        }
    }
}

