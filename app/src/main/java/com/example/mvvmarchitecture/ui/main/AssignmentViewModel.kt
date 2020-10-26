package com.example.mvvmarchitecture.ui.main

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.base.BaseViewModel
import com.example.mvvmarchitecture.base.MainArguments
import com.example.mvvmarchitecture.repository.IRepository
import com.example.mvvmarchitecture.server.Forecast
import com.example.mvvmarchitecture.server.response.AssignmentResponse
import com.example.mvvmarchitecture.server.response.PagesData
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.libraries.places.internal.it
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Named
import kotlin.collections.ArrayList

class AssignmentViewModel @Inject constructor(
    val context: Context,
    var repository: IRepository
) : BaseViewModel() {

    var assignmentAPICalled = ObservableBoolean(false)
    var apiRes = ObservableField<AssignmentResponse>()

    var latitude: Double? = 17.45038774389296
    var longitude: Double? = 78.36236547678709
    var itemClicked = ObservableField<Boolean>(false)

    var clickedItemResponse = ObservableField<PagesData>()


//    init {
//        val mLocationRequest = LocationRequest.create()
//        mLocationRequest.interval = 60000
//        mLocationRequest.fastestInterval = 5000
//        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        val mLocationCallback: LocationCallback = object : LocationCallback() {
//            override fun onLocationResult(locationResult: LocationResult) {
//                if (locationResult == null) {
//                    return
//                }
//                for (location in locationResult.locations) {
//                    if (location != null) {
//                    }
//                }
//            }
//        }
//        LocationServices.getFusedLocationProviderClient(context).requestLocationUpdates(mLocationRequest, mLocationCallback, null)
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
//        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
//           var locationLatitude = location?.latitude
//           var locationLongitude = location?.longitude
//        }.addOnFailureListener {}
//    }

    fun callApi(){
            showDefaultLoader()
        repository.getAssignmentResonse().process(
            onSuccess = {
                dismissDefaultLoader()
                assignmentAPICalled.set(true)
                apiRes.set(it)

                println("====response======${Gson().toJson(it)}=======")
                println("=====data=====${it?.data}=======")

            },
            onFailure = {
                dismissDefaultLoader()
                handleError(it, callback = fun(_: String?) {
                    when (it) {
                        else -> {
                            println("==============assignment_failure===$it==============")
                        }
                    }
                })
            }
        )
    }


}