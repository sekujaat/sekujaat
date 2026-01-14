package com.syncecleaner

import android.app.Application
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint.load
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.soloader.SoLoader
import com.syncecleaner.BuildConfig

class MainApplication : Application(), ReactApplication {

    private val mReactNativeHost: ReactNativeHost =
        object : DefaultReactNativeHost(this) {

            override fun getPackages(): MutableList<ReactPackage> {
                return PackageList(this).packages
            }

            override fun getJSMainModuleName(): String = "index"

            // new architecture flag yahin se control hoga
            override fun isNewArchEnabled(): Boolean = IS_NEW_ARCHITECTURE_ENABLED

            override fun isHermesEnabled(): Boolean = BuildConfig.IS_HERMES_ENABLED
        }

    override fun getReactNativeHost(): ReactNativeHost = mReactNativeHost

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, /* native exopackage */ false)

        if (IS_NEW_ARCHITECTURE_ENABLED) {
            // If new architecture is enabled, load it
            load()
        }
    }

    companion object {
        // yahi constant missing tha; ab har build me defined rahega
        private const val IS_NEW_ARCHITECTURE_ENABLED: Boolean =
            BuildConfig.IS_NEW_ARCHITECTURE_ENABLED
        // agar simple chahiye to yahan direct false bhi kar sakte:
        // private const val IS_NEW_ARCHITECTURE_ENABLED: Boolean = false
    }
}
