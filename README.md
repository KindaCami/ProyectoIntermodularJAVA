#  ESPACE – Proyecto Intermodular

**European Space Project Advancement and Collaboration Ecosystem**  
Una aplicación Java con JSP, Servlets y JDBC para la gestión de contratos internacionales, empresas postulantes y países financiadores.



##  Funcionalidades

- CRUD completo para:
  - Países
  - Empresas
  - Contratos
  - Postulaciones
- Asociación entre empresas y países (empresas multinacionales)
- Cálculo automático del presupuesto total por contrato
- Diseño modular siguiendo el patrón MVC
- Uso de DAO y consultas preparadas para acceso seguro a la base de datos
- Interfaz web mediante JSP y estilos con Bootstrap



## Tecnologías usadas

- Java 17+
- Jakarta Servlet 6
- JSP + JSTL
- JDBC + MySQL
- Apache Tomcat 10
- Maven
- Git + GitHub



##  Requisitos previos

- JDK 17 o superior
- MySQL Server
- Apache Tomcat configurado en IntelliJ IDEA
- Maven
- Git



##  Instrucciones de ejecución

##  Instrucciones de ejecución

1. Clona el repositorio:

   git clone https://github.com/KindaCami/ProyectoIntermodularJAVA

2. Configura la BBDD mySQL
3. Configura la conexion a la base de datos en el BBDDConnector: src/main/java/com/proyecto/proyectointermodular/BBDD/BBDDConnector.java
4. Ejecutar la aplicacion:
   - Abre el proyecto en IntelliJ IDEA (Ultimate o Community + plugin para Jakarta EE).
   - Recomiendo mi archivo pom.xlm.
   - Configura Tomcat
   - Asegúrate de que el proyecto esté empaquetado como .war
   





