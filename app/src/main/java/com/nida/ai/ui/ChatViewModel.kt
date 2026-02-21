package com.nida.ai.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nida.ai.service.OpenAIService
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    val messages = mutableStateListOf<Message>()
    private val openAIService = OpenAIService()

    init {
        messages.add(Message("Hello! How can I help you today?", false))
    }

    fun sendMessage(text: String) {
        if (text.isNotBlank()) {
            messages.add(Message(text, true))
            viewModelScope.launch {
                try {
                    val aiResponse = openAIService.getChatCompletion(text)
                    messages.add(Message(aiResponse, false))
                } catch (e: Exception) {
                    messages.add(Message("Error: ${e.message}", false))
                }
            }
        }
    }

    // TODO: Implement voice-to-text and text-to-voice
    // TODO: Implement emotional support mode
    // TODO: Implement Hinglish + English support
    // TODO: Implement memory for user preferences
}
