(ns intro-clojure.basics)

(comment

  ; Reader Forms (form read by reader before eval)

  ;; Literals
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
  ;; Maps
  {}
  {:key1 "value1" :key2 "value2"}
  ;; Sets
  #{}
  #{1 2 3 4}

  ; Evaluation
  ;; every form evaluates to itself except list.
  ;; list are evaluated as (operator operand1 operand2 ... operandn)
  ;; An operator can be a #{function  special-form macro}
  ;; prefix format
  (inc 1)
  (+ 1 1)
  (+ 1 2 3 4)
  (str "hello" " " "world")

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


  )
