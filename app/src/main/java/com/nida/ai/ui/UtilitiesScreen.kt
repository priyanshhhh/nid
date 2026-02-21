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
fun UtilitiesScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("AI Utilities Screen")
        // TODO: Implement Image generator, Instagram caption generator, Bio generator, Status/quote maker, Translate Hindi <-> English, Resume maker
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUtilitiesScreen() {
    NidaAITheme {
        UtilitiesScreen()
    }
}
