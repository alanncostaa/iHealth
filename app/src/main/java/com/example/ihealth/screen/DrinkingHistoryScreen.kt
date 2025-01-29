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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.room.Entity
import com.example.ihealth.R
import com.example.ihealth.components.DrinkCard
import com.example.ihealth.components.GoalCard
import com.example.ihealth.components.MenuCard
import com.example.ihealth.database.IHealthDatabase
import com.example.ihealth.database.entities.DrinkEntity
import com.example.ihealth.ui.theme.Padrao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkingHistoryScreen(navController: NavController) {
    val context = LocalContext.current
    var drinkHistory by remember { mutableStateOf<List<DrinkEntity>>(emptyList()) }

    LaunchedEffect(Unit) {
        drinkHistory = withContext(Dispatchers.IO) {
            IHealthDatabase.getInstance(context).drinkDao().findAll()
        }
    }

    Scaffold { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            Box(
                modifier = Modifier
                    .background(
                        color = Padrao,
                        shape = RoundedCornerShape(
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
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(28.dp)
                    .fillMaxSize()
            ) {

                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .size(60.dp)
                                .clip(CircleShape),
                            painter = painterResource(id = R.drawable.__retrato),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Column {
                            Text(
                                "Bruna Costa",
                                fontSize = 20.sp,
                                color = Color.White,
                                fontWeight = FontWeight.W500
                            )
                            Text(
                                "Iniciante",
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        }
                    }
                    GoalCard(2100, 3000)
                }
                Column(
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Histórico de Hidratação")
                        TextButton(
                            onClick = {
                                navController.navigate("drinkScreen")
                            },
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Image(
                                modifier = Modifier.size(16.dp),
                                painter = painterResource(id = R.drawable.__voltar),
                                contentDescription = null,
                            )
                            Text(
                                "Voltar",
                                color = Padrao,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Exibindo os drinks do histórico
                        for (drink in drinkHistory) {
                            DrinkCard(drink, navController)
                        }
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
fun DrinkHistoryScreenPreview(){
    DrinkingHistoryScreen(rememberNavController())
}