package com.dfl.comunicationdriveserver.domain.model

data class DeliveryModel(
    val id: String,
    val step: String
) {
    val goToStep: SRouteDefine = SRouteDefine.valueOf(step)
}

enum class SRouteDefine(val id: String) {
    DASHBOARD("/dashboard"),
    CREDIT("/dashboard/credits"),
    ACCOUNT("/dashboard/accounts")
}