package com.example.myapplication.util

import android.content.Context
import android.content.res.AssetManager
import java.io.InputStream
import java.util.*

class PropertiesUtil(private val context: Context) {

    private fun getProperties(): Properties {
        val properties = Properties()
        val assetManager: AssetManager = context.assets
        val inputStream: InputStream = assetManager.open("config.properties")
        properties.load(inputStream)

        return properties
    }

    fun getProperty(key: String): Any{
        return getProperties().getProperty(key)
    }
}