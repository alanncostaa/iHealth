package com.example.ihealth.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ihealth.R

@Composable
fun MenuCard(){

    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(16.dp)
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            TextButton(
                onClick = { }
            ) {
                Image(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.__home),
                    contentDescription = null,
                )

            }

            TextButton(
                onClick = { }
            ) {
                Image(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.__historico),
                    contentDescription = null,
                )
            }

            TextButton(
                onClick = { }
            ) {
                Image(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.__hidratacao),
                    contentDescription = null,
                )

            }

            TextButton(
                onClick = { }
            ) {
                Image(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(id = R.drawable.__perfil),
                    contentDescription = null,
                )
            }
        }
    }



}

@Preview
@Composable
fun MenuCardPreview(){
    MenuCard(

    )
}