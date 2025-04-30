package com.example.captaingame

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaptainGameTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CaptainGame()
                }
            }
        }
    }
    @Composable

    fun CaptainGame(){

        val treasuresFound = remember { mutableStateOf(0) }
        //val treasuresFound by remember { mutableStateOf(0) } //no need to add .value in Text
        val direction = remember { mutableStateOf("North") }
        val stormOrTresure = remember { mutableStateOf(" ") }

        Column {
            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Treasures Found : ${treasuresFound.value}")
            //Text(text = "Treasures Found : ${treasuresFound}")
            Text(text = "Current Direction : ${direction.value}")
            Text(text = "${stormOrTresure.value}")

            Button(onClick =  {
                direction.value = "East"
                if(Random.nextBoolean()) {
                    treasuresFound.value += 1
                    stormOrTresure.value = "Found a Treasure!"
                }else{
                    stormOrTresure.value = "Storm ahead!"
                }
            }){
                Text("Sail East")
            }

            Button(onClick =  {
                direction.value = "West"
                if(Random.nextBoolean()){
                    treasuresFound.value += 1
                    stormOrTresure.value = "Found a Treasure!"
                }else{
                    stormOrTresure.value = "Storm ahead!"
                }
            }){
                Text("Sail West")
            }

            Button(onClick =  {
                direction.value = "North"
                if(Random.nextBoolean()){
                    treasuresFound.value += 1
                    stormOrTresure.value = "Found a Treasure!"
                }else{
                    stormOrTresure.value = "Storm ahead!"
                }
            }){
                Text("Sail North")
            }

            Button(onClick =  {
                direction.value = "South"
                if(Random.nextBoolean()){
                    treasuresFound.value += 1
                    stormOrTresure.value = "Found a Treasure!"
                }else{
                    stormOrTresure.value = "Storm ahead!"
                }
            }){
                Text("Sail South")
            }
        }
    }



}

