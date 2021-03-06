package com.keropok;

import android.app.Application;
import android.content.Context;
import cl.json.RNSharePackage;
import cl.json.ShareApplication;
import io.github.traviskn.rnuuidgenerator.RNUUIDGeneratorPackage;

import com.reactlibrary.RNFileSharePackage;
import com.rnfs.RNFSPackage;
import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import com.guichaguri.trackplayer.TrackPlayer;
import com.thebylito.navigationbarcolor.NavigationBarColorPackage;
import com.levelasquez.androidopensettings.AndroidOpenSettingsPackage;
import com.dooboolab.RNIap.RNIapPackage;
import org.devio.rn.splashscreen.SplashScreenReactPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost =
      new ReactNativeHost(this) {
        @Override
        public boolean getUseDeveloperSupport() {
          return BuildConfig.DEBUG;
        }

        @Override
        protected List<ReactPackage> getPackages() {
          @SuppressWarnings("UnnecessaryLocalVariable")
          List<ReactPackage> packages = new PackageList(this).getPackages();
          // Packages that cannot be autolinked yet can be added manually here, for example:
          // packages.add(new MyReactNativePackage());
            new TrackPlayer();
            new SplashScreenReactPackage();
            new AndroidOpenSettingsPackage();
            new RNIapPackage();
            new RNSharePackage();
            new RNFSPackage();
            new RNFileSharePackage();
            new RNUUIDGeneratorPackage();
            new NavigationBarColorPackage();
          return packages;
        }

        @Override
        protected String getJSMainModuleName() {
          return "index";
        }
      };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    initializeFlipper(this); // Remove this line if you don't want Flipper enabled
  }

  /**
   * Loads Flipper in React Native templates.
   *
   * @param
   */
  private static void initializeFlipper(Context context) {
    if (BuildConfig.DEBUG) {
      try {
        /*
         We use reflection here to pick up the class that initializes Flipper,
        since Flipper library is not available in release mode
        */
        Class<?> aClass = Class.forName("com.facebook.flipper.ReactNativeFlipper");
        aClass.getMethod("initializeFlipper", Context.class).invoke(null, context);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (NoSuchMethodException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InvocationTargetException e) {
        e.printStackTrace();
      }
    }
  }
}
