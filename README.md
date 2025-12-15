# Übungsblatt: Eigene Operationen in gegebenen Java-Klassen schreiben

[Link to English version](./README_en.md)

In diesem Übungsblatt lernen Sie, gegebene Java-Programme durch das Schreiben eigener Operationen zu erweitern.

## Übung 01: Operation Rechteck

In dieser Übung arbeiten wir mit einer bestehenden Java-Klasse und fügen ihr neue Operationen hinzu. Die Klasse, mit der wir arbeiten werden, ist die `Rectangle`-Klasse, die ein Rechteck mit Länge (*Length*) und Breite (*Width*) darstellt.

### Hintergrundinformationen

Die `Rectangle`-Klasse hat die folgenden Attribute:

- `length`: die Länge des Rechtecks (Typ: double)
- `width`: die Breite des Rechtecks (Typ: double)

Die `Rectangle`-Klasse hat die folgenden Operationen:

- `getLength()`: gibt die Länge des Rechtecks zurück
- `getWidth()`: gibt die Breite des Rechtecks zurück
- `setLength(final double length)`: setzt die Länge des Rechtecks auf den angegebenen Wert
- `setWidth(final double width)`: setzt die Breite des Rechtecks auf den angegebenen Wert
- `getArea()`: gibt den Flächeninhalt des Rechtecks zurück (d.h., $length * width$)

### Aufgaben

1. Erstellen Sie eine neue Operation in der `Rectangle`-Klasse namens `getPerimeter()`, die den Umfang des Rechtecks zurückgibt (d.h., $2 * (length + width)$).
2. Ändern Sie die `Rectangle`-Klasse so, dass sie einen Konstruktor enthält, der die Länge und Breite des Rechtecks als Parameter akzeptiert. Achten Sie auf defensive Programmierung.
    * Stellen Sie sicher, dass Sie immer noch ein Rechteck erstellen können, ohne die Länge und Breite anzugeben, d.h., der Default-Konstruktor sollte weiterhin verfügbar sein.
3. Erstellen Sie eine neue Operation in der `Rectangle`-Klasse namens `getDiagonal()`, die die Diagonallänge des Rechtecks zurückgibt (d.h., $\sqrt{length^2 + width^2}$).
4. Erstellen Sie eine neue Operation in der `Rectangle`-Klasse namens `isSquare()`, die einen booleschen Wert zurückgibt, der angibt, ob das Rechteck ein Quadrat ist (d.h., wenn `length == width`).
5. Erstellen Sie eine neue Operation in der `Rectangle`-Klasse namens `scale(final double scaleFactor)`, die das Rechteck um den gegebenen Faktor skaliert. Diese Operation sollte die Länge und Breite mit dem Skalierungsfaktor multiplizieren. Achten Sie auf defensive Programmierung.

Hinweis: Sie müssen möglicherweise das Paket `java.lang.Math` importieren, um die Operation `sqrt()` zu verwenden.

Nachdem Sie die oben genannten Aufgaben abgeschlossen haben, erstellen Sie eine Instanz der `Rectangle`-Klasse in Ihrer `main()`-Operation und testen Sie die verschiedenen Operationen, die Sie erstellt haben. Erstellen Sie zusätzlich einige weitere Instanzen von `Rectangle` und testen Sie die neuen Operationen `isSquare()` und `scale()`.

## Übung 02: Banking 101

In dieser Übung arbeiten wir mit einer bestehenden Java-Klasse und fügen ihr neue Operationen hinzu. Die Klasse, mit der wir arbeiten werden, ist die `BankAccount`-Klasse, die ein Bankkonto mit Kontostand und Kontonummer darstellt.

### Hintergrundinformationen

Die `BankAccount`-Klasse hat die folgenden Attribute:

- `balance`: der Kontostand des Bankkontos (Typ: double)
- `accountNumber`: die Kontonummer des Bankkontos (Typ: int)

Die `BankAccount`-Klasse hat die folgenden Operationen:

- `getBalance()`: gibt den Kontostand des Bankkontos zurück
- `getAccountNumber()`: gibt die Kontonummer des Bankkontos zurück
- `deposit(final double amount)`: fügt den angegebenen Betrag zum Kontostand des Bankkontos hinzu
- `withdraw(final double amount)`: zieht den angegebenen Betrag vom Kontostand des Bankkontos ab
- `toString()`: gibt eine String-Repräsentation des Bankkontos im Format "Kontonummer: {Kontonummer}, Kontostand: ${Kontostand}" zurück

### Aufgaben

1. Erstellen Sie eine neue Operation in der `BankAccount`-Klasse namens `transferTo(final BankAccount otherAccount, final double amount)`, die den angegebenen Betrag vom aktuellen Bankkonto auf das andere Bankkonto überträgt. Beispiel: hat das aktuelle Bankkonto einen Kontostand von \$100 und das andere Bankkonto einen Kontostand von \$50, und der Übertragungsbetrag beträgt \$25, dann sollten die neuen Kontostände \$75 für das aktuelle Bankkonto und \$75 für das andere Bankkonto sein. Achten Sie auf defensive Programmierung.
2. Erstellen Sie eine neue Operation in der `BankAccount`-Klasse namens `addInterest(final double rate)`, die dem Bankkonto Zinsen auf der Grundlage des angegebenen Zinssatzes hinzufügt. Beispiel: wenn der aktuelle Kontostand $100 und der Zinssatz 5\% beträgt, sollte der neue Kontostand \$105 betragen. Achten Sie auf defensive Programmierung. Die `rate` ist als Fließkommazahl zu verstehen, z.B. 0.05 für 5\%.
3. Erstellen Sie eine neue Operation in der `BankAccount`-Klasse namens `getNetBalance()`, die den Kontostand des Bankkontos nach Abzug aller negativen Kontostände aufgrund von Überziehungen zurückgibt. D.h., wenn der Kontostand des Bankkontos -50 beträgt, sollte die Operation `getNetBalance()` 0 zurückgeben.
   Ändern Sie die Implementierung von `BankAccount` so, dass `balance` negativ sein kann.

Nachdem Sie die oben genannten Aufgaben abgeschlossen haben, erstellen Sie eine Instanz der `BankAccount`-Klasse in Ihrer `main()`-Operation und testen Sie die verschiedenen Operationen, die Sie erstellt haben.

## Übung 03: Eine Geschichte eines Restaurants

In dieser Übung arbeiten wir mit einem Java-Programm, das ein Restaurant simuliert. Das Programm beinhaltet eine `Restaurant`-Klasse, eine `Table`-Klasse, eine `MenuItem`-Klasse und eine `Order`-Klasse.

### Hintergrundinformationen

Die `Restaurant`-Klasse hat die folgenden Attribute:

- `tables`: eine Liste von `Table`-Objekten, die die Tische im Restaurant darstellen
- `menuItems`: eine Liste von `MenuItem`-Objekten, die die Artikel auf der Speisekarte des Restaurants darstellen

Die `Restaurant`-Klasse hat die folgenden Operationen:

- `getTables()`: gibt die `tables`-Liste zurück
- `getMenuItems()`: gibt die `menuItems`-Liste zurück
- `findTable(final int tableNumber)`: gibt das `Table`-Objekt mit der angegebenen Tischnummer zurück, oder `null`, wenn kein solcher Tisch existiert
- `findMenuItem(final String itemName)`: gibt das `MenuItem`-Objekt mit dem angegebenen Artikelnamen zurück, oder `null`, wenn kein solcher Artikel existiert

Die `Table`-Klasse hat die folgenden Attribute:

- `tableNumber`: eine Ganzzahl, die die Tischnummer darstellt
- `seats`: eine Ganzzahl, die die Anzahl der Sitzplätze am Tisch darstellt
- `occupied`: ein boolescher Wert, der angibt, ob der Tisch derzeit besetzt ist
- `orders`: eine Liste aller Bestellungen, die am Tisch aufgegeben wurden

Die `Table`-Klasse hat die folgenden Operationen:

- `getTableNumber()`: gibt die `tableNumber` zurück
- `getSeats()`: gibt die `seats` zurück
- `isOccupied()`: gibt `occupied` zurück
- `setOccupied(final boolean isOccupied)`: setzt das Attribut `occupied` auf den angegebenen Wert
- `getOrders()`: gibt die `orders` zurück
- `placeOrder(final MenuItem menuItem, final int amount)`: gibt eine Bestellung auf, die den Menüpunkt `amount` mal bestellt

Die `MenuItem`-Klasse hat die folgenden Attribute:

- `itemName`: ein String, der den Namen des Menüpunkts darstellt
- `description`: ein String, der eine Beschreibung des Menüpunkts darstellt
- `price`: ein Double, der den Preis des Menüpunkts darstellt

Die `MenuItem`-Klasse hat die folgenden Operationen:

- `getItemName()`: gibt den `itemName` zurück
- `getDescription()`: gibt die `description` zurück
- `getPrice()`: gibt den `price` zurück

Die `Order`-Klasse hat die folgenden Attribute:

- `menuItem`: der Menüpunkt, der bestellt wird
- `amount`: wie oft der Menüpunkt bestellt wird

Die `Order`-Klasse hat die folgenden Operationen:

- `getMenuItem`: gibt das `menuItem` zurück
- `getAmount`: gibt den `amount` zurück

### Aufgaben

1. Fügen Sie der `Restaurant`-Klasse eine neue Operation namens `findUnoccupiedTable(final int partySize)` hinzu, die einen unbesetzten Tisch mit genügend Sitzplätzen für die angegebene Gruppengröße findet, oder `null`, wenn kein solcher Tisch existiert.
2. Fügen Sie der `Restaurant`-Klasse eine neue Operation namens `getTotalRevenue()` hinzu, die den Gesamtumsatz zurückgibt, den das Restaurant aus allen Bestellungen erzielt hat.
3. Fügen Sie der `Restaurant`-Klasse eine neue Operation namens `getTableOccupancyPercentage()` hinzu, die den Prozentsatz (als Double, `[0,1]`) der Tische zurückgibt, die derzeit besetzt sind.
4. Fügen Sie der `Restaurant`-Klasse eine neue Operation namens `getSeatsOccupancyPercentage()` hinzu, die den Prozentsatz (als Double, `[0,1]`) der Sitzplätze zurückgibt, die derzeit besetzt sind. Sie können davon ausgehen, dass, wenn ein Tisch besetzt ist, alle seine Sitzplätze besetzt sind.
5. Fügen Sie der `MenuItem`-Klasse eine neue Operation namens `isVegetarian()` hinzu, die `true` zurückgibt, wenn der Menüpunkt vegetarisch ist (d.h., wenn seine Beschreibung das Wort "vegetarisch" oder "vegetarian" enthält) und `false` sonst.

Nachdem Sie die oben genannten Aufgaben abgeschlossen haben, erstellen Sie Instanzen der Klassen in Ihrer `main()`-Operation und testen Sie die verschiedenen Operationen, die Sie erstellt haben.

Hinweis: Sie sollten für diese Übung keine neuen Klassen erstellen müssen. Stattdessen fügen Sie den bestehenden Klassen neue Operationen hinzu.
