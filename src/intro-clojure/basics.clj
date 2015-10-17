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

  ;; error si no lo es
  (1 2 3)
  ;;
  (inc 1)
  (+ 1 1)
  (+ 1 2 3 4)
  (str "hello" " " "world")
  (class "hello")
  (class 3/4)

  ;; funciones anidadas
  (inc (inc 1))

  ;; los special forms i macros se evaluan de forma especial
  ;; durante la presentación veremos la majoria de special forms
  ;; de clojure

  ;; def
  ;; definir un symbolo hacer referencia a un valor
  ;; def es una forma especial no se evalua como las funciones.
  ;; more info (doc def)
  (def answer-to-everything 42)
  answer-to-everything

  ;; let
  ;; nos permite crear symbolos referenciando valores
  (let [x 1
        y 2]
    (+ x y))

  (def x 40)
  (let [x 1] (inc x))
  (inc x)

  ;; do
  ;; nos permite agrupar mas de un form
  ;; tiene sentido sobretodo quan usamos
  ;; forms con side effects
  ;; error
  ((+ 1 1) (+ 2 3))
  (do (+ 1 1) (+ 2 3))
  ;; side effects
  (do (println "hola")
      (println "adios"))

  ;; control de flujo
  ;; if special form
  (if true "t" "f")
  ;; nil es falso
  (if nil "t" "f")
  ;; todo lo demás es cierto
  (if "anything else" "t" "f")
  ;; incluso lista vacia!
  (if [] "t" "f")

  ;; otras macros para control de flujo sobre if
  ;; when
  ;; cond
  ;; etc

  ;; loop/recur Special forms
  ;; los "bucles" en clojure se hacen con recursividad o hof.
  ;; tiene que ser tail recursive
   (loop [x 10 fact 1]
    (if (zero? x) fact
        (recur (dec x) (* x fact)))
    )

  ;; fn
  ;; funciones
  ;; fn también es una forma especial.
  ;; more info (doc fn)
  (fn [x] (+ 1 x))
  ;; usar una función anonima
  ((fn [x] (+ 1 x)) 3)

  ;; nombrar una función
  ;; (aka crear un simbolo que referencia la función)
  (def my-inc (fn [x] (+ x 1)))
  my-inc
  (my-inc 1)

  ;; Tenemos una macro para crear funciones referenciadas
  ;; por simbolos.
  ;; (doc defn)
  (defn my-inc2 [x] (+ x 1))
  (macroexpand '(defn my-inc2 [x] (+ x 1)))

  ;; podemos llamar funciones
  ;; recursivamente non-tail
  (defn fact [x]
    (if (zero? x) 1
        (* x (fact (dec x)))))
  (fact 10)

  ;; llamar recur sin loop
  ;; para llamar a recursivamente a función en posición tail
  ;; llama a la función
  (defn fact[x acc]
    (if (zero? x) acc
        (recur (dec x) (* x acc)))
    )
  (fact 10 1)


  )
