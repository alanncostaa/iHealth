package com.example.ihealth.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.ihealth.R
import com.example.ihealth.ui.theme.Padrao

@Composable
fun DataCard(metric1: String, metric2: String,labelm1:String, labelm2: String) {
    // Definindo o estado para o texto do TextField
    val text = remember { mutableStateOf("") } // Usando mutableStateOf para criar uma variável mutável
    val text2 = remember { mutableStateOf("") } // Usando mutableStateOf para criar uma variável mutável


    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(16.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, top = 10.dp, end = 40.dp, bottom = 5.dp),
        ) {
            // Metrica1
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(65.dp)
                ){
                    Text(
                        metric1,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ){
                    BasicTextField(
                        value = text.value,
                        onValueChange = { newText -> text.value = newText },
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth(0.6f)
                            .border(1.dp, Color.Black, shape = RoundedCornerShape(4.dp)),
                        singleLine = true
                    )

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .width(60.dp)
                            .height(40.dp)
                            .background(
                                color = Padrao,
                                shape = RoundedCornerShape(4.dp)
                            )
                    ){
                        Text(labelm1,
                            fontSize = 15.sp,
                            color = Color.White
                        )
                    }
                }
            }

            // Metrica 2

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .width(65.dp)
                ){
                    Text(
                        metric2,
                        fontSize = 13.sp,
                        color = Color.Black
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ){
                    BasicTextField(
                        value = text2.value,
                        onValueChange = { newText -> text2.value = newText },
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth(0.6f)
                            .border(1.dp, Color.Black, shape = RoundedCornerShape(4.dp)),

                        singleLine = true
                    )

                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .width(60.dp)
                            .height(40.dp)
                            .background(
                                color = Padrao,
                                shape = RoundedCornerShape(4.dp)
                            )
                    ){
                        Text(
                            labelm2,
                            fontSize = 15.sp,
                            color = Color.White
                        )
                    }
                }
            }

        }
    }
}
@Preview
@Composable
fun DataCardScreen() {
    DataCard(metric1 = "Peso", labelm1 = "kg", metric2 = "Hidratação", labelm2= "metros")
}
