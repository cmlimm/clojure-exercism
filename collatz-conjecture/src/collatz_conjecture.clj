(ns collatz-conjecture)

(defn modify
  [num]
  (if (even? num) (/ num 2) (+ 1 (* 3 num))))

(defn collatz [num]
  "Count number of steps before reaching 1 
  (see https://en.wikipedia.org/wiki/Collatz_conjecture)."
  (if (pos? num) (count (take-while #(not= 1 %) (iterate modify num)))
      (let [message 
            (format "Value Error: expected positive number, got %s" num)]
        (throw (IllegalArgumentException. message)))))