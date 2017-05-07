Diseño e implementación de un programa que “lee” y prueba un autómata finito determinista.


Debe tomar como entrada un conjunto de datos desde la entrada estándar y producir salidas a la salida estándar

Para pruebas: Pueden tomar datos de archivos de texto planos

En la primera línea: un entero positivo Z indicando la cardinalidad del alfabeto usado y un entero N indicando la 
cantidad de estados del autómata. En la siguiente línea irán exáctamente Z símbolos separados por espacios que serán 
los símbolos del alfabeto.

Desde la tercera línea en adelante, irá una matriz rectangular de tamaño NxZ cuyas columnas irán separadas por espacios 
y las filas por saltos de línea, esta matriz será la matriz de transición del autómata. Ejemplo, si el número 4 está en 
la posición de la matriz dada por M[0][2] (todos los índices se asume que empiezan en 0), quiere decir que el autómata 
cuando está en el estado 0 y procesa el tercer símbolo (tercero porque es el índice de columna 2 y empiezan en 0) deberá ir al estado 4.

Después de la matriz M irá un entero F indicando la cantidad de estados finales. En la siguiente línea de la entrada irán 
F enteros diferentes extraídos entre 0 y N-1 los cuales serán los estados finales.

Después en una línea irá un entero Q, que indica la cantidad de consultas a hacer, y después irán Q líneas, cada una con una 
cadena a procesar por el autómata.

Se asume que el estado inicial siempre será el estado 0.


El programa debe tener dos modos de funcionamiento:

●	Sencillo: (argumento “1” al programa)
○	La salida es una secuencia de Q líneas cada una con un SI o un NO dependiendo de si acepta las cadenas de las consultas
●	Paso a paso ( argumento diferente de ”1” )
○	Debe mostrar paso a paso la evolución de los estados en la cadena procesada. Ejemplo, para procesar la cadena “0110” debería imprimir líneas como:
■	Del estado 0 procesando el símbolo 0 pasó al estado 4.
■	Del estado 4 procesando el símbolo 1 pasó al estado 2.
■	Del estado 2 procesando el símbolo 1 pasó al estado 3.
■	Del estado 3 procesando el símbolo 0 pasó al estado 4.
■	La palabra NO fue aceptada, el estado 4 no es estado de aceptación.

Ejemplo de entrada para el siguiente autómata:

 
Se asume que el estado 0 es S1 y que el estado 1 es S2

2 2
0 1
1 0
0 1
1
0
5
00
0010
1001
10001
111111111111111111111111110111111111111111111

La salida para el “modo” simple sería:

SI
NO
SI
NO
NO

Formato de entrada explicado:

2 2 (Z Y N)
0 1 (Los símbolos del alfabeto en una sola línea)
1 0 (Primera fila de la matriz M, índice 0)
0 1 (Segunda fila de la matriz M, índice 1)
1 (Número natural mayor que 0: F: Cantidad de estados finales)
0 (Estados finales separados por espacios; los estados están en [0,N-1]
5 (Número natural Q: cantidad de consultas que se van a hacer)
00 (Primera consulta)
0010 (Segunda consulta) 
1001
10001
111111111111111111111111110111111111111111111 (última consulta)


2 2
A B
1 0
0 1
1
0
6
A
B
AB
BA
AA
BB
