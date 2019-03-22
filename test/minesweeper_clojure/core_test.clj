(ns minesweeper-clojure.core-test
  (:require [clojure.test :refer :all]
            [minesweeper-clojure.core :refer :all]))

(deftest test-merge-values
  (testing "Test merge two values taking into account the :mine value."
    (are [expected actual] (= expected actual)
      0 (merge-values 0 0)
      1 (merge-values 0 1)
      1 (merge-values 1 0)
      2 (merge-values 1 1)
      :mine (merge-values 0 :mine)
      :mine (merge-values :mine 0)
      :mine (merge-values :mine :mine))))

(deftest test-inc-two-first
  (testing "Test increment two first fields on input array."
    (are [expected actual] (= expected actual)
      [0 0] (inc-two-first [0 0])
      [1 :mine] (inc-two-first [0 :mine])
      [:mine 1] (inc-two-first [:mine 0])
      [:mine :mine] (inc-two-first [:mine :mine])
      [:mine :mine] (inc-two-first [:mine :mine 0])
      [:mine :mine] (inc-two-first [:mine :mine :mine]))))

(deftest test-hint-minesweeper
  (testing "Test compute minesweeper hint values."
    (are [expected actual] (= expected actual)
      [0] (hint-minesweeper [0])
      [:mine] (hint-minesweeper [:mine])
      [:mine 1] (hint-minesweeper [:mine 0])
      [1 :mine] (hint-minesweeper [0 :mine])
      [0 0] (hint-minesweeper [0 0])
      [:mine :mine] (hint-minesweeper [:mine :mine])
      [:mine 1 0] (hint-minesweeper [:mine 0 0])
      [0 1 :mine] (hint-minesweeper [0 0 :mine])
      [1 :mine 1] (hint-minesweeper [0 :mine 0])
      [:mine 2 :mine] (hint-minesweeper [:mine 0 :mine])
      [:mine 1 0 0] (hint-minesweeper [:mine 0 0 0])
      [1 :mine 1 0] (hint-minesweeper [0 :mine 0 0])
      [0 1 :mine 1] (hint-minesweeper [0 0 :mine 0])
      [0 0 1 :mine] (hint-minesweeper [0 0 0 :mine])
      [:mine 1 1 :mine] (hint-minesweeper [:mine 0 0 :mine])
      [1 :mine 2 :mine] (hint-minesweeper [0 :mine 0 :mine])
      [0 1 :mine 2 :mine 1 0] (hint-minesweeper [0 0 :mine 0 :mine 0 0]))))
