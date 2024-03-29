package ru.job4j.assertj;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .isNotEmpty()
                .isNotBlank()
                .startsWith("Sph")
                .endsWith("e");
    }

    @Test
    void checkVertexOfSphere() {
        Box box = new Box(0, 10);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(0)
                .isGreaterThan(-1)
                .isEven();
    }

    @Test
    void checkBooleanOfSphere() {
        Box box = new Box(0, 8);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void checkAreaOfSphere() {
        Box box = new Box(0, 2);
        double area = box.getArea();
        assertThat(area).isEqualTo(50.265d, withPrecision(0.01d))
                .isCloseTo(50.265d, withPrecision(0.1d))
                .isPositive()
                .isNotNegative()
                .isGreaterThan(50D)
                .isLessThan(51D);
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 6);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron")
                .isNotBlank()
                .isNotEmpty()
                .endsWith("ron")
                .startsWith("Tet");
    }

    @Test
    void checkVertexOfTetrahedron() {
        Box box = new Box(4, 6);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(4)
                .isGreaterThan(3)
                .isLessThan(5)
                .isPositive()
                .isEven();
    }

    @Test
    void checkBooleanOfTetrahedron() {
        Box box = new Box(4, 5);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void checkAreaOfTetrahedron() {
        Box box = new Box(4, 2);
        double area = box.getArea();
        assertThat(area).isEqualTo(6.9D, withPrecision(0.1D))
                .isPositive()
                .isNotNegative()
                .isGreaterThan(6D)
                .isLessThan(7D);
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 6);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .isNotBlank()
                .isNotEmpty()
                .endsWith("e")
                .startsWith("C");
    }

    @Test
    void checkVertexOfCube() {
        Box box = new Box(8, 6);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(8)
                .isEven()
                .isPositive()
                .isLessThan(9)
                .isGreaterThan(7);
    }

    @Test
    void checkBooleanOfCube() {
        Box box = new Box(8, 6);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }

    @Test
    void checkAreaOfCube() {
        Box box = new Box(8, 6);
        double area = box.getArea();
        assertThat(area).isEqualTo(216D, withPrecision(0.01d))
                .isPositive()
                .isNotNegative();

    }
}