package com.reactnativernthubobjectdetection

import android.net.Uri
import com.facebook.react.bridge.*
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.objects.ObjectDetection
import com.google.mlkit.vision.objects.defaults.ObjectDetectorOptions
import java.io.File
import java.io.IOException

class RnThubObjectdetectionModule(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

  private var objectDetectionSuccessCallback: Callback? = null
  private var objectDetectionFailureCallback: Callback? = null

  private val options = ObjectDetectorOptions.Builder()
    .setDetectorMode(ObjectDetectorOptions.STREAM_MODE)
    .enableClassification()
    .build()
  private val objectDetector = ObjectDetection.getClient(options)

  override fun getName(): String {
    return "RnThubObjectdetection"
  }

  @ReactMethod
  fun objectDetection(uri: String, successCallback: Callback, failureCallback: Callback) {
    objectDetectionSuccessCallback = successCallback
    objectDetectionFailureCallback = failureCallback

    val image: InputImage
    try {
      val file = File(uri)
      image = InputImage.fromFilePath(reactContext, Uri.parse(file.toString()))
      objectDetector.process(image)
        .addOnSuccessListener { detectedObjects ->
          if (detectedObjects.size > 0) {
            objectDetectionSuccessCallback?.invoke("${detectedObjects[0].labels[0].text} ${detectedObjects[0].labels[0].confidence}")
          } else {
            objectDetectionFailureCallback?.invoke("No object detection")
          }
        }
        .addOnFailureListener { e ->
          objectDetectionFailureCallback?.invoke(e.message.toString())
        }
    } catch (e: IOException) {
      e.printStackTrace()
      objectDetectionFailureCallback?.invoke(e.message.toString())
    }
  }


}
