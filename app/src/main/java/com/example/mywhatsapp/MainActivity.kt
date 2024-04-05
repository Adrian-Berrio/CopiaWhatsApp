package com.example.mywhatsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mywhatsapp.data.MyChat
import com.example.mywhatsapp.data.obtenerChats
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyScreen() {

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(colorResource(id = R.color.backgroundToolBar))

    val chatsList = remember { mutableStateListOf<MyChat>() }
    chatsList.addAll(obtenerChats())

    Scaffold(
        floatingActionButton = { FloatingActionButton(chatsList) },
        topBar = { Toolbar() },
        content = { Content(chatsList) },
        bottomBar = { BottomBar() }
    )
}

@Composable
fun FloatingActionButton(listChat: MutableList<MyChat>) {
    FloatingActionButton(onClick = { addChat(listChat) }) {
        Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = "AddChat")
    }
}

fun addChat(listChat: MutableList<MyChat>) {
    listChat.add(MyChat("Andrea", "Claskdshfahsfsaf"))
}

@Composable
fun BottomBar() {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        containerColor = colorResource(id = R.color.backgroundToolBar)


    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(
                onClick = { /* Manejar la acción del botón */ },
                modifier = Modifier.size(90.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_message),
                        contentDescription = "chats",
                        tint = Color.White
                    )
                    Text(
                        text = "Chats", color = colorResource(id = R.color.textGray)
                    )
                }
            }
            IconButton(
                onClick = { /* Manejar la acción del botón */ },
                modifier = Modifier.size(90.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_stories),
                        contentDescription = "chats",
                        tint = Color.White
                    )
                    Text(
                        text = "Novedades", color = colorResource(id = R.color.textGray)
                    )
                }
            }
            IconButton(
                onClick = { /* Manejar la acción del botón */ },
                modifier = Modifier.size(90.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_comunity),
                        contentDescription = "chats",
                        tint = Color.White
                    )
                    Text(
                        text = "Comunidades", color = colorResource(id = R.color.textGray)
                    )
                }
            }
            IconButton(
                onClick = { /* Manejar la acción del botón */ },
                modifier = Modifier.size(90.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_phone),
                        contentDescription = "chats",
                        tint = Color.White
                    )
                    Text(
                        text = "Llamadas", color = colorResource(id = R.color.textGray),
                    )
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        modifier = Modifier.height(55.dp),
        title = {
            Text(
                text = "WhatsApp",
                color = Color.White,
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(Alignment.CenterVertically)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(colorResource(id = R.color.backgroundToolBar)),
        actions = {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = "menuPrincipal",
                    tint = Color.White
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_lupa),
                    contentDescription = "busqueda",
                    tint = Color.White
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentHeight(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_menu_puntos),
                    contentDescription = "menuPrincipal",
                    tint = Color.White
                )
            }
        }
    )
}

@Composable
fun Content(chats: MutableList<MyChat>) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.background))
            .padding(top = 55.dp, bottom = 65.dp),
    ) {
        items(chats) { chat ->
            MyChat(chat)
        }
    }
}


@Composable
fun MyChat(chat: MyChat) {
    Row(modifier = Modifier.padding(10.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_account),
            contentDescription = "Perfil de Prueba",
            modifier = Modifier
                .clip(CircleShape)
                .size(64.dp),
            colorFilter = ColorFilter.tint(Color.White)
        )
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = chat.name, color = Color.White, fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(3.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = "Check view",
                    colorFilter = ColorFilter.tint(colorResource(id = R.color.textGray)),
                    modifier = Modifier
                        .size(20.dp)
                        .padding(end = 8.dp)
                )
                Text(
                    text = chat.description,
                    color = colorResource(id = R.color.textGray),
                    fontSize = 14.sp
                )
            }
        }
    }

}



