
(defn is-prime
  "Sieve of Erasthotenes with 6k+-1 optimization.
  Source: https://en.wikipedia.org/wiki/Primality_test#Python"
  [n]
  (if (<= n 3)
    (> n 1)
    (if (or (= (mod n 3) 0) (= (mod n 2) 0))
      false
      (if (->>
           (for [i (range 5 (inc (Math/sqrt n)) 6) :when (or (= (mod n i) 0) (= (mod n (+ i 2)) 0))] i)
           (some identity))
        false
        true
    ))))


(defn next-prime [n]
  (let [p (atom n)]
    (swap! p inc)
    (while (not (is-prime @p))
      (swap! p inc)
      )
    @p
    )
  )

(def prime-numbers (iterate next-prime 2))

(println "10001st prime number:" (last (take 10001 prime-numbers)))
