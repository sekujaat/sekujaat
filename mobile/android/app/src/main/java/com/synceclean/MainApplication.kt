package com.synceclean

import android.app.Application
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.soloader.SoLoader

class MainApplication : Application(), ReactApplication {

    private val mReactNativeHost: ReactNativeHost =
        object : DefaultReactNativeHost(this) {

            override fun getPackages(): List<ReactPackage> {
                // Auto-linked packages handle most cases; add manual packages here if needed.
                return emptyList()
            }

            override fun getUseDeveloperSupport(): Boolean = BuildConfig.DEBUG

            override val isNewArchEnabled: Boolean
                get() = false

            override val isHermesEnabled: Boolean
                get() = true
        }

    override fun getReactNativeHost(): ReactNativeHost = mReactNativeHost

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
        if (BuildConfig.IS_NEW_ARCHITECTURE_ENABLED) {
            DefaultNewArchitectureEntryPoint.load()
        }
    }
}
