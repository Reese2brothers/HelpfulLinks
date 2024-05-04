package com.komparo.helpfullinks.screens

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ShareCompat
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.komparo.helpfullinks.R
import com.komparo.helpfullinks.data.AppDatabase
import com.komparo.helpfullinks.data.dao.ScreenOneDao
import com.komparo.helpfullinks.data.model.ScreenOne
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OneScreen(context : Context, database : AppDatabase, navController: NavController) {
    val texted = rememberSaveable { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    val showDialog = remember { mutableStateOf(false) }
    val showIdDialog = remember { mutableStateOf(false) }
    val isLoading = remember { mutableStateOf(false) }
    val items = remember { mutableStateListOf<UrlDataOne>() }
    var toBeDeleted by rememberSaveable { mutableStateOf<ScreenOne?>(null) }
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState().value

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
                            showDialog.value = true
                        })
                if (showDialog.value) {
                    AlertDialog(
                        onDismissRequest = {
                            showDialog.value = false
                        },
                        title = { Text("Подтверждение", color = colorResource(id = R.color.darkblue)) },
                        text = { Text("Вы уверены, что хотите полностью удалить весь раздел и все данные?",
                            color = colorResource(id = R.color.darkblue)) },
                        confirmButton = {
                            Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.darkblue)),
                                onClick = {
                                    scope.launch {
                                        items.clear()
                                        texted.value = ""
                                        database.oneDao().deleteAll()
                                        database.screenOneDao().deleteAll()
                                        navController.navigate("mainScreen")
                                    }
                                showDialog.value = false
                            }) {
                                Text("Да", color = colorResource(id = R.color.white))
                            }
                        },
                        dismissButton = {
                            Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.darkblue)),
                                onClick = {
                                showDialog.value = false
                            }) {
                                Text("Нет", color = colorResource(id = R.color.white))
                            }
                        }
                    )
                }
                TextField(colors = TextFieldDefaults.textFieldColors(
                    containerColor = colorResource(id = R.color.lightfield),
                    cursorColor = colorResource(id = R.color.orange),
                    unfocusedIndicatorColor = colorResource(id = R.color.darkblue),
                    focusedIndicatorColor = colorResource(id = R.color.orange),
                    textColor = colorResource(id = R.color.darkblue)),
                    value = texted.value, onValueChange = { newValue -> texted.value = newValue },
                    modifier = Modifier.weight(1f),
                    label = { Text("Введите ссылку здесь", color = colorResource(id = R.color.orange)) },
                    trailingIcon = {
                        if (texted.value.isNotEmpty()) {
                            IconButton(onClick = { texted.value = "" }) {
                                Icon(Icons.Default.Clear, contentDescription = "Очистить поле", tint = colorResource(
                                    id = R.color.orange
                                ))
                            }
                        }
                    }
                )
                if (isLoading.value) {
                    CircularProgressIndicator(color = colorResource(id = R.color.orange), strokeWidth = 3.dp)
                }
                Image(painter = painterResource(id = R.drawable.baseline_save_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                            val activeNetworkInfo = connectivityManager.activeNetworkInfo
                            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                                if (texted.value.isNotEmpty()) {
                                    scope.launch {
                                        isLoading.value = true
                                        val urlsData = fetchUrlDataOne(database, texted.value)
                                        database
                                            .screenOneDao()
                                            .insertScreenOne(
                                                ScreenOne(
                                                    linktext = urlsData.title,
                                                    linkimage = urlsData.imageUrl,
                                                    url = urlsData.url
                                                )
                                            )
                                        items.add(items.size, urlsData)
                                        listState.animateScrollToItem(index = items.size)
                                        isLoading.value = false
                                    }
                                } else {
                                    Toast
                                        .makeText(
                                            context,
                                            "Нет ничего для сохранения!",
                                            Toast.LENGTH_SHORT
                                        )
                                        .show()
                                }
                            } else {
                                Toast.makeText(context, "Проверьте соединение с интернетом!", Toast.LENGTH_SHORT).show()
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
                    color = colorResource(id = R.color.orange)
                )

                LaunchedEffect(Unit) {
                    scope.launch {
                        items.addAll(getAllLinksAsUrlDataOne(database.screenOneDao()))
                    }
                }
                LazyColumn(modifier = Modifier.padding(top = 8.dp, bottom = 72.dp), state = listState) {
                    items(items) {  item ->
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
                                            painter = painterResource(id = R.drawable.sharp_delete_forever_two_24),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(40.dp)
                                                .padding(end = 16.dp)
                                                .clickable {
                                                    scope.launch {
                                                        toBeDeleted = database
                                                            .screenOneDao()
                                                            .getAllLinks()
                                                            .firstOrNull {
                                                                it.linktext == item.title &&
                                                                        it.linkimage == item.imageUrl && it.url == item.url
                                                            }
                                                        if (toBeDeleted != null) {
                                                            showIdDialog.value = true
                                                        }
                                                    }
                                                },
                                            alignment = Alignment.CenterEnd
                                        )
                                        if (showIdDialog.value) {
                                            AlertDialog(
                                                onDismissRequest = {
                                                    showIdDialog.value = false
                                                },
                                                title = { Text("Подтверждение", color = colorResource(id = R.color.darkblue)) },
                                                text = { Text("Вы уверены, что хотите удалить элемент из списка?",
                                                    color = colorResource(id = R.color.darkblue)) },
                                                confirmButton = {
                                                    Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.darkblue)),
                                                        onClick = {
                                                            scope.launch {
                                                                if (toBeDeleted != null) {
                                                                    database.screenOneDao().deleteScreenOne(toBeDeleted!!)
                                                                    val itemToRemove = items.firstOrNull { it.title == toBeDeleted!!.linktext &&
                                                                            it.imageUrl == toBeDeleted!!.linkimage && it.url == toBeDeleted!!.url }
                                                                    if (itemToRemove != null) {
                                                                        items.remove(itemToRemove)
                                                                    }
                                                                    toBeDeleted = null
                                                                }
                                                            }
                                                            showIdDialog.value = false
                                                        }) {
                                                        Text("Да", color = colorResource(id = R.color.white))
                                                    }
                                                },
                                                dismissButton = {
                                                    Button(colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.darkblue)),
                                                        onClick = {
                                                            showIdDialog.value = false
                                                        }) {
                                                        Text("Нет", color = colorResource(id = R.color.white))
                                                    }
                                                }
                                            )
                                        }
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
                                        shape = CutCornerShape(bottomStart = 10.dp, topStart = 10.dp, topEnd = 10.dp, bottomEnd = 10.dp)) {
                                        Image(painter = rememberImagePainter(
                                                data = item.imageUrl),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .aspectRatio(16f / 9f)
                                        )
                                    }
                                    val annotatedString = buildAnnotatedString {
                                        withStyle(style = SpanStyle(color = colorResource(id = R.color.darkblue), fontSize = 18.sp, fontWeight = FontWeight.Bold,
                                        textDecoration = TextDecoration.Underline)) {
                                            append(item.title)
                                            addStringAnnotation(
                                                tag = "URL",
                                                annotation = item.url,
                                                start = 0,
                                                end = item.title.length
                                            )
                                        }
                                    }
                                    Row {
                                        Image(painter = painterResource(id = R.drawable.globals), contentDescription = null,
                                            modifier = Modifier
                                                .size(50.dp)
                                                .padding(start = 8.dp))
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
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(end = 8.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.Bottom
                                    ) {
                                        if (isPressed) {
                                            scope.launch(Dispatchers.IO) {
                                                delay(1000)
                                                if (isPressed) {
                                                    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                                                    val clip = ClipData.newPlainText("Copied Text", item.url)
                                                    clipboard.setPrimaryClip(clip)
                                                    withContext(Dispatchers.Main){
                                                        Toast.makeText(context, "Ссылка скопирована в буфер обмена!", Toast.LENGTH_SHORT).show()
                                                    }
                                                }
                                            }
                                        }
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(
                                                text = item.url,
                                                modifier = Modifier
                                                    .padding(
                                                        start = 16.dp,
                                                        top = 8.dp,
                                                        bottom = 8.dp
                                                    )
                                                    .clickable(
                                                        interactionSource = interactionSource,
                                                        indication = null,
                                                        onClick = {}
                                                    ),
                                                fontSize = 14.sp,
                                                color = colorResource(id = R.color.darkblue),
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                        Column(
                                            verticalArrangement = Arrangement.Bottom,
                                            horizontalAlignment = Alignment.End,
                                            modifier = Modifier.fillMaxHeight()
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.baseline_share_24),
                                                contentDescription = null,
                                                modifier = Modifier.size(40.dp).padding(bottom = 10.dp).clickable {
                                                    val shareIntent = ShareCompat.IntentBuilder.from(context as Activity).setType("text/plain")
                                                        .setText(item.url)
                                                        .intent
                                                    context.startActivity(Intent.createChooser(shareIntent, null))
                                                }
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
}

data class UrlDataOne(val title: String, val imageUrl: String, val url: String)

 suspend fun fetchUrlDataOne(database : AppDatabase, url: String): UrlDataOne {
    var title = ""
    var imageUrl = ""
    return withContext(Dispatchers.IO) {
        try {
            val doc = Jsoup.connect(url).get()
            title = doc.title()
            imageUrl = doc.select("meta[property=og:image]").first()?.attr("content").toString()
            UrlDataOne(title, imageUrl ?: "", url)
        } catch (e: Exception) {
            e.printStackTrace()
            if (title.isNotEmpty()) {
                val screenOne = ScreenOne(linkimage = imageUrl, linktext = title, url = title)
                database.screenOneDao().insertScreenOne(screenOne)
            }
            UrlDataOne(title, imageUrl, url)
        }
    }
    }
 suspend fun getAllLinksAsUrlDataOne(dao: ScreenOneDao): List<UrlDataOne> {
    return dao.getAllLinks().map { ScreenOne ->
        UrlDataOne(ScreenOne.linktext, ScreenOne.linkimage, ScreenOne.url)
    }
}



