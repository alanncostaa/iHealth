package com.example.ihealth.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import com.example.ihealth.components.DetailDrinkCard
import com.example.ihealth.components.DrinkCard
import com.example.ihealth.components.GoalCard
import com.example.ihealth.components.MenuCard
import com.example.ihealth.ui.theme.Padrao

@Composable
fun DrinkDetailScreen(navController: NavController) {
    Scaffold { innerPadding ->
        Surface (modifier = Modifier.padding(innerPadding)){
            Box(
                modifier = Modifier
                    .background(
                        color = Padrao,
                        shape = RoundedCornerShape(16.dp)
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
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        Image(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape),

                            painter = painterResource(id = R.drawable.__retrato),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Column {
                            Text("Bruna Costa",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.W500)
                            Text("Iniciante",
                                fontSize = 14.sp,
                                color = Color.White)
                        }

                    }
                    GoalCard(2100, 3000)
                }
                Column (

                    verticalArrangement = Arrangement.Top
                ){
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text("Hidratação")
                        TextButton(

                            onClick = {
                                navController.navigate("drinkingHistory")
                            },
                            modifier = Modifier
                                .padding(4.dp)

                        ) {
                            Image(
                                modifier = Modifier
                                    .size(16.dp),
                                painter = painterResource(id = R.drawable.__voltar),
                                contentDescription = null,

                                )
                            Text("Voltar",
                                color = Padrao,
                                modifier = Modifier
                                    .padding(8.dp))
                        }

                    }
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        DetailDrinkCard("25 de Novembro", "16:52","Água", 200)
                    }


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
fun DrinkDetailScreenPreview(){
    DrinkDetailScreen(rememberNavController())
}