package com.example.aplicacionfantasyimport

import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.aplicacionfantasy.PersonajeData

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.aplicacionfantasy.BotonAñadir
import com.example.aplicacionfantasy.Clase
import com.example.aplicacionfantasy.DetallesPj
import com.example.aplicacionfantasy.ui.theme.AplicacionFantasyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplicacionFantasyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Interfaz") {
                        composable(route = "Interfaz") {
                            Interfaz(navController = navController)
                        }
                        composable(
                            route = "DetallesPj/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )
                        ) { backStackEntry ->
                            val index = backStackEntry.arguments?.getInt("index")
                            if (index != null) {
                                DetallesPj(
                                    personajes = PersonajeData.personajes,
                                    itemId = index
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
@Preview
fun InterfazPreview() {
    val navController = rememberNavController()
    Interfaz(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Interfaz(navController: NavController) {
    var searchText by remember { mutableStateOf("") }
    var isDeleteMode by remember { mutableStateOf(false) }
    var selectedItems by remember { mutableStateOf(mutableListOf<Clase>()) }
    var showDialog by remember { mutableStateOf(false) }

    // Filtrar la lista de clases según el texto de búsqueda
    val filteredClases = remember {
        derivedStateOf {
            PersonajeData.personajes.filter {
                it.name.startsWith(searchText, ignoreCase = true) ||
                        it.characterClass.name.equals(searchText, ignoreCase = true)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.Gray)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = searchText,
                    onValueChange = {
                        searchText = it
                    },
                    placeholder = { Text("Buscar clases") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp)
                        .background(MaterialTheme.colorScheme.background)
                )
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            // Puedes agregar lógica de búsqueda adicional aquí si es necesario
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(filteredClases.value) { clase ->
                ItemClase(navController = navController, clase = clase, isDeleteMode, selectedItems)
            }
        }

        // Spacer para empujar el botón hacia abajo
        Spacer(modifier = Modifier.weight(1f))

        // Botón Borrar alineado a la derecha
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Botón Añadir alineado a la izquierda
            BotonAñadir(onClick = {
                // Navegar a la pantalla de añadir personaje
                navController.navigate("AñadirPj")
            })

            // Botón Borrar alineado a la derecha
            BotonBorrar(onClick = {
                if (isDeleteMode) {
                    // Activar el estado para mostrar el diálogo
                    showDialog = true
                } else {
                    // Activar el modo de borrado
                    isDeleteMode = true
                }
            })
        }

        // Mostrar el diálogo si es necesario
        if (showDialog) {
            ConfirmarBorradoDialog(
                onConfirm = {
                    // Realizar el borrado
                    PersonajeData.personajes.toMutableList().removeAll(selectedItems)
                    isDeleteMode = false
                    selectedItems.clear()
                    // Desactivar el estado de mostrar el diálogo
                    showDialog = false
                },
                onCancel = {
                    // Cancelar el borrado
                    isDeleteMode = false
                    selectedItems.clear()
                    // Desactivar el estado de mostrar el diálogo
                    showDialog = false
                }
            )
        }
    }
}


@Composable
fun ItemClase(navController: NavController, clase: Clase, isDeleteMode: Boolean, selectedItems: MutableList<Clase>) {
    var showTick by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(120.dp)
            .background(getBackgroundColor(clase.characterClass))
            .clickable {
                navController.navigate("DetallesPj/${clase.id}")
            }
    ) {
        // Contenedor externo para la fila de contenido
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // Contenedor para el texto
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                // Texto del nombre y la clase
                Text(
                    text = clase.name,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 32.dp)
                )

                // Texto del tipo de clase (más grande y en blanco)
                Text(
                    text = clase.characterClass.toString(),
                    fontSize = 17.sp,
                    color = Color.White
                )
            }

            // Muestra la imagen del personaje
            Image(
                painter = painterResource(id = clase.image),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
            )

            // Checkbox para el modo de borrado
            if (isDeleteMode) {
                Checkbox(
                    checked = selectedItems.contains(clase),
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            selectedItems.add(clase)
                        } else {
                            selectedItems.remove(clase)
                        }
                        // Cambiar el estado para mostrar los ticks azules
                        showTick = isChecked
                    },
                    modifier = Modifier
                        .padding(8.dp)
                        .graphicsLayer(
                            scaleX = if (showTick) 1.5f else 1f,
                            scaleY = if (showTick) 1.5f else 1f
                        )
                )
            }
        }
    }
}

@Composable
fun ConfirmarBorradoDialog(onConfirm: () -> Unit, onCancel: () -> Unit) {
    AlertDialog(
        onDismissRequest = {
            // No hacer nada si el diálogo se cierra
        },
        title = { Text("Confirmar borrado") },
        text = { Text("¿Estás seguro de que deseas borrar los elementos seleccionados?") },
        confirmButton = {
            Button(
                onClick = {
                    // Confirmar el borrado
                    onConfirm()
                }
            ) {
                Text("OK")
            }
        },
        dismissButton = {
            Button(
                onClick = {
                    // Cancelar el borrado
                    onCancel()
                }
            ) {
                Text("Cancelar")
            }
        }
    )
}


@Composable
fun BotonBorrar(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        contentColor = Color.White,
        content = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "",
                    tint = Color.White
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "Borrar")
            }
        },
        modifier = Modifier
            .width(80.dp)
            .height(42.dp)
            .background(color = Color.Black)
    )
}

@Composable
private fun getBackgroundColor(characterClass: PersonajeData.CharacterClass): Color {
    return when (characterClass) {
        PersonajeData.CharacterClass.DAMAGE -> Color(0xFFFFA500) // Naranja para Damage
        PersonajeData.CharacterClass.TANK -> Color(0xFF008000)   // Verde para Tank
        PersonajeData.CharacterClass.SUPPORT -> Color(0xFF0000FF) // Azul para Support
    }
}




