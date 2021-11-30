
(defn collatz-sequence 
  ;; Returns the Collatz sequence for an integer n
  [result n]
  (if (== n 1)
    (conj result n)
    (if (== (mod n 2) 0)
      (recur (conj result n) (/ n 2))
      (recur (conj result n) (inc (* n 3)))
      )
    )
  )

(defn collatz-reducer [x y]
  ;; Given two integers 'x' and 'y' returns the one with
  ;; the longest Collatz sequence
  (let [n-collatz-x (count (collatz-sequence [] x))
        n-collatz-y (count (collatz-sequence [] y))]
    (if (>= n-collatz-x n-collatz-y) x y)
    )
  )

(defn pretty-solution-string [n]
  (format
   "The number < 1000000 leading to the longest Collatz sequence (length %d) is %d."
   (count (collatz-sequence [] n)) n)
  )

(def solution
  (->>
   (Math/pow 10 6)
   (range 1)
   (reduce collatz-reducer)
   pretty-solution-string
   )
  )
