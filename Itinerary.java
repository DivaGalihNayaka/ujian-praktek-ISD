import java.util.*;

public class Itinerary {

    static class City {
        String name;
        List<City> neighbors;

        City(String name) {
            this.name = name;
            this.neighbors = new ArrayList<>();
        }

        void addNeighbor(City city) {
            neighbors.add(city);
        }
    }

    public static void main(String[] args) {
       
        City paris = new City("Paris");
        City brussels = new City("Brussels");
        City zurich = new City("Zurich");
        City amsterdam = new City("Amsterdam");
        City vienna = new City("Vienna");
        City prague = new City("Prague");
        City hamburg = new City("Hamburg");
        City warsaw = new City("Warsaw");
        City budapest = new City("Budapest");

        paris.addNeighbor(brussels);
        paris.addNeighbor(amsterdam);

        brussels.addNeighbor(paris);
        brussels.addNeighbor(hamburg);
        brussels.addNeighbor(vienna);

        zurich.addNeighbor(vienna);
        zurich.addNeighbor(prague);

        amsterdam.addNeighbor(brussels);

        vienna.addNeighbor(prague);
        vienna.addNeighbor(budapest);

        prague.addNeighbor(vienna);

        hamburg.addNeighbor(paris);
        hamburg.addNeighbor(warsaw);

        warsaw.addNeighbor(hamburg);

        budapest.addNeighbor(vienna);

        System.out.println("Negara Terdekat dari Paris:");
        Set<String> terdekat = new HashSet<>();
        for (City city : paris.neighbors) {
            System.out.println(" - " + city.name);
            terdekat.add(city.name);
        }

        System.out.println("\nNegara Terjauh dari Paris:");
        Set<String> sudah = new HashSet<>();
        Queue<City> queue = new LinkedList<>();
        queue.add(paris);
        sudah.add(paris.name);

        while (!queue.isEmpty()) {
            City current = queue.poll();
            for (City neighbor : current.neighbors) {
                if (!sudah.contains(neighbor.name)) {
                    queue.add(neighbor);
                    sudah.add(neighbor.name);
                }
            }
        }

        for (String nama : sudah) {
            if (!nama.equals(paris.name) && !terdekat.contains(nama)) {
                System.out.println(" - " + nama);
            }
        }
    }
}