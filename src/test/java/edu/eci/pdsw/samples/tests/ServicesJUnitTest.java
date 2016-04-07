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
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.entities.Comentario;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.services.ServiceFacadeException;
import edu.eci.pdsw.samples.services.ServicesFacade;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author hcadavid
 */
public class ServicesJUnitTest {

    public ServicesJUnitTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void clearDB() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "sa", "");
        Statement stmt = conn.createStatement();
        stmt.execute("delete from COMENTARIOS");
        stmt.execute("delete from SUSCRIPTORES");
        conn.commit();
        conn.close();
    }

    /**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException 
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "");        
    }
    
    @Test
    public void pruebaCeroTest() throws SQLException, ServiceFacadeException {
        //Insertar datos en la base de datos de pruebas, de acuerdo con la clase
        //de equivalencia correspondiente
        Connection conn=getConnection();
        Statement stmt=conn.createStatement();        
        stmt.execute("INSERT INTO `SUSCRIPTORES` (`id`, `nombre`,`anyo_nacimiento`,`total_suscripciones`) VALUES (123,'PEDRO PEREZ',1980,10)");
        stmt.execute("INSERT INTO `COMENTARIOS` (`id`, `comentario`, `puntaje`, `fecha`, `CLIENTES_id`) VALUES (3,'El periodico llego en mal estado',3,'2015-01-01 00:00:00',123)");          
        conn.commit();
        conn.close();
	
        //Realizar la operacion de la logica y la prueba
        
        ServicesFacade servicios=ServicesFacade.getInstance("h2-applicationconfig.properties");
	//servicios.comenteriosMasBajosPorRangoEdad(1, 10);
        //assert ...
        
    }    
    

}
