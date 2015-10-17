(ns algo-clojure.karatsuba
  (:import [java.lang Math])
  (:require [clojure.math.numeric-tower :as math]))

(defn k-multiply
  "Karatsuba multiplication algorithm: https://en.wikipedia.org/wiki/Karatsuba_algorithm"
  [x, y]
  (if (and (< x 0) (< y 0))  ; if both numbers are negative
    (k-multiply (- x) (- y)) ; negate them
    (if (or (< x 0) (< y 0))        ; if one number is negative
      (- (k-multiply (math/abs x)   ; return negation of the product of
                     (math/abs y))) ; absolute values
      (if (or (< x 10) (< y 10)) ; if one of the number is < 10
        (* x y)                  ; multiply them normally (base case)
        (let [n (+ 1 (int (Math/log10 (max x y)))) ; digits in bigger number
              m (int (quot n 2)) ; position to split the numbers in two
              divisor (math/expt 10 m)

              ; splitting number in two parts
              x1 (quot x divisor)
              x0 (mod  x divisor)
              y1 (quot y divisor)
              y0 (mod  y divisor)

              ; sub-multiplications
              z2 (k-multiply x1 y1)
              z0 (k-multiply x0 y0)
              z1 (- (k-multiply (+ x1 x0) (+ y1 y0)) z2 z0)]

          ; calculating final result
          (long (+
                 (* z2 (math/expt 10 (* 2 m)))
                 (* z1 (math/expt 10 m))
                 z0)))))))
