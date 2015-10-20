(ns intro-clojure.basics)

(comment

  ;;; We'll attempt to learn a bit of clojure by write
  ;;; expressions and evaluate them.
  ;;; REPL (read eval print loop)
  ;;; Expression/Forms can be send to REPL for evalutation

  ;;; Reader Forms (forms read by reader before eval)

  ;;; Literals
  ;;; strings
  "hello world"
  ;; characters
  \h
  \newline
  ;;; numbers
  ;;; integers
  42
  123412341234123412341234N
  ;;; decimals
  42.42
  123412431234.12431243213M
  ;;; rational
  3/4
  ;;; booleans
  true
  false
  ;;; nothing, null
  nil
  ;;; keywords
  :keyword
  :color
  :key1

  ;; Symbols (identifiers)
  inc
  +
  hola

  ;; Lists
  ;; "," are not used do  separate elements -> white spaces instead.
  ()
  '(1 2 3)
  ;; Vectors
  []
  [1 2 3]
  [1 "hello" 1/4]
  ;; Maps
  {}
  {:key1 "value1" :key2 "value2"}
  ;; Sets
  #{}
  #{1 2 3 4}

  ;; they can be nested
  [1 2 [3 4] {:one 1}]

  ;;; Evaluation
  ;; every form evaluates to itself except list.
  ;; list are evaluated as (operator operand1 operand2 ... operandn)
  ;; An operator can be a #{function  special-form macro}
  ;; prefix format

  ;;error not a operator -> quote to stop evaluation
  ;;??? should we talk about quote (quote (1 2 3)) '(1 2 3)
  (1 2 3)

  (inc 1)
  (+ 1 1)
  (+ 1 2 3 4)
  (str "hello" " " "world")
  (class "hello")
  (class 3/4)

  ;; nested function evaluate
  (inc (inc 1))

  ;; using symbols
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

  ;; error si no lo es
  (1 2 3)
  ;;
  (inc 1)
  (+ 1 1)
  (+ 1 2 3 4)
  (str "hello" " " "world")

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
  (do (println "hello")
      (println "bye"))


  ;; flow control
  ;; if special form
  (if true "t" "f")
  ;; nil is false
  (if nil "t" "f")
  ;; false and nil are false, anything else true
  (if "everything else" "t" "f")
  ;; even the empty collection (list, vector, map...) is true!
  (if [] "t" "f")

  ;; other macros for flow control
  ;; when
  ;; cond
  ;; etc

  ;; loops in clojure
  ;; loop/recur Special forms
  ;; tail recusive
  (loop [x 10 fact 1]
    (if (zero? x) fact
        (recur (dec x) (* x fact))))

  ;; fn
  ;; functions
  ;; fn is a forma especial.
  ;; more info (doc fn)
  (fn [x] (+ 1 x))
  ;; we can use the function we just defined
  ((fn [x] (+ 1 x)) 3)

  ;; giving a name to a function
  ;; we use a symbol to refer to it.
  (def my-inc (fn [x] (+ x 1)))
  my-inc
  (my-inc 1)

  ;; There is a macro to create named functions
  ;; (doc defn)
  (defn my-inc2 [x] (+ x 1))
  (macroexpand '(defn my-inc2 [x] (+ x 1)))

  ;; once we name a function we could call it again.
  (defn fact [x]
    (if (zero? x) 1
        (* x (fact (dec x)))))
  (fact 10)
  ;; it's possible to name anomimous functions as well
  ;; normally to call themselves
  ((fn fact [x]
     (if (zero? x) 1
         (* x (fact (dec x))))) 10)

  ;; we can call recur without a loop
  ;; it will call the function we are in.
  (defn fact[x acc]
    (if (zero? x) acc
        (recur (dec x) (* x acc))))
  (fact 10 1)

  ;; using named fn instead of loop recur
  (defn fact [x]
    ((fn fact[x acc]
       (if (zero? x) acc
           (recur (dec x) (* x acc)))) x 1))
  (fact 10)

  ;; high order functions
  ;; functions that take other functions as arguments

  ;; fact
  (defn fact [x]
    (reduce * (range 1 x)))
  (fact 10)
  ;; curiosity why does it work for 0
  (fact 0)
  (*)
  (+)

  ;; count a's in a sentence
  ;; ??? should #(%) be introduced?
  (count (filter #(= \a %) "mama"))

  ;; squares
  (take 10 (map #(* % %) (range)))



  )
