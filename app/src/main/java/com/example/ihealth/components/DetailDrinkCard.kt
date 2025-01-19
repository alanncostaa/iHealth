package com.example.ihealth.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ihealth.R

@Composable
fun DetailDrinkCard(data: String, hora: String, liquido: String, medida: Int){
    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
       Column(
           modifier = Modifier
               .fillMaxWidth()
               .padding(20.dp),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.spacedBy(12.dp),
       ){
           Image(
               modifier = Modifier
                   .size(80.dp),
               painter = painterResource(id = R.drawable.__big),
               contentDescription = null,
           )
           Text("${data}",
               fontSize = 12.sp,
           )
           Text("${hora}",
               fontSize = 12.sp,
           )
           Text("${liquido}",
               fontSize = 12.sp,
           )
           Text("${medida} ml",
               fontSize = 24.sp,
               fontWeight = FontWeight.W600,
           )
           OutlinedButton(
               onClick = {

               },
               border = BorderStroke(2.dp, color = Color.Red)
           ) {
               Text("Deletar",
                   color = Color.Red)
           }
       }
    }
}

@Preview
@Composable
fun DetailDrinkCardPreview(){
    DetailDrinkCard("25 de Novembro", "16:52", "Água", 200)
}