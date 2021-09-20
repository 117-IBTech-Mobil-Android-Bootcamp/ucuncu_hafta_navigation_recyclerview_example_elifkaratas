package com.example.week3

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.week3.utils.gone
import com.example.week3.utils.visible
import kotlinx.android.synthetic.main.activity_main.*
import android.content.DialogInterface

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.fragment)
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.splashFragment) {
                bottomNavigationView.gone()
            } else {
                bottomNavigationView.visible()
            }
        }

        /// navigation animations
        val options = NavOptions.Builder()
            .setLaunchSingleTop(true)
            .setEnterAnim(R.anim.enter_from_right)
            .setExitAnim(R.anim.exit_to_left)
            .setPopEnterAnim(R.anim.enter_from_left)
            .setPopExitAnim(R.anim.exit_to_right)
            .setPopUpTo(navController.graph.startDestination, false)
            .build()

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.battleFragment -> {
                    navController.navigate(R.id.battleFragment,null,options)
                }
                R.id.deckFragment -> {
                    navController.navigate(R.id.deckFragment,null,options)
                }
                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment,null,options)
                }
                R.id.SetAvatarFragment -> {
                    navController.navigate(R.id.SetAvatarFragment,null,options)
                }
                R.id.splashFragment -> {
                    navController.navigate(R.id.splashFragment,null,options)
                }
            }
            true
        }
    }

    fun hideNavigation() {
        bottomNavigationView.postDelayed(
            {
                bottomNavigationView.gone()

            }, 500
        )
    }

    fun showNavigation() {
        bottomNavigationView.postDelayed(
            {
                bottomNavigationView.visible()

            }, 500
        )
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 2) {
            // If there are back-stack entries, leave the FragmentActivity
            // implementation take care of them.
            supportFragmentManager.popBackStack()
        } else {
            // Ask user if user wants to leave
            AlertDialog.Builder(this)
                .setTitle("Uyarı")
                .setMessage("Uygulamadan çıkmak istediğine emin misin?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(
                    android.R.string.yes,
                    DialogInterface.OnClickListener { arg0, arg1 -> finish()})
                .create().show()
        }
    }
}