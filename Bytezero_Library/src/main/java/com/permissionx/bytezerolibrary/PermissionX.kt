package com.permissionx.bytezerolibrary

import androidx.fragment.app.FragmentActivity

/**
 * @Author: Bytezero_zhengLei
 * @Time: 2023/2/17 15:49
 * @Project_Name: com.permissionx.permissionx
 * @Email:420498246@qq.com
 * @Description:
 * @TODO:
 */
object PermissionX {
    private const val TAG = "InvisibleFragment"
    fun request(
        activity: FragmentActivity,
        vararg permissions: String,
        callback: PermissionCallback
    ) {
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if(existedFragment != null){
            existedFragment as InvisibleFragment
        }else{
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment, TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permissions)
    }


}