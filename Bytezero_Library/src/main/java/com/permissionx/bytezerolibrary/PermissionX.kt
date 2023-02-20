package com.permissionx.bytezerolibrary

import androidx.fragment.app.FragmentActivity

/**
 * @Author: Bytezero_zhengLei
 * @Time: 2023/2/17 15:49
 * @Project_Name: com.permissionx.permissionx
 * @Email:420498246@qq.com
 * @Description:
 * @TODO:  权限 java也可以调用权限
 *
 *
 *
 */
object PermissionX {
    private const val TAG = "InvisibleFragment"
    @JvmStatic
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


}    //测试
//private void RequestPermission_Test() {
//
//    PermissionX.request(this, new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.CAMERA}, new Function2<Boolean, List<String>, Unit>() {
//        @Override
//        public Unit invoke(Boolean aBoolean, List<String> strings) {
//            if (aBoolean) {
//                call();
//                Toast.makeText(MainActivity.this, "All permissions are granted", Toast.LENGTH_SHORT).show();
//            } else {
//
//                Toast.makeText(MainActivity.this, "You denied $deniedList", Toast.LENGTH_SHORT).show();
//            }
//
//            return null;
//        }
//    });
//}