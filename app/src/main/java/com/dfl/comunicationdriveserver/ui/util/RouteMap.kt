package com.dfl.comunicationdriveserver.ui.util

import android.content.Context
import android.content.Intent
import com.dfl.account.ui.AccountActivity
import com.dfl.comunicationdriveserver.domain.model.SRouteDefine
import com.dfl.comunicationdriveserver.ui.MainActivity
import com.dfl.credit.ui.CreditActivity

object RouteMap {
    fun SRouteDefine.getIntentRoute(context: Context) = when (this) {
        SRouteDefine.ACCOUNT -> AccountActivity::class.java
        SRouteDefine.CREDIT -> CreditActivity::class.java
        else -> MainActivity::class.java
    }.let { activity ->
        Intent(context, activity)
    }


}