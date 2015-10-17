(ns intro-clojure.basics)

(comment

  ; Form: código válido clojure

  ;; Literales - evaluan a su propio valor
  ;;; cadenas de caracteres (strings)
  "hello world"
  ;; caracteres
  \h
  \newline
  ;;; numeros
  ;;; enteros
  42
  123412341234123412341234N
  ;;; decimales
  42.42
  123412431234.12431243213M
  ;;; rationales
  3/4
  ;;; booleanos
  true
  false
  ;;; nothing, null
  nil
  ;;; palabras clave (keywords)
  :keyword
  :color
  :key1

  ;; símbolos (symbols) identificadores
  ;; normalmente se usan para referenciar algo
  inc
  +
  hola

  ;; Listas
  ;; "," no se utilizan para separar elementos,
  ;; usamos espacios para separar elementos
  ()
  ;; comentaremos quote ' más adelante
  '(1 2 "hola" 3/4)

  ;; Vectores
  []
  [1 2 3]

  ;; Mapas
  {}
  {:key1 "value1" :key2 "value2"}

  ;; Sets
  #{}
  #{1 2 3 4}

  ;; Pueden ser anidadas
  [1 2 [3 4] {:uno 1}]

  ; Evaluación
  ;; Todas las forms vistas hasta aquí evaluan a su propio valor
  ;; excepto las Listas.
  ;; Las listas se evalua como operaciones con el siguiente formato
  ;; (operador param-1 param-2 ... param-n)
  ;; Un operador puede ser #{function special-form macro}
  (inc 1)
  (+ 1 1)
  (+ 1 2 3 4)
  (str "hello" " " "world")
  (class "hello")
  (class 3/4)

  ;; funciones anidadas
  (inc (inc 1))

  ;;
  ;; def is a special form
  ;; more info (doc def)
  (def sym1 "value1")

  ;; functions
  ;; fn is a special form
  ;; more info (doc fn)
  (fn [x] (+ 1 x))
  ((fn [x] (+ 1 x)) 3)

  ;; name a function
  ;; use a symbol to refer to function
  (def my-inc (fn [x] (+ x 1)))
  my-inc
  (my-inc 1)

  ;; there is a macro to create a function and give it a name.
  ;; (doc defn)
  (defn my-inc2 [x] (+ x 1))
  (macroexpand '(defn my-inc2 [x] (+ x 1)))


  )
