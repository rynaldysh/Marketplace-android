package com.example.marketplace

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marketplace.core.data.source.remote.network.State
import com.example.marketplace.core.data.source.remote.request.LoginRequest
import com.example.marketplace.databinding.ActivityLoginBinding
import com.example.marketplace.ui.login.LoginViewModel
import com.inyongtisto.myhelper.extension.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel : LoginViewModel by viewModel()

    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()

    }    fun setData() {
        viewModel.text.observe(this) {
            binding.etEmail.setText(it)
        }

        viewModel.textt.observe(this) {
            binding.etPassword.setText(it)
        }

        binding.btMasuk.setOnClickListener {
            login()
        }
    }

    private fun login(){

        if (binding.etEmail.isEmpty()) return
        if (binding.etPassword.isEmpty()) return

        val body = LoginRequest(
            binding.etEmail.text.toString(),
            binding.etPassword.text.toString()
        )

        viewModel.login(body).observe(this) {

            when (it.state){
                State.SUCCES->{
                    dismisLoading()
                    showToast("Selamat datang " + it.data?.name)
                    pushActivity(NavigationActivity::class.java)

                }
                State.ERROR->{
                    dismisLoading()
                    toastError(it.message ?: "Terjadi kesalahan")
                }
                State.LOADING->{
                   showLoading()
                }
            }

        }
    }


}