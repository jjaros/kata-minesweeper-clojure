(ns minesweeper-clojure.core)

(defn merge-values "Merges two values taking into account the :mine value."
  [x y]
  (if (or (= x :mine) (= y :mine)) :mine (+ x y)))

(defn inc-two-first "Increments two first values of input array taking into account the :mine value."
  [input]
  (if (or (= (first input) :mine) (= (second input) :mine)) 
    [(merge-values (first input) 1) (merge-values (second input) 1)]
    [0 0]))

(defn hint-minesweeper "Computes minesweeper hints."
  [input]
  (cond (<= (count input) 1) input
        :else (concat [(first (inc-two-first input))] 
                      [(merge-values (second (inc-two-first input)) (first (hint-minesweeper (rest input))))] 
                      (rest (hint-minesweeper (rest input))))))
