package com.amanullah.permissions

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.permissionx.guolindev.PermissionX

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            PermissionX.init(this)
//                .permissions(
//                    Manifest.permission.READ_EXTERNAL_STORAGE,
//                    Manifest.permission.ACCESS_COARSE_LOCATION,
//                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
//                )
//                .request { allGranted, grantedList, deniedList ->
//                    if (allGranted) {
//                        Toast.makeText(this, "All permissions are granted", Toast.LENGTH_LONG).show()
//                    } else {
//                        Toast.makeText(
//                            this,
//                            "These permissions are denied: $deniedList",
//                            Toast.LENGTH_LONG
//                        ).show()
//                    }
//                }
//        }

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            PermissionX.init(this)
//                .permissions(
//                    Manifest.permission.READ_EXTERNAL_STORAGE,
//                    Manifest.permission.ACCESS_COARSE_LOCATION,
//                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
//                )
//                .onExplainRequestReason { scope, deniedList ->
//                    scope.showRequestReasonDialog(
//                        deniedList,
//                        "Core fundamental are based on these permissions",
//                        "OK",
//                        "Cancel"
//                    )
//                }
//                .request { allGranted, grantedList, deniedList ->
//                    if (allGranted) {
//                        Toast.makeText(this, "All permissions are granted", Toast.LENGTH_LONG).show()
//                    } else {
//                        Toast.makeText(
//                            this,
//                            "These permissions are denied: $deniedList",
//                            Toast.LENGTH_LONG
//                        ).show()
//                    }
//                }
//        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            PermissionX.init(this)
                .permissions(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
                )
                .onExplainRequestReason { scope, deniedList ->
                    scope.showRequestReasonDialog(
                        deniedList,
                        "Core fundamental are based on these permissions",
                        "OK",
                        "Cancel"
                    )
                }
                .onForwardToSettings { scope, deniedList ->
                    scope.showForwardToSettingsDialog(
                        deniedList,
                        "You need to allow necessary permissions in Settings manually",
                        "OK",
                        "Cancel"
                    )
                }
                .request { allGranted, grantedList, deniedList ->
                    if (allGranted) {
                        Toast.makeText(this, "All permissions are granted", Toast.LENGTH_LONG)
                            .show()
                    } else {
                        Toast.makeText(
                            this,
                            "$deniedList Permission is Denied",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

    }
}
