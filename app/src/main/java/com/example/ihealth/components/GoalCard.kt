package com.example.ihealth.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.ihealth.R


@Composable
fun GoalCard(ingerido: Int, meta: Int) {
    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),

            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)


        ) {
            Column (
                verticalArrangement = Arrangement.spacedBy(24.dp),
            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Text("Meta do dia ${meta} ml",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600,
                        )
                    TextButton(
                        onClick = { }
                    ) {
                        Image(
                            modifier = Modifier
                                .size(20.dp),
                            painter = painterResource(id = R.drawable.__proximo),
                            contentDescription = null,
                        )
                    }



                }

                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("${ingerido} ml ingeridos",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W500,
                    )
                    Text("${meta-ingerido} ml faltam",
                        fontSize = 14.sp,)
                }
            }


                LinearProgressIndicator(progress = 0.7f,
                    modifier = Modifier
                        .fillMaxWidth(),
                    Color(color = 0xFF40B59F)



                        )

        }
    }

}

@Preview
@Composable
fun GoalCardPreview(){
    GoalCard(2100,3000)
}
