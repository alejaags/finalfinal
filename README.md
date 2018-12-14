

[![Heroku](https://wmpics.pics/di-NNAT.png)](https://github.com/alejaags/finalfinal)


En la arquitectura se muestra la existencia de dos niveles aplicacion y presentacion, en presentacion encontramos 3 capas, html, javascript y css, las cuales permiten la interacción con el controlador que es la primera capa de aplicacion, este se comunica con los servicios que tiene la aplicacion y que conforman la segunda capa permite conectarse con una capa de conexion a servidores externos en nuestro caso [omdbapi.com] para  generar resultados que son vistos en el servicio web y así extraer la información de las peliculas que son consultadas a traves de nuestro servicio web.


En la parte del controlador utilizamos un GetMapping para publicar la informacion convertida, y por lo mismo hacemosuso del srvicio dataService que creamos, la aplicacion solo muestra los valores del JSON en forma de cadena mostrando todos los datos importantes de la pelicula.
