package com.example.ihealth.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextButton
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.ihealth.R


@Composable
fun TotalProgressCard(km: Double, hr: Double, kcal: Double) {
    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(16.dp) ,


    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)


        ) {
            Text("Progresso Total",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.W500)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF3F7FF))
                    .shadow(
                        elevation = 2.dp,
                        shape = RoundedCornerShape(16.dp),
                        clip = false,
                        spotColor = Color(0x80000000)
                    )
                    .padding(20.dp)



            ){
//          metrica 1
                Row{
                    Image(
                        modifier = Modifier
                            .size(45.dp),
                        painter = painterResource(id = R.drawable.km),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )

                    Column (horizontalAlignment = Alignment.End){
                        Text("${km}",
                            fontSize = 18.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.W500)
                        Text("km",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.W500)
                    }
                }
//          metrica 2
                Row(){
                    Image(
                        modifier = Modifier
                            .size(45.dp),
                        painter = painterResource(id = R.drawable.hr),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )

                    Column (horizontalAlignment = Alignment.End){
                        Text("${hr}",
                            fontSize = 18.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.W500)
                        Text("hr",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.W500)
                    }
                }
//          metrica 3
                Row(

                ){
                    Image(
                        modifier = Modifier
                            .size(45.dp),
                        painter = painterResource(id = R.drawable.kcal),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )

                    Column (horizontalAlignment = Alignment.End){
                        Text("${kcal}",
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.W500)
                        Text("Kcal",
                            fontSize = 12.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.W500)
                    }
                }
            }

        }
    }

}

@Preview
@Composable
fun TotalProgressCardPreview(){
    TotalProgressCard(hr = 10.5, km = 10.6, kcal = 100.0)
}
