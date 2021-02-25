/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.contextaware.ContextAware
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.pink100

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun MyApp() {
    val repository = Repository()
    val puppyList = repository.getPuppyList()
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn {
            stickyHeader {
                PuppyInfo()
            }
            items(puppyList, ({
                it.toString()
            }), itemContent = {
                PuppyItem(it)
            })
        }
    }
}

@Composable
fun PuppyInfo() {
    val typography = MaterialTheme.typography
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "PUPPY ADOPTION",
            style = typography.h5,
            fontWeight = FontWeight.W700
        )
    }
}

//@Preview("Light Theme")
@Composable
fun PuppyItem(puppy: Puppy) {
    val puppyImg = painterResource(id = puppy.photo)
    val typography = MaterialTheme.typography
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(8.dp))
                .clickable(true, "show puppy detail", onClick = {
                    PuppyInfoActivity.startActivity(context = context, puppy = puppy)
                })
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = puppyImg, contentDescription = "🐶", modifier = Modifier
                    .padding(8.dp)
                    .width(80.dp)
                    .height(80.dp)
                    .clip(shape = RoundedCornerShape(40.dp))
                    .border(4.dp, pink100, shape = RoundedCornerShape(40.dp)),
                alignment = Alignment.BottomCenter,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = puppy.variety, style = typography.h6)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${puppy.age} years old, is a ${puppy.gender}",
                    style = typography.body1,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = puppy.moreInfo,
                    style = typography.body1,
                    color = Color.Gray,
                    maxLines = 1
                )
            }
        }
    }
}
