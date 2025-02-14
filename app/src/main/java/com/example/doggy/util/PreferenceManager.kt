package com.example.doggy.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import com.example.doggy.dataClasses.DogData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@SuppressLint("StaticFieldLeak")
object PreferenceManager {

    private lateinit var context: Context
    private val gson = Gson()
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editPref: SharedPreferences.Editor
    private var dogList = ArrayDeque<String>()
    private const val DOG_LIST = "dog_list"

    fun init(context: Context) {
        this.context = context
        sharedPreferences =
            PreferenceManager.context.getSharedPreferences("dogs", Context.MODE_PRIVATE)
        dogList = getData().let {
            val arr = ArrayDeque<String>()
            it.forEach {
                arr.addFirst(it)
            }
            arr
        }
        editPref = sharedPreferences.edit()
    }


    fun addDog(dog: DogData) {
        dogList.addFirst(dog.message)
        if (dogList.size > 20) dogList.removeLastOrNull()
        saveData()
    }

    private fun saveData() {
        val jsonString = gson.toJson(dogList)
        editPref.putString(DOG_LIST, jsonString).apply()
    }

    fun getData(): List<String> {
        val json = sharedPreferences.getString(DOG_LIST, null)
        return if (json != null) {
            val type = object : TypeToken<ArrayDeque<String>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }

    fun clearData() {
        editPref.clear().apply()
        dogList = ArrayDeque<String>()
    }
}