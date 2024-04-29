package com.komparo.helpfullinks.screens

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.komparo.helpfullinks.R
import com.komparo.helpfullinks.data.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OneScreen(context : Context, database : AppDatabase, navController: NavController) {
    val texted = rememberSaveable { mutableStateOf("") }
    val items = remember { mutableStateListOf<Pair<String, UrlData>>() }
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    Scaffold(
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.sharp_delete_forever_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            items.clear()
                            texted.value = ""
                        })
                TextField(
                    value = texted.value, onValueChange = { newValue -> texted.value = newValue },
                    modifier = Modifier.weight(1f),
                    label = { Text("Введите ссылку здесь") }
                )
                Image(painter = painterResource(id = R.drawable.baseline_save_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            if (texted.value.isNotEmpty()) {
                                scope.launch {
                                    val urlsData = fetchUrlData(texted.value)
                                    items.add(0, Pair(texted.value, urlsData))
                                    listState.animateScrollToItem(index = 0)
                                }
                            } else {
                                Toast.makeText(context, "Нет ничего для сохранения!", Toast.LENGTH_SHORT).show()
                            }
                        })
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.darkblue),
                            colorResource(id = R.color.lightblue)
                        )
                    )
                ), contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = database.oneDao().getTitle()?.title.toString(),
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .clickable { navController.navigate("mainScreen") },
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white)
                )
                LazyColumn(modifier = Modifier.padding(bottom = 72.dp), state = listState) {
                    items(items) { item ->
                        Card(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .background(Color.Transparent)
                                .shadow(
                                    elevation = 5.dp, ambientColor = Color.White,
                                    shape = CutCornerShape(
                                        bottomStart = 16.dp,
                                        topStart = 8.dp,
                                        topEnd = 8.dp,
                                        bottomEnd = 8.dp
                                    )
                                ),
                            shape = CutCornerShape(bottomStart = 16.dp, topStart = 8.dp, topEnd = 8.dp, bottomEnd = 8.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .background(
                                        brush = Brush.verticalGradient(
                                            colors = listOf(
                                                colorResource(id = R.color.darkblue),
                                                colorResource(id = R.color.lightblue)
                                            )
                                        )
                                    )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                        .background(
                                            brush = Brush.verticalGradient(
                                                colors = listOf(
                                                    colorResource(id = R.color.darkblue),
                                                    colorResource(id = R.color.lightblue)
                                                )
                                            )
                                        )
                                ) {
                                    Row( modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.End
                                    ){
                                        Image(
                                            painter = painterResource(id = R.drawable.sharp_delete_forever_24),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(40.dp)
                                                .padding(end = 16.dp)
                                                .clickable { items.remove(item) },
                                            alignment = Alignment.CenterEnd
                                        )
                                    }
                                    Card( modifier = Modifier
                                        .padding(
                                            start = 16.dp,
                                            end = 16.dp,
                                            top = 8.dp,
                                            bottom = 8.dp
                                        )
                                        .fillMaxWidth()
                                        .wrapContentHeight()
                                        .background(Color.Transparent),
                                        shape = CutCornerShape(bottomStart = 16.dp, topStart = 16.dp, topEnd = 16.dp, bottomEnd = 16.dp)) {
                                        Image(painter = rememberImagePainter(
                                                data = item.second.imageUrl),
                                               // builder = { fallback(R.drawable.emptylink) }),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .aspectRatio(16f / 9f)
                                        )
                                    }
                                    val annotatedString = buildAnnotatedString {
                                        withStyle(style = SpanStyle(color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold,
                                        textDecoration = TextDecoration.Underline)) {
                                            append(item.first)
                                            addStringAnnotation(
                                                tag = "URL",
                                                annotation = item.first,
                                                start = 0,
                                                end = item.first.length
                                            )
                                        }
                                    }
                                    Row {
                                        Image(painter = painterResource(id = R.drawable.globals), contentDescription = null,
                                            modifier = Modifier.size(50.dp).padding(start = 8.dp))
                                        ClickableText(
                                            text = annotatedString,
                                            onClick = { offset ->
                                                annotatedString.getStringAnnotations("URL", offset, offset)
                                                    .firstOrNull()?.let { annotation ->
                                                        val url = annotation.item
                                                        val intent = Intent(Intent.ACTION_VIEW)
                                                        intent.data = Uri.parse(url)
                                                        try {
                                                            context.startActivity(intent)
                                                        } catch (e: ActivityNotFoundException) {
                                                            Toast.makeText(context, "Пожалуйста, проверьте свою ссылку!", Toast.LENGTH_SHORT).show()
                                                            e.printStackTrace()
                                                        }
                                                    }
                                            },
                                            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 8.dp, bottom = 8.dp)
                                        )
                                    }

                                }
                            }
                        }
                    }

                }
            }
        }
    }
}

data class UrlData(val title: String, val imageUrl: String)

suspend fun fetchUrlData(url: String): UrlData {
    return withContext(Dispatchers.IO) {
        try {
            val doc = Jsoup.connect(url).get()
            val title = doc.title()
            val imageUrl = doc.select("meta[property=og:image]").first()?.attr("content")
            UrlData(title, imageUrl ?: "")
        } catch (e: Exception) {
            UrlData("", "")
        }
    }
}