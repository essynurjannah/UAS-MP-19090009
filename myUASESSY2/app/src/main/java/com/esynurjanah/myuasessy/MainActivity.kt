package com.esynurjanah.myuasessy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var toolbarr : Toolbar
    private lateinit var drawerlayoutt : DrawerLayout
    private lateinit var navView : NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarr = findViewById(R.id.toolbar)
        drawerlayoutt = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        setSupportActionBar(toolbarr)

        val navController = Navigation.findNavController(this, R.id.fragment_container)
        NavigationUI.setupWithNavController(navView, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drawerlayoutt)

        val toggle = ActionBarDrawerToggle(this, drawerlayoutt, toolbarr, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerlayoutt.addDrawerListener(toggle)
        toggle.syncState()
    }

    override fun onBackPressed() {
        if (drawerlayoutt.isDrawerOpen(GravityCompat.START)){
            drawerlayoutt.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()
        }
    }
}