package com.example.ihealth.screen

import android.annotation.SuppressLint
import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Canvas
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
import com.example.ihealth.components.GoalCard
import com.example.ihealth.components.MenuCard
import com.example.ihealth.ui.theme.Padrao


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkScreen(navController: NavController) {



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

                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        var aux by remember { mutableIntStateOf(200) }
                        Button(
                            onClick = {
                                if(aux > 200.00){
                                    aux = aux - 100
                                    }
                                      },
                            colors = ButtonDefaults.buttonColors(containerColor = Padrao)
                        ) {
                            Text("-",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.W600)
                        }
                        Text("${aux} ml",
                            fontSize = 24.sp)
                        Button(
                            onClick = {
                                aux = aux + 100},
                            colors = ButtonDefaults.buttonColors(containerColor = Padrao)
                        ) {
                            Text("+",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.W600)
                        }


                    }

                    var selectedIndex by remember { mutableIntStateOf(0) }
                    val options = listOf("Água", "Suco", "Chá", "Outros")

                    SingleChoiceSegmentedButtonRow (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                        options.forEachIndexed { index, label ->
                            SegmentedButton(
                                shape = SegmentedButtonDefaults.itemShape(
                                    index = index,
                                    count = options.size
                                ),
                                onClick = { selectedIndex = index },
                                selected = index == selectedIndex,
                                label = { Text(label) }
                            )
                        }
                    }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Padrao)
                    ) { Text("Salvar",
                        color = Color.White)
                    }


                    OutlinedButton(
                        modifier = Modifier
                            .fillMaxWidth(),
                        onClick = {
                            navController.navigate("drinkingHistory")
                        },
                        border = BorderStroke(2.dp, color = Padrao)
                    ) { Text("Historico",
                        color = Padrao)
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
fun DrinkScreenPreview(){
    DrinkScreen(rememberNavController())
}
