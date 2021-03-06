(ns recursion)

(defn product [coll]
  (if (empty? coll)
    1
    (* (first coll)
       (product (rest coll)))))

(defn singleton? [coll]
  (if (empty? coll)
    false
    (empty? (rest coll))))

(defn my-last [coll]
  (if (or (singleton? coll) (empty? coll))
    (first coll)
    (my-last (rest coll))))

(defn max-element [a-seq]
  (let [helper (fn [cur-max b-seq]
    (if (empty? b-seq)
      cur-max
      (recur (max cur-max (first b-seq)) (rest b-seq))))]
    (if (or (empty? a-seq) (singleton? a-seq))
      (first a-seq)
      (helper (first a-seq) (rest a-seq)))))

(defn seq-max [seq-1 seq-2]
  (if (<= (count seq-1) (count seq-2))
    seq-2
    seq-1))


(defn longest-sequence [a-seq]
  (let [helper (fn [cur-longest-seq b-seq]
                 (if (empty? b-seq)
                   cur-longest-seq
                   (recur (seq-max cur-longest-seq (first b-seq)) (rest b-seq))))]
    (if (or (empty? a-seq) (singleton? a-seq))
      (first a-seq)
      (helper (first a-seq) (rest a-seq)))))

(defn my-filter [pred? a-seq]
  (if (empty? a-seq)
    a-seq
    (if (pred? (first a-seq))
      (cons (first a-seq)
            (my-filter pred? (rest a-seq)))
      (my-filter pred? (rest a-seq)))))

(defn sequence-contains? [elem a-seq]
  (cond
    (empty? a-seq)
      false
    (= elem (first a-seq))
      true
    :else
      (sequence-contains? elem (rest a-seq))))

(defn my-take-while [pred? a-seq]
  (cond
    (empty? a-seq)
      '()
    (pred? (first a-seq))
      (cons
        (first a-seq)
        (my-take-while pred? (rest a-seq)))
    :else
      '()))

(defn my-drop-while [pred? a-seq]
  (cond
    (empty? a-seq)
      '()
    (pred? (first a-seq))
      (my-drop-while pred? (rest a-seq))
    :else
      a-seq))

(defn seq= [a-seq b-seq]
  (cond
    (and (empty? a-seq) (empty? b-seq))
      true
    (and (singleton? a-seq) (not (singleton? b-seq)))
      false
    (and (singleton? b-seq) (not (singleton? a-seq)))
      false
    (= (first a-seq) (first b-seq))
      (seq= (rest a-seq) (rest b-seq))
    :else
      false))

(defn my-map [f seq-1 seq-2]
  (cond
    (or (empty? seq-1) (empty? seq-2))
      '()
    :else
      (cons (f (first seq-1) (first seq-2))
            (my-map f (rest seq-1) (rest seq-2)))))

(defn power [n k]
  (if (zero? k)
    1
    (* n (power n (dec k)))))

(defn fib [n]
  (cond
    (= n 0)
      0
    (= n 1)
      1
    :else
      (+ (fib (- n 1)) (fib (- n 2)))))

(defn my-repeat [how-many-times what-to-repeat]
  (cond
    (<= how-many-times 0)
      '()
    :else
      (cons what-to-repeat (my-repeat (dec how-many-times) what-to-repeat))))

(defn my-range [up-to]
  (cond
    (<= up-to 0)
      '()
    :else
      (cons (dec up-to) (my-range (dec up-to)))))

(defn tails [a-seq]
  (cond
    (empty? a-seq)
      (seq ['()])
    :else
      (cons a-seq (tails (rest a-seq)))))

(defn inits [a-seq]
  (let [reversed (tails (reverse a-seq))]
    (reverse (map reverse reversed))))

(defn rotations [a-seq]
  (cond
    (empty? a-seq)
      (seq ['()])
    :else
      (reverse (rest (reverse (map concat (tails a-seq) (inits a-seq)))))))

(defn my-frequencies-helper [freqs a-seq]
  (let [cur (first a-seq)
        contains-cur (contains? freqs cur)
        old-cur (get freqs cur)]
    (cond
      (empty? a-seq)
        freqs
      contains-cur
        (my-frequencies-helper (assoc freqs cur (inc old-cur)) (rest a-seq))
      :else
        (my-frequencies-helper (assoc freqs cur 1) (rest a-seq)))))

(defn my-frequencies [a-seq]
  (my-frequencies-helper {} a-seq))

(defn un-frequencies [a-map]
  [:-])

(defn my-take [n coll]
  [:-])

(defn my-drop [n coll]
  [:-])

(defn halve [a-seq]
  [:-])

(defn seq-merge [a-seq b-seq]
  [:-])

(defn merge-sort [a-seq]
  [:-])

(defn split-into-monotonics [a-seq]
  [:-])

(defn permutations [a-set]
  [:-])

(defn powerset [a-set]
  [:-])


