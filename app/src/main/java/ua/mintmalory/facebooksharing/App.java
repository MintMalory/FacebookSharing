package ua.mintmalory.facebooksharing;

import android.app.Application;

import com.vk.sdk.VKSdk;

/**
 * Created by Администратор on 28.10.2016.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VKSdk.initialize(getApplicationContext());
    }
}
