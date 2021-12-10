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

(defn traverse-lattice [n-paths x y N]
  (for [[x1 y1] (concat (next-horizontal-step x y N) (next-vertical-step x y N))]
    (if (and (= x1 N) (= y1 N))
      (inc n-paths)
      (traverse-lattice n-paths x1 y1 N)
      )
    )
  )

(def lattice-size 20)

(println
 (->>
  lattice-size
  (traverse-lattice 0 0 0)
  flatten
  (reduce +)
  )
)
