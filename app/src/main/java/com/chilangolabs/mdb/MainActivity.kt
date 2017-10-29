package com.chilangolabs.mdb

import android.graphics.Point
import android.hardware.fingerprint.FingerprintManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.BounceInterpolator
import android.view.animation.TranslateAnimation
import com.chilangolabs.mdb.utils.logd
import com.chilangolabs.mdb.utils.loge
import com.chilangolabs.mdb.utils.logw
import com.dev21.fingerprintassistant.FingerprintAuthListener
import com.dev21.fingerprintassistant.FingerprintHelper
import com.dev21.fingerprintassistant.FingerprintResultsHandler
import com.dev21.fingerprintassistant.ResponseCode
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), FingerprintAuthListener {

    private val point = Point()
    private var height = 0
    private val fingerPrintHelper: FingerprintHelper? by lazy {
        FingerprintHelper(this, "FingerPrintMDB")
    }
    private val fingerprintresulthandler: FingerprintResultsHandler? by lazy {
        FingerprintResultsHandler(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = resources.getColor(R.color.colorStatusBar)

        FirebaseMessaging.getInstance().subscribeToTopic("mdb")

        val display = windowManager.defaultDisplay
        display.getSize(point)
        height = point.y

//        val anim = AnimationUtils.loadAnimation(this, R.anim.jump_arrow)
//
//        imgLandingLeft.startAnimation(anim)
        imgLandingLeft.startAnimation(anim(100))
        imgLandingCenter.startAnimation(anim(200))
        imgLandingRight.startAnimation(anim(300))

        val a = fingerprintresulthandler

        btnMainInit.setOnClickListener {

            startActivity<WelcomeActivity>()
            /*
            val responseCode = fingerPrintHelper?.checkAndEnableFingerPrintService()
            when (responseCode) {
                ResponseCode.FINGERPRINT_SERVICE_INITIALISATION_SUCCESS -> {
                    toast("Fingerprint sensor service initialisation success")
                    fingerprintresulthandler?.setFingerprintAuthListener(this)
                    fingerprintresulthandler?.startListening(fingerPrintHelper?.fingerprintManager, fingerPrintHelper?.cryptoObject)
                }
                ResponseCode.OS_NOT_SUPPORTED -> toast("OS doesn't support fingerprint api")
                ResponseCode.FINGER_PRINT_SENSOR_UNAVAILABLE -> toast("Fingerprint sensor not found")
                ResponseCode.ENABLE_FINGER_PRINT_SENSOR_ACCESS -> toast("Provide access to use fingerprint sensor")
                ResponseCode.NO_FINGER_PRINTS_ARE_ENROLLED -> toast("No fingerprints found")
                ResponseCode.FINGERPRINT_SERVICE_INITIALISATION_FAILED -> toast("Fingerprint service initialisation failed")
                ResponseCode.DEVICE_NOT_KEY_GUARD_SECURED -> toast("Device is not key guard protected")
            }
            */
        }

    }

    override fun onResume() {
        super.onResume()
        fingerprintresulthandler?.let {
            if (it.isAlreadyListening) {
                it.startListening(fingerPrintHelper?.fingerprintManager, fingerPrintHelper?.cryptoObject)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        fingerprintresulthandler?.stopListening()
    }


    fun anim(time: Long): TranslateAnimation {
        val tanim = TranslateAnimation(0f, 0f, height.toFloat() / 3, 0f)
        tanim.startOffset = time
        tanim.interpolator = BounceInterpolator()
        tanim.duration = 3000
        return tanim
    }

    override fun onAuthentication(helpOrErrorCode: Int,
                                  infoString: CharSequence?,
                                  authenticationResult: FingerprintManager.AuthenticationResult?,
                                  authCode: Int) {
        when (authCode) {
            ResponseCode.AUTH_ERROR -> {
                loge("AUTH Error")
                logd("$infoString")
            }
            ResponseCode.AUTH_FAILED -> {
                loge("AUTH Failed")
                logd("$infoString")
            }
            ResponseCode.AUTH_HELP -> {
                logw("AUTH HELP")
                logd("$infoString")
            }
            ResponseCode.AUTH_SUCCESS -> {
                logd("AUTH Success")
                logd("$infoString")
            }
        }
    }

}
