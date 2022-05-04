(ns difference-of-squares)

(defn sum-of-squares [num]
 (apply + (map #(* % %) (range (inc num)))))

(defn square-of-sum [num]
  (let [sum (apply + (range (inc num)))]
    (* sum sum)))

(defn difference [num]
  (- (square-of-sum num) (sum-of-squares num)))