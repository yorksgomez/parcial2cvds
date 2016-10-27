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
package edu.eci.pdsw.samples.services;

import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.persistence.DaoFactory;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.eci.pdsw.samples.persistence.DAOPaciente;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public class ServicesFacade {
    
    
    private static ServicesFacade instance=null;
    
    private final Properties properties=new Properties();
    
    private final DaoFactory dc=null;
    
    private ServicesFacade(String propFileName) throws IOException{        
	InputStream input = null;
        input = this.getClass().getClassLoader().getResourceAsStream(propFileName);        
        properties.load(input);
        
    }
    
    public static ServicesFacade getInstance(String propertiesFileName) throws RuntimeException{
        if (instance==null){
            try {
                instance=new ServicesFacade(propertiesFileName);
            } catch (IOException ex) {
                throw new RuntimeException("Error on application configuration:",ex);
            }
        }        
        return instance;
    }

    
    /**
     * Consultar los N pacientes que mas consultas hayan tenido registrados
     * en el anyo indicado (del 1 de Enero al 31 de Diciembre del anyo 
     * indicado).
     * @param N el tope de resultados de la consulta
     * @param year El anyo para el cual se realiza la consulta
     * @return los pacientes, ordenados por numero de consultas
     */    
    public List<Paciente> topNPacientesPorAnyo(int N,int year) throws ServiceFacadeException{
        DaoFactory df=DaoFactory.getInstance(properties);
        try {
            df.beginSession();
            return df.getDaoPaciente().loadTopNPatientsInAYear(N, year);
        } catch (PersistenceException ex) {
            Logger.getLogger(ServicesFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceFacadeException("Error en consulta comentarios bajos por rango de edad", ex);                    
        }
         
    }
    
}
