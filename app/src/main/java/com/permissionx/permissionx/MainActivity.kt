package com.permissionx.permissionx

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.permissionx.bytezerolibrary.PermissionX
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @Author: Bytezero_zhengLei
 * @Time: 2023/2/17 15:29
 * @Project_Name: MainActivity.kt
 * @Email: 420498246@qq.com
 * @Description:
 * @TODO:   用于测试权限库
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        makeCallBtn.setOnClickListener {

            PermissionX.request(
                this,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_CONTACTS
            ) { allGranted, deniedList ->
                if (allGranted) {
                    call()
                    Toast.makeText(this, "All permissions are granted", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        this, "You denied $deniedList", Toast.LENGTH_SHORT
                    ).show()
                }

            }

        }
    }


    private fun call() {
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }
}