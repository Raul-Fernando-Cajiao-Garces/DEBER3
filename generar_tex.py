import os
import glob

ejercicios_desc = {
    1: """Reto 1 - Caso de estudio: Gestión de turnos en una clínica usando colas\n\nDesarrolle un programa en Java que permita registrar pacientes en una cola de atención médica. Cada paciente tendrá nombre, cédula y tipo de consulta. El sistema debe permitir:\n1. Registrar pacientes\n2. Atender al siguiente paciente\n3. Mostrar todos los pacientes en espera\n4. Buscar un paciente por cédula\n5. Ordenar los pacientes en espera alfabéticamente por nombre""",
    2: """Reto 2 - Caso de estudio: Historial de navegación usando pilas\n\nCree un programa que simule el historial de navegación de un navegador web. El estudiante debe implementar una pila donde se almacenen las páginas visitadas. El sistema debe permitir:\n1. Visitar una nueva página\n2. Volver a la página anterior\n3. Mostrar el historial actual\n4. Buscar si una página fue visitada\n5. Ordenar alfabéticamente las páginas visitadas para mostrarlas como reporte""",
    3: """Reto 3 - Caso de estudio: Registro de productos usando listas\n\nDiseñe un programa para registrar productos de una tienda. Cada producto debe tener código, nombre, precio y stock. El sistema debe permitir:\n1. Agregar productos\n2. Listar todos los productos\n3. Buscar un producto por código\n4. Ordenar productos por precio de menor a mayor\n5. Mostrar los productos con stock menor a 5 unidades""",
    4: """Reto 4 - Caso de estudio: Control de tareas académicas\n\nDesarrolle un programa para gestionar tareas académicas de estudiantes. Cada tarea tendrá código, descripción, prioridad y estado. El sistema debe permitir:\n1. Registrar tareas en una lista\n2. Buscar una tarea por código\n3. Ordenar las tareas por prioridad\n4. Marcar una tarea como completada\n5. Guardar las tareas completadas en una pila\n6. Mostrar la última tarea completada"""
}

def generar_tex():
    base_dir = "/home/uisrael/Escritorio/Fundamentos De La Especialidad I - NAC /DEBER3"
    tex_path = os.path.join(base_dir, "informe.tex")
    
    with open(tex_path, "w", encoding="utf-8") as f:
        # Preamble
        f.write(r"""\documentclass[12pt,a4paper]{article}
\usepackage[utf8]{inputenc}
\usepackage[spanish]{babel}
\usepackage{graphicx}
\usepackage{geometry}
\usepackage{xcolor}
\usepackage{titlesec}
\usepackage{float}
\usepackage{hyperref}
\usepackage{times}
\usepackage{caption}

\geometry{left=2.54cm,right=2.54cm,top=2.54cm,bottom=2.54cm}
\hypersetup{colorlinks=true, linkcolor=blue, urlcolor=blue}

\begin{document}

% Encabezado institucional
\begin{center}
    \begin{tabular}{c c c}
        \framebox[3cm][c]{\textbf{Logo UISRAEL}} & 
        \begin{tabular}{c}
            \textbf{UNIVERSIDAD ISRAEL} \\
            Av. Francisco de Orellana y Colina \\
            Quito - Ecuador \\
            Telf: (02) 252-5766
        \end{tabular} & 
        \framebox[3cm][c]{\textbf{Logo EMPRENDE}} \\
    \end{tabular}
    \vspace{0.5cm}
    \hrule
    \vspace{0.5cm}
    {\large \textbf{Facultad:}} Ciencias de la Ingeniería \\
    {\large \textbf{Asignatura:}} Fundamentos de Especialidad 1 - NAC \\
    {\large \textbf{Docente:}} Ms. Carlos Salazar \\
    \vspace{0.5cm}
    {\Large \textbf{Laboratorio Semana 3: Estructuras de datos dinámicas lineales}} \\
    \vspace{0.5cm}
    {\large \textbf{Autor:}} Raul Fernando Cajiao Garces \\
    \vspace{1cm}
\end{center}

\section*{Introducción}
Este laboratorio tiene como finalidad fortalecer las competencias prácticas de programación en Java mediante la resolución de ejercicios contextualizados en escenarios reales, permitiendo al estudiante comprender no solo la sintaxis del lenguaje, sino también la lógica y el comportamiento de las estructuras de datos en aplicaciones cotidianas. A través de estos ejercicios se desarrollarán habilidades relacionadas con el análisis de problemas, manipulación de colecciones dinámicas, modelado de objetos, implementación de algoritmos y aplicación de buenas prácticas de programación.

Durante el desarrollo del taller, el estudiante trabajará con estructuras como ArrayList, Stack y Queue, además de aplicar algoritmos de búsqueda secuencial y métodos de ordenamiento para gestionar información de manera eficiente.

\section*{Evidencias del Trabajo Realizado}
""")

        # Sections for each exercise
        for i in range(1, 5):
            f.write(f"\\subsection*{{Reto {i}}}\n")
            f.write(f"{ejercicios_desc[i].replace('&', '\\&').replace('_', '\\_')}\n\n")
            
            # Code Captures
            f.write("\\subsubsection*{Capturas de Pantalla del Código}\n")
            code_imgs = glob.glob(os.path.join(base_dir, f"ejercicio{i}/CAPTURAS_CODIGO/*.png"))
            for img in sorted(code_imgs):
                rel_img = os.path.relpath(img, base_dir)
                name = os.path.basename(img).replace('_', '\\_')
                f.write(r"\begin{figure}[H]" + "\n")
                f.write(r"    \centering" + "\n")
                f.write(f"    \\includegraphics[width=0.8\\textwidth]{{{rel_img}}}\n")
                f.write(f"    \\caption{{Código Fuente: {name}}}\n")
                f.write(r"\end{figure}" + "\n\n")

            # Result Captures
            f.write("\\subsubsection*{Evidencias de Ejecución}\n")
            res_imgs = glob.glob(os.path.join(base_dir, f"ejercicio{i}/CAPTURAS_RESULTADO_CODIGO/*.png"))
            for img in res_imgs:
                rel_img = os.path.relpath(img, base_dir)
                f.write(r"\begin{figure}[H]" + "\n")
                f.write(r"    \centering" + "\n")
                f.write(f"    \\includegraphics[width=0.8\\textwidth]{{{rel_img}}}\n")
                f.write(f"    \\caption{{Resultado de Ejecución - Reto {i}}}\n")
                f.write(r"\end{figure}" + "\n\n")

        # Links
        f.write(r"""\section*{Enlaces de Entrega}
\begin{itemize}
    \item \textbf{Repositorio GitHub:} \url{https://github.com/Raul-Fernando-Cajiao-Garces/DEBER3}
    \item \textbf{Video Explicativo:} \url{https://drive.google.com/drive/folders/1-sCL-fiyJHtzv8PmKGGQZojoxlkY9-lI?usp=sharing}
\end{itemize}

\end{document}
""")

    print("informe.tex generado exitosamente.")

if __name__ == "__main__":
    generar_tex()
