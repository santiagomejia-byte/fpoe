/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package co.edu.uvapalmira.fpoe.persistencia;

import co.edu.uvapalmira.fpoe.modelo.Asignatura;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sala Sistemas
 */
public class AsignaturaDAOTest {
    private AsignaturaDAO asignaturaDAO;
    private Long id;
    
    public AsignaturaDAOTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoPU");
        this.asignaturaDAO = new AsignaturaDAO(emf);
    }
    
    @Test
    public void test(){
        try {
            System.out.println("Insertar");
            Asignatura asig= new Asignatura("750014C", "FPOE",(byte) 3, (byte)3);
            asignaturaDAO.create(asig);
            this.id = asig.getId();
            System.out.println(this.id);
            Assert.assertNotNull(asig.getId());
            
            System.out.println("Buscar");
            asig= null;
            asig= asignaturaDAO.buscarPorCodigo("750014C");
            Assert.assertEquals("FPOE", asig.getNombre());
            
            asig.setNombre("Fund. Prog. O. Eventos");
            this.asignaturaDAO.edit(asig);
            
            asig= asignaturaDAO.buscarPorCodigo("750014C");
            Assert.assertEquals("Fund. Prog. O. Eventos", asig.getNombre());
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(AsignaturaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
            fail();
        }
    }
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of buscarPorCodigo method, of class AsignaturaDAO.
     
    @Test
    /*public void testBuscarPorCodigo() {
        System.out.println("buscarPorCodigo");
        String codigo = "";
        AsignaturaDAO instance = null;
        Asignatura expResult = null;
        Asignatura result = instance.buscarPorCodigo(codigo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarPorEscuela method, of class AsignaturaDAO.
     */
    
    /**
    @Test
    public void testBuscarPorEscuela() {
        System.out.println("buscarPorEscuela");
        String codigoEscuela = "";
        AsignaturaDAO instance = null;
        List<Asignatura> expResult = null;
        List<Asignatura> result = instance.buscarPorEscuela(codigoEscuela);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
   */
}
