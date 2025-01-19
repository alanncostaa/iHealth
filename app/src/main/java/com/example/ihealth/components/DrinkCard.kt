package com.example.ihealth.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ihealth.R

@Composable
fun DrinkCard(data: String, hora: String, medida: Int) {
    Surface (
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(16.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {

            Row(

                verticalAlignment = Alignment.CenterVertically

            ) {
                Image(
                    modifier = Modifier
                        .size(80.dp),
                    painter = painterResource(id = R.drawable.__medium),
                    contentDescription = null,
                )
                Column(

                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.SpaceBetween

                ) {
                    Text("${data}",
                        fontSize = 12.sp,

                        )
                    Text("${medida} ml",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W500,
                    )
                    Text("${hora}",
                        fontSize = 12.sp,

                        )

                }
            }

            TextButton(
                onClick = {

                }
            ) {
                Image(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.__proximo),
                    contentDescription = null,
                )
            }


        }
    }
}

@Preview
@Composable
fun DrinkCardPreview(){
    DrinkCard("25 de Novembro","16:50", 200)
}