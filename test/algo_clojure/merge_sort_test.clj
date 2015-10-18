(ns algo-clojure.merge-sort-test
  (:require [clojure.test :refer :all]
            [algo-clojure.merge-sort :refer :all]))

(deftest merge-sort-test
  (testing "empty sequence"
    (is (= (merge-sort (list))
           (list))))

  (testing "sequence with one element"
    (is (= (merge-sort (list 1))
           (list 1))))

  (testing "sequence with two elements"
    (is (= (merge-sort (list 2 1))
           (list 1 2))))

  (testing "sequence sorted from the start"
    (is (= (merge-sort (list 1 2 3 4 5))
           (list 1 2 3 4 5))))

  (testing "sequence with unique elements"
    (is (= (merge-sort (list 5 3 1 2 4))
           (list 1 2 3 4 5))))

  (testing "sequence with repeated elements"
    (is (= (merge-sort (list 3 3 1 2 4))
           (list 1 2 3 3 4))))

  (testing "sequence with negative elements"
    (is (= (merge-sort (list (- 4) (- 4) 4 1 2))
           (list (- 4) (- 4) 1 2 4)))))
