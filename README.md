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

##  Pruebas con JUnit
Se han implementado test unitarios utilizando JUnit para asegurar el correcto funcionamiento de las operaciones CRUD
sobre la entiedad Postulacion y Contrato. Cubren los siguientes casos:

1. Insercion
2. Verificacion de existencia
3. Recuperacion de una postulacion especifica
4. Actualizacion del resultado de la postulacion
5. Listado de todas las postulaciones
6. Eliminacion de una postulacion
7. Insertar y obtener un contrato

## Manejo de errores
A lo largo del proyecto he implementado manejo de errores y alguna validacion de forma basica:
1. En los DAOs mediante try-catch
2. En varios form.jsp usando validaciones HTML.
3. En el backend algunas validaciones de forma logica, como comprobar si un ID es null o si ResultSet tiene datos antes de
construir un objeto.

Faltarian validaciones del servidor mas robustas, como:
1. Evitar string vacios, validar rangos de numeracion:
(presupuestoAsignado < presupuestoTotal), validar formatis (ID alfanumericos, por ejemplo).
2. Mensajes mas claros en los JSP (mostrar mensaje si el usuario deja un campo vacio), Mostrar errores de insercio(si una empresa ya existe).

 



##  Instrucciones de ejecución

1. Clona el repositorio:

   git clone https://github.com/KindaCami/ProyectoIntermodularJAVA

2. Configura la BBDD mySQL
3. Configura la conexion a la base de datos en el BBDDConnector: src/main/java/com/proyecto/proyectointermodular/BBDD/BBDDConnector.java
4. Ejecutar la aplicacion:
   - Abre el proyecto en IntelliJ IDEA (Ultimate o Community + plugin para Jakarta EE).
   - Configura Tomcat.
   - Asegúrate de que el proyecto esté empaquetado como .war.
   





