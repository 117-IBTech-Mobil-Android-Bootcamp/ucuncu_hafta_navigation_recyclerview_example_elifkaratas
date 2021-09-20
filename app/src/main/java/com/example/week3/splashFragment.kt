package com.example.week3

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.week3.utils.visible
import kotlinx.android.synthetic.main.fragment_splash.*
import java.util.*

class splashFragment : Fragment() {
    private var i = 0
    private val handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_splash, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        /* /// getting error
        /// waiting 3 seconds
        Thread(Runnable {
            while (i < 3) {
                i += 1
                handler.post(Runnable {
                    progressBar!!.progress = i
                })
                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }).start()*/
        findNavController().navigate(R.id.action_splashFragment_to_battleFragment)
    }
}