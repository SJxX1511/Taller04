# ClinicaVeterinaria

Proyecto Java Maven para practicar refactoring con principios SOLID en un taller colaborativo.

El sistema funciona desde el inicio, pero contiene violaciones intencionales de SRP, OCP, LSP, ISP y DIP. La idea es que cada integrante refactorice una zona del código sin romper la ejecución.

## Setup en 5 minutos


Compilar con Maven. Salida esperada:

```text
=== ClinicaVeterinaria funcionando ===
```

## Estructura del proyecto

```text
src/main/java/clinicaveterinaria/
├── Main.java
├── interfaces/
│   ├── IAnimal.java
│   ├── IBaseDatos.java
│   ├── IServicioClinica.java
│   ├── ITratamiento.java
│   └── IVeterinarioService.java
├── model/
│   ├── Mascota.java
│   ├── Veterinario.java
│   ├── Cita.java
│   ├── Tratamiento.java
│   ├── Factura.java
│   └── clases auxiliares para animales y enums
├── repository/
│   ├── BaseDatos.java
│   └── DirectoBaseDatos.java
└── service/
    ├── ReservaService.java
    ├── DiagnosticoService.java
    ├── FacturacionService.java
    ├── ReporteService.java
    └── servicios CRUD y clases con violaciones intencionales
```

## Trabajo del taller

- Integrante 1: refactorizar SRP.
- Integrante 2: refactorizar OCP.
Checklist de validación:
| Criterio | Sí/No |
| --- | --- |
| El proyecto compila |si|
| No hay condicional gigante por tipo en la lógica nueva |si|
| Cada tratamiento conoce su propio costo e indicaciones |si|
| Agregar un nuevo tratamiento requiere crear una clase, no editar todas |si|

Preguntas de discusión:

- ¿Por qué los condicionales repetidos hacen más caro el cambio?
por el tiempo y algun tipo de riesgo a errores
- ¿Qué pasaría si agregamos `Odontologia` como tratamiento?
Nada estariamos extendiendo osea podriamos agregar sin problemas TratamientoOdontologia
- ¿Cuándo una interfaz ayuda a extender el sistema?
que cuando agregues algo debe conectarse de manera que el sistema sepa que tarea le toque hacer


- Integrante 3: refactorizar LSP.
- ¿Por qué lanzar `UnsupportedOperationException` puede ser señal de mal diseño?
 Ya que la clase hija no cumple contodo lo que se prometio es decir caminar,volar o nadar y si lanza una excepción donde el padre no lo haría, no se podria hacer la sustitucion entre padre e hijo
- ¿Qué contrato estaba prometiendo `Animal`?
animal a parte de los getters y setters, se promete que cada animal puede caminar, volar y nadar y no todos los animales pueden hacerlo.
- ¿Cómo cambia el diseño cuando modelamos capacidades en lugar de herencia amplia?
la persona puede elegir la interfaz que desea utilizar y no el tipo de animal, asi no se edita ninguna clase.
- Integrante 4: refactorizar ISP y DIP.

Lee `guia.md` para instrucciones, checklists y preguntas de discusión.
