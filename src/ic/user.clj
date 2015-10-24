(ns ic.user)

(def current-slide (atom 1))
(def slides (atom {}))

(defn add-slide
  ([key text]
   (swap! slides assoc key text))
  ([text]
   (add-slide (inc (apply max (keys @slides))) text )))

(def sep-slide "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

(defn slide
  ([] (slide @current-slide))
  ([key] (println sep-slide)
   (println (@slides key))
   (println sep-slide)
   (str "[slide:" key "]")))

(defn next-slide []
  (swap! current-slide inc)
  (slide))

(def sl slide)
(def nsl next-slide)

(add-slide 1 "Clojure is a LISP dialect.
-> prefix notation
-> (function param-1 param-2 ... param-n)
example inc (3) becomes (inc 3)")

(comment
  ;; inc (3)
  (inc 3)
  ;; inc (inc (3))
  (inc (inc (3))))

(add-slide "If first element is not an operator
-> error")

(comment
  ("text" 1 3))

(add-slide "With prefix notation
Functions can accept different number of arguments.
Arity is strict. Wrong arity -> Exception")

(comment
  (+ 1 3 4)
  (+ 1 3)
  (+)
  +
  (source +)
  ;; error ArityException
  (inc 2 4))

(add-slide "Nested prefix notation ->
no need for op preference
2 * 3 + 4 or 4 + 2 * 3 -> (+ 4 (* 2 3))")

(comment
  (+ 4 (* 2 3)))

(add-slide "Evaluation of expressions
Recursive -> First evaluate sub-expressions
(+ (* 2 3) (- 5 1))
-> (+ 6 (- 5 1))
-> (+ 6 4)
-> 10")

(comment
  (+ (* 2 3) (- 5 1)))

(add-slide "Basic/Simple types.
- numbers 2 2N 1.2 1.2M 3/4
- \"strings\", \\c \\h \\a \\r \\s
- boolean true false
- nil
- :keyword
- symbols (vars)")

(comment
  ;; Reader Forms (forms read by reader before eval)
  ;; Literals
  ;; strings
  "hello world"
  ;; characters
  \h
  \newline
  ;; numbers
  ;; integers
  42
  123412341234123412341234N
  ;; decimals
  42.42
  123412431234.12431243213M
  ;; rational
  3/4
  ;; booleans
  true
  false
  ;; nothing, null
  nil
  ;; keywords
  :keyword
  :color
  :key1
  ;; Symbols (identifiers)
  inc
  +
  hola)

(add-slide "Collection/Containers of types
Clojure literals for all of them
- List (1 \"three\" \a)
- Vector []
- Map {:key 123}
- Set #{\\a 2 2/3}")

(comment
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
  [1 2 [3 4] {:one 1}])

(add-slide "Naming Things
with def")

(comment
  "I lied a bit went I explained that (function...) special form"
  (def answer-to-everything 42)
  "def is a special for that associates a name to a value")

(add-slide "Doing more than one expression
with do.
main use -> side effects
returns last value of expression")

(comment
  ((println "hello") (println "bye"))
  (do (println "hello") (println "bye")))

(add-slide "Let it be... local names")

(comment
  (def x 10)
  (let [x 2] (* x x))
  (inc x))

(add-slide "From let to function fn")

(comment
  (fn [x] (* x x))
  #(* %1 %1))

(add-slide  "Naming a function")

(comment
  (def square (fn [x] (* x x)))
  (defn square [x] (* x x)))

(add-slide "Tell me the 'true':
- false nil
- true everything else")

(add-slide "Flow control")

(comment
  (if true true false)
  (if nil true false)
  (if (or "" () {} :key) true false)
  )
