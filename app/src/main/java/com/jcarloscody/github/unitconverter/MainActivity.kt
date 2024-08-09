package com.jcarloscody.github.unitconverter

import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jcarloscody.github.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}


@Composable
fun UnitConverter(){
    val dropDown1 = remember {
        mutableStateOf(false)
    }

    var dropDown2 by remember {
        mutableStateOf(false)
    }

    var inputValue by remember {
        mutableStateOf("")
    }

    var convertionValue by remember {
        mutableStateOf(1.0)
    }

    var convertionValue2 by remember {
        mutableStateOf(1.0)
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Unit Converter", Modifier.padding(bottom = 16.dp))
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
            inputValue = it
            },
            label = {
                Text(text = "Digite um valor")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
           /* val ctx = LocalContext.current
            Button(onClick = {
                Toast.makeText(ctx,"Thanks for clicking!!",Toast.LENGTH_LONG).show()
            }) {
                Text(text = "Click Me!")
            }*/

            val select1 = remember {
                mutableStateOf("Select")
            }
            Box {
                Button(onClick = {
                    dropDown1.value = !dropDown1.value
                }) {
                    Text(text = select1.value)
                    Icon(Icons.Default.ArrowDropDown, "Arrow Down")
                }
                DropdownMenu(expanded = dropDown1.value, onDismissRequest = {
                    dropDown1.value = !dropDown1.value
                }) {
                    DropdownMenuItem(
                        text = { Text(text = "Metro") },
                        onClick = {
                            select1.value = "Metro"
                            dropDown1.value = !dropDown1.value
                            convertionValue = 100.0
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            select1.value = "Centimeters"
                            dropDown1.value = !dropDown1.value
                            convertionValue = 0.01
                        }
                    )
                }
            }

            val select2 = remember {
                mutableStateOf("Select")
            }
            Box {
                Button(onClick = {
                    dropDown2 = !dropDown2
                }) {
                    Text(text = select2.value)
                    Icon(Icons.Default.ArrowDropDown, "Arrow Down")
                }
                DropdownMenu(expanded = dropDown2, onDismissRequest = {
                    dropDown2 = !dropDown2
                }) {
                    DropdownMenuItem(
                        text = { Text(text = "Metro") },
                        onClick = {
                            select2.value = "Metro"
                            dropDown2 = !dropDown2
                            convertionValue2 = 100.0
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            select2.value = "Centimeters"
                            dropDown2 = !dropDown2
                            convertionValue2 = 0.01
                        }
                    )
                }
            }


        }
        Spacer(modifier = Modifier.height(16.dp))
        var result by remember {
            mutableStateOf(0.0)
        }
        Button(onClick = {
            result = inputValue.toFloat() * convertionValue  / convertionValue2*100
            println(inputValue.toFloat())
            println(convertionValue)
            println(convertionValue2)
            println(inputValue.toFloat() * convertionValue)
            println(inputValue.toFloat() * convertionValue  / convertionValue2)
        }) {
            Text(text = "Click", style = TextStyle(fontFamily = FontFamily.Default, fontSize = 16.sp, color = Color.Red,))
            Icon(Icons.Default.Done, "Done")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Resultado: $result",
            style = MaterialTheme.typography.headlineLarge
            )
    }
}


@Preview
@Composable
fun UnitConverterPreview (){
    UnitConverter()
}

