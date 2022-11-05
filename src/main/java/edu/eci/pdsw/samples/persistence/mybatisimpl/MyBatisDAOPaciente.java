/*
 * Copyright (C) 2016 hcadavid
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
package edu.eci.pdsw.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.persistence.DaoPaciente;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.PacienteMapper;
import java.util.List;

/**
 *
 * @author hcadavid
 */
public class MyBatisDAOPaciente implements DaoPaciente {


    @Inject
    PacienteMapper pacienteMapper;
    
    @Override
    public Paciente load(int id, TipoIdentificacion tipoIdentificacion) throws PersistenceException {
        try {
            return pacienteMapper.getPaciente(id, tipoIdentificacion);
        } catch(Exception ex) {
            throw new PersistenceException("Error al consultar el paciente: " + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Paciente> loadAll() throws PersistenceException {
        try{
            return pacienteMapper.getPacientes();
        }
        catch(Exception ex){
            throw new PersistenceException("Error al consultar los pacientes:"+ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public void save(Paciente e) throws PersistenceException {
        try {
            pacienteMapper.addPaciente(e);
        } catch(Exception ex) {
            throw new PersistenceException("Error al guardar el paciente: " + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public void update(Paciente e) throws PersistenceException {
        try {
            pacienteMapper.setPaciente(e);
        } catch(Exception ex) {
            throw new PersistenceException("Error al actualizar el paciente: " + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public void addConsulta(int id, TipoIdentificacion tipoId, Consulta c) throws PersistenceException {
        try {
            pacienteMapper.addConsulta(id, tipoId, c);
        } catch(Exception ex) {
            throw new PersistenceException("Error al agregar consulta al paciente: " + ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public List<Paciente> loadSick() throws PersistenceException {
        try {
            return pacienteMapper.getSick();
        } catch(Exception ex) {
            throw new PersistenceException("Error al consultar pacientes: " + ex.getLocalizedMessage(), ex);
        }
    }


}
