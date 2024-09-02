package ch.ffhs.util;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Allgemeine Hilfsfunktionen zum Einlesen von Textdateien.
 */
public class FileUtils {

    /**
     * Es werden keine Objekte dieser Klasse erstellt.
     */
    private FileUtils() {
    }

    public static List<Integer> getIntegersFrom(String file) {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(FileUtils.getInputStream(file)));
        List<Integer> lines = new ArrayList<>();
        try {
            while (reader.ready()) {
                lines.add(Integer.parseInt(reader.readLine().trim()));
            }
        } catch (IOException ignore) {
        }

        return lines;
    }

    /**
     * Einlesen einer Datei. Diese Version funktioniert in jeder Umgebung.
     *
     * @param fileName einzulesende Datei
     * @return Datenstrom der zu lesenden Datei
     */
    public static InputStream getInputStream(final String fileName) {
        InputStream inputStream = FileUtils.class
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("File not found! " + fileName);
        }

        return inputStream;
    }

    /**
     * Einlesen einer Datei, welche sich im Ressourcen-Verzeichnis
     * befindet. Diese Version funktioniert nicht, falls wir das
     * ganze Projekt in einer {@code .jar} Datei speichern.
     *
     * @param fileName einzulesende Datei
     * @return gefundene Datei
     * @throws URISyntaxException falls die Datei nicht gefunden wurde
     */
    public File getFileFromResource(final String fileName) throws URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }

    }
}
