package com.abdo.islami.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.abdo.islami.R


class SebhaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    lateinit var tasbehNumButton: Button
    lateinit var tasbehButton: Button
    lateinit var resetButton: Button
    lateinit var sebhaImage: ImageView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tasbehNumButton = view.findViewById(R.id.tasbeh_num_button)
        tasbehButton = view.findViewById(R.id.tasbeh)
        resetButton = view.findViewById(R.id.reset)
        sebhaImage = view.findViewById(R.id.sebha_body_icon)
        val mCurrRotation = 0
        tasbehNum()
        resetTasbehNum()


    }

    var counter: Int = 0
    private fun resetTasbehNum() {
        resetButton.setOnClickListener {
            tasbehNumButton.text.toString().toInt()
            tasbehNumButton.text = "0"
            counter = 0

        }
    }

    private fun tasbehNum() {

        tasbehButton.setOnClickListener {
            tasbehNumButton.text.toString().toInt()
            tasbehNumButton.text = "${++counter}"


            var mCurrRotation = 360
            val fromRotation: Int = mCurrRotation
            val toRotation: Int = 90.let { mCurrRotation += it; mCurrRotation }

            val rotateAnim = RotateAnimation(
                fromRotation.toFloat(), toRotation.toFloat(),
                (sebhaImage.width / 2).toFloat(), (sebhaImage.height / 2).toFloat()
            )

            rotateAnim.duration = 10 // Use 0 ms to rotate instantly

            rotateAnim.fillAfter = true // Must be true or the animation will reset


            sebhaImage.startAnimation(rotateAnim)
            sebhaImage.setRotation(sebhaImage.rotation + 90)
        }
    }
}