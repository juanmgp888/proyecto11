package es.santander.ascender.proyecto11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GestionEstudiantes implements IGestionEstudiantes{

    private Map<String, Integer> estudiantesMap;
    private Set<String> estudiantesSet;  
    
    public GestionEstudiantes(){
        estudiantesMap = new HashMap<String,Integer>();
        estudiantesSet = new HashSet<String>();
    }
    @Override
    public boolean agregarEstudiante(String nombre, int calificacion) {
        
              if (estudiantesMap.containsKey(nombre)){
                return false; 
              } 
                estudiantesMap.put(nombre,calificacion);
                return true;
    }

    @Override
    public Integer obtenerCalificacion(String nombre) {
        return estudiantesMap.get(nombre);
    }

    @Override
    public Map<String, Integer> obtenerEstudiantesYCalificaciones() {
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
