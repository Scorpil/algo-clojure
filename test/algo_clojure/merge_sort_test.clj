(ns algo-clojure.merge-sort-test
  (:require [clojure.test :refer :all]
            [algo-clojure.merge-sort :refer :all]))

(deftest merge-sort-test
  (testing "empty array"
    (is (= (merge-sort (list))
           (list))))

  (testing "array with one element"
    (is (= (merge-sort (list 1))
           (list 1))))

  (testing "array with two elements"
    (is (= (merge-sort (list 2 1))
           (list 1 2))))

  (testing "array with unique elements"
    (is (= (merge-sort (list 5 3 1 2 4))
           (list 1 2 3 4 5))))

  (testing "array with repeated elements"
    (is (= (merge-sort (list 3 3 1 2 4))
           (list 1 2 3 3 4))))

  (testing "array with negative elements"
    (is (= (merge-sort (list (- 4) (- 4) 4 1 2))
           (list (- 4) (- 4) 1 2 4)))))
