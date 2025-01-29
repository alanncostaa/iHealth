package com.example.ihealth.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ihealth.R
import com.example.ihealth.database.IHealthDatabase
import com.example.ihealth.ui.theme.Padrao
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val userDao = IHealthDatabase.getInstance(context).userDao()

    val login = remember { mutableStateOf("") }
    val senha = remember { mutableStateOf("") }
    val errorMessage = remember { mutableStateOf("") }  // Para armazenar a mensagem de erro

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
                    .padding(250.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(28.dp)
                    .fillMaxSize()
            ) {
                // Exibição da imagem
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    Image(
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .size(280.dp),
                        painter = painterResource(id = R.drawable.health),
                        contentDescription = null,
                        contentScale = ContentScale.None
                    )
                }

                // Superfície do formulário de login
                Surface(
                    shadowElevation = 8.dp,
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(40.dp)
                    ) {
                        // Texto de "Login"
                        Text("Login", fontSize = 10.sp, color = Color.Black, fontWeight = FontWeight.W500)

                        // Campo de login
                        BasicTextField(
                            value = login.value,
                            onValueChange = { newText -> login.value = newText },
                            modifier = Modifier
                                .width(1000.dp)
                                .height(40.dp)
                                .border(1.dp, Color.LightGray, shape = RoundedCornerShape(4.dp)),
                            singleLine = true
                        )

                        // Texto de "Senha"
                        Text("Senha", fontSize = 10.sp, color = Color.Black, fontWeight = FontWeight.W500)

                        // Campo de senha
                        BasicTextField(
                            visualTransformation = PasswordVisualTransformation(),
                            value = senha.value,
                            onValueChange = { newText -> senha.value = newText },
                            modifier = Modifier
                                .width(1000.dp)
                                .height(40.dp)
                                .border(1.dp, Color.LightGray, shape = RoundedCornerShape(4.dp)),
                            singleLine = true
                        )

                        // Mostra a mensagem de erro, se houver
                        if (errorMessage.value.isNotEmpty()) {
                            Text(
                                text = errorMessage.value,
                                color = Color.Red,
                                style = MaterialTheme.typography.bodySmall
                            )
                        }

                        // Botão de acessar
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                coroutineScope.launch {
                                    val user = userDao.getUserByLoginAndSenha(login.value, senha.value)
                                    if (user != null) {
                                        navController.navigate("drinkingHistory")
                                    } else {
                                        errorMessage.value = "Email ou senha incorretos, ou usuário não cadastrado."
                                    }
                                }
                            },
                            colors = ButtonDefaults.buttonColors(containerColor = Padrao)
                        ) {
                            Text("Acessar", color = Color.White)
                        }

                        // Link para cadastro
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Cadastre-se",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF018786),
                                modifier = Modifier
                                    .clickable { navController.navigate("RegisterScreen") }
                                    .padding(16.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(rememberNavController())
}
