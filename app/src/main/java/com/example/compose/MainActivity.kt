package com.example.compose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val bluetoothManager  = getSystemService(Context.BLUETOOTH_SERVICE)
//        val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
//        bluetoothAdapter.getProfileConnectionState

        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", modifier =  Modifier.padding(3.dp), onClick = {
                        Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_LONG).show()
                    })
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Column(Modifier.clickable(onClick = onClick)) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )

        Text(
            text = "Hello XiaoJing!",
            modifier = modifier
        )

        Row(verticalAlignment = Alignment.Bottom) {
            Text(text = "zhangtao")
            Text(text = "xiaojing")
        }

        MyButton(LocalContext.current.applicationContext)
        ExtendedFloatingActionButton(
            text = { Text(text = "Hello，Compose，Hello，New Android") },
            icon = {
                Icon(
                    Icons.Filled.Close, contentDescription = "close",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
            },
            onClick = { /*TODO*/ })
        ExtendedFloatingActionButton(onClick = { }, content = {
            Icon(
                Icons.Filled.Close, contentDescription = "close",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Text(text = "Hello，Compose，Hello，New Android")
        })
        showBasicText(message = stringResource(R.string.XiaoJing))
        showText(message = stringResource(R.string.XiaoJing), color = Color.Red)
        showText(message = stringResource(R.string.XiaoJing), fontSize = 20.sp, fontStyle = FontStyle.Italic)
    }

}

@Composable
fun MyButton(context: Context) {
    Button(
        onClick = { handleClick(context) },
        contentPadding = ButtonDefaults.ContentPadding
    ) {
        Icon(
            Icons.Filled.Favorite, contentDescription = "hello",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Hi,Xiao Jing")
    }
}

fun handleClick(context: Context) {
    Toast.makeText(context, "Hello, XiaoJing", Toast.LENGTH_LONG).show()
}

@Composable
fun showText(
    message: String,
    color: Color = Color.Cyan,
    fontSize: TextUnit = 30.sp,
    fontStyle: FontStyle?= FontStyle.Normal
) {
    Text(text = message,
        modifier = Modifier.width(120.dp), color = color, fontSize = fontSize, fontStyle = fontStyle,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.End,
        fontFamily = FontFamily.Serif
    )
}

@Composable
fun showBasicText(message: String) {
    BasicText(text = message)
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeDemoTheme {
//        Greeting("Android")
//    }
//}