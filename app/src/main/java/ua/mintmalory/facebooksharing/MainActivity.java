package ua.mintmalory.facebooksharing;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareButton;
import com.facebook.share.widget.ShareDialog;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.model.VKApiPhoto;
import com.vk.sdk.api.model.VKPhotoArray;
import com.vk.sdk.dialogs.VKShareDialogBuilder;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_main);

        AppEventsLogger.activateApp(this);
        facebookCode();
        vkCode();
    }


    private void vkCode() {
      /*/////////////////////////////////////////////////////////////////////////////////////////////
        code for getting Key hash for Android-VK app
        /////////////////////////////////////////////////////////////////////////////////////////////
        String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        Log.e("hash key", Arrays.deepToString(fingerprints));*/

        Button vk_button = (Button) findViewById(R.id.vk_share_button);
        vk_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!VKSdk.isLoggedIn()) {
                    VKSdk.login(MainActivity.this, new String[]{VKScope.WALL});
                }

                VKPhotoArray photos = new VKPhotoArray();
                photos.add(new VKApiPhoto("photo-131109669_438961353"));

                VKShareDialogBuilder builder = new VKShareDialogBuilder();

                builder.setText("Hello from AS! https://vk.com/tv_regeneration");
                builder.setAttachmentLink("Проверка текста",
                        "https://play.google.com/store/apps/details?id=com.iurii.tv");
              //  builder.setUploadedPhotos(photos);
                builder.show(getFragmentManager(), "VK_SHARE_DIALOG");
            }
        });
    }

    private void facebookCode() {
                /*
       /////////////////////////////////////////////////////////////////////////////////////////////
       code for getting Key hash for Android-Facebook app
       /////////////////////////////////////////////////////////////////////////////////////////////

       PackageInfo info;
       try {
            info = getPackageManager().getPackageInfo("ua.mintmalory.facebooksharing", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String something = new String(Base64.encode(md.digest(), 0));
                //String something = new String(Base64.encodeBytes(md.digest()));
                Log.e("hash key", something);
            }
        } catch (PackageManager.NameNotFoundException e1) {
            Log.e("name not found", e1.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("no such an algorithm", e.toString());
        } catch (Exception e) {
            Log.e("exception", e.toString());
        }*/

        CallbackManager callbackManager;
        ShareDialog shareDialog;

        ShareLinkContent linkContent = new ShareLinkContent.Builder()
                .setContentTitle("Возрождение")
                .setContentDescription(
                        "«Телеканал Возрождение» - это мобильное приложение, позволяющее Вам смотреть данный телеканал в удобном для вас формате.")
                .setImageUrl(Uri.parse("https://lh3.googleusercontent.com/d2VD08pm52wRowLLs_Gzd_0pjCXOYnQLrVXjgl7wfG7rmMB1tHSIsV64rYSRCdbIeLc=w300-rw"))
                .setContentUrl(Uri.parse("www.facebook.com/820786184690887/"))
                .build();


        ShareButton shareButton = (ShareButton) findViewById(R.id.fb_share_button);
        shareButton.setShareContent(linkContent);

        /*callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(this);
        // this part is optional
        shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
            @Override
            public void onSuccess(Sharer.Result result) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });*/




      /*
        if (ShareDialog.canShow(ShareLinkContent.class)) {
            ShareLinkContent linkContent = new ShareLinkContent.Builder()
                    *//*.setContentTitle("Hello Facebook")
                    .setContentDescription(
                            "The 'Hello Facebook' sample  showcases simple Facebook integration")*//*
                    .setContentUrl(Uri.parse("https://play.google.com/store/apps/details?id=com.iurii.tv"))
                    .build();

            shareDialog.show(linkContent);
        }*/
    }
}
