package com.example.prosync.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.prosync.Component.DatePickerDialog
import com.example.prosync.Component.TimePickerDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTask(navController: NavHostController) {

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    var deadline by remember { mutableStateOf("") }
    var reminder by remember { mutableStateOf("") }

    var showDeadlinedatePicker by remember { mutableStateOf(false) }
    var showDeadlinetimePicker by remember { mutableStateOf(false) }
    var showReminderDatePicker by remember { mutableStateOf(false) }
    var showReminderTimePicker by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Column {

            Text("Add Task", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(20.dp))
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(15.dp))
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                maxLines = 4
            )

            Spacer(Modifier.height(20.dp))
            OutlinedTextField(
                value = deadline,
                onValueChange = {},
                label = { Text("Deadline") },
                modifier = Modifier.fillMaxWidth(),
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { showDeadlinedatePicker = true }) {
                        Icon(Icons.Default.DateRange, contentDescription = null)
                    }
                }
            )

            Spacer(Modifier.height(15.dp))
            OutlinedTextField(
                value = reminder,
                onValueChange = {},
                label = { Text("Reminder") },
                modifier = Modifier.fillMaxWidth(),
                readOnly = true,
                trailingIcon = {
                    IconButton(onClick = { showReminderDatePicker = true }) {
                        Icon(Icons.Default.DateRange, contentDescription = null)
                    }
                }
            )

            Spacer(Modifier.height(30.dp))

            Button(
                onClick = {  },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Task")
            }
        }
    }
    if (showDeadlinedatePicker) {
        DatePickerDialog(
            onDateSelected = {
                deadline = it
                showDeadlinedatePicker=false
                showDeadlinetimePicker=true      },
            onDismiss = { showDeadlinedatePicker = false }
        )
    }
    if(showDeadlinetimePicker){
        TimePickerDialog(
            onTimeSelected = { time ->
                deadline = "$deadline at $time"
            },
            onDismiss = { showDeadlinetimePicker = false }
        )
    }

    if(showReminderDatePicker){
        DatePickerDialog(
            onDateSelected = {
                reminder= it
                showReminderDatePicker=false
                showReminderTimePicker=true

            },
            onDismiss = {showReminderDatePicker=false}
        )
    }

    if (showReminderTimePicker) {
        TimePickerDialog(
            onTimeSelected = { time ->
                reminder = "$reminder at $time"
            },
            onDismiss = { showReminderTimePicker = false }
        )
    }
}
