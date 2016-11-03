(ns dbexec.core
  (require [clojure.java.jdbc :as j])
  (require [clojure.string :as s])
  (import java.sql.SQLException)
  (:gen-class))

(defn print-array
  [arr]
  (println (s/join "\t|\t" arr)))

(defn print-res-arrays
  [res]
  (println (str "Number of results: " (- (count res) 1)))
  (doall (map print-array res)))

(defn query
  [conn sql]
  (print-res-arrays (j/query conn [sql] {:as-arrays? true})))

(defn exec
  [conn sql]
  (println (str "Rows updated " (j/execute! conn [sql]))) )

(defn -main
  [conn-file file]
  (let [sql (s/trim (slurp file))
        conn (read-string (slurp conn-file))]
    (try
      (query conn sql)
      (catch SQLException se
        (println (.getMessage se))
        (try 
          (exec conn sql)
          (catch Exception e (println (.getMessage e))))))))

(def db {:classname   "org.sqlite.JDBC",
         :subprotocol "sqlite",
         :subname "test.db"})

