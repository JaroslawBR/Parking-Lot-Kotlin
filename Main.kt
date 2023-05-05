package parking

import kotlin.system.exitProcess

class Car(var seatNum: String = " ", var id: String = "", var color: String = "")


fun main() {
    var spot = crate()
    while (true) {
        val input: CharSequence = readln()
        when {
            input.contains("park") -> park(spot, input)
            input.contains("leave") -> leave(spot, input)
            input.contains("status") -> status(spot)
            input.contains("create") -> spot = crate(input)
            input.contains("reg_by_color") || input.contains("spot_by_color") -> byColor(spot, input)
            input.contains("spot_by_reg") || input.contains("color_by_reg")  -> byReg(spot, input)
            input.contains("exit") -> break
            else -> println("Wrong input")
        }
    }
}

fun park(spot: MutableList<Car>, input: CharSequence) {
    val spotSpilt = input.split(" ")
    val freeSpot = findFreeSpot(spot)
    if (freeSpot is Int) {
        if (spotSpilt.size == 3) {
            val color = spotSpilt[2]
            val id = spotSpilt[1]
            spot[freeSpot.toString().toInt()].color = color
            spot[freeSpot.toString().toInt()].id = id
            spot[freeSpot.toString().toInt()].seatNum = "${freeSpot + 1}"
            println("$color car parked in spot ${freeSpot.toString().toInt() + 1}.")
        } else println("Wrong input")
    }

} //park car in first free spot

fun findFreeSpot(spot: MutableList<Car>): Any {
    val freeSpot = spot.indexOfFirst { it.id == "" }
    return if (freeSpot >= 0) {
        freeSpot
    }
    else {
        println("Sorry, the parking lot is full.")
    }
} //helper function to fun park finds the first free spot

fun leave(spot: MutableList<Car>, input: CharSequence) {
    val spotSpilt = input.split(" ")
    try {
    if (spotSpilt.size == 2) { val num = spotSpilt[1].toInt()
            if (spot[num - 1].id == "" && spot[num - 1].color == "") {
                println("There is no car in spot $num.")
            } else {
                println("Spot $num is free.")
                spot[num - 1].id = ""
                spot[num - 1].color = ""
                spot[num - 1].seatNum = ""
            }
        } else println("Wrong input")
    } catch (e: Exception) {
        println("Wrong input")
    }
} //removes the car from the specified location

fun crate(size: CharSequence = readln()): MutableList<Car> {
    if (size.toString() == "exit") exitProcess(0) else {
        val sizeSplit = size.split(" ")
        return try {
            val testSize: Any = sizeSplit[1]
            return if (sizeSplit.size == 2 && size.contains("create")) {
                println("Created a parking lot with $testSize spots.")
                return MutableList(testSize.toString().toInt()) { Car() }
            } else {
                println("Sorry, a parking lot has not been created.")
                crate()
            }
        } catch (e: Exception) {
            println("Sorry, a parking lot has not been created.")
            crate()
        }
    }
} //created a parking lot with the selected size

fun status(spot: MutableList<Car>) {
    val empty = spot.all { it.id == ""}
    if (!empty) {
        for (i in spot) {
            if (i.id != "" && i.color != "") println("${i.seatNum} ${i.id} ${i.color}")
        }
    } else println("Parking lot is empty.")
} //shows parked cars with spot number

fun byColor(spot: MutableList<Car>, input: CharSequence) {
    val spotSpilt = input.split(" ")
    val spotColor: MutableList<Car> = mutableListOf()
    if (spotSpilt.size == 2) {
        for (i in spot) {
            if (i.color.uppercase() == spotSpilt[1].uppercase()) {
                spotColor.add(spot[i.seatNum.toInt() - 1])
            }
        }
        if (spotColor.isNotEmpty()) {
            when (spotSpilt[0]) {
                "spot_by_color" -> {
                    for (i in spotColor) {
                        if (i != spotColor.last()) print("${i.seatNum}, ") else print(i.seatNum)
                    }
                    println()
                }

                "reg_by_color" -> {
                    for (i in spotColor) {
                        if (i != spotColor.last()) print("${i.id}, ") else print(i.id)
                    }
                    println()
                }
            }
        } else println("No cars with color ${spotSpilt[1]} were found.")
    } else println("Wrong Input!")
}

fun byReg(spot: MutableList<Car>, input: CharSequence) {
    val spotSpilt = input.split(" ")
    val spotReg: MutableList<Car> = mutableListOf()
    if (spotSpilt.size == 2) {
        for (i in spot) {
            if (i.id.uppercase() == spotSpilt[1].uppercase()) {
                spotReg.add(spot[i.seatNum.toInt() - 1])
            }
        }
        if (spotReg.isNotEmpty()) {
            when (spotSpilt[0]) {
                "spot_by_reg" -> {
                    for (i in spotReg) {
                        if (i != spotReg.last()) print("${i.seatNum}, ") else print(i.seatNum)
                    }
                    println()
                }

                "color_by_reg" -> {
                    for (i in spotReg) {
                        if (i != spotReg.last()) print("${i.color}, ") else print(i.color)
                    }
                    println()
                }
            }
        } else println("No cars with registration number ${spotSpilt[1]} were found.")
    } else println("Wrong Input!")
}
