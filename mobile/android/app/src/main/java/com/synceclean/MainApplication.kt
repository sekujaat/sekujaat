package com.synceclean

import android.app.Application
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.defaults.DefaultReactNativeHost
import com.facebook.soloader.SoLoader
import com.syncecleaner.BuildConfig

class MainApplication : Application(), ReactApplication {

    override val reactNativeHost: ReactNativeHost =
        object : DefaultReactNativeHost(this) {

            override fun getPackages(): List<ReactPackage> {
                // Auto-linked packages; manual packages yahan add kar sakte ho agar future me zarurat ho.
                return emptyList()
            }

            override fun getUseDeveloperSupport(): Boolean = BuildConfig.DEBUG

            // New architecture / Hermes flags hata diye, kyunki BuildConfig me define nahi hain.
            override val isNewArchEnabled: Boolean
                get() = false

            override val isHermesEnabled: Boolean
                get() = true
        }

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
        // Yahan bhi New Architecture flag wala code hata diya.
    }
}
