package com.felipe.spotifyconsult.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.felipe.spotifyconsult.R
import com.felipe.spotifyconsult.fragments.ProfileFragment
import com.felipe.spotifyconsult.fragments.WelcomeFragment
import com.felipe.spotifyconsult.preferences.PreferencesUtil
import com.felipe.spotifyconsult.spotify.config.ConfigurateCredentials
import com.google.android.material.navigation.NavigationView
import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationResponse


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private val profileFragment: ProfileFragment = ProfileFragment()
    private val welcomeFragment: WelcomeFragment = WelcomeFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    override fun onResume() {
        super.onResume()

        ConfigurateCredentials.verifyCredentials(this)
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_playlist -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ConfigurateCredentials.REQUEST_CODE) {
            val response: AuthenticationResponse = AuthenticationClient.getResponse(resultCode, data)

            when (response.type) {
                AuthenticationResponse.Type.TOKEN -> {
                    PreferencesUtil.getInstance(this).token = response.accessToken
                    PreferencesUtil.getInstance(this).expiresIn = response.expiresIn
                    PreferencesUtil.getInstance(this).createdTime = System.currentTimeMillis()
                }

                AuthenticationResponse.Type.ERROR -> {
                    Toast.makeText(this, "Error: " + response.error, Toast.LENGTH_SHORT).show()
                }
                else -> {
                }
            }
        }
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.layout_nav_header -> {
                putFragment(profileFragment)
            }
        }
    }

    fun setupView() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val headerView = navView.getHeaderView(0)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.open, R.string.close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
        val header = headerView.findViewById(R.id.layout_nav_header) as LinearLayout

        header.setOnClickListener(this)

        supportFragmentManager.beginTransaction()
            .add(R.id.content, welcomeFragment).commit()
    }

    fun putFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(com.felipe.spotifyconsult.R.id.content, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
