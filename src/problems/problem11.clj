
(ns problems.problem11
  (:require [utils.io :as uio]
            [clojure.string :as str]
            [incanter.core :refer :all])
  )


(def input-data-path "resources/problem10_grid.txt")

(defn seq-to-int
  "Convert all elements of a sequence to integers. 
  E.g. (seq-to-int (\"1\" \"2\")) --> (1 2)"
  [seq]
  (map #(Integer. %) seq)
  )

(defn windows
  "Retrieves from 'seq' all sliding windows of size 'size'.
  E.g.: (window (range 3) 2) --> ((0 1) (1 2))"
  [seq size]
  (let [length (count seq)]
    (for [i (reverse (range size (inc length)))]
      (take size (take-last i seq))
      )
    )
  )

(defn vertical-windows
  ""
  [data size]
  (let [nrows (nrow data)
        ncols (ncol data)
        row-indexes (windows (range nrows) size)]
    (for [rows row-indexes
          col (range ncols)]
      (sel data :rows rows :cols col)
      )
    )
  )

(defn horizontal-windows
  ""
  [data size]
  (let [nrows (nrow data)
        ncols (ncol data)
        col-indexes (windows (range ncols) size)]
    (for [cols col-indexes
          row (range nrows)]
      (sel data :rows row :cols cols)
      )
    )
  )

(defn left-to-right-diagonal-windows
  ""
  [data size]
  (let [nrows (nrow data)
        ncols (ncol data)
        row-indexes (windows (range nrows) size)
        col-indexes (windows (range ncols) size)]
    (for [rows row-indexes
          cols col-indexes]
      (diag (sel data :rows rows :cols cols))
      )
    )
  )

(defn right-to-left-diagonal-windows
  ""
  [data size]
  (let [nrows (nrow data)
        ncols (ncol data)
        row-indexes (windows (range nrows) size)
        col-indexes (windows (range ncols) size)]
    (for [rows row-indexes
          cols col-indexes]
      (diag (sel data :rows rows :cols (reverse cols)))
      )
    )
  )

(defn seq-prod-mapping
  [vector]
  {:seq (seq vector) :prod (reduce * vector)}
  )

(defn beautify-mapping
  [mapping]
  (str/join ""
            ["The largest product is "
             (format "%.0f" (:prod mapping))
             " corresponding to adjacent numbers "
             (vec (:seq mapping))])
  )

(def solution
  (let [data-matrix (->>
                     (uio/read-lines input-data-path)
                     (map #(str/split %1 #" "))
                     (map seq-to-int)
                     matrix)]
    (->>
     (for [window-type [vertical-windows
                        horizontal-windows
                        left-to-right-diagonal-windows
                        right-to-left-diagonal-windows]]
       (apply max-key :prod (map seq-prod-mapping (window-type data-matrix 4)))
       )
     (apply max-key :prod)
     beautify-mapping
     )
    )
  )
