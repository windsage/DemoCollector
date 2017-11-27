package org.jeff.binderclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.jeff.binder.IMyAidlInterface;


public class MainActivity extends AppCompatActivity {
    IMyAidlInterface iMyAidlInterface;

    private TextView aidl;
    boolean mIsBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        intent.setAction("org.jeff.binder.aidl");
        intent.setPackage("org.jeff.binderservice");
//        intent.setComponent(new ComponentName(this, "org.jeff.binderservice.MyService"));
        bindService(intent, conn, BIND_AUTO_CREATE);
        aidl = findViewById(R.id.aidl);
        aidl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add(v);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑服务，回收资源
        unbindService(conn);
    }


    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(getClass().getSimpleName(),"onServiceConnected");
            iMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
            mIsBind = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iMyAidlInterface = null;
        }
    };

    public void add(View view) {
        try {
            Log.e(getClass().getSimpleName(), String.valueOf(mIsBind));
            if (mIsBind) {
                int res = iMyAidlInterface.add(1, 2);
                Log.e(getClass().getSimpleName(), "从服务端调用成功的结果：" + res);
            }
        } catch (RemoteException e) {
            Log.e(getClass().getSimpleName(), e.getMessage());
        }
    }

}
