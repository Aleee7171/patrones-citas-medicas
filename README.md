# Proyecto: Sistema de Citas Médicas

## Descripción
Este proyecto implementa una gestión simple de citas médicas desde consola utilizando Java y aplicando tres patrones de diseño:

- **Singleton**
- **DAO (Data Access Object)**
- **Strategy**

El sistema permite registrar citas y mostrarlas ordenadas por fecha o por nombre del paciente.

---

## Patrones de Diseño Utilizados

### 🔹 Singleton
Asegura que exista solo una instancia del gestor de citas (`GestorCitas`).  
Evita duplicación de datos y centraliza el control del sistema.

### 🔹 DAO (Data Access Object)
`CitaDAO` maneja el almacenamiento de citas en memoria.  
Separa la lógica de acceso a datos del resto del programa.

### 🔹 Strategy
Permite cambiar el criterio de ordenamiento de las citas sin modificar la lógica base.  
Estrategias implementadas:
- `OrdenPorFecha`
- `OrdenPorPaciente`

---

## Casos de Uso

### ✔ Registrar Cita
El usuario ingresa el nombre del paciente y la fecha.  
El sistema crea una cita y la almacena en memoria mediante el DAO.

### ✔ Ver Citas Ordenadas por Fecha
El sistema cambia la estrategia de ordenamiento a `OrdenPorFecha` y muestra las citas ordenadas.

### ✔ Ver Citas Ordenadas por Paciente
El sistema utiliza la estrategia `OrdenPorPaciente` para mostrar las citas según el nombre del paciente.

### ✔ Salir del Sistema
Finaliza la ejecución del sistema desde consola.

---

## Cómo Ejecutar el Programa

### 1️⃣ Compilar todos los archivos `.java`
```bash
javac *.java
