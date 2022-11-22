#**INTRODUCCIÓN**
Proyecto en el cual se utilizan los patrones de automatización Screenplay, combinado con Cucumber y Serenity.


Detalles generales de la implementación:

+ Herramienta de automatización: Intellij IDEA Community Edition Versión: 2022
+ Compilador:  JAVA
+ Patrón de diseño:  Screenplay


Prerequisitos:

+ Tener permisos de acceso al aplicativo que se desea probar y motores de Base de Datos Complementarios.
+ Tener instalado y verificar su funcionamiento:
+ Intellij IDEA Community Edition Versión: 2021.2 Build: 212.4746.92 o superior.
+ Gradle y variables de entorno configurada
+ Java  y variables de entorno configurada 
+ Tener GIT en su ultima versión.



La estructura completa del proyecto es:

+ exceptions: clases que permiten darreportes especifico cuando falla la prueba.
+ integrations: clases que permiten integraciones a otros subsistemas. 
+ interacions: clases que representan las interacciones directas con la interfaz de usuario.
+ models: clases que usan el patrón object builder o relacionadas con el modelo de dominio.
+ questions: objectos usados para consultar acerca del estado de la aplicación.
+ tasks: clases que representan tareas que realiza el actor a nivel de proceso de negocio.
+ userinterfaces: Page Objects y Page Elements. Mapean los objetos de la interfaz de usuario.
+ utils: utilidades que se puedan reusar.


#**PROYECTO AUTOMATIZADO**

**Lenguaje de programación:** Java.  
**Frameworks:** Selenium, JUnit y Serenity BDD.  
**Patrón de diseño:** Screenplay.  
**Feature:** Hecho en lenguaje Gherkin.  
**IDE:** Eclipse o Intellij.  
**Driver:** ChromeDriver.exe, GheckoDriver.exe 
**Manejo de dependencias con Gradle.**


Para ejecutar la automatización se abre la consola en la raíz del proyecto, y se pone el comando:

###gradle clean test

**Para correr el proyecto se necesita Java JDK 1.8 y Gradle preferiblemente con la versión 4.9.**


## Autor ##
Yefri Ruiz Mosquera