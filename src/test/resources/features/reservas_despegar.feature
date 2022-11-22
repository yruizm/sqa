#language: es
#Autor: Yefri Ruiz Mosquera

@Regresion
Característica:  Proceso de Reserva y Compra de Vuelos, Paquetes y Alojamiento

  @dataFile:src/test/resources/InformaciónReserva/ReservaAlojamiento.csv
  @ReservaAlojamiento
  Esquema del escenario: Compra de Alojamiento
    Dado el ingreso al sitio web "<url>"
    Cuando filtro los datos del Alojamiento
    |<destinoHotel>|<fechaIda>|<fechaRegreso>|
    Y seleccione alojamiento dentro del rango <presupuesto>
    Y diligencio los datos personales alojamiento
      |<nombres>|<apellidos>|<email>|<telefono>|
    Entonces diligencio la informacion del pago
      |<numeroTC>|<titularTC>|<vencimientoTC>|<codigoTC>|<documentoTitularTC>|

    Ejemplos:
      |url|destinoHotel|fechaIda|fechaRegreso|presupuesto|nombres|apellidos|email|telefono|numeroTC|titularTC|vencimientoTC|codigoTC|documentoTitularTC|
      |https://www.despesgar.com.co|Medellin|2022-11-25|2022-12-9|50000|Yefri|Ruiz Mosquera|ingenieroyefri.r.m@gmail.com|3147653726|4599186591517657|Tadeo Elias Ruiz Gonzalez|0430|430|1077442975|

         @ReservaVuelos
  Esquema del escenario: Compra de Tiquetes Aereos
    Dado el ingreso al sitio web "<url>"
    Cuando filtro los datos del vuelo
      |<idaVuelta>|<origen>|<destino>|<fechaIda>|<fechaRegreso>|
    Y seleccione Tiquetes dentro del rango <presupuesto>
    Y diligencio los datos personales
      |<nombres>|<apellidos>|<paisResidencia>|<tipoDocumento>|<numeroDocumento>|<email>|<telefono>|
    Entonces diligencio la informacion del pago
      |<numeroTC>|<titularTC>|<vencimientoTC>|<codigoTC>|<documentoTitularTC>|
    Ejemplos:
      |url|idaVuelta|origen|destino|fechaIda|fechaRegreso|presupuesto|nombres|apellidos|paisResidencia|tipoDocumento|numeroDocumento|email|telefono|numeroTC|titularTC|vencimientoTC|codigoTC|documentoTitularTC|
      |https://www.despegar.com.co|SI|Bogota|Medellin|2022-11-29|2022-12-19|50000|Yefri|Ruiz Mosquera|Colombia|CC|1077461366|ingenieroyefri.r.m@gmail.com|3147653726|4599186591517657|Tadeo Elias Ruiz Gonzalez|0430|430|1077442975|

  @ReservaPaquete
  Esquema del escenario: Compra de Paquete Turistico
    Dado el ingreso al sitio web "<url>"
    Cuando filtro los datos del paquete
      |<origen>|<destino>|<fechaIda>|<fechaRegreso>|
    Y selecciono paquete dentro del rango con hotel
    |<presupuesto>|<hotel>|
    Y diligencio los datos personales paquete
      |<nombresPUno>|<apellidosPUno>|<numeroDocumentoPUno>|<fechaNacimientoPUno>|<GeneroPUno>|<nombresPDos>|<apellidosPDos>|<numeroDocumentoPDos>|<fechaNacimientoPDos>|<GeneroPDos>|<email>|<telefono>|
    Entonces diligencio la informacion del pago
      |<numeroTC>|<titularTC>|<vencimientoTC>|<codigoTC>|<documentoTitularTC>|
    Ejemplos:
      |url|origen|destino|fechaIda|fechaRegreso|presupuesto|hotel|nombresPUno|apellidosPUno|numeroDocumentoPUno|fechaNacimientoPUno|GeneroPUno|nombresPDos|apellidosPDos|numeroDocumentoPDos|fechaNacimientoPDos|GeneroPDos|email|telefono|numeroTC|titularTC|vencimientoTC|codigoTC|documentoTitularTC|
      |https://www.despegar.com.co|Bogota|Medellin|2022-11-25|2022-12-15|80000000|Hotel San Fernando Plaza|Yefri|Ruiz Mosquera|1077461366|2-12-1993|M|Liseth|Ruiz Mosquera|1077461843|2-12-1995|F|ingenieroyefri.r.m@gmail.com|3147653726|4599186591517657|Tadeo Elias Ruiz Gonzalez|0430|430|1077442975|


