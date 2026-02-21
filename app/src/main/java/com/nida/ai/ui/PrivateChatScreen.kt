package com.nida.ai.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nida.ai.ui.theme.NidaAITheme

@Composable
fun PrivateChatScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Password Protected Private Chat Mode")
        // TODO: Implement password protection and private chat logic
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPrivateChatScreen() {
    NidaAITheme {
        PrivateChatScreen()
    }
}
