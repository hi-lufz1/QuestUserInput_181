package com.example.questuserinput

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
) {
    var nama by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }

    val jenisKelamin = listOf("Laki-laki", "Perempuan")

    var namaUser by rememberSaveable { mutableStateOf("") }
    var emailUser by remember { mutableStateOf("") }
    var alamatUser by remember { mutableStateOf("") }
    var noHpUser by remember { mutableStateOf("") }
    var selectedGenderuser by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        OutlinedTextField(
            value = nama,
            onValueChange = { nama = it },
            placeholder = { Text("Masukkan Nama") },
            label = { Text("Nama") },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        )
        Row() {
            jenisKelamin.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selectedGender == item,
                        onClick = {
                            selectedGender = item
                        })
                    Text(item)
                }
            }

        }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("Masukkan Email") },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = { alamat = it },
            placeholder = { Text("Masukkan Alamat") },
            label = { Text("Alamat") },
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = noHp,
            onValueChange = { noHp = it },
            placeholder = { Text("Masukkan No Hp") },
            label = { Text("No Hp") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        )
        Spacer(Modifier.padding(5.dp))
        Button(onClick = {
            namaUser = nama
            alamatUser = alamat
            emailUser = email
            noHpUser = noHp
            selectedGenderuser = selectedGender
        })
        {
            Text("Simpan")
        }
        Spacer(Modifier.padding(10.dp))
        Card(modifier.size(350.dp, 300.dp)) {
            CardSection("Nama", namaUser)
            CardSection("Jenis Kelamin", selectedGenderuser)
            CardSection("Email", emailUser)
            CardSection("Alamat", alamatUser)
            CardSection("No HP", noHpUser)


        }
    }
}

@Composable
fun CardSection(judulParam: String, isiParam: String) {
    Column(modifier = Modifier.padding(15.dp), horizontalAlignment = Alignment.Start) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = judulParam, fontSize = 20.sp, modifier = Modifier.weight(0.9f))
            Text(text = " : ", fontSize = 20.sp, modifier = Modifier.weight(0.2f))
            Text(text = isiParam, fontSize = 20.sp, modifier = Modifier.weight(1.4f))
        }

    }
}
