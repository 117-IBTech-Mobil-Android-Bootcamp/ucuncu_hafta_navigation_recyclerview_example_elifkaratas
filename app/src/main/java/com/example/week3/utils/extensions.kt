package com.example.week3.utils

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


fun Fragment.toNextFragment(@IdRes id : Int){
    findNavController().navigate(id)
}

fun View.visible(){
    this.visibility = View.VISIBLE
}
fun View.gone(){
    this.visibility = View.GONE
}

