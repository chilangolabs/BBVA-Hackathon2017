package com.chilangolabs.mdb.services

import com.chilangolabs.mdb.utils.logd
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * @author Gorro.
 */
class FirebaseInstanceIDService : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        super.onTokenRefresh()
        val refreshedToken = FirebaseInstanceId.getInstance().token
        logd("Refreshed Token $refreshedToken")

        //SendToken to Server
        //todo
    }

}