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

##  Posibles dudas y errores ejecutando el programa:

1. No se puede eliminar una empresa que esté unida a un contrato, una postulacion o una empresa multinacional (empresa_pais)
primero hay que eliminar esas relaciones manualmente para evitar incoherencias y fuga de datos en la BBDD.
2. No se pueden borrar los paises, primero hay que eliminar las relaciones entre empresas, puesto que existen restricciones de clave foranea para proteger la integridad de la app. Solo se
puede borrar un pais que no tenga ningua empresa asociada.
(PARA MAS INFO VEASE EL SCRIPT O LA IMAGEN DEL DIAGRAMA DE LA BBDD MySQL).

##  Posibles dudas sobre algunos atributos de pais, contrato, contratoPais y postulacion:

- Pais -> presupuesto_total: Es el importe maximo de dinero que un pais ha destinado o reservado para invertir en contratos
internacionales(espacial, defensa, ID+i, etc).
Ej: España tiene un presupuesto de 1 millon de euros para invertir en contratos.
- Pais -> presupuesto_asignado: Es el importe que se ha comprometido (o repartido) entre los contratos en los que el pais participa.
Se puede usar para mostrar cuanto queda disponible (total - asignado), tambien validar si un contrato cabe en el presupuesto restante.
Ej: Si españa ha asigando 500 mil euros a varios contratos, le quedarian 500 mil disponibles para otros.
(TODO EL PRESUPUESTO SE USA DE FORMA INFORMATIVA Y NO ESTA AUTOMATIZADO) En un escenario ideal, al añadir un pais a un contrato con una cantidad, esa cantidad se suma al presupuesto asignado.
- Contrato -> importe: Es el coste total y real de un contrato. Ej: Si un contrato como lanzar un satelite al espacio, y el gobierno destina 200 mil para ello, ese seria el importe del contrato. importe = presupuesto total del contrato.
- Postulacion -> propuesta_importe: Cuando una empresa se postula a un contrato, propone una cantidad de dinero para llevarlo a cabo.
Esa propuesta es el importe o propuesta_importe en la BBDD.
En una logica avanzada (que puedo implementar mas adelante) podria: 
Comparar todas las postulaciones de un contrato, evaluar si una propuesta es menor o igual al importe del contrato,
marcar automaticamente esa postulacion como ganadora (resultado = "ganada), o rechazar las que superen
el presupuesto.
- contratoPais -> aporte: Es lo que cada país ha invertido en un proyecto en especifico.

Para mas información sobre el analisis de ESPACE, lea las memorias adjuntadas.
