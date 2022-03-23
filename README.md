# super-hero
Repositorio servicio super hero

#La coleccion de todos los servicios para postman se encuentra en el siguiente directorio
/collections/SuperHeroes.postman_collection

#Flujo completo para el servicio


#TODOS LOS SERVICIOS REQUIEREN AUTENTICACION A TRAVES DE TOKEN JWT, EXCEPTO LOGIN Y ALTA DE USUARIO.
1- Dar de alta nuevo usuario a traves del servicio [POST] http://localhost:8080/api/users 
2- Realizar login a traves del servicio  [POST] http://localhost:8080/login y copiar del header response el token que se encuentra en Authorization 
3- Dar de alta 2 super heroes a traves de [POST] http://localhost:8080/api/super-heroes/ utilizando el token Bearer anteriormente devuelto por el servicio de login
4- Realizar consulta de todos los super heroes a traves del servicio [GET] http://localhost:8080/api/super-heroes/
5- Realizar actualizacion de uno de los super heroes a traves del servicio [PUT] http://localhost:8080/api/super-heroes/
7- Realizamos consulta por nombre busqueda inName [GET] http://localhost:8080/api/super-heroes/byNameCont/man nos devolvera todos los que contengan por ejemplo en este caso "man" en su nombre.
8- Realizamos consulta por id [GET] http://localhost:8080/api/super-heroes/1
9- Damos de baja el mismo a traves del servicio [DELETE] http://localhost:8080/api/super-heroes/1


#Para realizar el test unitario del servicio de super heroes solo se necesita ejecutar la clase SuperHeroeRepositoryTest y hara las pruebas correspondientes.
