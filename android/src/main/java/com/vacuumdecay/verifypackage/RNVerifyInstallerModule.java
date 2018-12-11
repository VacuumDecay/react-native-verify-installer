
package com.vacuumdecay.verifypackage;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class RNVerifyInstallerModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private Map installers;

  public RNVerifyInstallerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    installers = new HashMap();
    installers.put("com.android.vending", "Play Store");
    installers.put("com.google.android.feedback", "Play Store");
    installers.put("com.amazon.venezia","Amazon Appstore");
  }

  @Override
  public String getName() {
    return "VerifyInstaller";
  }

  @ReactMethod
  public void getInstallerSource(String packageName, Callback callback) {
    String installerName;
      try {
        final String installerPackage = this.reactContext.getPackageManager().getInstallerPackageName(packageName);
        if(installerPackage == null){
            installerName = "ADB";
        }else{
          try{
            installerName = installers.get(installerPackage).toString();
          }catch(NullPointerException e){
            installerName = "Unknown";
          }
        }
      }catch (IllegalArgumentException e){
        installerName = "Unknown";
      }
    callback.invoke(installerName);
  }

}