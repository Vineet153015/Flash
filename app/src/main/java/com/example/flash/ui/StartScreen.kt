package com.example.flash.ui

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.flash.data.DataSource

@Composable
fun StartScreen(
    flashViewModel: FlashViewModel,
    onCategoryClicked : (Int) -> Unit
){
    val context = LocalContext.current
    val flashUiState by flashViewModel.uiState.collectAsState()

    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
        items(DataSource.loadCategories()){
            CardCategory(
                context = context,
                stringResourceId = it.stringResourceId,
                imageResourceId = it.imageResourceId,
                flashViewModel = flashViewModel,
                onCategoryClicked = onCategoryClicked
            )
        }
    }

}

@Composable
fun CardCategory(
    context: Context,
    stringResourceId : Int,
    imageResourceId: Int,
    flashViewModel: FlashViewModel,
    onCategoryClicked: (Int) -> Unit
){
    val categoryName = stringResource(id = stringResourceId)
    Card(modifier = Modifier.clickable {
        flashViewModel.updateClickText(categoryName)
        Toast.makeText(context,"This card was Clicked",Toast.LENGTH_SHORT).show()
        onCategoryClicked(stringResourceId)
    }) {
        Column (
            modifier = Modifier.padding(5.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = categoryName,
                fontSize = 17.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = imageResourceId),
                contentDescription = "Fruits",
                modifier = Modifier.size(150.dp)
            )
        }
    }
}