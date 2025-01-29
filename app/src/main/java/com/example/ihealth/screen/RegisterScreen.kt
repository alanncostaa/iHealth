package com.example.ihealth.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ihealth.R
import com.example.ihealth.database.IHealthDatabase
import com.example.ihealth.database.entities.UserEntity
import com.example.ihealth.ui.theme.Padrao
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(navController: NavController) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val userDao = IHealthDatabase.getInstance(context).userDao()

    var login by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var nome by remember { mutableStateOf("") }
    var sobrenome by remember { mutableStateOf("") }
    var sexo by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }

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
                    .padding(250.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(28.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .size(280.dp),
                    painter = painterResource(id = R.drawable.health),
                    contentDescription = null,
                    contentScale = ContentScale.None
                )

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
                        Text("Cadastro", style = MaterialTheme.typography.headlineMedium)
                        Spacer(modifier = Modifier.height(16.dp))

                        CustomTextField(value = login, onValueChange = { login = it }, label = "Login")
                        CustomTextField(value = senha, onValueChange = { senha = it }, label = "Senha", isPassword = true)
                        CustomTextField(value = email, onValueChange = { email = it }, label = "Email")
                        CustomTextField(value = nome, onValueChange = { nome = it }, label = "Nome")
                        CustomTextField(value = sobrenome, onValueChange = { sobrenome = it }, label = "Sobrenome")
                        CustomTextField(value = sexo, onValueChange = { sexo = it }, label = "Sexo")
                        CustomTextField(value = peso, onValueChange = { peso = it }, label = "Peso")
                        CustomTextField(value = altura, onValueChange = { altura = it }, label = "Altura")
                        CustomTextField(value = idade, onValueChange = { idade = it }, label = "Idade")

                        Spacer(modifier = Modifier.height(16.dp))
                        Button(onClick = {
                            coroutineScope.launch {
                                val user = UserEntity(
                                    login = login,
                                    senha = senha,
                                    email = email,
                                    nome = nome,
                                    sobrenome = sobrenome,
                                    sexo = sexo,
                                    peso = peso,
                                    altura = altura,
                                    idade = idade
                                )
                                userDao.insertUser(user)
                            }

                            navController.navigate("LoginScreen") {
                                popUpTo("RegisterScreen") { inclusive = true }
                            }
                        }) {
                            Text("Cadastrar")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CustomTextField(value: String, onValueChange: (String) -> Unit, label: String, isPassword: Boolean = false) {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Text(label, style = MaterialTheme.typography.bodySmall)
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
            modifier = Modifier
                .width(1000.dp)
                .height(40.dp)
                .border(1.dp, Color.LightGray, shape = RoundedCornerShape(4.dp)),
        )
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(rememberNavController())
}
