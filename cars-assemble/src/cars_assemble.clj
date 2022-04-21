(ns cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (* 
    221
    speed
    (condp >= speed
      0  0.0
      4  1.0
      8  0.9
      9  0.8
      10 0.77)))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60)))
