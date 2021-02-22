package com.reactnativernthubobjectdetection

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise

class RnThubObjectdetectionModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "RnThubObjectdetection"
    }

    // Example method
    // See https://reactnative.dev/docs/native-modules-android
    @ReactMethod
    fun multiply(a: Int, b: Int, promise: Promise) {
    
      promise.resolve(a * b)
    
    }

    
}
