package com.example.aplicacionfantasy

data class Clase(
    val id: Int,
    val image: Int,
    val name: String,
    val characterClass: PersonajeData.CharacterClass,
    var experience: Int = 0,
    val description: String
)

object PersonajeData {

    enum class CharacterClass {
        SUPPORT, TANK, DAMAGE
    }

    val personajes = listOf(
        Clase(1, R.drawable.aniripsa, "Aniripsa", CharacterClass.SUPPORT, 0, "Desde siempre, los aniripsas son conocidos por ser unos inestimables curanderos. Es la pura verdad: ¡les basta con una palabra para curarte de todos tus males! En cuanto a sus enemigos, no te preocupes, siempre encuentran la manera de hacerles pasar un mal trago..."),
        Clase(2, R.drawable.anutrof, "Anutrof", CharacterClass.SUPPORT, 0, "No se resisten a su tez tostada, ni a su caluroso perfume ni, mucho menos, a sus curvas perfectas: ¡cuando un anutrof ve un kama, pierde del todo la cabeza! Hacen prueba de una avaricia sin igual y son capaces de remover cielo y tierra provistos de su pala cuando siguen la pista de un tesoro. Esto los convierte en aliados muy útiles y ayuda a olvidar su mal carácter y su higiene dudosa..."),
        Clase(3, R.drawable.feca, "Feca", CharacterClass.TANK, 0, "Los fecas son protectores natos. No esperes que te entreguen aquello que protegen, ¡a menos que pases por encima de sus cadáveres! Darán hasta su último aliento velando lo que se les confía. Tampoco intentes atacar al primer jalató que se cruce por tu camino,porque, aunque ya no sean pastores, se enfrentarán a todo aquel que la tome con criaturas indefensas."),
        Clase(4, R.drawable.hipermago, "Hipermago", CharacterClass.DAMAGE, 0, "Los hipermagos son maestros de las runas elementales que combinan agua, fuego, aire y tierra para crear hechizos de un poder impresionante. Su sed de conocimiento y la importancia de su misión los lleva a estudiar sin descanso las formas de restablecer el equilibrio de la Balanza Krósmica, garante de la estabilidad del Mundo de los Doce."),
        Clase(5, R.drawable.ocra, "Ocra", CharacterClass.DAMAGE, 0, "\"Orgullo y precisión\", este podría ser el lema de los ocras. Especialistas en el ataque a distancia, estos arqueros sin par son unos preciados aliados que solo necesitan tener el arco bien tensado para mantener a sus enemigos en tensión. Su mayor afición: lanzar sus flechas a los traseros más rollizos..."),
        Clase(6, R.drawable.osamodas, "Osamodas", CharacterClass.SUPPORT, 0, "El rugido de un rebaño de minotauroros al galope no les impresiona. Ni se asustan con el grito ensordecedor de los kwaks, ni con el aullido de un milubo. La empatía que muestran con las criaturas de la naturaleza es tan fuerte que ellos mismos están dotados de un lado animal que les aporta todo su encanto y los hace, a su vez, peligrosos."),
        Clase(7, R.drawable.panda, "Pandawa", CharacterClass.TANK, 0, "Maestros en el arte del puño, los pandawas también son muy hábiles en la disciplina del empinamiento de codo. Y, cuando no tienen una jarrita a mano, ¡levantan a sus enemigos por los aires! Si te enfrentas a un pandawa, no olvides que ellos siempre están dispuestos a una última ronda, ya sea de bebidas o de golpes..."),
        Clase(8, R.drawable.sacro, "Sacrógrito", CharacterClass.TANK, 0, "Los sacrógritos no tienen miedo de las heridas. Al contrario, ¡sacan su poder de los golpes que reciben! Son adeptos a las veladas guerreras, no se hacen mala sangre en ellas y son unos inestimables aliados en las peleas de verdad. En pocas palabras: para el adversario, ¡el discípulo de Sacrógrito es como un gran dolor de muelas!"),
        Clase(9, R.drawable.sadida, "Sadida", CharacterClass.SUPPORT, 0, "Se les conoce como \"el pueblo de los árboles\", pero, en realidad, los sadidas veneran a todas las criaturas vegetales. Y, cuando no declaran su amor a las plantas, juegan con muñecas de guerra o de cura que ellos mismos confeccionan. Una manera como cualquier otra de irse por las ramas cuando la ocasión lo pide."),
        Clase(10, R.drawable.selatrop, "Selatrop", CharacterClass.DAMAGE, 0, "Aparecidos por accidente, los selotropes son el reflejo de su creador, el Rey-Dios. Se desplazan a la velocidad del rayo, desaparecen en un abrir y cerrar de ojos y vuelven a aparecer en otro sitio. Al igual que los selatropes, conocen los secretos del Wakfu."),
        Clase(11, R.drawable.sram, "Sram", CharacterClass.DAMAGE, 0, "Por mucho que se esconda tras una máscara, todo el mundo conoce su verdadera cara: ¡la falsedad! Los srams son los mejores a la hora de aligerar los bolsillos de los aventureros o cuando hay que deshacerse de un enemigo bastante molesto. En pocas palabras: más vale evitar pasearse por donde caminan los srams..."),
        Clase(12, R.drawable.steamer, "Steamer", CharacterClass.TANK, 0, "Los steamers, pacientes y prudentes, esperan a que llegue el momento justo de actuar... Durante siglos, no han dejado de mejorar, tanto a nivel intelectual como físico. Antiguamente eran ateos y belicosos. Sin embargo, en la actualidad son embajadores de un pueblo en pro de la paz. Tienen por misión encontrar minas de stasili para poder preparar el retorno de su gente."),
        Clase(13, R.drawable.tymador, "Tymador", CharacterClass.DAMAGE, 0, "Los tymadores, que asocian la inteligencia al engaño, son unos traidores de excepción. Convertidos en maestros del arte de la chapuza, usan y abusan de herramientas y trastos para llevar a cabo sus planes. A pesar de toda su malicia, tienen un valor que está por encima de todo: el respeto a la familia."),
        Clase(14, R.drawable.uginak, "Uginak", CharacterClass.DAMAGE, 0, "Los uginaks son guerreros que persiguen a sus presas sin darles cuartel. Ágiles y resistentes, no dudan en saltar sobre todo lo que se mueva. ¿Jugador o monstruo? ¡No hay distinción!"),
        Clase(15, R.drawable.xelor, "Xelor", CharacterClass.DAMAGE, 0, "Los xelors juegan con el tiempo. Manipular el tic tac, ¡esa es su táctica! Apasionados de los mecanismos relojeros de cualquier tipo, ¡no dejan escapar el más mínimo segundo ni al más mínimo enemigo! Si ves que manipulan sus agujas... ¡huye!, porque ha llegado tu hora."),
        Clase(16, R.drawable.yopuka, "Yopuka", CharacterClass.DAMAGE, 0, "Los yopukas son unos valerosos caballeros que saben cómo hacer que sus armas hablen. Si supieran lo que es un refrán, el suyo sería este: \"Actuar y luego pensar\". Aunque, por mucho que el tamaño de su cerebro sea inversamente proporcional al de su espada, los yopukas son buenos protectores apreciados por sus aliados. Porque ellos lo valen..."),
        Clase(17, R.drawable.zobal, "Zobal", CharacterClass.SUPPORT, 0, "Los zobals son los guardianes de unas máscaras con extraños poderes. Temerarios, cobardes y locos a la vez, estos aventureros de orígenes misteriosos cambian de cara como de camisa. Sus motivaciones son bastante oscuras, pero, a menudo, están teñidas de una profunda sed de venganza..."),
        Clase(18, R.drawable.zurcarak, "Zurcarak", CharacterClass.SUPPORT, 0, "Jugadores empedernidos, los zurcaráks no dudan en poner su vida en peligro por simple amor al riesgo. Y al contrario de lo que se suele decir, no siempre caen de pie... Pero no pasa nada: ¡la adrenalina que les procura el juego es mucho más fuerte! Entonces qué, ¿te atreves a desafiar al lindo gatito?"),
    )


}


