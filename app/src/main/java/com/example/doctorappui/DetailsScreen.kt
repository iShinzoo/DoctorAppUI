package com.example.doctorappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun DetailsScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF945DCF))
    ) {
        Column {
            DoctorHeader()
            DoctorInfo()
        }
    }
}

@Composable
fun DoctorHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.women),
            contentDescription = "Doctor Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.back_white),
                contentDescription = "Back",
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
                    .clickable {

                    }
            )
            Image(
                painter = painterResource(id = R.drawable.favorite_white),
                contentDescription = "Back",
                modifier = Modifier
                    .size(60.dp)
                    .padding(8.dp)
                    .clickable {

                    }
            )
        }
    }
}

@Composable
fun DoctorInfo() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(Color.White)
            .padding(20.dp)
    ) {
        item {
            Text("Dr. Sarah Thompson", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text("Radiology Specialist", color = Color.Gray)
            Text("8502 Preston Rd, Inglewood, Maine 88380", color = Color.Gray)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                StatItem(icon = Icons.Filled.Person, value = "500+", label = "Patients")
                StatItem(icon = Icons.Filled.Star, value = "4 Years +", label = "Experience")
                StatItem(icon = Icons.Filled.Star, value = "4.5", label = "Rating")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("BioGhraphy", fontWeight = FontWeight.Bold)
            Text(
                "A board-certified with over 15 years of experience, specializing in heart conditions such as coronary artery disease and arrhythmias. Known for patient-centered care and a commitment to the latest medical advancements.",
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ActionButton(icon = painterResource(id = R.drawable.website), label = "Website")
                ActionButton(icon = painterResource(id = R.drawable.message), label = "Message")
                ActionButton(icon = painterResource(id = R.drawable.call), label = "Call")
                ActionButton(icon = painterResource(id = R.drawable.direction), label = "Direction")
                ActionButton(icon = painterResource(id = R.drawable.share), label = "Share")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Handle appointment */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF945DCF))
            ) {
                Text("Make Appointment", color = Color.White)
            }
        }
    }
}

@Composable
fun StatItem(icon: ImageVector, value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = null, tint = Color(0xFF945DCF))
        Text(value, fontWeight = FontWeight.Bold)
        Text(label, color = Color.Gray, fontSize = 12.sp)
    }
}

@Composable
fun ActionButton(icon: Painter, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = icon,
            contentDescription = "",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(Color(0xFFF0EFF4))
                .padding(8.dp)
        )
        Text(label, fontSize = 12.sp)
    }
}
