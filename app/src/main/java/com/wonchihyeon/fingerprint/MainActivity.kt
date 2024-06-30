package com.wonchihyeon.fingerprint

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import me.aflak.libraries.FingerprintCallback
import me.aflak.libraries.FingerprintDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {

            // FingerPrintDialog로 지문인증을 쉽게 사용 가능
            // 사용법은 AlertDialog의 빌더 패턴과 유사
            FingerprintDialog.initialize(this)
                .title("지문인증")
                .message("지문으로 인증합니다.")
                .callback(object : FingerprintCallback {
                        // 인증 성공인 경우의 콜백 함수
                        override fun onAuthenticationSuccess() {
                            Toast.makeText(applicationContext, "인증", Toast.LENGTH_SHORT).show()
                        }

                    // 인증 실패인 경우의 콜백 함수
                    override fun onAuthenticationCancel() {
                        Toast.makeText(applicationContext, "인증 실패", Toast.LENGTH_SHORT).show()
                    }
                })
                .show()
        }
    }
}