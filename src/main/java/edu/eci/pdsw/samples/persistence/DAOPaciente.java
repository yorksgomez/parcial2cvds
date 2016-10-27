/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.persistence;

import edu.eci.pdsw.samples.entities.Paciente;
import java.util.List;


/**
 *
 * @author hcadavid
 */
public interface DAOPaciente {

    
    /**
     * Consultar los N pacientes que mas consultas hayan tenido registrados
     * en el anyo indicado (del 1 de Enero al 31 de Diciembre del anyo 
     * indicado).
     * @param N el tope de resultados de la consulta
     * @param year El anyo para el cual se realiza la consulta
     * @return los pacientes, ordenados por numero de consultas
     */    
    public List<Paciente> loadTopNPatientsInAYear(int N,int year);        
    
        
    
}
