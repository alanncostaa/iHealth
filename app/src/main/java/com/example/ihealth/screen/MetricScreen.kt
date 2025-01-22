package com.example.ihealth.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ihealth.R
import com.example.ihealth.components.DataCard
import com.example.ihealth.components.MenuCard
import com.example.ihealth.ui.theme.Padrao

@Composable
fun MetricScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Surface (modifier = Modifier.padding(innerPadding)){
            Box(
                modifier = Modifier
                    .background(
                        color = Padrao,
                        shape =RoundedCornerShape(
                            topStart = 0.dp,
                            topEnd = 0.dp,
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .fillMaxWidth()
                    .padding(100.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(28.dp)
                    .fillMaxSize()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ){
                    Column (
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,

                        ){
                        Text("Profile",
                            fontSize = 10.sp,
                            color = Color.White,
                            fontWeight = FontWeight.W500)
                        Image(
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape),

                            painter = painterResource(id = R.drawable.__retrato),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Column (
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Text("Andrey",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.W500)
                            Text("Beginner",
                                fontSize = 10.sp,
                                color = Color.White)
                        }

                    }

                    DataCard(metric1 = "Exercicios", labelm1 = "km", metric2 = "Hidratação", labelm2= "ml")

                }
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        navController.navigate("drinkingHistory")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Padrao)
                ) { Text("Salvar Alterações",
                    color = Color.White)
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Bottom
            ) { MenuCard() }

        }

    }
}

@Preview(
    device = Devices.PIXEL_3A
)
@Composable
fun MetricScreen(){
    MetricScreen(rememberNavController())
}