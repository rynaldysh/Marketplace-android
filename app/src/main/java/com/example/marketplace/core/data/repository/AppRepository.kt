package com.example.marketplace.core.data.repository

import com.example.marketplace.core.data.source.local.LocalDataSource
import com.example.marketplace.core.data.source.remote.RemoteDataSource
import com.example.marketplace.core.data.source.remote.network.Resource
import com.example.marketplace.core.data.source.remote.request.LoginRequest
import com.inyongtisto.myhelper.extension.getErrorBody
import com.inyongtisto.myhelper.extension.logs
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class AppRepository (val local : LocalDataSource, val remote : RemoteDataSource) {

    fun login(data: LoginRequest) = flow {
        emit(Resource.loading(null))
        try {
            remote.login(data).let {
                if (it.isSuccessful){
                    val body = it.body()
                    emit(Resource.succes(body?.data))
                    logs("succes:" + body.toString())
                } else {
                    emit(Resource.error(it.getErrorBody()?.message ?:"Error default", null))
                    logs("Error:" + "keterangan error")
                }
            }
        } catch (e:Exception) {
            emit(Resource.error(e.message ?: "Terjadi kesalahan", null))
            logs("Error:" + e.message)
        }
    }
}