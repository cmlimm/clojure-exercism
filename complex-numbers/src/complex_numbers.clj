(ns complex-numbers)

(defn real [[a b]] a)

(defn imaginary [[a b]] b)

(defn abs [[a b]]
  (Math/pow (+ (* a a) (* b b)) 0.5))

(defn conjugate [[a b]]
  [a (-' b)])

(defn add [[a b] [c d]]
  [(+ a c) (+ b d)])

(defn sub [[a b] [c d]]
  [(- a c) (- b d)])

(defn mul [[a b] [c d]]
  [(- (* a c) (* b d)) (+ (* b c) (* a d))]
)

(defn div [[a b] [c d]]
  (let [divider (float (+ (* c c) (* d d)))]
    [(/ (+ (* a c) (* b d)) divider)
     (/ (- (* b c) (* a d)) divider)]))
