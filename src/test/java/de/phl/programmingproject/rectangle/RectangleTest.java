package de.phl.programmingproject.rectangle;

import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the {@link Rectangle} exercise.
 */
public class RectangleTest {

    final double length = 2.33;
    final double width = 5;

    Rectangle rectangle;

    @BeforeEach
    void setUp() {
        rectangle = new Rectangle();
        rectangle.setLength(length);
        rectangle.setWidth(width);
    }

    @Test
    void task_1_getPerimeter_implemented() {
        Method getPerimeterMethod = TestUtils.getMethod(Rectangle.class, "getPerimeter");
        double perimeter = 2 * (length + width);

        try {
            assertEquals(perimeter,
                    getPerimeterMethod.invoke(rectangle),
                    String.format("The perimeter of a rectangle with length '%f' and width '%f' must be '%f'!",
                            length, width, perimeter));
        } catch (Exception e) {
            fail("Something went wrong when testing the 'getPerimeter' method.\n" + e);
        }
    }

    @Test
    void task_2_constructor_with_length_and_width_implemented() {
        Constructor<Rectangle> constructor = null;
        try {
            constructor = Rectangle.class.getConstructor(double.class, double.class);
        } catch (NoSuchMethodException e) {
            fail("The constructor with parameters length and width does not exist in the 'Rectangle' class.");
        }

        Constructor<Rectangle> finalConstructor = constructor;
        assertThrows(Exception.class, () -> finalConstructor.newInstance(-1, -1),
                "The constructor with parameters length and width must throw an IllegalArgumentException if the length or width is negative!");

        Rectangle recti = null;
        try {
            recti = constructor.newInstance(length, width);
        } catch (Exception e) {
            fail("Something went wrong when testing the constructor with parameters length and width.\n" + e);
        }

        assertEquals(length, recti.getLength(),
                String.format("The length of the rectangle is not set correctly!", length));
        assertEquals(width, recti.getWidth(),
                String.format("The width of the rectangle is not set correctly!", width));
    }

    @Test
    void task_3_getDiagonal_implemented() {
        Method getDiagonalMethod = TestUtils.getMethod(Rectangle.class, "getDiagonal");

        double diagonal = Math.sqrt(length * length + width * width);

        try {
            assertEquals(diagonal,
                    getDiagonalMethod.invoke(rectangle),
                    String.format("The diagonal of a rectangle with length '%f' and width '%f' must be '%f'!",
                            length, width, diagonal));
        } catch (Exception e) {
            fail("Something went wrong when testing the 'getDiagonal' method.\n" + e);
        }
    }

    @Test
    void task_4_isSquare_implemented() {
        Method isSquareMethod = TestUtils.getMethod(Rectangle.class, "isSquare");

        Rectangle square = new Rectangle();
        square.setLength(width);
        square.setWidth(width);

        try {
            assertFalse((boolean) isSquareMethod.invoke(rectangle),
                    String.format("A rectangle with length '%f' and width '%f' is not a square!", length, width));

            assertTrue((boolean) isSquareMethod.invoke(square),
                    String.format("A rectangle with length '%f' and width '%f' is a square!", width, width));

        } catch (Exception e) {
            fail("Something went wrong when testing the 'isSquare' method.\n" + e);
        }
    }

    @Test
    void task_5_scale_implemented() {
        Method scaleMethod = TestUtils.getMethod(Rectangle.class, "scale", double.class);

        Method finalScaleMethod = scaleMethod;
        // assert that the cause of the thrown exception is an IllegalArgumentException
        Exception exception = assertThrows(Exception.class, () -> finalScaleMethod.invoke(rectangle, -1),
                "The 'scale' method must throw an IllegalArgumentException if the factor is negative!");
        assertEquals(IllegalArgumentException.class, exception.getCause().getClass(),
                "The 'scale' method must throw an IllegalArgumentException if the factor is negative!");

        assertThrows(Exception.class,
                () -> finalScaleMethod.invoke(rectangle, -1), "The 'scale' method must throw an IllegalArgumentException if the factor is negative!");

        double factor = 2.5;
        double scaledLength = length * factor;
        double scaledWidth = width * factor;

        try {
            scaleMethod.invoke(rectangle, factor);
        } catch (Exception e) {
            fail("Something went wrong when testing the 'scale' method.\n" + e);
        }

        assertEquals(scaledLength, rectangle.getLength(),
                "The length of the rectangle is not scaled correctly!");
        assertEquals(scaledWidth, rectangle.getWidth(),
                "The width of the rectangle is not scaled correctly!");
    }
}
