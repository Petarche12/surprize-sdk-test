package com.example.bottomnavtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.axiomc.sdk.LoyalKit.initLoyalKit
import com.axiomc.sdk.LoyalServers.AXIOM
import com.axiomc.sdk.LoyalServers.INTEG
import com.example.bottomnavtest.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    // This needs to be called
    // as early as possible.
    initLoyalKit(AXIOM)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)


    val navView: BottomNavigationView = binding.navView

    val navController = findNavController(R.id.nav_host_fragment_activity_main)

    // Passing each menu ID as a set of Ids because each
    // menu should be considered as top level destinations.
    val appBarConfiguration = AppBarConfiguration(setOf(
      R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
    setupActionBarWithNavController(navController, appBarConfiguration)
    navView.setupWithNavController(navController)
  }
}