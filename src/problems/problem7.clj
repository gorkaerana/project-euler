
(ns problems.problem7
  (:require [utils.maths :as maths]
            [clojure.string :as str])
  )


(defn next-prime [n]
  (let [p (atom n)]
    (swap! p inc)
    (while (not (maths/is-prime @p))
      (swap! p inc)
      )
    @p
    )
  )

(def prime-numbers (iterate next-prime 2))

(def solution
  (str/join ["10001st prime number: "
             (last (take 10001 prime-numbers))
             "."])
  )
