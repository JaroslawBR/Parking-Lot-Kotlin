# Parking-Lot-Kotlin

## PL: Program symulujący system parkowania samochodów na parkingu. Użytkownik może wykonywać różne operacje związane z zarządzaniem miejscami parkingowymi, takie jak parkowanie samochodu, zwalnianie miejsca, sprawdzanie statusu parkingu, tworzenie nowego parkingu, wyszukiwanie samochodów na podstawie koloru i numeru rejestracyjnego.

### Funkcje programu:
  * `crate` - Tworzy parking o wybranej liczbie miejsc. Na starcie programu należy podać tą komendę.
```shell 
> crate 22
Created a parking lot with 22 spots.
```
  * `main` - Główna funkcja programu, obsługuje interakcję z użytkownikiem poprzez wybór dostępnych opcji.

  * `park` - Pozwala na zaparkowanie samochodu na pierwszym wolnym miejscu na parkingu. Aktualizuje stan parkingu i wyświetla informacje o zaparkowanym samochodzie.  Aby funkcja zadziała na użytkownik musi za komendą `park` podać numer rejestracji pojazdu oraz kolor samochodu 

```shell 
> park KA-01-HH-3672 White
White car parked in spot 1.
```

  * `leave` - Zwalnia miejsce na parkingu i usuwa informacje o samochodzie z danego miejsca.
```shell 
> leave 1
Spot 1 is free.
```

  * `status` - Wyświetla informacje o samochodach zaparkowanych na parkingu.

  * `reg_by_color` - Wyszukuje samochody na podstawie koloru i wyświetla ich numer rejestracyjny.

  * `spot_by_reg` - Wyszukuje samochod na podstawie numeru rejestracyjnego i wyświetla jego numer miejsca.

## ENG: This is a program that simulates a car parking system in a parking lot. The user can perform various operations related to parking space management, such as parking the car, freeing up a space, checking the status of the parking lot, creating a new parking lot, searching for cars based on color and plate number.

### Program features:
   * `crate` - Creates a car park with the selected number of spaces. Enter this command at the start of the program.
```shell
> crate 22
Created a parking lot with 22 spots.
```
   * `main` - The main function of the program, supports interaction with the user by selecting the available options.

   * `park` - Allows you to park your car in the first free spot in the parking lot. Updates the status of the parking lot and displays information about the parked car. In order for the function to work, the user must enter the vehicle registration number and the color of the car after the `park` command

```shell
> park KA-01-HH-3672 White
White car parked in spot 1.
```

   * `leave` - Frees a parking space and removes the car information from the given spot.
```shell
> leaves 1
Spot 1 is free.
```

   * `status` - Displays information about cars parked in the parking lot.

   * `reg_by_color` - Searches for cars based on color and displays their registration number.

   * `spot_by_reg` - Searches for a car based on the registration number and displays its spot number.

