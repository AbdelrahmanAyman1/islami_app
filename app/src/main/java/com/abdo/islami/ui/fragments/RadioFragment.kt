package com.abdo.islami.ui.fragments

import android.Manifest.permission.INTERNET
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.abdo.islami.R
import com.abdo.islami.network.ApiManager
import com.abdo.islami.network.RadioResponse
import com.abdo.islami.network.RadiosItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RadioFragment : Fragment() {

    lateinit var channelName: TextView
    lateinit var playButton: ImageButton
    lateinit var backButton: ImageButton
    lateinit var nextButton: ImageButton
    lateinit var itemList: ArrayList<RadiosItem>
    var position = 0
    lateinit var progressBar: ProgressBar
    var isPlaying: Boolean = false
    var mediaPlayer = MediaPlayer()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_radio, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        getDataFromApi()
    }

    private fun getDataFromApi() {

        ApiManager().getApi().fetRadiosDataFromApi().enqueue(object : Callback<RadioResponse> {
            override fun onResponse(call: Call<RadioResponse>, response: Response<RadioResponse>) {
                Log.e("onResponse", response.body().toString())
                itemList = response.body()?.radios as ArrayList<RadiosItem>
                channelName.text = itemList[0].name
                playSound(0)
                progressBar.isVisible = false
            }

            override fun onFailure(call: Call<RadioResponse>, t: Throwable) {
                Log.e("onFailure", t.message.toString())
                progressBar.isVisible = false
                if (INTERNET == null) {
                    Toast.makeText(requireContext(), "plll", Toast.LENGTH_LONG).show()
                }
            }
        })

    }

    private fun playSound(pos: Int) {
        val url = itemList[pos].uRL // your URL here
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(url)
            prepareAsync() // might take long! (for buffering, etc)

        }
        mediaPlayer.setOnPreparedListener {
            if (isPlaying == false) {
                mediaPlayer.stop()
            } else if (isPlaying == true) {
                mediaPlayer.start()
            }

        }
    }

    private fun initViews() {
        channelName = requireView().findViewById(R.id.radio_name_text)
        playButton = requireView().findViewById(R.id.play)
        backButton = requireView().findViewById(R.id.play_back)
        nextButton = requireView().findViewById(R.id.play_next)
        progressBar = requireView().findViewById(R.id.progress)

        playButton.setOnClickListener {

            if (isPlaying == false) {
                Log.e("isplay", "false")
                isPlaying = true
                playButton.setImageResource(R.drawable.pause)
                playSound(position)
                mediaPlayer.stop()
            } else if (isPlaying == true) {
                Log.e("isplay1", "true")
                isPlaying = false
                playButton.setImageResource(R.drawable.icon_play)
                mediaPlayer.stop()
            }
        }
        nextButton.setOnClickListener {
            position++
            if (position == 163) {
                position = 0
                channelName.text = itemList[position].name
            }
            channelName.text = itemList[position].name
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }
            playSound(position)
        }
        backButton.setOnClickListener {
            position--
            if (position == -1) {
                position = 163
                position--
                channelName.text = itemList[position].name
            }
            //


            channelName.text = itemList[position].name
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }
            playSound(position)
        }

    }
}