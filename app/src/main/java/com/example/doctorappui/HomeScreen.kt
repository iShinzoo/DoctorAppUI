package com.example.doctorappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Scaffold(
        topBar = { AppTopBar() },
        bottomBar = { BottomNavigation() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            BookingCard()
            DoctorSpecialities()
            Spacer(modifier = Modifier.height(16.dp))
            TopDoctors()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar() {
    TopAppBar(
        title = {
            Column {
                Text("Hi, Mohsen Jamali", fontWeight = FontWeight.Bold)
                Text("How Are You Today", fontSize = 12.sp, color = Color.Gray)
            }
        },
        actions = {
            Image(
                painter = painterResource(id = R.drawable.bell_icon),
                contentDescription = "Back",
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
                    .clickable {

                    }
            )
        },
        modifier = Modifier.padding(top = 18.dp)
    )
}

@Composable
fun BookingCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Promotional image",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun DoctorSpecialities() {
    Column {
        Text(
            "Doctor Speciality",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp),
            fontSize = 18.sp
        )
        LazyRow {
            items(5) { index ->
                SpecialityItem(
                    icon = when (index) {
                        0 -> R.drawable.cardiology
                        1 -> R.drawable.neurology
                        2 -> R.drawable.dentistry
                        3 -> R.drawable.orthopedics
                        else -> R.drawable.radiology
                    },
                    name = when (index) {
                        0 -> "Cardiology"
                        1 -> "Dentistry"
                        2 -> "Neurology"
                        3 -> "Orthopedics"
                        else -> "Radiology"
                    }
                )
            }
        }
    }
}

@Composable
fun SpecialityItem(icon: Int, name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = name,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color(0xFFF0EFF4))
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(name, fontSize = 12.sp)
    }
}

@Composable
fun TopDoctors() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Top Doctors", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            TextButton(onClick = { /* Handle See All */ }) {
                Text("See all")
            }
        }
        LazyRow {
            items(5) { index ->
                DoctorCard(
                    name = when (index) {
                        0 -> "Dr. Michael Roberts"
                        1 -> "Dr. Richard Lee"
                        2 -> "Dr. Sarah Williams"
                        3 -> "Dr. Emily Brown"
                        4 -> "Dr. John Smith"
                        else -> ""
                    },
                    specialty = when (index) {
                        0 -> "Orthopedics"
                        1 -> "Dentistry"
                        2 -> "Cardiology"
                        3 -> "Neurology"
                        4 -> "Pediatrics"
                        else -> ""
                    },
                    rating = when (index) {
                        0 -> 4.3f
                        1 -> 4.7f
                        2 -> 4.5f
                        3 -> 4.8f
                        4 -> 4.6f
                        else -> 0f
                    },
                    experience = when (index) {
                        0 -> "4 Years"
                        1 -> "6 Years"
                        2 -> "5 Years"
                        3 -> "7 Years"
                        4 -> "8 Years"
                        else -> ""
                    },
                    imageRes = when (index) {
                        0 -> R.drawable.drmichaelroberts
                        1 -> R.drawable.drrichardlee
                        2 -> R.drawable.drjessicawyne
                        3 -> R.drawable.drdavidjohnson
                        4 -> R.drawable.drsarahthompson
                        else -> R.drawable.drsarahthompson // Placeholder image in case of missing data
                    }
                )
            }
        }
    }
}

@Composable
fun DoctorCard(name: String, specialty: String, rating: Float, experience: String, imageRes: Int) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp).background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Doctor",
                modifier = Modifier
                    .size(120.dp)
                    .width(140.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(name, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(specialty, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Filled.Star, contentDescription = "Rating", tint = Color.Yellow)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text("$rating")
                }
                Spacer(modifier = Modifier.width(32.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.experience),
                        contentDescription = "experience",
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(experience)
                }
            }
        }
    }
}

@Composable
fun BottomNavigation() {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Explorer") },
            selected = true,
            onClick = { /* Handle navigation */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Wishlist") },
            label = { Text("Wishlist") },
            selected = false,
            onClick = { /* Handle navigation */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
            label = { Text("Settings") },
            selected = false,
            onClick = { /* Handle navigation */ }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Account") },
            label = { Text("Account") },
            selected = false,
            onClick = { /* Handle navigation */ }
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
