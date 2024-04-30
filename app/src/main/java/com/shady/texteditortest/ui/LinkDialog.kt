package com.shady.texteditortest.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun LinkDialog(
    showLinkDialog: Boolean,
    onDismissRequest: () -> Unit,
    onConfirmation: (String, String) -> Unit
) {
    if (showLinkDialog) {
        Dialog(
            onDismissRequest = onDismissRequest
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    val linkTextState = remember { mutableStateOf("") }
                    val linkState = remember { mutableStateOf("") }

                    Surface(
                        color = Color.LightGray, // Background color for the first BasicTextField
                        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                    ) {
                        BasicTextField(
                            value = linkTextState.value,
                            onValueChange = { linkTextState.value = it },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(color = Color.Black)
                        )
                    }

                    Surface(
                        color = Color.LightGray, // Background color for the second BasicTextField
                        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
                    ) {
                        BasicTextField(
                            value = linkState.value,
                            onValueChange = { linkState.value = it },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(color = Color.Black)
                        )
                    }

                    Button(
                        onClick = {
                            onConfirmation(linkTextState.value, linkState.value)
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Confirm")
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun LinkDialogPreview() {
    LinkDialog(
        showLinkDialog = true,
        onDismissRequest = { /*TODO*/ },
        onConfirmation = { s1,s2 ->

        }
    )
}
