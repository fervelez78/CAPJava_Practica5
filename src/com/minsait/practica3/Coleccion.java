package com.minsait.practica3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

// Y la siguiente coleccion
public class Coleccion {
	
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Cursos profesional de Java", 6.5f, 50, 200 ));
        cursos.add(new Curso("Cursos profesional de Python", 8.5f, 60, 800 ));
        cursos.add(new Curso("Cursos profesional de DB", 4.5f, 70, 700 ));
        cursos.add(new Curso("Cursos profesional de Android", 7.5f, 10, 400 ));
        cursos.add(new Curso("Cursos profesional de Escritura", 1.5f, 10, 300));

        /***
         * Resolver los siguientes problemas con streams:
         */
        /**
         * Obtener la cantidad de cursos con una duración mayor a 5 horas.
         */
        List<Curso> masDeCincoHoras = cursos.stream().filter(c-> c.getDuracion() > 5).collect(Collectors.toList());
        long totMasdeCincoHoras = masDeCincoHoras.stream().count(); 
        System.out.println("Se encontraron " + totMasdeCincoHoras + " cursos con mas de 5 horas:");
        masDeCincoHoras.forEach(c->System.out.println(" - " + c.getTitulo() + " (" + c.getDuracion() + " hrs.)"));
        
        /**
         * Obtener la cantidad de cursos con una duración menor a 2 horas.
         */
        List<Curso> menosDeDosHoras = cursos.stream().filter(c-> c.getDuracion() < 2).collect(Collectors.toList());
        long totMenosdeDosHoras = menosDeDosHoras.stream().count();
        System.out.println("Se encontraron " + totMenosdeDosHoras + " cursos con menos de 2 horas:");
        menosDeDosHoras.forEach(c->System.out.println(" - " + c.getTitulo() + " (" + c.getDuracion() + " hrs.)"));
        
        /**
         * Listar el título de todos aquellos cursos con una cantidad de vídeos mayor a 50.
         */
        List<Curso> masDeCincuentaVideos = cursos.stream().filter(c-> c.getVideos() > 50).collect(Collectors.toList());
        System.out.println("Se encontraron los siguientes cursos con mas de 50 videos:");
        masDeCincuentaVideos.forEach(c->System.out.println(" - " + c.getTitulo() + " (" + c.getVideos() + " videos)"));
        
        /**
         * Mostrar en consola el título de los 3 cursos con mayor duración.
         */
        System.out.println("Los 3 cursos con mas duracion:");
        List<Curso> ordenadaPorDuracion = cursos.stream().sorted(Comparator.comparing(Curso::getDuracion).reversed()).limit(3).collect(Collectors.toList());
        ordenadaPorDuracion.forEach(c->System.out.println(" - " + c.getTitulo() + " (" + c.getDuracion() + " hrs.)"));
    	/*
        Curso[] ordenadaPorDuracion = cursos.stream().sorted(Comparator.comparing(Curso::getDuracion)).toArray(Curso[]::new);
        for (int i = ordenadaPorDuracion.length - 3; i< ordenadaPorDuracion.length;i++)
        	System.out.println(" - " + ordenadaPorDuracion[i].getTitulo() + " (" + ordenadaPorDuracion[i].getDuracion() + " hrs.)");
        */
        /**
         * Mostrar en consola la duración total de todos los cursos.
         */
        DoubleSummaryStatistics estadistica = cursos.stream().mapToDouble(x->x.getDuracion()).summaryStatistics();
        System.out.println("La Duracion total es: " + estadistica.getSum() + " hrs.");
        /**
         * Mostrar en consola todos aquellos cursos que superen el promedio en cuanto a duración se refiere.
         */
        double promedioDuracion = estadistica.getAverage();
        List<Curso> duracionMasDelPromedio = cursos.stream().filter(c-> c.getDuracion() > promedioDuracion).collect(Collectors.toList());
        long totDuracionMasDelPromedio = masDeCincoHoras.stream().count(); 
        System.out.println("Se encontraron " + totDuracionMasDelPromedio + " cursos con mas del promedio de " + promedioDuracion + " horas:");
        duracionMasDelPromedio.forEach(c->System.out.println(" - " + c.getTitulo() + " (" + c.getDuracion() + " hrs.)"));
        
        /**
         * Mostrar en consola la duración de todos aquellos cursos que tengan una
         * cantidad de alumnos inscritos menor a 500.
         */
        List<Curso> menosDeQuinientosAlumnos = cursos.stream().filter(c-> c.getAlumnos() < 500).collect(Collectors.toList());
        long totMenosDeQuinientosAlumnos = masDeCincoHoras.stream().count(); 
        System.out.println("Se encontraron " + totMenosDeQuinientosAlumnos + " cursos con menos de 500 alumnos inscritos:");
        menosDeQuinientosAlumnos.forEach(c->System.out.println(" - " + c.getTitulo() + " (" + c.getAlumnos() + " alumnos)"));
        
        /**
         * Obtener el curso con mayor duración.
         */
        Curso cursoMaxDur = cursos.stream().max(Comparator.comparing(Curso::getDuracion)).get();
        System.out.println("El curso con mayor duración es " + cursoMaxDur.getTitulo() + " (" + cursoMaxDur.getDuracion() + " hrs.)");
        
        
        /**
         * Crear una lista de Strings con todos los titulos de los cursos.
         */
        List<String> cursosLista = cursos.stream().map(s->s.getTitulo()).distinct().collect(Collectors.toList());
        System.out.println("Lista de cursos: ");
        cursosLista.forEach(System.out::println);
        /**
         * Una vez terminado subirlo al repositorio
         */
}
}
