
(ns utils.io
  (:require [clojure.java.io :as io])
  )


(defn read-lines
  "Reads the lines of 'path' into a sequence."
  [path]
  (with-open [rdr (io/reader path)]
    (doall (line-seq rdr))
    )
  )
