package com.example.aplicacionfantasy

import android.widget.RadioGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun BotonAñadir(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        contentColor = Color.White,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Añadir")
            }
        },
        modifier = Modifier
            .width(80.dp)
            .height(42.dp)
            .background(color = Color.Black) // Puedes ajustar el color
    )
}

/*
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AñadirPj(navController: NavController) {
    var nombre by remember { mutableStateOf("") }
    var selectedClass by remember { mutableStateOf(PersonajeData.CharacterClass.DAMAGE) }
    var descripcion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Dropdown para seleccionar el nombre del personaje existente
        var nombres = PersonajeData.personajes.map { it.name }
        var selectedNombreIndex by remember { mutableStateOf(0) }

        // DropdownMenu para seleccionar el nombre
        DropdownMenu(
            expanded = false,
            onDismissRequest = { /* No hacer nada */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            nombres.forEachIndexed { index, item ->
                DropdownMenuItem(onClick = {
                    selectedNombreIndex = index
                    nombre = item
                }) {
                    Text(text = item)
                }
            }
        }

        // Caja de texto editable para mostrar el nombre seleccionado
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // RadioGroup para seleccionar la clase del personaje
        RadioGroup(
            selectedClass = selectedClass,
            onSelectedClassChange = { selectedClass = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // TextField para ingresar la descripción
        OutlinedTextField(
            value = descripcion,
            onValueChange = { descripcion = it },
            label = { Text("Descripción") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.weight(1f))

        // Botón de confirmar
        Button(
            onClick = {
                // Agregar el nuevo personaje a la lista
                val nuevoPersonaje = PersonajeData.personajes[selectedNombreIndex].copy(
                    name = nombre,
                    characterClass = selectedClass,
                    description = descripcion
                )
                PersonajeData.personajes[selectedNombreIndex] = nuevoPersonaje

                // Navegar de vuelta a la pantalla anterior
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Añadir Personaje")
        }
    }
}
*/