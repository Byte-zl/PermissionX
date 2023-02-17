package com.permissionx.bytezerolibrary

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

/**
 * @Author: Bytezero_zhengLei
 * @Time: 2023/2/17 15:38
 * @Project_Name: com.permissionx.permissionx
 * @Email:420498246@qq.com
 * @Description:
 * @TODO:typealias关键字可以用于给任意类型指定一个别名，比如我们将(Boolean, List<String>) -> Unit的别名指定成了PermissionCallback，
 *         这样就可以使用PermissionCallback来替代之前所有使用(Boolean, List<String>) -Unit的地方，从而让代码变得更加简洁易懂。
 */

typealias PermissionCallback = (Boolean, List<String>) -> Unit

class InvisibleFragment : Fragment() {

//    private var callback: ((Boolean, List<String>) -> Unit)? = null

    private var callback: PermissionCallback? = null
    fun requestNow(cb: PermissionCallback, vararg permissions: String) {
        callback = cb
        requestPermissions(permissions, 1)

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 1) {
            val denideList = ArrayList<String>()
            for ((index, result) in grantResults.withIndex()) {
                if (result != PackageManager.PERMISSION_GRANTED) {
                    denideList.add(permissions[index])
                }
            }
            val allGranted = denideList.isEmpty()
            callback?.let { it(allGranted, denideList) }
        }

    }

}