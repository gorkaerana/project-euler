(defn next-vertical-step [x y N]
  (when (not (= x N))
    [[(inc x) y]]
    )
  )

(defn next-horizontal-step [x y N]
  (when (not (= y N))
    [[x (inc y)]]
    )
  )

(defn traverse-lattice [paths x y N]
  (for [[x1 y1] (concat (next-horizontal-step x y N) (next-vertical-step x y N))]
    (if (and (= x1 N) (= y1 N))
      (into [] (concat paths [[x1 y1]]))
      (traverse-lattice (concat paths [[x1 y1]]) x1 y1 N)
      )
    )
  )

(def lattice-size 2)

(def solution)

(println (traverse-lattice [] 0 0 lattice-size))
