(ns algo-clojure.merge-sort)

(defn combine
  [xs1 xs2]
  (if (empty? xs1) xs2 ; if one sequence is empty return other one
      (if (empty? xs2) xs1
          (let [[f1 & t1] xs1
                [f2 & t2] xs2]
            (if (< f1 f2) ; else, return smallest element and combine the rest
              (cons f1 (combine t1 xs2))
              (cons f2 (combine xs1 t2)))))))

(defn merge-sort
  [xs]
  (let [len-xs (count xs)]
    (if (< len-xs 2) xs ; return sequence if there is less than 2 elements in it
        (let [[xs1 xs2] (split-at (quot len-xs 2) xs)] ; split sequence in two
          (combine (merge-sort xs1) (merge-sort xs2)))))) ; combine sorted parts
