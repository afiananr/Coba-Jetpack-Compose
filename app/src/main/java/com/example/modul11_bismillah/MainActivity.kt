package com.example.modul11_bismillah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.modul11_bismillah.ui.theme.Modul11_BismillahTheme

private val sampleName = listOf(
    "Ana anak Baik",
    "Ana anak Rajin",
    "Ana anak Indipindin",
    "Ana tidak suka berkata kasar",
    "Ana Sopan Santun",
    "Ana Berhati Mulia",
    "Ana Berperilaku Terpuji"
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Modul11_BismillahTheme {
                Modul11_BismillahApp ()
            }
        }
    }
}

@Composable
fun Modul11_BismillahApp() {
    GreetingList(sampleName)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var isExpanded by remember { mutableStateOf(false) }
    val animatedSizeDp by animateDpAsState(
        targetValue = if (isExpanded) 120.dp else 80.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = ""
    )

    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.jetpack_compose),
            contentDescription = "Logo Jetpack Compose",
            modifier = Modifier.size(animatedSizeDp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column (modifier = Modifier.weight(1f)){
            Text(
                text = "Hello $name!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
            )
            Text(text = "Welcome to HomePage!")
        }
        IconButton(onClick = { isExpanded = !isExpanded }) {
            Icon(
                imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Outlined.ExpandMore,
                contentDescription = if (isExpanded) "Show less" else "Show more"
            )
        }

    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun Modul11_BismillahPreview() {
    Modul11_BismillahTheme {
        Modul11_BismillahApp()
    }
}
@Composable
fun GreetingList(names: List<String>) {
    if (names.isNotEmpty()) {
        LazyColumn {
            items(names) { name ->
                Greeting(name)
            }
        }
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("No people to greet :(")
        }
    }
}




