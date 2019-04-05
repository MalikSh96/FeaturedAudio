package com.example.featuredaudio

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView
import android.widget.Toast;

class MainActivity : AppCompatActivity() {

    var player : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun play(v: View) {
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.electronicsound)
            player?.setOnCompletionListener { MediaPlayer.OnCompletionListener { stopPlayer() } }
            /*MediaPlayer.OnCompletionListener:
            * definition for a callback to be invoked when playback of a media source has completed.
            * */
        }

        player?.start()
    }

    fun pause(v: View) {
        if (player != null) {
            player?.pause()
        }
    }

    fun stop(v: View) {
        stopPlayer()
    }

    private fun stopPlayer() {
        if (player != null) {
            player?.release()
            player = null
            Toast.makeText(this, "MediaPlayer released", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStop() {
        super.onStop()
        stopPlayer()
    }
}
