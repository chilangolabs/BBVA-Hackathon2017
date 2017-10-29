package com.chilangolabs.mdb.services

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import com.chilangolabs.mdb.R
import com.chilangolabs.mdb.TransferActivity
import com.chilangolabs.mdb.utils.loge
import com.chilangolabs.mdb.utils.logi
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


/**
 * @author Gorro.
 */
class MDBFirebaseMessaginService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        super.onMessageReceived(remoteMessage)

        loge("From: ${remoteMessage?.from}")

        remoteMessage?.data?.let {
            logi("Message: $it")
            sendNotification(remoteMessage)
        }

    }

    private fun sendNotification(messageBody: RemoteMessage) {
        val intent = Intent(this, TransferActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        val pendingIntent = PendingIntent.getActivity(this, System.currentTimeMillis().toInt(), intent, PendingIntent.FLAG_ONE_SHOT)

        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val builder = NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setColor(resources.getColor(R.color.background_material_light))
                .setContentTitle(getString(R.string.app_name))
                .setContentText(messageBody.data["body"])
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent)
        val bigNotification = NotificationCompat.BigTextStyle(builder)
                .bigText(messageBody.data["body"])
                .build()

        val notifManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notifManager.notify(System.currentTimeMillis().toInt() /* ID of notification */, bigNotification)

    }

}