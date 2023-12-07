# Usuarios CRUD JAVA☕
---
## Aplicacion de consola tipo CRUD usando JAVA
---
La aplicacion se divide en tres paquetes de archivos 
- datos (contiene los datos para el funcionamiento de la aplicacion)
- - Conexion.java (contiene los datos mysql y metodos para crear y cerrar la conexion con la base de datos)
- - UsuarioDao (Contiene las diferentes consultas y metodos para Seleccionar,Crear Actualizar y Eliminar )
- domain
- - Usuario (Clase encargada de crear nuevos usuarios, usa la sobrecarga de constructores, ya que cada metodo de UsuarioDao recibe distintos numeros de parametros )
- test
- - TestUsuarios (Clase encargada de realizar el test de los diferentes metodos de UsuarioDao)

# Base de datos javacrud 📔
## Tabla: usuarios
- ID (PK AUTO INCREMENT)
- usuario (campo tipo varchar)
- password (campo tipo varchar)


| ID  | usuario | password |
| --------- | --------- | --------- |
|    |    |     |
