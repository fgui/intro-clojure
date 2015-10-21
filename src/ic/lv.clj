(ns ic.lv)

(def current-slide (atom 1))
(def slides (atom {}))

(defn add-slide [key text]
  (swap! slides assoc key text))

(def sep-slide "----------------------------------------")

(defn slide
  ([] (slide @current-slide))
  ([key] (println sep-slide)
   (println (@slides key))
   (println sep-slide)
   (str "[slide:" key "]")) )

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

(add-slide 2 "If first element is not an operator
-> error")

(comment 2
         ("text" 1 3)
         )

(add-slide 3 "With prefix notation
Functions can accept different number of arguments.
Arity is strict. Wrong arity -> Exception")

(comment 3
         (+ 1 3 4);
         (+ 1 3)
         (+)
         +
         (source +)
         ;; error ArityException
         (inc 2 4)
         )

(add-slide 4 "Nested prefix notation ->
no need for op preference
2 * 3 + 4 or 4 + 2 * 3 -> (+ 4 (* 2 3))")

(comment 4
         (+ 4 (* 2 3)))

(add-slide 5 "Evaluation of expressions
Recursive -> First evaluate sub-expressions
(+ (* 2 3) (- 5 1))
-> (+ 6 (- 5 1))
-> (+ 6 4)
-> 10")

(comment 5
         (+ (* 2 3) (- 5 1))
         )

(add-slide 6 "Naming Things
with def")

(comment 6
         "I lied a bit went I explained that (function...) special form"
         (def answer-to-everything 42)
         "def is a special for that associates a name to a value"
         )

(add-slide 7 "doing more than one expression
with do.
main use -> side effects
returns last value of expression")

(comment 7
         ((println "hello") (println "bye"))
         (do (println "hello") (println "bye"))

         )

(add-slide 8 "let it be... local names")

(comment 8
        (def x 10)
        (let [x 2] (* x x))
        (inc x)
        )

(add-slide 9 "from let to function fn")

(comment 9
         (fn [x] (* x x)))
