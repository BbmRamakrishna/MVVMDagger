package com.example.mvvmarchitecture.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.mvvmarchitecture.R
import com.example.mvvmarchitecture.base.AssignmentArguments
import com.example.mvvmarchitecture.base.BaseActivity
import com.example.mvvmarchitecture.base.ItemClickListener
import com.example.mvvmarchitecture.databinding.AssignmentBinding
import com.example.mvvmarchitecture.server.response.PagesData
import com.example.mvvmarchitecture.ui.observe
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlin.reflect.KClass

class AssignmentActivity : BaseActivity<AssignmentViewModel, AssignmentBinding>(),
    OnMapReadyCallback, ItemClickListener {

    override val layoutId: Int = R.layout.assignment

    override val viewModelClass: KClass<AssignmentViewModel> = AssignmentViewModel::class

    var adapter: AssignmentAdapter? = null

    var googleMap: GoogleMap? = null
    var mapFragment: SupportMapFragment? = null

    override fun navigate(navigateTo: String, arguments: Any?) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this@AssignmentActivity)

        viewModel.callApi()
        obserList()
    }

    private fun obserList() {


        viewModel.assignmentAPICalled.observe {
            if (it!!) {
                this.runOnUiThread {
                    adapter = AssignmentAdapter(viewModel.apiRes.get()?.data, this)
                    binding.recyclerViewAssignmentDetails.adapter = adapter
                }
            }
        }
    }

    companion object {

        fun createActivity(context: Context, arguments: AssignmentArguments): Intent {
            val i = Intent(context, AssignmentActivity::class.java)
            i.putExtra("arguments", arguments)
            return i
        }
    }

    override fun onItemSelected(item: PagesData?) {

        viewModel.itemClicked.set(true)

        viewModel.clickedItemResponse.set(item)

        onMapReady(googleMap)

    }

    override fun onMapReady(p0: GoogleMap?) {

        googleMap = p0

        var latLng: LatLng = LatLng(viewModel.latitude!!, viewModel.longitude!!)

        if(viewModel.itemClicked.get()?:false){
            googleMap?.addMarker(
                MarkerOptions().position(latLng).title(
                    "${viewModel.clickedItemResponse.get()?.id} \t ${viewModel.clickedItemResponse.get()?.name} \t ${
                        viewModel.clickedItemResponse.get()?.year
                    } \t ${
                        viewModel.clickedItemResponse.get()?.color
                    } \t ${
                        viewModel.clickedItemResponse.get()?.pantone_value
                    }"
                )
            )
        }



//        googleMap?.addMarker(
//            MarkerOptions().position(latLng).title(
//                "${viewModel.localDataRepository.getPagesResponse().id} \t ${viewModel.localDataRepository.getPagesResponse().name} \t ${
//                    viewModel.localDataRepository.getPagesResponse().year
//                } \t ${
//                    viewModel.localDataRepository.getPagesResponse().color
//                } \t ${
//                    viewModel.localDataRepository.getPagesResponse().pantone_value
//                }"
//            )
//        )


//        googleMap?.mapType = GoogleMap.MAP_TYPE_NORMAL
//        try {
//            googleMap?.isMyLocationEnabled = true
//        } catch (se: SecurityException) {
//        }
//
//        if (viewModel.itemClicked.get() ?: false) {
//
//            googleMap?.setOnMapClickListener(object : OnMapClickListener {
//                override fun onMapClick(p0: LatLng?) {
//
//                    googleMap?.isTrafficEnabled = true
//                    googleMap?.isIndoorEnabled = true
//                    googleMap?.isBuildingsEnabled = true
//                    googleMap?.uiSettings?.isZoomControlsEnabled = true
//
//                    var markerOptions: MarkerOptions = MarkerOptions()
//
//                    markerOptions.position(LatLng(viewModel.latitude!!, viewModel.longitude!!))
//                    markerOptions.title("${p0?.latitude} ${p0?.longitude} ")
////                    googleMap!!.clear()
//
//                    googleMap?.moveCamera(CameraUpdateFactory.newLatLng(p0))
//                    googleMap?.animateCamera(CameraUpdateFactory.zoomTo(10F), 1000, null)
//
//                    if (googleMap != null) {
//
//                        googleMap!!.addMarker(
//                            markerOptions.icon(
//                                BitmapDescriptorFactory.defaultMarker(
//                                    BitmapDescriptorFactory.HUE_RED
//                                )
//                            )
//                        )
//                    }
//
//                }
//
//            })
//
//        }


    }


}
