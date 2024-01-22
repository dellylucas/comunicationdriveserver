package com.dfl.comunicationdriveserver.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dfl.comunicationdriveserver.domain.model.MainProducts
import com.dfl.comunicationdriveserver.domain.model.ProductModel
import com.dfl.comunicationdriveserver.domain.use_case.DashboardInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dashboardInteractor: DashboardInteractor
) : ViewModel() {

    // var dashUiState: MarsUiState by mutableStateOf(null)
    var productsUser: MainProducts? = null


    fun getInformation() {
        viewModelScope.launch {
            dashboardInteractor.getInformation()
        }
    }

    fun sendDelivery(productModel: ProductModel) {
        viewModelScope.launch {
            val deliveryModel =
                dashboardInteractor.sendDelivery(productsUser?.id ?: "0", productModel)
        }
    }
}
