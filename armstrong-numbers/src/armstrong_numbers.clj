(ns armstrong-numbers)

(defn pow 
  [x n]
  (reduce * (repeat n x)))

(defn armstrong?
  "Returns `true` if `num` is an [Armstrong number](https://en.wikipedia.org/wiki/Narcissistic_number)"
  [num]
  (let [digits (map #(mod % 10) 
                    (take-while pos? (iterate #(quot % 10) num))) 
        n (count digits)]
    (== num (reduce + (map #(pow % n) digits)))))
