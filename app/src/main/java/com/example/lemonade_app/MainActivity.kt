package com.example.lemonade_app

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade_app.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun LemonadeApp() {

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.top_bar),
                    fontSize = 30.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color(
                    249,
                    228,
                    76,
                    255
                )
            ),
        )
    }, content = {
        ScreenViewChange()
    }
    )
}


@Composable
fun LemonScreen(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionId: Int,
    onLemonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = { onLemonClick() },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(195, 236, 219, 255)),
                shape = RoundedCornerShape(48.dp)
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionId),
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(24.dp)
                        .width(200.dp)
                        .height(200.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = stringResource(textLabelResourceId))
        }
    }
}

@Composable
fun ScreenViewChange() {
    var currentStep by remember { mutableStateOf(0) }

    val textLabelResourceId = when (currentStep) {
        0 -> R.string.lemon_select
        1 -> R.string.squeeze
        2 -> R.string.drink_lemon
        else -> R.string.restart_message
    }

    val drawableResourceId = when (currentStep){
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val contentDescriptionId = when(currentStep){
        0 -> R.string.tree_content_description
        1 -> R.string.lemon_content_description
        2 -> R.string.glass_content_description
        else -> R.string.empty_content_description
    }

    LemonScreen(
        textLabelResourceId = textLabelResourceId,
        drawableResourceId = drawableResourceId,
        contentDescriptionId = contentDescriptionId,
        onLemonClick = { currentStep = (currentStep + 1).rem(4) })
}
