/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lizeth Casillas
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class CVXMLWriter {
    public static void main(String[] args) {
        try {
            // Crear un documento XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // Crear el elemento raíz
            Element root = document.createElement("CurriculumVitae");
            document.appendChild(root);

            // Agregar datos personales
            Element personal = document.createElement("DatosPersonales");
            root.appendChild(personal);

            Element nombre = document.createElement("Nombre");
            nombre.setTextContent("Alondra Ramirez");
            personal.appendChild(nombre);

            Element correo = document.createElement("Correo");
            correo.setTextContent("alondra@gmail.com");
            personal.appendChild(correo);

            Element telefono = document.createElement("Telefono");
            telefono.setTextContent("123-456-7890");
            personal.appendChild(telefono);

            // Agregar experiencia laboral
            Element experiencia = document.createElement("ExperienciaLaboral");
            root.appendChild(experiencia);

            Element trabajo1 = document.createElement("Trabajo");
            trabajo1.setAttribute("empresa", "Empresa X");
            trabajo1.setAttribute("puesto", "Desarrolladora Web");
            trabajo1.setTextContent("Trabajé en desarrollo de aplicaciones web.");
            experiencia.appendChild(trabajo1);

            // Guardar el XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("CV.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo CV.xml guardado exitosamente.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
