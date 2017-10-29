package com.chilangolabs.mdb

import android.hardware.fingerprint.FingerprintManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chilangolabs.mdb.utils.logd
import com.chilangolabs.mdb.utils.loge
import com.chilangolabs.mdb.utils.logw
import com.dev21.fingerprintassistant.FingerprintAuthListener
import com.dev21.fingerprintassistant.FingerprintHelper
import com.dev21.fingerprintassistant.FingerprintResultsHandler
import com.dev21.fingerprintassistant.ResponseCode
import kotlinx.android.synthetic.main.activity_confirm_transfer.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import org.jetbrains.anko.toast

class ConfirmTransferActivity : AppCompatActivity(), FingerprintAuthListener {

    private val fingerPrintHelper: FingerprintHelper? by lazy {
        FingerprintHelper(this, "FingerPrintMDB")
    }
    private val fingerprintresulthandler: FingerprintResultsHandler? by lazy {
        FingerprintResultsHandler(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_transfer)

        val a = fingerprintresulthandler


        btnConfirmTransfer.setOnClickListener {
            startActivity(intentFor<CardsActivity>().singleTop())
        }
    }


    override fun onResume() {
        super.onResume()

        val responseCode = fingerPrintHelper?.checkAndEnableFingerPrintService()
        when (responseCode) {
            ResponseCode.FINGERPRINT_SERVICE_INITIALISATION_SUCCESS -> {
//                toast("Fingerprint sensor service initialisation success")
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

    override fun onAuthentication(helpOrErrorCode: Int,
                                  infoString: CharSequence?,
                                  authenticationResult: FingerprintManager.AuthenticationResult?,
                                  authCode: Int) {
        when (authCode) {
            ResponseCode.AUTH_ERROR -> {
                loge("AUTH Error")
                logd("$infoString")
                txtConfirmTransfer.text = "Error al leer tu huella, intena de nuevo"
                imgFingerPrint.setImageResource(R.drawable.ic_finger_print_red)
            }
            ResponseCode.AUTH_FAILED -> {
                loge("AUTH Failed")
                logd("$infoString")
                txtConfirmTransfer.text = "Error al leer tu huella, intena de nuevo"
                imgFingerPrint.setImageResource(R.drawable.ic_finger_print_red)
            }
            ResponseCode.AUTH_HELP -> {
                logw("AUTH HELP")
                logd("$infoString")
                txtConfirmTransfer.text = "Error al leer tu huella, intena de nuevo"
                imgFingerPrint.setImageResource(R.drawable.ic_finger_print_red)
            }
            ResponseCode.AUTH_SUCCESS -> {
                logd("AUTH Success")
                logd("$infoString")
                txtConfirmTransfer.text = "Huella confirmada"
                imgFingerPrint.setImageResource(R.drawable.ic_finger_print_green)
            }
        }
    }

}
