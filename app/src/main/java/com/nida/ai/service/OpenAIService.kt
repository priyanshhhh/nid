package com.nida.ai.service

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

class OpenAIService {

    private val client = OkHttpClient()
    private val gson = Gson()

    // TODO: Replace with your actual OpenAI API Key
    private val OPENAI_API_KEY = "YOUR_OPENAI_API_KEY"
    private val CHAT_COMPLETIONS_URL = "https://api.openai.com/v1/chat/completions"

    suspend fun getChatCompletion(prompt: String): String = withContext(Dispatchers.IO) {
        val requestBody = gson.toJson(ChatCompletionRequest(
            model = "gpt-3.5-turbo",
            messages = listOf(Message("user", prompt))
        )).toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())

        val request = Request.Builder()
            .url(CHAT_COMPLETIONS_URL)
            .header("Authorization", "Bearer $OPENAI_API_KEY")
            .post(requestBody)
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")
            val responseBody = response.body?.string()
            val chatResponse = gson.fromJson(responseBody, ChatCompletionResponse::class.java)
            chatResponse.choices.firstOrNull()?.message?.content ?: "Error: No response from AI."
        }
    }
}

data class ChatCompletionRequest(
    val model: String,
    val messages: List<Message>
)

data class Message(
    val role: String,
    val content: String
)

data class ChatCompletionResponse(
    val choices: List<Choice>
)

data class Choice(
    val message: Message
)
