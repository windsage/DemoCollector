package org.jeff.binderservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import org.jeff.binder.IMyAidlInterface;

public class MyService extends Service {
    public MyService() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(getClass().getSimpleName(), "Service Create");
    }

    private IBinder mIBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public int add(int num1, int num2) throws RemoteException {
            Log.e(getClass().getSimpleName(), "从客户端发来的AIDL请求:num1->" + num1 + "::num2->" + num2);
            return num1 + num2;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mIBinder;
    }
}
