package com.example.mywhatsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScreen()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyScreen() {

    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(colorResource(id = R.color.backgroundToolBar))

    Scaffold(
        topBar = { Toolbar() },
        content = { Content() },
        bottomBar = { BottomBar() }
    )
}

@Composable
fun BottomBar() {
    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        containerColor = colorResource(id = R.color.backgroundToolBar)


    ) {
        IconButton(
            onClick = { /* Manejar la acción del botón */ }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "Home"
            )
        }
        // Agrega más botones o contenido según sea necesario
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = {
            Text(
                text = "WhatsApp",
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(colorResource(id = R.color.backgroundToolBar))
    )
}

@Composable
fun Content() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.background))
            .padding(top = 65.dp, bottom = 65.dp),
    ) {
        items(1) {
            MyChat()
        }
    }
}


@Preview
@Composable
fun MyChat() {
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
                text = "Apuntes", color = Color.White, fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(3.dp))
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = "Check view"
                )
                Text(
                    text = "Tú: Leche: 105",
                    color = colorResource(id = R.color.textGray),
                    fontSize = 14.sp
                )
            }
        }
    }

}

