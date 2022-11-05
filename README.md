Hecho por YORKS KEVIN GOMEZ LOPEZ

**CONFIGURACIÓN**

Se agregan los parámetros a los Mappers
![image](https://user-images.githubusercontent.com/23731047/200142304-99856bf2-534c-4352-916d-913d61bbda36.png)

Se agrega el mapeo de Consulta y los prefijos de las columnas en las consultas

![image](https://user-images.githubusercontent.com/23731047/200142336-b661ed56-4aca-41ac-b788-f4bd25d64fc8.png)

**HISTORIAS DE USUARIO**

Implementamos las consultas necesarias en el mapper
![image](https://user-images.githubusercontent.com/23731047/200142488-31b6462c-622d-466c-a370-ce16de7e663b.png)

Igualmente en el Mapper java
![image](https://user-images.githubusercontent.com/23731047/200142494-0caa1354-ecfe-4e50-83c1-4a7ba44c40fa.png)

Implementamos los servicios relevantes en la implementación del DAO de MyBatis
![image](https://user-images.githubusercontent.com/23731047/200142522-4c2faae6-2e6d-4663-9ee5-c2a3916faf4a.png)

![image](https://user-images.githubusercontent.com/23731047/200142531-fd82879b-a0cb-400b-9a1f-4e7fa3c42bac.png)

También enlazamos los servicios pertinentes a MyBatis desde la clase de implementación de servicios
![image](https://user-images.githubusercontent.com/23731047/200142538-7d783e4b-64d8-4884-bbf1-91683e537a99.png)


**TESTS**

Se verifica que la prueba inicial esté corriendo bien, y se modifica para que no devuelva error automáticamente
![image](https://user-images.githubusercontent.com/23731047/200142368-3edf696c-d39b-47c0-aa35-50aee0c74e5d.png)

Se adiciona la nueva prueba, aquí vamos a testear la capacidad del sistema de buscar un paciente por id y tipo de documento
![image](https://user-images.githubusercontent.com/23731047/200142388-a7a395bc-1977-4d6c-b58f-16e0dd9ced5c.png)

Ejecutamos las pruebas y verificamos que estén funcionando correctamente
![image](https://user-images.githubusercontent.com/23731047/200142430-8946a9c6-b81b-47ec-9a99-1a0c9982f716.png)

**FRONT**

Ejecutamos las configuraciones necesarias dentro del Bean para la funcionalidad del sistema
![image](https://user-images.githubusercontent.com/23731047/200142663-a8dddf66-9983-4e60-a1d5-b5c79945cc4e.png)

Implementamos los métodos necesarios para la solicitud de datos
![image](https://user-images.githubusercontent.com/23731047/200142678-c8e0d973-70d2-4a0f-b71f-bb611a5ddfd6.png)

También el método que llamaremos para consultar
![image](https://user-images.githubusercontent.com/23731047/200142727-78836afe-6351-4563-80a2-a236ffd71921.png)

Dentro de la vista consultarPaciente adicionamos los enlaces de la vista con las variables del Bean y las acción de consultar
![image](https://user-images.githubusercontent.com/23731047/200142700-2a5d9a08-b2b3-49ad-a2be-17408795de8d.png)

Dentro de la vista mostrarMenoresConEnfermedadesContagiosas sólo es necesario enlazar la lista de getSicks para mostrar el informe
![image](https://user-images.githubusercontent.com/23731047/200142767-441555e6-ed3a-4baf-91c0-33fd772675a5.png)


