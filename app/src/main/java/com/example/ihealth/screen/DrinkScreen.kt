package com.example.ihealth.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.example.ihealth.R
import com.example.ihealth.components.GoalCard
import com.example.ihealth.database.IHealthDatabase
import com.example.ihealth.database.entities.DrinkEntity
import com.example.ihealth.ui.theme.Padrao
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkScreen(navController: NavController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    var quantidade by remember { mutableIntStateOf(200) }
    var selectedIndex by remember { mutableIntStateOf(0) }
    val options = listOf("Água", "Suco", "Chá", "Outros")

    Scaffold { innerPadding ->
        Surface(modifier = Modifier.padding(innerPadding)) {
            Box(
                modifier = Modifier
                    .background(color = Padrao, shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                    .fillMaxWidth()
                    .padding(100.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(28.dp).fillMaxSize()
            ) {
                // Perfil do usuário
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Image(
                            modifier = Modifier.size(60.dp).clip(CircleShape),
                            painter = painterResource(id = R.drawable.__retrato),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Column {
                            Text("Bruna Costa", fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.W500)
                            Text("Iniciante", fontSize = 14.sp, color = Color.White)
                        }
                    }
                    GoalCard(2100, 3000)
                }

                // Ajuste da quantidade de líquido
                Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = { if (quantidade > 200) quantidade -= 100 },
                            colors = ButtonDefaults.buttonColors(containerColor = Padrao)
                        ) { Text("-", fontSize = 24.sp, fontWeight = FontWeight.W600) }

                        Text("${quantidade} ml", fontSize = 24.sp)

                        Button(
                            onClick = { quantidade += 100 },
                            colors = ButtonDefaults.buttonColors(containerColor = Padrao)
                        ) { Text("+", fontSize = 24.sp, fontWeight = FontWeight.W600) }
                    }

                    // Seleção do tipo de bebida
                    SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
                        options.forEachIndexed { index, label ->
                            SegmentedButton(
                                shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                                onClick = { selectedIndex = index },
                                selected = index == selectedIndex,
                                label = { Text(label) }
                            )
                        }
                    }

                    // Botão Salvar
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            val tipo = options[selectedIndex]
                            val currentDateTime = LocalDateTime.now()
                            val dataFormatada = currentDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                            val horaFormatada = currentDateTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"))

                            val drink = DrinkEntity(quantidade = quantidade, tipo = tipo, data = dataFormatada, hora = horaFormatada)

                            coroutineScope.launch {
                                IHealthDatabase.getInstance(context).drinkDao().save(drink)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Padrao)
                    ) {
                        Text("Salvar", color = Color.White)
                    }

                    // Botão Histórico
                    OutlinedButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { navController.navigate("drinkingHistory") },
                        border = BorderStroke(2.dp, color = Padrao)
                    ) {
                        Text("Histórico", color = Padrao)
                    }
                }
            }

            // Menu inferior de navegação
            Column(
                modifier = Modifier.fillMaxSize().padding(20.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Botão Home
                    TextButton(onClick = { navController.navigate("HomeScreen") }) {
                        Image(modifier = Modifier.size(24.dp), painter = painterResource(id = R.drawable.__home), contentDescription = "Home Icon")
                    }

                    // Botão Histórico
                    TextButton(onClick = { navController.navigate("profileScreen") }) {
                        Image(modifier = Modifier.size(24.dp), painter = painterResource(id = R.drawable.__historico), contentDescription = "History Icon")
                    }

                    // Botão Hidratação
                    TextButton(onClick = { navController.navigate("drinkingHistory") }) {
                        Image(modifier = Modifier.size(24.dp), painter = painterResource(id = R.drawable.__hidratacao), contentDescription = "Hydration Icon")
                    }

                    // Botão Perfil
                    TextButton(onClick = { navController.navigate("metasScreen") }) {
                        Image(modifier = Modifier.size(24.dp), painter = painterResource(id = R.drawable.__perfil), contentDescription = "Profile Icon")
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(device = Devices.PIXEL_3A)
@Composable
fun DrinkScreenPreview() {
    DrinkScreen(rememberNavController())
}
