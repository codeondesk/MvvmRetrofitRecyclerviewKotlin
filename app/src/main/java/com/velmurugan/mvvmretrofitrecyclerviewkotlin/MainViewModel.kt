package com.velmurugan.mvvmretrofitrecyclerviewkotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository)  : ViewModel() {

    val repoList = MutableLiveData<List<GitHubRepos>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllRepos() {

        val response = repository.getAllRepos()
        response.enqueue(object : Callback<List<GitHubRepos>> {
            override fun onResponse(call: Call<List<GitHubRepos>>, response: Response<List<GitHubRepos>>) {
                repoList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<GitHubRepos>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}