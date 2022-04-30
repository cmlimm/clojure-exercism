(ns robot-simulator)

(defn robot 
  [coordinates bearing]
  {:coordinates coordinates 
   :bearing bearing})

(defn turn-right 
  [bearing]
  (case bearing
    :north :east
    :east  :south
    :south :west
    :west  :north))

(defn turn-left 
  [bearing]
  (case bearing
    :north :west
    :west  :south
    :south :east
    :east  :north))

(defn advance
  [robot]
  (case (:bearing robot)
    :north (update-in robot [:coordinates :y] inc)
    :east  (update-in robot [:coordinates :x] inc)
    :south (update-in robot [:coordinates :y] dec)
    :west  (update-in robot [:coordinates :x] dec)))

(defn run-command
  [robot command]
  (case command
    \A (advance robot)
    \R (update-in robot [:bearing] turn-right)
    \L (update-in robot [:bearing] turn-left)))

(defn simulate 
  [commands robot]
  (reduce run-command robot commands))