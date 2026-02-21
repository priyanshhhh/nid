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
fun TranslateScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hindi ↔ English Translation Feature")
        // TODO: Implement logic for Hindi ↔ English translation
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTranslateScreen() {
    NidaAITheme {
        TranslateScreen()
    }
}
