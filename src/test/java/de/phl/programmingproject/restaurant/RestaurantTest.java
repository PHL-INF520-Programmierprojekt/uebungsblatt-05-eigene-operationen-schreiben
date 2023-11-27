package de.phl.programmingproject.restaurant;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the {@link Restaurant} exercise.
 */
public class RestaurantTest {
    static List<Table> tables = Arrays.asList(
            new Table(1, 2),
            new Table(2, 4),
            new Table(3, 4),
            new Table(4, 6),
            new Table(5, 6),
            new Table(6, 8),
            new Table(7, 8),
            new Table(8, 10),
            new Table(9, 10),
            new Table(10, 12)
    );

    static List<MenuItem> menuItems = Arrays.asList(
            new MenuItem("Pizza", "A delicious pepperoni pizza", 5.0),
            new MenuItem("Pasta", "Yummy pasta with meat sauce",4.0),
            new MenuItem("Salad", "A fresh salad, vegetarian", 3.0),
            new MenuItem("Soup", "Healthy soup",2.0),
            new MenuItem("Burger", "Bacory burger", 5.0),
            new MenuItem("Steak", "For meat lovers",10.0),
            new MenuItem("Fries", "Everyone loves vegetarian fries",2.0),
            new MenuItem("Ice Cream", "It's summer time (vegetarian)!", 3.0),
            new MenuItem("Cake", "For our sweet teeth, only vegetarians!",4.0),
            new MenuItem("Pie", "Not the number and with gelatine",4.0)
    );

    static Restaurant restaurant;

    static double totalRevenue;

    static double occupiedTablesPercentage;

    static double occupiedSeatsPercentage;
    @BeforeAll
    public static void setUp() {
        Random randy = new Random();
        int occupiedTables = 0;
        int occupiedSeats = 0;
        // randomly order stuff
        for (Table table : tables) {
            if(randy.nextBoolean() && table.getSeats() != 12) {
                table.setOccupied(true);
                occupiedTables++;
                occupiedSeats += table.getSeats();
                int amountOfOrders = randy.nextInt(5) + 1;
                MenuItem randomMenuItem = menuItems.get(randy.nextInt(menuItems.size()));
                totalRevenue += randomMenuItem.getPrice() * amountOfOrders;
                table.placeOrder(randomMenuItem, amountOfOrders);
            }
        }

        occupiedTablesPercentage = occupiedTables / (double) tables.size();
        occupiedSeatsPercentage = occupiedSeats / (double) tables.stream().mapToInt(Table::getSeats).sum();

        restaurant = new Restaurant(tables, menuItems);
    }

    @Test
    void task_1_findUnoccupiedTable_implemented() throws InvocationTargetException, IllegalAccessException {
        Method findUnoccupiedTableMethod = null;
        try{
            findUnoccupiedTableMethod = Restaurant.class.getMethod("findUnoccupiedTable", int.class);
        } catch (NoSuchMethodException e) {
            fail("The method 'findUnoccupiedTable(final int partySize)' does not exist in the 'Restaurant' class.");
        }

        Table emptyTable = (Table) findUnoccupiedTableMethod.invoke(restaurant, 12);
        assertNotNull(emptyTable,
                "The method 'findUnoccupiedTable(final int partySize)' does not return a free table.");

        emptyTable.setOccupied(true);
        assertNull(findUnoccupiedTableMethod.invoke(restaurant, 12),
                "The method 'findUnoccupiedTable(final int partySize)' should return null if no appropriate table is free.");

        assertNull(findUnoccupiedTableMethod.invoke(restaurant, tables.stream().max(Comparator.comparingInt(Table::getSeats)).get().getSeats() + 1),
                "The method 'findUnoccupiedTable(final int partySize)' should return null if no appropriate table is free.");

        emptyTable.setOccupied(false);
    }

    @Test
    void task_2_getTotalRevenue_implemented() throws InvocationTargetException, IllegalAccessException {
        Method getTotalRevenueMethod = null;
        try{
            getTotalRevenueMethod = Restaurant.class.getMethod("getTotalRevenue");
        } catch (NoSuchMethodException e) {
            fail("The method 'getTotalRevenue()' does not exist in the 'Restaurant' class.");
        }

        assertEquals(totalRevenue, getTotalRevenueMethod.invoke(restaurant),
                "The method 'getTotalRevenue()' does not return the correct revenue.");
    }

    @Test
    void task_3_getTableOccupyPercentage_implemented() throws InvocationTargetException, IllegalAccessException {
        Method getTableOccupyPercentageMethod = null;
        try{
            getTableOccupyPercentageMethod = Restaurant.class.getMethod("getTableOccupancyPercentage");
        } catch (NoSuchMethodException e) {
            fail("The method 'getTableOccupancyPercentage()' does not exist in the 'Restaurant' class.");
        }

        assertEquals(occupiedTablesPercentage, getTableOccupyPercentageMethod.invoke(restaurant),
                "The method 'getTableOccupyPercentage()' does not return the correct percentage.");
    }

    @Test
    void task_4_getSeatsOccupyPercentage_implemented() throws InvocationTargetException, IllegalAccessException {
        Method getSeatsOccupyPercentageMethod = null;
        try{
            getSeatsOccupyPercentageMethod = Restaurant.class.getMethod("getSeatsOccupancyPercentage");
        } catch (NoSuchMethodException e) {
            fail("The method 'getSeatsOccupancyPercentage()' does not exist in the 'Restaurant' class.");
        }

        double occupiedSeats = 0;
        for (Table table : tables) {
            if(table.isOccupied())
                occupiedSeats += table.getSeats();
        }
        assertEquals(occupiedSeatsPercentage, getSeatsOccupyPercentageMethod.invoke(restaurant),
                "The method 'getSeatsOccupyPercentage()' does not return the correct percentage.");
    }

    @Test
    void task_5_isVegetarian_implemented() throws InvocationTargetException, IllegalAccessException {
        Method isVegetarianMethod = null;
        try{
            isVegetarianMethod = MenuItem.class.getMethod("isVegetarian");
        } catch (NoSuchMethodException e) {
            fail("The method 'isVegetarian()' does not exist in the 'MenuItem' class.");
        }

        for (MenuItem menuItem : menuItems) {
            assertEquals(menuItem.getDescription().toLowerCase().contains("vegetarian"), isVegetarianMethod.invoke(menuItem),
                    "The method 'isVegetarian()' does not return the correct value.");
        }
    }
}
