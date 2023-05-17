package com.example.lemonade_app

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade_app.ui.theme.LemonadeAppTheme
import java.util.IdentityHashMap

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

@Preview (showBackground = true)
@Composable
fun LemonadeApp() {
    LemonScreen(
        textLabelResourceId = R.string.lemon_select,
        drawableResourceId = R.drawable.lemon_tree,
        contentDescriptionId = R.string.tree_content_description,
    )
}


@Composable
fun LemonScreen(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionId: Int,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
//            Button(
//                onClick = onImageClick,
//                shape = RoundedCornerShape( 40.dp)
//            ){
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionId),
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(24.dp)
                )
//            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(text = stringResource(textLabelResourceId))
        }
    }
}