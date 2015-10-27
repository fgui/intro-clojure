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

(add-slide 1 "Parenthesis hell ?

((  ))  ((()))  ()      ()
((  ))  ()      ()      ()
((()))  ((()))  ()      ()
((  ))  ()      ()      ()
((  ))  ((()))  ((()))  ((()))
")

(comment
  ;; inc (3)
  (println "hola"))

(add-slide "First things first:
First function followed by parameters
(function param-1 param-2 ... param-n)")

(comment
  (str "hola" "mundo")
  )


(add-slide "(not-a-function bla bla) -> Good try but try again!")

(comment
  (1 2 3)
  ("text" 1 3))

(add-slide "Math operands are functions
and functions FIRST")

(comment
  (- 4 3)
  (- 4 3 1)
  (+ 4 5)
  (+ 1)
  (+)
  )

(add-slide "Life is easy with prefix notation
- functions can accept different number of arguments.")

(comment
  (+ 1 3 4)
  (< 1 2 3 4)
  (+ 1 3)
  (+)
  +
  (source +)
  ;; error ArityException
  (inc 2 4))

(add-slide "Life is easy with prefix notation
- no need to have order of application for math operators
2 * 3 + 4 or 4 + 2 * 3 -> (+ 4 (* 2 3))")

(comment
  (+ 4 (* 2 3)))

(add-slide "Evaluation of expressions
(+ (* 2 3) 5)
-> (+ 6 5)
-> 11")

(comment
  (+ (* 2 3) 5))

(add-slide "Types. The usual suspects
- numbers 2 1.2
- \"strings\", \\c \\h \\a \\r \\s
- boolean true false")

(add-slide "More 'types'
- Big numbers, ratios
- :keywords
- symbols
- nil possible value of any data type")

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

(add-slide "Collection
(with literal syntax)
- Vector []
- Map {:key 123}
- Set #{\\a 2 2/3}
- List (1 \"three\" \\a)")

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
associates values to symbols")

(comment
  "I lied a bit went I explained that (function...) special form"
  (def answer-to-everything 42)
  (def pi 3.14)
  "def is a special for that associates a name to a value")

(add-slide "Doing more than one expression
with do.
main use -> side effects
do evaluates to the evaluation of the last expression")

(comment
  ((println "hello") 4)
  (do (println "hello") 4))

(add-slide "Let it be... local names")

(comment
  (let [pi 355/113] pi)
  pi)

(add-slide "Functions
fn
defn
")

(comment
  (def square (fn [x] (* x x)))
  (square 3)
  ;; evaluation
  ;; functions are nothing else than values
  ((fn [x] (* x x)) 3)
  (* 3 3)

  #(* %1 %1))

(add-slide "Functions are values
A function can eval to a function
A function can be a parameter of a function")

(comment
  (defn apply-twice [f]
    (fn [x] (f (f x)))
    )

  ((apply-twice square) 2)
  )

(add-slide "Flow control
if
cond")

(comment
  (if (zero? 0) "cero" "otro")

  )

(add-slide "Tell me the truth:
- false nil
- true everything else")

(comment
  (if true true false)
  (if nil true false)
  (if (or "" () {} :key) true false))

(add-slide "Higher-order function
frequently used in clojure
- map
    [a a a] fun -> [(fun a) (fun a) (fun a)]
- filter
    [a b a] a? -> [a a]
- reduce
    [a b c] fun -> (fun (fun a b) c)
- iterate
    fun a -> [(fun a) (fun (fun a)) (fun (fun (fun a))) ...]
- etc")

(comment

  (map square [1 2 3 4])

  (filter even? [1 2 3 4])

  (defn factorial [n] (reduce * (range 1N n)))
  (factorial 10000)

  (reduce #(update %1 %2 (fnil inc 0)) {} "agatta")

  (frequencies "agatta")


  (defn factorial [n] (reduce * (range 1N n)))
  ;; fib-n = fib-n-2 + fib-n-1
  (defn next-fib [[n-2 n-1]] [n-1 (+ n-1 n-2)])

  (take 10 (map first  (iterate next-fib [0 1])))
  (take 10 (->> [0 1] (iterate next-fib) (map first)))
  (def fibonaccis (map first  (iterate next-fib [0N 1N])) )
  (first (drop 3 fibbonaccis))
  )

(add-slide "Higher-order functions are fine,
but where is my loop?
recur-it.")

(comment

  (loop [count 0 coll '(1 2 3)]
    (if (empty? coll)
      count
      (recur (inc count) (rest coll))))



  (defn factorial [n]
    (if (zero? n) 1N
        (* n (factorial (dec n)))))
  (factorial 1000)

  (factorial 10000)
  ;;stackoverflow


  (defn factorial-helper [acc n]
    (if (zero? n) acc
        (recur (* acc n) (dec n))))

  ;; with partial
  (def factorial4 (partial factorial-helper 1N))

  (defn factorial5 [n]
    (loop [acc 1N fact n]
      (if (zero? fact)
        acc
        (recur (* acc fact) (dec fact)))))
  )

(add-slide "Seq
- first
- rest
- empty?
- seq
- cons
Collections
- conj
- assoc
- update")

(comment
  (def ex-vector [:one 2 :three])
  (first (range))
  (second (range))
  (take 10 (rest (range)))
  (rest ())
  (rest [])
  (cons 1 [2 3 4])
  (conj [1 2 3] 4)
  )

(add-slide "Teach it to fish
- doc, find-doc, source
- cheatsheet, conj.io
")

(add-slide "Lots more to learn about:
- namespaces
- destructuring
- metadata
- managing state, concurrency
- lazy-sequence
- polymorphism (multimethods)
- protocols, deftype, defrecord
- macros
- java/javascript interop
- cljc
- ...")
