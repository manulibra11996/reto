package com.certidevs.reto;

import com.certidevs.reto.entities.Proyecto;
import com.certidevs.reto.entities.Tarea;
import com.certidevs.reto.repositories.ProyectoRepository;
import com.certidevs.reto.repositories.TareaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class RetoApplication {

	public static void main(String[] args) {

		// inicializar spring
		ApplicationContext spring = SpringApplication.run(RetoApplication.class, args);

		// obtener repositorio (lo crea spring)
		ProyectoRepository proyectoRepository = spring.getBean(ProyectoRepository.class);
		TareaRepository tareaRepository = spring.getBean(TareaRepository.class);


		//Proyectos
		Proyecto proyecto1 = new Proyecto("Proyecto 1", "Proyecto 1 descripción", LocalDate.now(), true);
		Proyecto proyecto2 = new Proyecto("Proyecto 2", "Proyecto 2 descripción", LocalDate.now(), false);

		//Tarea
		Tarea tarea1 = new Tarea("Tarea 1", "Tarea 1 descripción", true, proyecto1);
		Tarea tarea2 = new Tarea("Tarea 2", "Tarea 2 descripción", false, proyecto2);
		Tarea tarea3 = new Tarea("Tarea 3", "Tarea 3 descripción", false, proyecto1);
		Tarea tarea4 = new Tarea("Tarea 4", "Tarea 4 descripción", true, proyecto2);
		Tarea tarea5 = new Tarea("Tarea 5", "Tarea 5 descripción", true, proyecto1);

		// guardar proyectos
		proyectoRepository.save(proyecto1);
		proyectoRepository.save(proyecto2);

		// guardar tareas
		tareaRepository.save(tarea1);
		tareaRepository.save(tarea2);
		tareaRepository.save(tarea3);
		tareaRepository.save(tarea4);
		tareaRepository.save(tarea5);

		//Un método derivado para buscar proyectos por nombre
		String nombre = "proyecto1";
		List<Proyecto> proyectoNombre = proyectoRepository.findByNombreIgnoreCase(nombre);
		for (Proyecto proyectoFor : proyectoNombre) {
			System.out.println(proyectoFor.toString());
		}

		//Un método derivado para buscar proyectos por fecha de inicio
		LocalDate fecha = LocalDate.now();
		List<Proyecto> proyectoFecha = proyectoRepository.findByFechaInicio(fecha);
		for (Proyecto proyectoFor : proyectoFecha) {
			System.out.println(proyectoFor.toString());
		}

		//Una consulta JPQL que encuentre todos los proyectos activos
		List<Proyecto> proyectoActivos = proyectoRepository.findByActivoTrue();
		for (Proyecto proyectoActivo : proyectoActivos) {
			System.out.println(proyectoActivo.toString());
		}

		//Un método derivado para buscar tareas por título
		String titulo = "Tarea 1";
		List<Tarea> tareaTitulos = tareaRepository.findByTituloIgnoreCase(titulo);
		for (Tarea tareaTitulo : tareaTitulos) {
			System.out.println(tareaTitulo.toString());
		}

		//Un método derivado para contar cuántas tareas no están completadas
		Long tareaCompletadas = tareaRepository.countByCompletadaTrue();
		System.out.println(tareaCompletadas.toString());

		//Una consulta JPQL que encuentre todas las tareas que pertenezcan a un mismo proyecto
		String proyecto = "Proyecto 1";
		List<Tarea> tareaProyectos = tareaRepository.findByProyecto_NombreIgnoreCase(proyecto);
		for (Tarea tareaProyecto : tareaProyectos) {
			System.out.println(tareaProyecto.toString());
		}
	}
}
