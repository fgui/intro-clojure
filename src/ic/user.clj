(ns ic.user)

(def current-slide (atom 1))
(def slides (atom {}))

(defn add-slide
  ([key text]
   (swap! slides assoc key text))
  ([text]
   (add-slide (inc (apply max (keys @slides))) text )))

(def sep-slide "----------------------------------------")

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

(comment 1
         ;; inc (3)
         (inc 3)
         ;; inc (inc (3))
         (inc (inc (3)))
         )

(add-slide "If first element is not an operator
-> error")

(comment
         ("text" 1 3)
         )

(add-slide "With prefix notation
Functions can accept different number of arguments.
Arity is strict. Wrong arity -> Exception")

(comment
         (+ 1 3 4);
         (+ 1 3)
         (+)
         +
         (source +)
         ;; error ArityException
         (inc 2 4)
         )

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
         (+ (* 2 3) (- 5 1))
         )

(add-slide "Naming Things
with def")

(comment
         "I lied a bit went I explained that (function...) special form"
         (def answer-to-everything 42)
         "def is a special for that associates a name to a value"
         )

(add-slide "doing more than one expression
with do.
main use -> side effects
returns last value of expression")

(comment
         ((println "hello") (println "bye"))
         (do (println "hello") (println "bye"))

         )

(add-slide "let it be... local names")

(comment
        (def x 10)
        (let [x 2] (* x x))
        (inc x)
        )

(add-slide "from let to function fn")

(comment
         (fn [x] (* x x))
         #(* %1 %1)
         )

(add-slide  "naming a function")

(comment
         (def square (fn [x] (* x x)))
         (defn square [x] (* x x)))
