package com.nida.ai.utils

import android.content.Context
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import java.util.Locale

class TextToSpeechManager(private val context: Context, private val listener: TextToSpeechListener) : TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private var isTtsReady = false

    init {
        tts = TextToSpeech(context, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "The Language specified is not supported!")
                listener.onSpeechError("Language not supported")
            } else {
                isTtsReady = true
                tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
                    override fun onStart(utteranceId: String?) {
                        listener.onSpeechStart()
                    }

                    override fun onDone(utteranceId: String?) {
                        listener.onSpeechDone()
                    }

                    override fun onError(utteranceId: String?) {
                        listener.onSpeechError("TTS Error")
                    }
                })
                listener.onTtsInitialized()
            }
        } else {
            Log.e("TTS", "Initialization Failed!")
            listener.onSpeechError("TTS Initialization Failed")
        }
    }

    fun speak(text: String) {
        if (isTtsReady) {
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
        } else {
            listener.onSpeechError("Text-to-Speech not ready")
        }
    }

    fun stop() {
        tts?.stop()
    }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
    }

    interface TextToSpeechListener {
        fun onTtsInitialized()
        fun onSpeechStart()
        fun onSpeechDone()
        fun onSpeechError(error: String)
    }
}
