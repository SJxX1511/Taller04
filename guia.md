# ClinicaVeterinaria - Guía de Refactoring SOLID

Duración: 1.5 horas  
Participantes: 4 personas  
Objetivo general: practicar refactoring en Java aplicando principios SOLID sobre un proyecto funcional, pero deliberadamente mal diseñado.

### Tiempo recomendado:

| Fase | Tiempo |
| --- | --- |
| Setup y lectura | 10 min |
| Análisis por integrante | 10 min |
| Refactoring | 40 min |
| Prueba individual | 10 min |
| Integración final | 15 min |
| Discusión | 5 min |

## Setup inicial (10 minutos)

Requisitos previos:

- Java 11 o superior.
- Maven 3.8 o superior.
- Crear el repositorio en GitHub y todos los integrantes del equipo deben tener acceso.

Desde la raíz del proyecto:

```bash
cd ClinicaVeterinaria
mvn compile
```

También se puede compilar sin Maven:

```bash
javac -d bin src/main/java/**/*.java
```

Ejecutar el proyecto:
```bash
java -cp target/classes clinicaveterinaria.Main
```
O si se usó la otra forma de compilar:
```bash
java -cp bin clinicaveterinaria.Main
```

Verificación:

- Debe aparecer `=== ClinicaVeterinaria funcionando ===`.
- Deben imprimirse una mascota, una cita, una factura, reportes básicos e ingresos del mes.
- Si algo no compila, primero revisen paquetes, imports y nombres de clases.

## Integrante 1 - SRP

Principio: Single Responsibility Principle. Una clase debe tener una sola razón para cambiar.

Problema principal:

- `model/Veterinario.java` guarda datos del veterinario y además reserva citas, diagnostica, factura y genera reportes.
- `repository/BaseDatos.java` almacena datos, audita operaciones y calcula ingresos.
- `service/GestorReportesClinica.java` mezcla creación de datos con salida por consola.

Archivos a revisar:

- `src/main/java/clinicaveterinaria/model/Veterinario.java`
- `src/main/java/clinicaveterinaria/service/ReservaService.java`
- `src/main/java/clinicaveterinaria/service/DiagnosticoService.java`
- `src/main/java/clinicaveterinaria/service/FacturacionService.java`
- `src/main/java/clinicaveterinaria/service/ReporteService.java`
- `src/main/java/clinicaveterinaria/repository/BaseDatos.java`

Tarea:

Separar el comportamiento de `Veterinario` en:

- `ReservaService`
- `DiagnosticoService`
- `FacturacionService`
- `ReporteService`

Pasos sugeridos:

1. Identificar métodos de `Veterinario` que no son datos del modelo.
2. Mover la lógica a los servicios existentes.
3. Mantener `Veterinario` con atributos, constructor, getters, setters, `equals()` y `toString()`.
4. Actualizar `Main.java` para usar servicios en lugar de métodos del modelo.
5. Compilar y ejecutar.

Checklist de validación:

| Criterio | Sí/No |
| --- | --- |
| El proyecto compila | |
| `Veterinario` ya no reserva, diagnostica, factura ni reporta | |
| La funcionalidad del `Main` se mantiene | |
| Los nombres de servicios son claros | |

Preguntas de discusión:

- ¿Cuántas razones para cambiar tenía `Veterinario` antes del refactoring?
- ¿Qué ganamos al separar modelo y servicios?
- ¿Qué clase debería cambiar si mañana cambia el formato del reporte?

## Integrante 2 - OCP

Principio: Open/Closed Principle. El código debe estar abierto a extensión, pero cerrado a modificación.

Problema principal:

- `model/Tratamiento.java` usa condicionales por tipo.
- `service/TratamientoService.java` repite reglas por tipo.
- `service/CalculadoraCostoTratamiento.java` también debe cambiar cuando aparece un nuevo tratamiento.

Archivos a revisar:

- `src/main/java/clinicaveterinaria/model/Tratamiento.java`
- `src/main/java/clinicaveterinaria/service/TratamientoService.java`
- `src/main/java/clinicaveterinaria/service/CalculadoraCostoTratamiento.java`
- `src/main/java/clinicaveterinaria/interfaces/ITratamiento.java`

Tarea:

Crear implementaciones concretas de `ITratamiento` para:

- `VacunaTratamiento`
- `CirugiaTratamiento`
- `MedicamentoTratamiento`
- `FisioterapiaTratamiento`

Ejemplo esperado:

```java
public class VacunaTratamiento implements ITratamiento {
    private final double costo;

    public VacunaTratamiento(double costo) {
        this.costo = costo;
    }

    @Override
    public double calcularCostoFinal() {
        return costo + 5.0;
    }

    @Override
    public String obtenerIndicaciones() {
        return "Observar fiebre durante 24 horas.";
    }
}
```

Pasos sugeridos:

1. Crear una clase por tipo de tratamiento.
2. Mover las reglas de costo e indicaciones a esas clases.
3. Modificar `TratamientoService` para trabajar con `ITratamiento`.
4. Evitar nuevos `if` o `switch` por tipo.
5. Validar que se pueda agregar un nuevo tratamiento sin tocar las clases existentes.

Checklist de validación:

| Criterio | Sí/No |
| --- | --- |
| El proyecto compila | |
| No hay condicional gigante por tipo en la lógica nueva | |
| Cada tratamiento conoce su propio costo e indicaciones | |
| Agregar un nuevo tratamiento requiere crear una clase, no editar todas | |

Preguntas de discusión:

- ¿Por qué los condicionales repetidos hacen más caro el cambio?
- ¿Qué pasaría si agregamos `Odontologia` como tratamiento?
- ¿Cuándo una interfaz ayuda a extender el sistema?

## Integrante 3 - LSP

Principio: Liskov Substitution Principle. Una subclase debe poder reemplazar a su clase base sin romper el programa.

Problema principal:

- `Animal` promete `volar()`, `nadar()` y `caminar()`.
- `Perro`, `Gato`, `Pajaro` y `Pez` heredan métodos que no siempre pueden cumplir.
- Algunas subclases lanzan `UnsupportedOperationException`.

Archivos a revisar:

- `src/main/java/clinicaveterinaria/model/Animal.java`
- `src/main/java/clinicaveterinaria/model/Perro.java`
- `src/main/java/clinicaveterinaria/model/Gato.java`
- `src/main/java/clinicaveterinaria/model/Pajaro.java`
- `src/main/java/clinicaveterinaria/model/Pez.java`
- `src/main/java/clinicaveterinaria/interfaces/IAnimal.java`

Tarea:

Crear una jerarquía correcta con interfaces segmentadas:

- `Caminador`
- `Nadador`
- `Volador`

Pasos sugeridos:

1. Dejar `Animal` solo con datos comunes.
2. Crear interfaces pequeñas para capacidades reales.
3. Hacer que cada animal implemente solo lo que puede hacer.
4. Eliminar métodos que lanzan `UnsupportedOperationException`.
5. Actualizar `Main.java` para demostrar uso correcto.

Checklist de validación:

| Criterio | Sí/No |
| --- | --- |
| El proyecto compila | |
| Ningún animal implementa acciones imposibles | |
| No hay `UnsupportedOperationException` por capacidades naturales | |
| El código cliente usa la interfaz correcta según la acción | |

Preguntas de discusión:

- ¿Por qué lanzar `UnsupportedOperationException` puede ser señal de mal diseño?
- ¿Qué contrato estaba prometiendo `Animal`?
- ¿Cómo cambia el diseño cuando modelamos capacidades en lugar de herencia amplia?

## Integrante 4 - DIP/ISP

Principios:

- Interface Segregation Principle: los clientes no deben depender de métodos que no usan.
- Dependency Inversion Principle: las clases de alto nivel deben depender de abstracciones, no de implementaciones concretas.

Problema principal:

- `IServicioClinica` tiene más de 15 métodos.
- `RecepcionService` implementa métodos que no necesita y lanza excepciones.
- `Clinica` crea `new DirectoVeterinario()` y `new DirectoBaseDatos()`.
- `GestorReportesClinica` crea su propia `BaseDatos`.

Archivos a revisar:

- `src/main/java/clinicaveterinaria/interfaces/IServicioClinica.java`
- `src/main/java/clinicaveterinaria/interfaces/IVeterinarioService.java`
- `src/main/java/clinicaveterinaria/interfaces/IBaseDatos.java`
- `src/main/java/clinicaveterinaria/service/RecepcionService.java`
- `src/main/java/clinicaveterinaria/service/ServicioClinicaCompleto.java`
- `src/main/java/clinicaveterinaria/service/Clinica.java`
- `src/main/java/clinicaveterinaria/service/GestorReportesClinica.java`

Tarea:

Segregar interfaces e inyectar dependencias.

Pasos sugeridos:

1. Dividir `IServicioClinica` en interfaces pequeñas: `IMascotaService`, `ICitaService`, `IFacturaService`, `IReporteService`.
2. Hacer que `RecepcionService` dependa solo de las interfaces que usa.
3. Cambiar `Clinica` para recibir `IVeterinarioService` e `IBaseDatos` por constructor.
4. Cambiar `GestorReportesClinica` para recibir la dependencia desde afuera.
5. Probar en `Main.java` con implementaciones concretas.

Ejemplo de inyección:

```java
public class Clinica {
    private final IVeterinarioService veterinarioService;
    private final IBaseDatos baseDatos;

    public Clinica(IVeterinarioService veterinarioService, IBaseDatos baseDatos) {
        this.veterinarioService = veterinarioService;
        this.baseDatos = baseDatos;
    }
}
```

Checklist de validación:

| Criterio | Sí/No |
| --- | --- |
| El proyecto compila | |
| `RecepcionService` no implementa métodos innecesarios | |
| `Clinica` no usa `new` para dependencias principales | |
| Las dependencias se reciben por constructor | |

Preguntas de discusión:

- ¿Qué problema causa una interfaz gigante en equipos grandes?
- ¿Por qué `new DirectoBaseDatos()` dificulta cambiar o probar la clase?
- ¿Qué dependencia debería conocer el código de alto nivel: interfaz o clase concreta?

## Checklist de validación general

| Equipo | Compila | Ejecuta | Cumple SOLID | Evidencia breve |
| --- | --- | --- | --- | --- |
| SRP | | | | |
| OCP | | | | |
| LSP | | | | |
| ISP/DIP | | | | |

Comandos mínimos:

```bash
javac -d bin src/main/java/**/*.java
java -cp bin clinicaveterinaria.Main
```

## Integración final (últimos 15 minutos)

Objetivo: unir el trabajo de todo el equipo y confirmar que el sistema sigue funcionando.

Pasos:

1. Cada equipo explica en 2 minutos qué cambió y qué principio aplicó.
2. Compilar el proyecto completo.
3. Ejecutar `Main.java`.
4. Revisar que las operaciones principales sigan funcionando: crear mascota, crear veterinario, reservar cita, diagnosticar, facturar y generar reportes.
5. Resolver conflictos de nombres o paquetes si aparecen.
6. El facilitador pregunta qué clases quedaron más simples y por qué.

Demostración esperada:

- Crear una mascota y un veterinario.
- Reservar una cita.
- Registrar diagnóstico.
- Generar factura.
- Mostrar reporte de citas por veterinario.
- Mostrar reporte de mascotas por dueño.
- Mostrar ingresos mensuales.

## Extensiones opcionales

Si terminan antes:

- Agregar validaciones de entrada para datos vacíos o montos negativos.
- Implementar logging simple con `System.out.println()` centralizado en un servicio.
- Agregar más métodos CRUD.
- Crear unit tests básicos con JUnit.
- Agregar un nuevo tratamiento y verificar que no se modifiquen clases existentes.
- Crear un reporte por estado de cita.

## Notas para facilitador

Dificultad por equipo:

| Equipo | Dificultad | Motivo |
| --- | --- | --- |
| SRP | Fácil/Media | Los servicios ya existen como destino natural del refactoring. |
| OCP | Media | Requiere cambiar condicionales por polimorfismo. |
| LSP | Media | Requiere discutir contrato, herencia e interfaces por capacidad. |
| ISP/DIP | Difícil | Combina diseño de interfaces e inyección de dependencias. |

Puntos clave a revisar:

- SRP: que `Veterinario` quede como modelo y no como servicio.
- OCP: que no solo muevan el `if` a otra clase; debe desaparecer la decisión centralizada por tipo.
- LSP: que no queden métodos imposibles ni excepciones por comportamiento natural.
- ISP/DIP: que las clases dependan de interfaces pequeñas y reciban dependencias por constructor.

Errores comunes:

- Crear una clase nueva, pero dejar la lógica vieja duplicada.
- Reemplazar un `if` por otro `switch`.
- Mantener métodos vacíos o con excepciones en subclases.
- Crear interfaces pequeñas, pero seguir usando `new` dentro de clases de alto nivel.
- Romper el `Main` y no verificar ejecución integrada.


Ayudas rápidas:

- Si SRP se atasca: preguntar "¿esta clase representa datos o hace procesos?".
- Si OCP se atasca: pedir que agreguen mentalmente un tratamiento nuevo y observen cuántas clases tocarían.
- Si LSP se atasca: preguntar "¿puedo usar cualquier subclase sin preguntar qué animal es?".
- Si ISP/DIP se atasca: empezar por constructor injection antes de rediseñar todo.
