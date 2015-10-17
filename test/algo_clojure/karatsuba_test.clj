(ns algo-clojure.karatsuba-test
  (:require [clojure.test :refer :all]
            [algo-clojure.karatsuba :refer :all]))

(deftest karatsuba-test
  (testing "trivial (2 * 2)"
    (is (= 4 (k-multiply 2 2))))

  (testing "zero (0 * 1234)"
    (is (= 0 (k-multiply 0 1234))))

  (testing "one (1 * 1234)"
    (is (= 1234 (k-multiply 1 1234))))

  (testing "big numbers (123456789 * 123456789)"
    (is (= 15241578750190521 (k-multiply 123456789 123456789))))

  (testing "numbers of different lengths (123456789 * 1234)"
    (is (= 152345677626 (k-multiply 123456789 1234))))

  (testing "one negative number (-1234 * 1234)"
    (is (= -1522756 (k-multiply (- 1234) 1234))))

  (testing "two negative numbers (-1234 * -1234)"
    (is (= 1522756 (k-multiply (- 1234) (- 1234))))))
