package es.santander.ascender.proyecto11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// Implemento la interfaz. Le digo que agrege los métodos de la misma desde la bombillita
public class GestionEstudiantes implements IGestionEstudiantes{

    private Map<String, Integer> estudiantesMap;
    private Set<String> estudiantesSet;  
    // En los ejemplos vistos hasta ahora, la declaración e inicialización de la instancia
    // los hacía dentro del main y podía usar sus métodos a continuación. Estos métodos no son estáticos.
    
    public GestionEstudiantes(){
        estudiantesMap = new HashMap<String,Integer>();
        estudiantesSet = new HashSet<String>();
    }
    @Override
    public boolean agregarEstudiante(String nombre, int calificacion) {
    // El test pide comprobar (true/false) si ya existe el estudiante para no duplicar la entrada. Si es posible, agregar.
    
              if (estudiantesMap.containsKey(nombre)){
                return false; // Ya existe luego no es posible agregarlo.
              } 
                estudiantesMap.put(nombre,calificacion);
                return true;
    }

    @Override
    public Integer obtenerCalificacion(String nombre) {
        return estudiantesMap.get(nombre);
        // devuelve el par-valor del parámetro nombre, que es calificación, un entero.
    }

    @Override
    public Map<String, Integer> obtenerEstudiantesYCalificaciones() {
        // estudiantesMap.put("Pepe del Uno",99);
        // estudiantesMap.put("Pepe del Dos",68);
        // El test ya aporta las dos entradas.
        return estudiantesMap;
    }
        
    @Override
    public boolean existeEstudiante(String nombre) {
        if (estudiantesMap.containsKey(nombre))
            { return true;} else {return false;}
    }

    @Override
    public boolean eliminarEstudiante(String nombre) {
        if (estudiantesMap.containsKey(nombre))
        { estudiantesMap.remove(nombre); return true;} else {return false;}
    }

    @Override
    public void agregarEstudiantes(Set<String> nuevosEstudiantes, Map<String, Integer> nuevasCalificaciones) {
        for (String nuevosE : nuevosEstudiantes) {
            estudiantesSet.add(nuevosE);
        }
        for (Map.Entry<String, Integer> nuevasC : nuevasCalificaciones.entrySet()){
            // Este con ayuda.
            String nomEstudiante = nuevasC.getKey();
            Integer notaEstudiante = nuevasC.getValue();
            estudiantesMap.put(nomEstudiante,notaEstudiante);
        }
    }
}
