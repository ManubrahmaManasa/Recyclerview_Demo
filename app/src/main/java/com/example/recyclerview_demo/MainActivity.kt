package com.example.recyclerview_demo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MyAdapter
    private val itemList = mutableListOf<ModelClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        itemList.add(ModelClass("VoiceToText",false))
        itemList.add(ModelClass("DarkMode", false))
        itemList.add(ModelClass("LiveLocation", true))
        itemList.add(ModelClass("PushNotifications", false))
        itemList.add(ModelClass("BiometricAuthentication", true))
        itemList.add(ModelClass("OfflineMode", false))
        itemList.add(ModelClass("InAppUpdates", true))
        itemList.add(ModelClass("GestureNavigation", false))
        itemList.add(ModelClass("ScreenRecording", true))
        itemList.add(ModelClass("MultiWindowSupport", false))
        itemList.add(ModelClass("PictureInPicture", true))
        itemList.add(ModelClass("AutoFillFramework", false))
        itemList.add(ModelClass("AdaptiveBattery", true))
        itemList.add(ModelClass("SplitScreenMode", false))
        itemList.add(ModelClass("NearbyShare", true))
        itemList.add(ModelClass("SmartReply", false))
        itemList.add(ModelClass("OneHandedMode", true))
        itemList.add(ModelClass("InstantApps", false))
        itemList.add(ModelClass("DynamicThemes", true))
        itemList.add(ModelClass("ScreenMagnification", false))


        adapter = MyAdapter(itemList)
        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.rvList.adapter = adapter

    }
}