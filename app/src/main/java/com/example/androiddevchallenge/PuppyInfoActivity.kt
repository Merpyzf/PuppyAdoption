package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class PuppyInfoActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context, puppy: Puppy) {
            val intent = Intent(context, PuppyInfoActivity::class.java)
            intent.putExtra("puppy", puppy)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val puppy = intent.extras!!.getSerializable("puppy") as Puppy
        setContent {
            Surface(
                color = Color.White, modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                MyTheme {
                    PuppyInfo(puppy)
                }
            }
        }
    }

    @Composable
    fun PuppyInfo(puppy: Puppy) {
        val typography = MaterialTheme.typography
        val puppyImg = painterResource(id = puppy.photo)
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = puppyImg,
                contentDescription = "puppy's photo",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(16.dp))
            Column {
                Text(text = puppy.variety, style = typography.h5)
                Text(text = "${puppy.age} years old, is a ${puppy.gender}", style = typography.h6)
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = "${puppy.moreInfo}", style = typography.body1, color = Color.Gray)
            }
        }
    }
}




